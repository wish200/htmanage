package com.huiting.manage.dto.base;

import java.sql.Timestamp;
import java.util.Date;

import org.apache.ibatis.type.Alias;

@Alias("appCommentBaseDto")
public class AppCommentBaseDto {
    private String commentid;

    private String modular;

    private String busiid;

    private String concerneduserid;

    private String concernednickname;

    private String concerneduserpic;

    private Timestamp commenttime;

    private String commenttext;

    private String commentstatus;

    public String getCommentid() {
        return commentid;
    }

    public void setCommentid(String commentid) {
        this.commentid = commentid == null ? null : commentid.trim();
    }

    public String getModular() {
        return modular;
    }

    public void setModular(String modular) {
        this.modular = modular == null ? null : modular.trim();
    }

    public String getBusiid() {
        return busiid;
    }

    public void setBusiid(String busiid) {
        this.busiid = busiid == null ? null : busiid.trim();
    }

    public String getConcerneduserid() {
        return concerneduserid;
    }

    public void setConcerneduserid(String concerneduserid) {
        this.concerneduserid = concerneduserid == null ? null : concerneduserid.trim();
    }

    public String getConcernednickname() {
        return concernednickname;
    }

    public void setConcernednickname(String concernednickname) {
        this.concernednickname = concernednickname == null ? null : concernednickname.trim();
    }

    public String getConcerneduserpic() {
        return concerneduserpic;
    }

    public void setConcerneduserpic(String concerneduserpic) {
        this.concerneduserpic = concerneduserpic == null ? null : concerneduserpic.trim();
    }

 

    public Timestamp getCommenttime() {
		return commenttime;
	}

	public void setCommenttime(Timestamp commenttime) {
		this.commenttime = commenttime;
	}

	public String getCommenttext() {
        return commenttext;
    }

    public void setCommenttext(String commenttext) {
        this.commenttext = commenttext == null ? null : commenttext.trim();
    }

    public String getCommentstatus() {
        return commentstatus;
    }

    public void setCommentstatus(String commentstatus) {
        this.commentstatus = commentstatus == null ? null : commentstatus.trim();
    }
}