package com.tutorial.deliserdangapps.model;

public class ModelDeliSerdang {

    String kabupaten;
    String provinsi;
    String detaillengkap;
    int photo;

    public ModelDeliSerdang(String kabupaten, String provinsi, String detaillengkap, int photo) {
        this.kabupaten = kabupaten;
        this.provinsi = provinsi;
        this.detaillengkap = detaillengkap;
        this.photo = photo;
    }

    public String getKabupaten() {
        return this.kabupaten;
    }

    public String getProvinsi() {
        return this.provinsi;
    }

    public String getDetaillengkap() {
        return this.detaillengkap;
    }

    public int getPhoto() {
        return this.photo;
    }
}
