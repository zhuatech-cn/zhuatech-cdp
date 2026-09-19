/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.cdp.controller;

import cn.zhuatech.cdp.common.ApiResponse;
import cn.zhuatech.cdp.service.ConsentActivationGuardService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
 */
@RestController
@RequestMapping("/api/cdp/insights")
public class ConsentActivationGuardController {
    private final ConsentActivationGuardService service;

    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public ConsentActivationGuardController(ConsentActivationGuardService service) {
        this.service = service;
    }

    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    @PostMapping("/consent-activation-guard")
    public ApiResponse<ConsentActivationGuardService.Result> evaluate(
        @Valid @RequestBody ConsentActivationGuardService.Request request) {
        return ApiResponse.ok(service.evaluate(request));
    }
}
