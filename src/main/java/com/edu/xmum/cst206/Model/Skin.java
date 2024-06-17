package com.edu.xmum.cst206.Model;

public enum Skin {
    V1,V2,V3,Vs,AI;
    public String getSkin() {
        switch (this) {
            case V1:
                return "V1";
            case V2:
                return "V2";
            case V3:
                return "V3";
            case Vs:
                return "Vs";
            case AI:
                return "AI";
            default:
                return null;
        }
    }

}
