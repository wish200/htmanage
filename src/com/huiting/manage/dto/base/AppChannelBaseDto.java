package com.huiting.manage.dto.base;

import org.apache.ibatis.type.Alias;

@Alias("appChannelBaseDto")
public class AppChannelBaseDto {
    private String channelid;

    private String channelname;

    private String channeldesc;

    private String djname;

    private String djdesc;

    private Integer programcnt;

    private Integer flowercnt;

    private Integer fanscnt;

    private String channelpic;

    private String backgroundpic;

    private String sort;

    private String status;

    public String getChannelid() {
        return channelid;
    }

    public void setChannelid(String channelid) {
        this.channelid = channelid == null ? null : channelid.trim();
    }

    public String getChannelname() {
        return channelname;
    }

    public void setChannelname(String channelname) {
        this.channelname = channelname == null ? null : channelname.trim();
    }

    public String getChanneldesc() {
        return channeldesc;
    }

    public void setChanneldesc(String channeldesc) {
        this.channeldesc = channeldesc == null ? null : channeldesc.trim();
    }

    public String getDjname() {
        return djname;
    }

    public void setDjname(String djname) {
        this.djname = djname == null ? null : djname.trim();
    }

    public String getDjdesc() {
        return djdesc;
    }

    public void setDjdesc(String djdesc) {
        this.djdesc = djdesc == null ? null : djdesc.trim();
    }

    public Integer getProgramcnt() {
        return programcnt;
    }

    public void setProgramcnt(Integer programcnt) {
        this.programcnt = programcnt;
    }

    public Integer getFlowercnt() {
        return flowercnt;
    }

    public void setFlowercnt(Integer flowercnt) {
        this.flowercnt = flowercnt;
    }

    public Integer getFanscnt() {
        return fanscnt;
    }

    public void setFanscnt(Integer fanscnt) {
        this.fanscnt = fanscnt;
    }

    public String getChannelpic() {
        return channelpic;
    }

    public void setChannelpic(String channelpic) {
        this.channelpic = channelpic == null ? null : channelpic.trim();
    }

    public String getBackgroundpic() {
        return backgroundpic;
    }

    public void setBackgroundpic(String backgroundpic) {
        this.backgroundpic = backgroundpic == null ? null : backgroundpic.trim();
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort == null ? null : sort.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }
}