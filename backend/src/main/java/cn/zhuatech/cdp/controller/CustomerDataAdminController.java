/* Copyright 2026 Shanghai Rujing Zhihua Information Technology Co., Ltd. · https://www.zhuatech.cn/ */
package cn.zhuatech.cdp.controller; import cn.zhuatech.cdp.common.ApiResponse; import cn.zhuatech.cdp.dto.CdpDto.*; import cn.zhuatech.cdp.service.CdpService; import org.springframework.security.access.prepost.PreAuthorize; import org.springframework.web.bind.annotation.*; import java.util.List;
/**
 * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
 */
@RestController @RequestMapping("/api/admin") @PreAuthorize("hasAnyRole('CDP_MANAGER','QUALITY','ADMIN')") public class CustomerDataAdminController {private final CdpService service;/**
                                                                                                                                                                                       * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                                                                                                                                       */
public CustomerDataAdminController(CdpService service){this.service=service;}/**
                                                                                                                                                                                                                                                                    * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                                                                                                                                                                                                                    */
@GetMapping("/dashboard") public ApiResponse<Dashboard> dashboard(){return ApiResponse.ok(service.adminDashboard());}/**
                                                                                                                                                                                                                                                                                                                                                                                         * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                                                                                                                                                                                                                                                                                                                                         */
@GetMapping("/work-orders") public ApiResponse<List<AudienceTaskView>> orders(){return ApiResponse.ok(service.audienceTasks());}}
