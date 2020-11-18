/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.burakyavru.dovizapi.model;

/**
 *
 * @author ismai
 */
public class ParaBirimi {
    private String birimAd;
    private double alisDegeri;
    private double satisDegeri;

    public ParaBirimi(String birimAd, double alisDegeri, double satisDegeri) {
        this.birimAd = birimAd;
        this.alisDegeri = alisDegeri;
        this.satisDegeri = satisDegeri;
    }

    public String getBirimAd() {
        return birimAd;
    }

    public void setBirimAd(String birimAd) {
        this.birimAd = birimAd;
    }

    public double getAlisDegeri() {
        return alisDegeri;
    }

    public void setAlisDegeri(double alisDegeri) {
        this.alisDegeri = alisDegeri;
    }

    public double getSatisDegeri() {
        return satisDegeri;
    }

    public void setSatisDegeri(double satisDegeri) {
        this.satisDegeri = satisDegeri;
    }

    @Override
    public String toString() {
        return "ParaBirimi{" + "birimAd=" + birimAd + ", alisDegeri=" + alisDegeri + ", satisDegeri=" + satisDegeri + '}';
    }
    
    
    
    
}
