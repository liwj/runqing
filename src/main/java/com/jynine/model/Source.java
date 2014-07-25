package com.jynine.model;

import java.util.List;

public class Source {
    private String sourceid;

    private String sourcename;

    private String sourceurl;

    private Integer sourcetype;

    private Integer sourceindex;

    private String sourceparent;

    private Integer roleId;
    
    private Integer level;
    
    private String btnName;
    
    private String btnType;
    
    private String btnImgUrl;
    
    private List<Source> sources;
    public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public String getSourceid() {
        return sourceid;
    }

    public void setSourceid(String sourceid) {
        this.sourceid = sourceid == null ? null : sourceid.trim();
    }

    public String getSourcename() {
        return sourcename;
    }

    public void setSourcename(String sourcename) {
        this.sourcename = sourcename == null ? null : sourcename.trim();
    }

    public String getSourceurl() {
        return sourceurl;
    }

    public void setSourceurl(String sourceurl) {
        this.sourceurl = sourceurl == null ? null : sourceurl.trim();
    }

    public Integer getSourcetype() {
        return sourcetype;
    }

    public void setSourcetype(Integer sourcetype) {
        this.sourcetype = sourcetype;
    }

    public Integer getSourceindex() {
        return sourceindex;
    }

    public void setSourceindex(Integer sourceindex) {
        this.sourceindex = sourceindex;
    }

    public String getSourceparent() {
        return sourceparent;
    }

    public void setSourceparent(String sourceparent) {
        this.sourceparent = sourceparent == null ? null : sourceparent.trim();
    }

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public List<Source> getSources() {
		return sources;
	}

	public void setSources(List<Source> sources) {
		this.sources = sources;
	}

	public String getBtnName() {
		return btnName;
	}

	public void setBtnName(String btnName) {
		this.btnName = btnName;
	}

	public String getBtnType() {
		return btnType;
	}

	public void setBtnType(String btnType) {
		this.btnType = btnType;
	}

	public String getBtnImgUrl() {
		return btnImgUrl;
	}

	public void setBtnImgUrl(String btnImgUrl) {
		this.btnImgUrl = btnImgUrl;
	}
    
}
