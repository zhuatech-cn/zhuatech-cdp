/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.cdp;

import cn.zhuatech.cdp.service.ConsentActivationGuardService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
 */
class ConsentActivationGuardServiceTests {
    private final ConsentActivationGuardService service = new ConsentActivationGuardService();

    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    @Test
    void reviewsActivationAfterConsentAndSuppressionFiltering() {
        var result = service.evaluate(new ConsentActivationGuardService.Request(
            "SEG-HIGH-VALUE", "WECHAT", 10000, 9000, 500, 300, true));

        assertEquals(8200, result.eligibleAudience());
        assertEquals(.82, result.eligibleRate());
        assertEquals("REVIEW", result.decision());
        assertTrue(result.actions().size() >= 2);
    }

    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    @Test
    void blocksActivationWithoutConfiguredPurpose() {
        var result = service.evaluate(new ConsentActivationGuardService.Request(
            "SEG-NEW-CUSTOMER", "SMS", 1000, 990, 0, 0, false));

        assertEquals("BLOCK", result.decision());
        assertTrue(result.actions().getFirst().contains("处理目的"));
    }
}
