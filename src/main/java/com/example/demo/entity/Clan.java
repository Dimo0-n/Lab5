package com.example.demo.entity;

public class Clan {
    private String ClanUI;
    private String NumeClan;
    private String NrMembri;
    private String Welcome;

    public Clan(String clanUI, String numeClan, String nrMembri, String welcome) {
        ClanUI = clanUI;
        NumeClan = numeClan;
        NrMembri = nrMembri;
        Welcome = welcome;
    }

    public Clan() {

    }

    public String getClanUI() {
        return ClanUI;
    }

    public void setClanUI(String clanUI) {
        ClanUI = clanUI;
    }

    public String getNumeClan() {
        return NumeClan;
    }

    public void setNumeClan(String numeClan) {
        NumeClan = numeClan;
    }

    public String getNrMembri() {
        return NrMembri;
    }

    public void setNrMembri(String nrMembri) {
        NrMembri = nrMembri;
    }

    public String getWelcome() {
        return Welcome;
    }

    public void setWelcome(String welcome) {
        Welcome = welcome;
    }
}