/* Copyright 2026 Shanghai Rujing Zhihua Information Technology Co., Ltd. */
package cn.zhuatech.cdp.dto;
import jakarta.validation.constraints.*; import java.time.*; import java.util.List;
public final class CdpDto { private CdpDto(){}
    public record Metric(String label,String value,String hint,String tone){}
    public record AudienceTaskView(Long id,String orderNo,String productCode,String productName,String segment,String workshop,int plannedQty,int completedQty,int defectQty,LocalDate dueDate,String status,String batchNo,int progress){}
    public record DataSourceView(String code,String name,String segment,String status,int oee,LocalDateTime lastHeartbeat){}
    public record IdentityIssueView(String identityIssueNo,String orderNo,String productName,String identityIssueType,int identityIssueQty,int defectQty,String result,String inspector){}
    public record Dashboard(List<Metric> metrics,List<AudienceTaskView> audienceTasks,List<DataSourceView> dataSource,List<IdentityIssueView> identityIssues){}
    public record ReportRequest(@NotBlank String operationName,@Positive int goodQty,@PositiveOrZero int defectQty,@Size(max=200) String remark){}
    public record ReportResult(String orderNo,int completedQty,int defectQty,int progress,String status){}
}
