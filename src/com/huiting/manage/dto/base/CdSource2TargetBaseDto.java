package com.huiting.manage.dto.base;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;

/**
 * 
* @ClassName: CdSource2TargetBaseDto 
* @Description: CD_SOURCE2TARGET
* @author Zou_ZhuoQi
* @date 2013-12-20 下午1:37:59 
*
 */
@Alias("cdSource2TargetBaseDto")
public class CdSource2TargetBaseDto implements Serializable {

	private static final long serialVersionUID = 1L;
    private String faccode;

    private String sourcedesc;

    private String judgeiden1;

    private String judgeiden2;

    private String judgeiden3;

    private String judgedesc4;

    private String judgeiden5;

    private String judgedesc1;

    private String judgedesc2;

    private String judgedesc3;

    private String judgeiden4;

    private String judgedesc5;

    public String getFaccode() {
        return faccode;
    }

    public void setFaccode(String faccode) {
        this.faccode = faccode == null ? null : faccode.trim();
    }

    public String getSourcedesc() {
        return sourcedesc;
    }

    public void setSourcedesc(String sourcedesc) {
        this.sourcedesc = sourcedesc == null ? null : sourcedesc.trim();
    }

    public String getJudgeiden1() {
        return judgeiden1;
    }

    public void setJudgeiden1(String judgeiden1) {
        this.judgeiden1 = judgeiden1 == null ? null : judgeiden1.trim();
    }

    public String getJudgeiden2() {
        return judgeiden2;
    }

    public void setJudgeiden2(String judgeiden2) {
        this.judgeiden2 = judgeiden2 == null ? null : judgeiden2.trim();
    }

    public String getJudgeiden3() {
        return judgeiden3;
    }

    public void setJudgeiden3(String judgeiden3) {
        this.judgeiden3 = judgeiden3 == null ? null : judgeiden3.trim();
    }

    public String getJudgedesc4() {
        return judgedesc4;
    }

    public void setJudgedesc4(String judgedesc4) {
        this.judgedesc4 = judgedesc4 == null ? null : judgedesc4.trim();
    }

    public String getJudgeiden5() {
        return judgeiden5;
    }

    public void setJudgeiden5(String judgeiden5) {
        this.judgeiden5 = judgeiden5 == null ? null : judgeiden5.trim();
    }

    public String getJudgedesc1() {
        return judgedesc1;
    }

    public void setJudgedesc1(String judgedesc1) {
        this.judgedesc1 = judgedesc1 == null ? null : judgedesc1.trim();
    }

    public String getJudgedesc2() {
        return judgedesc2;
    }

    public void setJudgedesc2(String judgedesc2) {
        this.judgedesc2 = judgedesc2 == null ? null : judgedesc2.trim();
    }

    public String getJudgedesc3() {
        return judgedesc3;
    }

    public void setJudgedesc3(String judgedesc3) {
        this.judgedesc3 = judgedesc3 == null ? null : judgedesc3.trim();
    }

    public String getJudgeiden4() {
        return judgeiden4;
    }

    public void setJudgeiden4(String judgeiden4) {
        this.judgeiden4 = judgeiden4 == null ? null : judgeiden4.trim();
    }

    public String getJudgedesc5() {
        return judgedesc5;
    }

    public void setJudgedesc5(String judgedesc5) {
        this.judgedesc5 = judgedesc5 == null ? null : judgedesc5.trim();
    }
}