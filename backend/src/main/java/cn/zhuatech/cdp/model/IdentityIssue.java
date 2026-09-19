/* Copyright 2026 Shanghai Rujing Zhihua Information Technology Co., Ltd. · https://www.zhuatech.cn/ */
package cn.zhuatech.cdp.model;
import jakarta.persistence.*; import java.time.LocalDateTime;
/**
 * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
 */
@Entity @Table(name="cdp_identity_issue") public class IdentityIssue extends BaseEntity {
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public enum Result { PENDING, PASSED, FAILED }
    @Column(nullable=false,unique=true,length=32) private String identityIssueNo; @ManyToOne(optional=false,fetch=FetchType.LAZY) private AudienceTask audienceTask;
    @Column(nullable=false,length=30) private String identityIssueType; @Column(nullable=false) private int identityIssueQty; @Column(nullable=false) private int defectQty; @Enumerated(EnumType.STRING) @Column(nullable=false,length=20) private Result result;
    @Column(length=50) private String inspector; @Column(nullable=false) private LocalDateTime createdAt;
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    protected IdentityIssue(){} /**
                                 * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                 */
public IdentityIssue(String identityIssueNo,AudienceTask audienceTask,String identityIssueType,int identityIssueQty,int defectQty,Result result,String inspector){this.identityIssueNo=identityIssueNo;this.audienceTask=audienceTask;this.identityIssueType=identityIssueType;this.identityIssueQty=identityIssueQty;this.defectQty=defectQty;this.result=result;this.inspector=inspector;this.createdAt=LocalDateTime.now();}
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public String getIdentityIssueNo(){return identityIssueNo;} /**
                                                                 * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                 */
public AudienceTask getAudienceTask(){return audienceTask;} /**
                                                                                                                             * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                                                                             */
public String getIdentityIssueType(){return identityIssueType;} /**
                                                                                                                                                                                             * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                                                                                                                                             */
public int getIdentityIssueQty(){return identityIssueQty;} /**
                                                                                                                                                                                                                                                        * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                                                                                                                                                                                                        */
public int getDefectQty(){return defectQty;} /**
                                                                                                                                                                                                                                                                                                     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                                                                                                                                                                                                                                                     */
public Result getResult(){return result;} /**
                                                                                                                                                                                                                                                                                                                                               * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                                                                                                                                                                                                                                                                                               */
public String getInspector(){return inspector;}
}
