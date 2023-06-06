package com.company.tds;

public class Type {

    public static final String entier = "INT";
    public static final String booleen = "BOOL";
    public static final String vide = "VOID";
    public static final String tableau = "ARRAY";
    public static final String fonction = "FUNCTION";

    public String type;
    public String soustype;
    public int[] decallages;
    public int nbArg;

    public Type(String type, String soustype, int nbArg) {
        this.type = this.determineType(type);
        this.soustype = soustype == null ? null : this.determineType(soustype);
        this.decallages = null;
        this.nbArg = nbArg;
    }

    private String determineType(String type) {
        String t = "";
        switch (type.toUpperCase()) {
            case entier:
                t = entier;
                break;
            case booleen:
                t = booleen;
                break;
            case vide:
                t = vide;
                break;
            case tableau:
                t = tableau;
                break;
            case fonction:
                t = fonction;
                break;
            default:
                t = null;
        }
        return t;
    }

    public String getType() {
        return this.type;
    }

    public String getSoustype() {
        return this.soustype;
    }

    public int[] getDecallages() {
        return decallages;
    }

    public void setDecallages(int[] decallages) {
        this.decallages = decallages;
    }

    public String toString(){
        return type+" "+soustype+" "+nbArg+" ";
    }
}
