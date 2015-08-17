package com.huiting.manage.dto.base;

public class ModOdsFundBaseDtoKey {
    private String statdate;

    private String handAccount;

    public String getStatdate() {
        return statdate;
    }

    public void setStatdate(String statdate) {
        this.statdate = statdate == null ? null : statdate.trim();
    }

    public String getHandAccount() {
        return handAccount;
    }

    public void setHandAccount(String handAccount) {
        this.handAccount = handAccount == null ? null : handAccount.trim();
    }
}