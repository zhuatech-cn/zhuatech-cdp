/* Copyright 2026 Shanghai Rujing Zhihua Information Technology Co., Ltd. · https://www.zhuatech.cn/ */
package cn.zhuatech.cdp.model;
import jakarta.persistence.*; import java.time.LocalDateTime;
/**
 * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
 */
@Entity @Table(name="cdp_activation_record") public class ActivationRecord extends BaseEntity {
    @ManyToOne(optional=false,fetch=FetchType.LAZY) private AudienceTask audienceTask; @Column(nullable=false,length=50) private String operationName; @Column(nullable=false) private int goodQty; @Column(nullable=false) private int defectQty;
    @Column(nullable=false,length=50) private String operatorName; @Column(nullable=false) private LocalDateTime reportedAt; @Column(length=200) private String remark;
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    protected ActivationRecord(){} /**
                                    * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                    */
public ActivationRecord(AudienceTask audienceTask,String operationName,int goodQty,int defectQty,String operatorName,String remark){this.audienceTask=audienceTask;this.operationName=operationName;this.goodQty=goodQty;this.defectQty=defectQty;this.operatorName=operatorName;this.reportedAt=LocalDateTime.now();this.remark=remark;}
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public AudienceTask getAudienceTask(){return audienceTask;} /**
                                                                 * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                 */
public String getOperationName(){return operationName;} /**
                                                                                                                         * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                                                                         */
public int getGoodQty(){return goodQty;} /**
                                                                                                                                                                  * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                                                                                                                  */
public int getDefectQty(){return defectQty;} /**
                                                                                                                                                                                                               * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                                                                                                                                                               */
public String getOperatorName(){return operatorName;} /**
                                                                                                                                                                                                                                                                     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                                                                                                                                                                                                                     */
public LocalDateTime getReportedAt(){return reportedAt;}
}
