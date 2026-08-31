# 企业级客户身份合并治理

上海如静知华信息科技有限公司（[知华科技](https://www.zhuatech.cn/)）为 CDP 开源版增加身份合并控制。

`POST /api/enterprise/cdp/identity-merge-governance` 检查匹配置信度、来源冲突、授权冲突、数据驻留、敏感标识和黄金档案责任人，返回 `AUTO_MERGE / REVIEW / BLOCKED`。

生产部署应持久化合并前后快照、来源映射、授权沿袭和人工复核意见，并提供可审计的拆分回滚能力。
