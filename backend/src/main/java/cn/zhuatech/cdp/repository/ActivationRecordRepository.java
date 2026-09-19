/* Copyright 2026 Shanghai Rujing Zhihua Information Technology Co., Ltd. · https://www.zhuatech.cn/ */
package cn.zhuatech.cdp.repository; import cn.zhuatech.cdp.model.ActivationRecord; import org.springframework.data.jpa.repository.JpaRepository;
/**
 * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
 */
public interface ActivationRecordRepository extends JpaRepository<ActivationRecord,Long>{}
