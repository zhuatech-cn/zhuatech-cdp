/* Copyright 2026 Shanghai Rujing Zhihua Information Technology Co., Ltd. */
package cn.zhuatech.cdp.model;
import jakarta.persistence.*; import java.time.LocalDateTime;
@Entity @Table(name="cdp_activation_record") public class ActivationRecord extends BaseEntity {
    @ManyToOne(optional=false,fetch=FetchType.LAZY) private AudienceTask audienceTask; @Column(nullable=false,length=50) private String operationName; @Column(nullable=false) private int goodQty; @Column(nullable=false) private int defectQty;
    @Column(nullable=false,length=50) private String operatorName; @Column(nullable=false) private LocalDateTime reportedAt; @Column(length=200) private String remark;
    protected ActivationRecord(){} public ActivationRecord(AudienceTask audienceTask,String operationName,int goodQty,int defectQty,String operatorName,String remark){this.audienceTask=audienceTask;this.operationName=operationName;this.goodQty=goodQty;this.defectQty=defectQty;this.operatorName=operatorName;this.reportedAt=LocalDateTime.now();this.remark=remark;}
    public AudienceTask getAudienceTask(){return audienceTask;} public String getOperationName(){return operationName;} public int getGoodQty(){return goodQty;} public int getDefectQty(){return defectQty;} public String getOperatorName(){return operatorName;} public LocalDateTime getReportedAt(){return reportedAt;}
}
