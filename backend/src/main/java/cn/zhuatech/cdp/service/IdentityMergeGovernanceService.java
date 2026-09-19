/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.cdp.service;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

/**
 * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
 */
@Service
public class IdentityMergeGovernanceService {
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public Assessment assess(Request request) {
        List<String> blockers = new ArrayList<>();
        List<String> actions = new ArrayList<>();
        if (request.consentConflict()) blockers.add("候选档案存在相互冲突的授权状态");
        if (!request.dataResidencyCompatible()) blockers.add("候选数据的数据驻留规则不兼容");
        if (request.sensitiveIdentifierConflict()) blockers.add("敏感身份标识发生冲突");
        if (!blockers.isEmpty()) {
            actions.add("禁止合并并转交数据治理负责人处理冲突");
            return new Assessment(Decision.BLOCKED, false, blockers, actions);
        }
        if (request.matchConfidence() < 90 || request.sourceConflictCount() > 0
            || !request.goldenRecordOwnerAssigned()) {
            if (request.matchConfidence() < 90) actions.add("补充确定性身份标识或人工核验");
            if (request.sourceConflictCount() > 0) actions.add("按来源可信级别解决字段冲突");
            if (!request.goldenRecordOwnerAssigned()) actions.add("指定黄金客户档案责任人");
            return new Assessment(Decision.REVIEW, false, blockers, actions);
        }
        actions.add("执行身份合并并保留来源映射、授权和回滚快照");
        return new Assessment(Decision.AUTO_MERGE, true, blockers, actions);
    }

    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public record Request(@NotBlank String mergeRequestId, @Min(2) int candidateProfileCount,
                          @Min(0) @Max(100) int matchConfidence,
                          @Min(0) int sourceConflictCount, boolean consentConflict,
                          boolean dataResidencyCompatible, boolean sensitiveIdentifierConflict,
                          boolean goldenRecordOwnerAssigned) {}
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public record Assessment(Decision decision, boolean mergeable, List<String> blockers,
                             List<String> actions) {}
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public enum Decision { AUTO_MERGE, REVIEW, BLOCKED }
}
