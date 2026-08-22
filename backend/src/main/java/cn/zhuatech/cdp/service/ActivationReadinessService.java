/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.cdp.service;
import jakarta.validation.constraints.*;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
@Service
public class ActivationReadinessService {
    public Result evaluate(Request r){
        double identity=rate(r.identifiableProfiles(),r.audienceSize()), consent=rate(r.consentedProfiles(),r.audienceSize());
        double reachable=rate(r.reachableProfiles(),r.audienceSize()), stale=rate(r.staleProfiles(),r.audienceSize());
        double score=identity*.30+consent*.35+reachable*.25+Math.min(10,r.channelCount()*2)-Math.min(20,stale*.3);
        score=Math.max(0,Math.min(100,score));
        String decision=consent<70||r.channelCount()==0?"BLOCK":score<80||stale>15?"REVIEW":"READY";
        List<String> actions=new ArrayList<>();
        if(identity<85)actions.add("补齐客户身份映射与主数据关联"); if(consent<90)actions.add("按渠道复核授权范围与有效期");
        if(reachable<80)actions.add("清理无效触达地址并补充可用渠道"); if(stale>15)actions.add("刷新长期未更新的客户画像特征");
        return new Result(scale(identity),scale(consent),scale(reachable),scale(stale),scale(score),decision,actions);
    }
    private double rate(int value,int total){return total==0?0:value*100.0/total;}
    private double scale(double value){return BigDecimal.valueOf(value).setScale(2,RoundingMode.HALF_UP).doubleValue();}
    public record Request(@NotBlank String segmentId,@Positive int audienceSize,@PositiveOrZero int identifiableProfiles,
        @PositiveOrZero int consentedProfiles,@PositiveOrZero int reachableProfiles,@PositiveOrZero int staleProfiles,
        @Min(0) @Max(10) int channelCount){}
    public record Result(double identityRate,double consentRate,double reachableRate,double staleRate,double readinessScore,String decision,List<String> actions){}
}

