package com.example.test;

public class Coder {
    private int pId;
    private String pName;
    private String pLang;

    public Coder() {
        super();
    }

    public Coder(int pId, String pName, String pLang) {
        this.pId = pId;
        this.pName = pName;
        this.pLang = pLang;
    }

    public int getpId() {
        return pId;
    }

    public void setpId(int pId) {
        this.pId = pId;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public String getpLang() {
        return pLang;
    }

    public void setpLang(String pLang) {
        this.pLang = pLang;
    }
}
