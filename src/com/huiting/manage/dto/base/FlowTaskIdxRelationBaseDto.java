package com.huiting.manage.dto.base;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import org.apache.ibatis.type.Alias;
/**
 * 
* @ClassName: FlowTaskIdxRelationBaseDto 
* @Description: FLOW_TASKIDXRELATION
* @author Zou_ZhuoQi
* @date 2013-12-20 下午1:36:51 
*
 */
@Alias("flowTaskIdxRelationBaseDto")
public class FlowTaskIdxRelationBaseDto extends FlowTaskIdxRelationBaseDtoKey implements Serializable {

	private static final long serialVersionUID = 1L;
    private BigDecimal backnums;

    private Date lastbackdate;

    private String lastbackercode;

    public BigDecimal getBacknums() {
        return backnums;
    }

    public void setBacknums(BigDecimal backnums) {
        this.backnums = backnums;
    }

    public Date getLastbackdate() {
        return lastbackdate;
    }

    public void setLastbackdate(Date lastbackdate) {
        this.lastbackdate = lastbackdate;
    }

    public String getLastbackercode() {
        return lastbackercode;
    }

    public void setLastbackercode(String lastbackercode) {
        this.lastbackercode = lastbackercode == null ? null : lastbackercode.trim();
    }
}