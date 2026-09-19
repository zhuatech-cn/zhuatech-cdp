/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.cdp.service;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
 */
class IdentityMergeGovernanceServiceTest {
    private final IdentityMergeGovernanceService service = new IdentityMergeGovernanceService();

    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    @Test void automaticallyMergesHighConfidenceProfiles() {
        var result = service.assess(new IdentityMergeGovernanceService.Request(
            "MRG-001", 2, 98, 0, false, true, false, true));
        assertThat(result.decision()).isEqualTo(IdentityMergeGovernanceService.Decision.AUTO_MERGE);
        assertThat(result.mergeable()).isTrue();
    }

    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    @Test void blocksConsentResidencyAndIdentifierConflicts() {
        var result = service.assess(new IdentityMergeGovernanceService.Request(
            "MRG-002", 3, 99, 0, true, false, true, true));
        assertThat(result.decision()).isEqualTo(IdentityMergeGovernanceService.Decision.BLOCKED);
        assertThat(result.blockers()).hasSize(3);
    }

    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    @Test void reviewsAmbiguousGoldenRecord() {
        var result = service.assess(new IdentityMergeGovernanceService.Request(
            "MRG-003", 2, 80, 2, false, true, false, false));
        assertThat(result.decision()).isEqualTo(IdentityMergeGovernanceService.Decision.REVIEW);
        assertThat(result.actions()).hasSize(3);
    }
}
