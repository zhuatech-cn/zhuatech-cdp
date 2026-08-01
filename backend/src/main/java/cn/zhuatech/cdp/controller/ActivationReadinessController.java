/* Copyright 2026 上海如静知华信息科技有限公司 */
package cn.zhuatech.cdp.controller;
import cn.zhuatech.cdp.common.ApiResponse; import cn.zhuatech.cdp.service.ActivationReadinessService; import jakarta.validation.Valid; import org.springframework.web.bind.annotation.*;
@RestController @RequestMapping("/api/admin") public class ActivationReadinessController {private final ActivationReadinessService service; public ActivationReadinessController(ActivationReadinessService service){this.service=service;} @PostMapping("/activation-readiness") public ApiResponse<ActivationReadinessService.Result> evaluate(@Valid @RequestBody ActivationReadinessService.Request request){return ApiResponse.ok(service.evaluate(request));}}

