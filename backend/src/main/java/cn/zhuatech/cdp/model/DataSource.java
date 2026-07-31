/* Copyright 2026 Shanghai Rujing Zhihua Information Technology Co., Ltd. */
package cn.zhuatech.cdp.model;
import jakarta.persistence.*; import java.time.LocalDateTime;
@Entity @Table(name="cdp_data_source") public class DataSource extends BaseEntity {
    public enum Status { RUNNING, IDLE, MAINTENANCE, ALARM }
    @Column(nullable=false,unique=true,length=32) private String code; @Column(nullable=false,length=80) private String name; @ManyToOne(optional=false,fetch=FetchType.LAZY) private Segment segment;
    @Enumerated(EnumType.STRING) @Column(nullable=false,length=20) private Status status; @Column(nullable=false) private int oee; @Column(nullable=false) private LocalDateTime lastHeartbeat;
    protected DataSource(){} public DataSource(String code,String name,Segment segment,Status status,int oee){this.code=code;this.name=name;this.segment=segment;this.status=status;this.oee=oee;this.lastHeartbeat=LocalDateTime.now();}
    public String getCode(){return code;} public String getName(){return name;} public Segment getSegment(){return segment;} public Status getStatus(){return status;} public int getOee(){return oee;} public LocalDateTime getLastHeartbeat(){return lastHeartbeat;}
}
