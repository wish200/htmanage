package com.huiting.manage.dto.base;

public class CdOperationReoprtBaseDtoKey {
    private String cdCodeLev1;

    private String cdCodeLev2;

    public String getCdCodeLev1() {
        return cdCodeLev1;
    }

    public void setCdCodeLev1(String cdCodeLev1) {
        this.cdCodeLev1 = cdCodeLev1 == null ? null : cdCodeLev1.trim();
    }

    public String getCdCodeLev2() {
        return cdCodeLev2;
    }

    public void setCdCodeLev2(String cdCodeLev2) {
        this.cdCodeLev2 = cdCodeLev2 == null ? null : cdCodeLev2.trim();
    }
}