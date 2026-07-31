# CDP 架构

版权所有 © 2026 上海如静知华信息科技有限公司。

浏览器通过 Vue 管理端或营销运营专员端访问 Spring Boot REST API。安全层完成 JWT 与角色鉴权，业务层负责激活任务、客户、数据源、身份合并和结果记录，JPA/Flyway 管理 MySQL 数据。

管理端角色为 `CDP_MANAGER`、`QUALITY`、`ADMIN`；执行端角色为 `CAMPAIGN_OPERATOR`。正式部署建议将数据源连接置于独立采集服务，并隔离受众分群网络和办公网络。
