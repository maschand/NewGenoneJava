package com.newgen.iforms.user.flexiapi;

import com.fasterxml.jackson.annotation.JsonProperty;

public class KtpInput {
    @JsonProperty("pob")
    private String pob;

    @JsonProperty("nama_ibu")
    private String namaIbu;

    @JsonProperty("dob")
    private String dob;

    @JsonProperty("jenis_kelamin")
    private String jenisKelamin;

    @JsonProperty("nama_ktp")
    private String namaKtp;

    // Getters and setters
    public String getPob() {
        return pob;
    }

    public void setPob(String pob) {
        this.pob = pob;
    }

    public String getNamaIbu() {
        return namaIbu;
    }

    public void setNamaIbu(String namaIbu) {
        this.namaIbu = namaIbu;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getJenisKelamin() {
        return jenisKelamin;
    }

    public void setJenisKelamin(String jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
    }

    public String getNamaKtp() {
        return namaKtp;
    }

    public void setNamaKtp(String namaKtp) {
        this.namaKtp = namaKtp;
    }
}
