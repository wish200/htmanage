package com.huiting.manage.dto.base;

import org.apache.ibatis.type.Alias;
/**
 * 因子状态改变后的需要修改的表
 * @author ncp
 *
 */
@Alias("ccFacinputtrackChangeBaseDto")
public class CcFacinputtrackChangeBaseDto {
    private String statdate;

    private String newdepcode;

    private String emailsend;

    public String getStatdate() {
        return statdate;
    }

    public void setStatdate(String statdate) {
        this.statdate = statdate == null ? null : statdate.trim();
    }

    public String getNewdepcode() {
        return newdepcode;
    }

    public void setNewdepcode(String newdepcode) {
        this.newdepcode = newdepcode == null ? null : newdepcode.trim();
    }

    public String getEmailsend() {
        return emailsend;
    }

    public void setEmailsend(String emailsend) {
        this.emailsend = emailsend == null ? null : emailsend.trim();
    }
}