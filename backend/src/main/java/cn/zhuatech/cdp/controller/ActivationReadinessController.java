/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.cdp.controller;
import cn.zhuatech.cdp.common.ApiResponse; import cn.zhuatech.cdp.service.ActivationReadinessService; import jakarta.validation.Valid; import org.springframework.web.bind.annotation.*;
/**
 * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
 */
@RestController @RequestMapping("/api/admin") public class ActivationReadinessController {private final ActivationReadinessService service; /**
                                                                                                                                             * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                                                                                             */
public ActivationReadinessController(ActivationReadinessService service){this.service=service;} /**
                                                                                                                                                                                                                                             * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                                                                                                                                                                                             */
@PostMapping("/activation-readiness") public ApiResponse<ActivationReadinessService.Result> evaluate(@Valid @RequestBody ActivationReadinessService.Request request){return ApiResponse.ok(service.evaluate(request));}}

