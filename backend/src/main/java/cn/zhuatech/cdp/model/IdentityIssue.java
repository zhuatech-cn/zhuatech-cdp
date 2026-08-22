/* Copyright 2026 Shanghai Rujing Zhihua Information Technology Co., Ltd. · https://www.zhuatech.cn/ */
package cn.zhuatech.cdp.model;
import jakarta.persistence.*; import java.time.LocalDateTime;
@Entity @Table(name="cdp_identity_issue") public class IdentityIssue extends BaseEntity {
    public enum Result { PENDING, PASSED, FAILED }
    @Column(nullable=false,unique=true,length=32) private String identityIssueNo; @ManyToOne(optional=false,fetch=FetchType.LAZY) private AudienceTask audienceTask;
    @Column(nullable=false,length=30) private String identityIssueType; @Column(nullable=false) private int identityIssueQty; @Column(nullable=false) private int defectQty; @Enumerated(EnumType.STRING) @Column(nullable=false,length=20) private Result result;
    @Column(length=50) private String inspector; @Column(nullable=false) private LocalDateTime createdAt;
    protected IdentityIssue(){} public IdentityIssue(String identityIssueNo,AudienceTask audienceTask,String identityIssueType,int identityIssueQty,int defectQty,Result result,String inspector){this.identityIssueNo=identityIssueNo;this.audienceTask=audienceTask;this.identityIssueType=identityIssueType;this.identityIssueQty=identityIssueQty;this.defectQty=defectQty;this.result=result;this.inspector=inspector;this.createdAt=LocalDateTime.now();}
    public String getIdentityIssueNo(){return identityIssueNo;} public AudienceTask getAudienceTask(){return audienceTask;} public String getIdentityIssueType(){return identityIssueType;} public int getIdentityIssueQty(){return identityIssueQty;} public int getDefectQty(){return defectQty;} public Result getResult(){return result;} public String getInspector(){return inspector;}
}
