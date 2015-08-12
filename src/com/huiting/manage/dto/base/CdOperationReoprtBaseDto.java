package com.huiting.manage.dto.base;

import org.apache.ibatis.type.Alias;

@Alias("cdOperationReoprtBaseDto")
public class CdOperationReoprtBaseDto extends CdOperationReoprtBaseDtoKey {
    private String cdNameLev1;

    private String cdNameLev2;

    public String getCdNameLev1() {
        return cdNameLev1;
    }

    public void setCdNameLev1(String cdNameLev1) {
        this.cdNameLev1 = cdNameLev1 == null ? null : cdNameLev1.trim();
    }

    public String getCdNameLev2() {
        return cdNameLev2;
    }

    public void setCdNameLev2(String cdNameLev2) {
        this.cdNameLev2 = cdNameLev2 == null ? null : cdNameLev2.trim();
    }
}