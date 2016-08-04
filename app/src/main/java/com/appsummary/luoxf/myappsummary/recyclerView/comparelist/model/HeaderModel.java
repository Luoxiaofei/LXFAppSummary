package com.appsummary.luoxf.myappsummary.recyclerView.comparelist.model;

public class HeaderModel {

    private String leftStr;
    private String rightStr;

    public HeaderModel(String leftStr, String rightStr) {
        super();
        this.leftStr = leftStr;
        this.rightStr = rightStr;
    }

    public String getLeftStr() {
        return leftStr;
    }

    public void setLeftStr(String leftStr) {
        this.leftStr = leftStr;
    }

    public String getRightStr() {
        return rightStr;
    }

    public void setRightStr(String rightStr) {
        this.rightStr = rightStr;
    }
}
