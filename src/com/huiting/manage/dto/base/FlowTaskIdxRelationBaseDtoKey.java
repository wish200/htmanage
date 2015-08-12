package com.huiting.manage.dto.base;

import java.io.Serializable;
import java.util.Date;

import org.apache.ibatis.type.Alias;
/**
 * 
* @ClassName: FlowTaskIdxRelationBaseDtoKey 
* @Description: FLOW_TASKIDXRELATION 主键
* @author Zou_ZhuoQi
* @date 2013-12-20 下午1:36:45 
*
 */
@Alias("flowTaskIdxRelationBaseDtoKey")
public class FlowTaskIdxRelationBaseDtoKey implements Serializable {

	private static final long serialVersionUID = 1L;
    private String taskcode;

    private String indexcode;

    private Date statdate;

    public String getTaskcode() {
        return taskcode;
    }

    public void setTaskcode(String taskcode) {
        this.taskcode = taskcode == null ? null : taskcode.trim();
    }

    public String getIndexcode() {
        return indexcode;
    }

    public void setIndexcode(String indexcode) {
        this.indexcode = indexcode == null ? null : indexcode.trim();
    }

    public Date getStatdate() {
        return statdate;
    }

    public void setStatdate(Date statdate) {
        this.statdate = statdate;
    }
}