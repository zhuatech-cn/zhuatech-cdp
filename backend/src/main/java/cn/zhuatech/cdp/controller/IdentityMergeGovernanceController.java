/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.cdp.controller;

import cn.zhuatech.cdp.common.ApiResponse;
import cn.zhuatech.cdp.service.IdentityMergeGovernanceService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

/**
 * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
 */
@RestController
@RequestMapping("/api/enterprise/cdp")
public class IdentityMergeGovernanceController {
    private final IdentityMergeGovernanceService service;
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public IdentityMergeGovernanceController(IdentityMergeGovernanceService service) { this.service = service; }

    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    @PostMapping("/identity-merge-governance")
    public ApiResponse<IdentityMergeGovernanceService.Assessment> assess(
        @Valid @RequestBody IdentityMergeGovernanceService.Request request) {
        return ApiResponse.ok(service.assess(request));
    }
}
