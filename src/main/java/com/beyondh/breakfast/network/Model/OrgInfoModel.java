package com.beyondh.breakfast.network.Model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by jliang on 7/31/2017.
 */
public class OrgInfoModel {
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getpId() {
        return pId;
    }

    public void setpId(Long pId) {
        this.pId = pId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getOpen() {
        return open;
    }

    public void setOpen(Boolean open) {
        this.open = open;
    }

    public String getOrgSn() {
        return orgSn;
    }

    public void setOrgSn(String orgSn) {
        this.orgSn = orgSn;
    }

    public Byte getOrgTypeId() {
        return orgTypeId;
    }

    public void setOrgTypeId(Byte orgTypeId) {
        this.orgTypeId = orgTypeId;
    }

    public Long id;
    public Long pId;
    private String name;
    private Boolean open;

    @JsonProperty("OrgSn")
    private String orgSn;

    @JsonProperty("OrgTypeId")
    private Byte orgTypeId;
}
