package com.xinyi.datax_xcloud_web.entity;

/**
 * 请求任务参数对象
 */
public class TaskDescription {

    private Integer tdTaskId ;
    private String tdSourceId ;
    private String tdMode;
    private String tdIncrementColumn ;
    private String tdTableName ;
    private String tdColumns;
    private String tdTargetTableName ;
    private String tdDispatch ;
    private String tdRemarks ;

    public Integer getTdTaskId() {
        return tdTaskId;
    }

    public void setTdTaskId(Integer tdTaskId) {
        this.tdTaskId = tdTaskId;
    }

    public String getTdSourceId() {
        return tdSourceId;
    }

    public void setTdSourceId(String tdSourceId) {
        this.tdSourceId = tdSourceId;
    }

    public String getTdMode() {
        return tdMode;
    }

    public void setTdMode(String tdMode) {
        this.tdMode = tdMode;
    }

    public String getTdIncrementColumn() {
        return tdIncrementColumn;
    }

    public void setTdIncrementColumn(String tdIncrementColumn) {
        this.tdIncrementColumn = tdIncrementColumn;
    }

    public String getTdTableName() {
        return tdTableName;
    }

    public void setTdTableName(String tdTableName) {
        this.tdTableName = tdTableName;
    }

    public String getTdColumns() {
        return tdColumns;
    }

    public void setTdColumns(String tdColumns) {
        this.tdColumns = tdColumns;
    }

    public String getTdTargetTableName() {
        return tdTargetTableName;
    }

    public void setTdTargetTableName(String tdTargetTableName) {
        this.tdTargetTableName = tdTargetTableName;
    }

    public String getTdDispatch() {
        return tdDispatch;
    }

    public void setTdDispatch(String tdDispatch) {
        this.tdDispatch = tdDispatch;
    }

    public String getTdRemarks() {
        return tdRemarks;
    }

    public void setTdRemarks(String tdRemarks) {
        this.tdRemarks = tdRemarks;
    }
}
