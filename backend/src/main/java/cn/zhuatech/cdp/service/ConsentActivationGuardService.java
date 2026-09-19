/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.cdp.service;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
 */
@Service
public class ConsentActivationGuardService {
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public Result evaluate(Request request) {
        long conservativeEligible = Math.max(0,
            request.consentedAudienceSize() - request.suppressedAudienceSize() - request.staleIdentityCount());
        long eligibleAudience = Math.min(request.audienceSize(), conservativeEligible);
        long withheldAudience = Math.max(0, request.audienceSize() - eligibleAudience);
        double eligibleRate = request.audienceSize() == 0 ? 0
            : Math.round((double) eligibleAudience / request.audienceSize() * 10_000D) / 10_000D;
        String decision = !request.purposeConfigured() || eligibleRate < .80 ? "BLOCK"
            : eligibleRate < .95 ? "REVIEW" : "RELEASE";

        List<String> actions = new ArrayList<>();
        if (!request.purposeConfigured()) actions.add("配置处理目的、保存期限和渠道授权依据");
        if (request.suppressedAudienceSize() > 0) actions.add("从激活人群中排除退订与渠道抑制名单");
        if (request.staleIdentityCount() > 0) actions.add("刷新过期身份映射后重新计算可触达人群");
        if ("RELEASE".equals(decision)) actions.add("生成授权快照并允许渠道任务发布");
        if (actions.isEmpty()) actions.add("人工复核低覆盖率原因并补齐授权证据");
        return new Result(request.segmentCode(), request.channel(), eligibleAudience,
            withheldAudience, eligibleRate, decision, actions);
    }

    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public record Request(@NotBlank String segmentCode,
                          @Pattern(regexp = "EMAIL|SMS|PUSH|ADS|WECHAT") String channel,
                          @Min(0) long audienceSize, @Min(0) long consentedAudienceSize,
                          @Min(0) long suppressedAudienceSize, @Min(0) long staleIdentityCount,
                          boolean purposeConfigured) {}

    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public record Result(String segmentCode, String channel, long eligibleAudience,
                         long withheldAudience, double eligibleRate,
                         String decision, List<String> actions) {}
}
