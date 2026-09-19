/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.cdp.config;

import cn.zhuatech.cdp.model.*;
import cn.zhuatech.cdp.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDate;
import java.util.List;

/**
 * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
 */
@Configuration
public class DataInitializer {
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    @Bean
    CommandLineRunner seed(SegmentRepository segments, AudienceTaskRepository orders,
                           DataSourceRepository dataSources, IdentityIssueRepository identityIssues,
                           UserRepository users, PasswordEncoder encoder) {
        return args -> {
            if (segments.count() > 0) return;
            Segment chemistry = segments.save(new Segment("SEG-CHEM", "高价值客户分群", "客户数据中心", 180));
            Segment micro = segments.save(new Segment("SEG-MICRO", "沉睡客户分群", "研发中心", 120));
            Segment material = segments.save(new Segment("SEG-MAT", "新客培育分群", "工程中心", 96));

            AudienceTask t1 = orders.save(new AudienceTask("AUD-260801-018", "GB-T-228", "高价值续购人群", material, 24, 16, 1, LocalDate.now().plusDays(1), AudienceTask.Status.RUNNING, "S260801-A"));
            AudienceTask t2 = orders.save(new AudienceTask("AUD-260801-021", "HPLC-042", "新注册未转化人群", chemistry, 18, 8, 0, LocalDate.now().plusDays(1), AudienceTask.Status.RUNNING, "S260801-C"));
            AudienceTask t3 = orders.save(new AudienceTask("AUD-260802-006", "ISO-4833", "近 90 日沉睡客户", micro, 12, 0, 0, LocalDate.now().plusDays(3), AudienceTask.Status.RELEASED, "S260802-B"));
            AudienceTask t4 = orders.save(new AudienceTask("AUD-260731-015", "ICP-017", "流失预警客户", chemistry, 20, 20, 1, LocalDate.now(), AudienceTask.Status.COMPLETED, "S260731-D"));

            dataSources.saveAll(List.of(
                new DataSource("SRC-HPLC-03", "电商行为数据源 03", chemistry, DataSource.Status.RUNNING, 88),
                new DataSource("SRC-ICP-02", "线下门店数据源", chemistry, DataSource.Status.IDLE, 76),
                new DataSource("SRC-UTM-05", "客户服务数据源", material, DataSource.Status.RUNNING, 91),
                new DataSource("SRC-INC-08", "广告触点数据源 08", micro, DataSource.Status.ALARM, 62)
            ));
            identityIssues.saveAll(List.of(
                new IdentityIssue("ID-260801-032", t1, "留样身份合并", 6, 0, IdentityIssue.Result.PASSED, "周妍"),
                new IdentityIssue("ID-260801-011", t2, "前处理身份合并", 3, 0, IdentityIssue.Result.PASSED, "陆承"),
                new IdentityIssue("ID-260801-018", t4, "结果身份合并", 5, 1, IdentityIssue.Result.FAILED, "周妍"),
                new IdentityIssue("ID-260802-003", t3, "收样确认", 4, 0, IdentityIssue.Result.PENDING, "陆承")
            ));
            String demo = encoder.encode("Demo@2026");
            users.saveAll(List.of(
                new UserAccount("operator", demo, "陆承", UserAccount.Role.CAMPAIGN_OPERATOR, "SEG-CHEM"),
                new UserAccount("planner", demo, "周妍", UserAccount.Role.CDP_MANAGER, null),
                new UserAccount("quality", demo, "顾清", UserAccount.Role.QUALITY, null),
                new UserAccount("admin", encoder.encode("ZhuaTech@2026"), "系统管理员", UserAccount.Role.ADMIN, null)
            ));
        };
    }
}
