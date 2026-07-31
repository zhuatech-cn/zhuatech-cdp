/* Copyright 2026 Shanghai Rujing Zhihua Information Technology Co., Ltd. */
package cn.zhuatech.cdp.model;
import jakarta.persistence.*;
@Entity @Table(name="cdp_user")
public class UserAccount extends BaseEntity {
    public enum Role { ADMIN, CDP_MANAGER, CAMPAIGN_OPERATOR, QUALITY }
    @Column(nullable=false,unique=true,length=32) private String username; @Column(nullable=false) private String password;
    @Column(nullable=false,length=50) private String fullName; @Enumerated(EnumType.STRING) @Column(nullable=false,length=20) private Role role;
    @Column(name="segment_code",length=32) private String segmentCode; @Column(nullable=false) private boolean enabled=true;
    protected UserAccount(){}
    public UserAccount(String username,String password,String fullName,Role role,String segmentCode){this.username=username;this.password=password;this.fullName=fullName;this.role=role;this.segmentCode=segmentCode;}
    public String getUsername(){return username;} public String getPassword(){return password;} public String getFullName(){return fullName;} public Role getRole(){return role;} public String getSegmentCode(){return segmentCode;} public boolean isEnabled(){return enabled;}
}
