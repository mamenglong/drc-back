package com.drc.mybatis.entity;

import java.io.Serializable;

public class Reportimg implements Serializable {
    private Integer id;

    private Integer reportid;

    private String measurementvalue;

    private String path;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getReportid() {
        return reportid;
    }

    public void setReportid(Integer reportid) {
        this.reportid = reportid;
    }

    public String getMeasurementvalue() {
        return measurementvalue;
    }

    public void setMeasurementvalue(String measurementvalue) {
        this.measurementvalue = measurementvalue == null ? null : measurementvalue.trim();
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path == null ? null : path.trim();
    }
}