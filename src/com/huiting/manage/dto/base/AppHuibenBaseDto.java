package com.huiting.manage.dto.base;

import java.util.Date;

import org.apache.ibatis.type.Alias;

@Alias("appHuibenBaseDto")
public class AppHuibenBaseDto {
    private String huibenid;

    private String picbookid;

    private String picbookname;

    private String picbookurl;

    private String picscene;

    private String audioid;

    private String audioname;

    private String audiourl;

    private String audiolength;

    private String audiocontent;

    private String userid;

    private String nickname;

    private String userpic;

    private Integer flowercnt;

    private String status;

    private Integer commentcnt;

    private Date createtime;

    private String flag;

    public String getHuibenid() {
        return huibenid;
    }

    public void setHuibenid(String huibenid) {
        this.huibenid = huibenid == null ? null : huibenid.trim();
    }

    public String getPicbookid() {
        return picbookid;
    }

    public void setPicbookid(String picbookid) {
        this.picbookid = picbookid == null ? null : picbookid.trim();
    }

    public String getPicbookname() {
        return picbookname;
    }

    public void setPicbookname(String picbookname) {
        this.picbookname = picbookname == null ? null : picbookname.trim();
    }

    public String getPicbookurl() {
        return picbookurl;
    }

    public void setPicbookurl(String picbookurl) {
        this.picbookurl = picbookurl == null ? null : picbookurl.trim();
    }

    public String getPicscene() {
        return picscene;
    }

    public void setPicscene(String picscene) {
        this.picscene = picscene == null ? null : picscene.trim();
    }

    public String getAudioid() {
        return audioid;
    }

    public void setAudioid(String audioid) {
        this.audioid = audioid == null ? null : audioid.trim();
    }

    public String getAudioname() {
        return audioname;
    }

    public void setAudioname(String audioname) {
        this.audioname = audioname == null ? null : audioname.trim();
    }

    public String getAudiourl() {
        return audiourl;
    }

    public void setAudiourl(String audiourl) {
        this.audiourl = audiourl == null ? null : audiourl.trim();
    }

    public String getAudiolength() {
        return audiolength;
    }

    public void setAudiolength(String audiolength) {
        this.audiolength = audiolength == null ? null : audiolength.trim();
    }

    public String getAudiocontent() {
        return audiocontent;
    }

    public void setAudiocontent(String audiocontent) {
        this.audiocontent = audiocontent == null ? null : audiocontent.trim();
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    public String getUserpic() {
        return userpic;
    }

    public void setUserpic(String userpic) {
        this.userpic = userpic == null ? null : userpic.trim();
    }

    public Integer getFlowercnt() {
        return flowercnt;
    }

    public void setFlowercnt(Integer flowercnt) {
        this.flowercnt = flowercnt;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public Integer getCommentcnt() {
        return commentcnt;
    }

    public void setCommentcnt(Integer commentcnt) {
        this.commentcnt = commentcnt;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag == null ? null : flag.trim();
    }
}