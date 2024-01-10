package com.example.artour;

public class PitanjeOdgovorModel {
    private String pitanje;
    private String odgovor;

    public PitanjeOdgovorModel(String pitanje, String odgovor) {
        this.pitanje = pitanje;
        this.odgovor = odgovor;
    }

    public String getPitanje() {
        return pitanje;
    }

    public String getOdgovor() {
        return odgovor;
    }
}