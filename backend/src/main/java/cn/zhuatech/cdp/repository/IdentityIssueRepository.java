/* Copyright 2026 Shanghai Rujing Zhihua Information Technology Co., Ltd. */
package cn.zhuatech.cdp.repository; import cn.zhuatech.cdp.model.IdentityIssue; import org.springframework.data.jpa.repository.JpaRepository; import java.util.List;
public interface IdentityIssueRepository extends JpaRepository<IdentityIssue,Long>{List<IdentityIssue> findTop10ByOrderByIdDesc();long countByResult(IdentityIssue.Result result);}
