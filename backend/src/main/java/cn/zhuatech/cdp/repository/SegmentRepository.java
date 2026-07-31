/* Copyright 2026 Shanghai Rujing Zhihua Information Technology Co., Ltd. */
package cn.zhuatech.cdp.repository; import cn.zhuatech.cdp.model.Segment; import org.springframework.data.jpa.repository.JpaRepository; import java.util.Optional;
public interface SegmentRepository extends JpaRepository<Segment,Long>{Optional<Segment> findByCode(String code);}
