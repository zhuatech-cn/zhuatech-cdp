/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.cdp.controller;

import cn.zhuatech.cdp.common.ApiResponse;
import cn.zhuatech.cdp.service.IdentityMergeGovernanceService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/enterprise/cdp")
public class IdentityMergeGovernanceController {
    private final IdentityMergeGovernanceService service;
    public IdentityMergeGovernanceController(IdentityMergeGovernanceService service) { this.service = service; }

    @PostMapping("/identity-merge-governance")
    public ApiResponse<IdentityMergeGovernanceService.Assessment> assess(
        @Valid @RequestBody IdentityMergeGovernanceService.Request request) {
        return ApiResponse.ok(service.assess(request));
    }
}
