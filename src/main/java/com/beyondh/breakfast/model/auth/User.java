package com.beyondh.breakfast.model.auth;

import net.minidev.json.annotate.JsonIgnore;

/**
 * Created by jliang on 7/17/2017.
 */
public class User {
    private String userName;

    private String password;

    private String shift;

    private String url;

    @JsonIgnore
    private long  orgId;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getShift() {
        return shift;
    }

    public void setShift(String shift) {
        this.shift = shift;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public long getOrgId() {
        return orgId;
    }

    public void setOrgId(long orgId) {
        this.orgId = orgId;
    }
}
