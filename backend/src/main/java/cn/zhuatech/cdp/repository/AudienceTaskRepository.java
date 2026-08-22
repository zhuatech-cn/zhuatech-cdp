/* Copyright 2026 Shanghai Rujing Zhihua Information Technology Co., Ltd. · https://www.zhuatech.cn/ */
package cn.zhuatech.cdp.repository; import cn.zhuatech.cdp.model.AudienceTask; import org.springframework.data.jpa.repository.JpaRepository; import java.util.List;
public interface AudienceTaskRepository extends JpaRepository<AudienceTask,Long>{List<AudienceTask> findAllByOrderByDueDateAsc();List<AudienceTask> findBySegmentCodeOrderByDueDateAsc(String code);long countByStatus(AudienceTask.Status status);}
