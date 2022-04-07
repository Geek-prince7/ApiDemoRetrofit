package com.example.apidemoretrofit.RetroDemo;

import com.google.gson.annotations.SerializedName;

public class Result {

    @SerializedName("name")
    private String superName;
    private  String realname;


    public Result(String superName, String realname) {
        this.superName = superName;
        this.realname = realname;
    }

    public String getSuperName() {
        return superName;
    }

    public void setSuperName(String superName) {
        this.superName = superName;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }
}
