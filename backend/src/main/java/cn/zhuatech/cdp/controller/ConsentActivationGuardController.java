/* Copyright 2026 上海如静知华信息科技有限公司 */
package cn.zhuatech.cdp.controller;

import cn.zhuatech.cdp.common.ApiResponse;
import cn.zhuatech.cdp.service.ConsentActivationGuardService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/cdp/insights")
public class ConsentActivationGuardController {
    private final ConsentActivationGuardService service;

    public ConsentActivationGuardController(ConsentActivationGuardService service) {
        this.service = service;
    }

    @PostMapping("/consent-activation-guard")
    public ApiResponse<ConsentActivationGuardService.Result> evaluate(
        @Valid @RequestBody ConsentActivationGuardService.Request request) {
        return ApiResponse.ok(service.evaluate(request));
    }
}
