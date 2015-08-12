package com.huiting.manage.dto.base;

public class ModOdsStockBaseDtoKey {
    private String handAccount;

    private String statdate;

    public String getHandAccount() {
        return handAccount;
    }

    public void setHandAccount(String handAccount) {
        this.handAccount = handAccount == null ? null : handAccount.trim();
    }

    public String getStatdate() {
        return statdate;
    }

    public void setStatdate(String statdate) {
        this.statdate = statdate == null ? null : statdate.trim();
    }
}