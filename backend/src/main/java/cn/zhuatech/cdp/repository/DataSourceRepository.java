/* Copyright 2026 Shanghai Rujing Zhihua Information Technology Co., Ltd. · https://www.zhuatech.cn/ */
package cn.zhuatech.cdp.repository; import cn.zhuatech.cdp.model.DataSource; import org.springframework.data.jpa.repository.JpaRepository; import java.util.List;
public interface DataSourceRepository extends JpaRepository<DataSource,Long>{List<DataSource> findAllByOrderByCodeAsc();long countByStatus(DataSource.Status status);}
