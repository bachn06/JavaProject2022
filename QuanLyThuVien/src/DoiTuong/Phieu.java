/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DoiTuong;

import java.io.Serializable;

/**
 *
 * @author Dell 7559
 */
public class Phieu implements Serializable{
    private String maP;
    private String maDG;
    private String maS;
    private int sL;
    private float gia;
    private String ngaymuon;
    private String ngaytra;

    public String getMaP() {
        return maP;
    }

    public void setMaP(String maP) {
        this.maP = maP;
    }

    public String getMaDG() {
        return maDG;
    }

    public void setMaDG(String maDG) {
        this.maDG = maDG;
    }

    public String getMaS() {
        return maS;
    }

    public void setMaS(String maS) {
        this.maS = maS;
    }

    public int getsL() {
        return sL;
    }

    public void setsL(int sL) {
        this.sL = sL;
    }

    public float getGia() {
        return gia;
    }

    public void setGia(float gia) {
        this.gia = gia;
    }

    public String getNgaymuon() {
        return ngaymuon;
    }

    public void setNgaymuon(String ngaymuon) {
        this.ngaymuon = ngaymuon;
    }

    public String getNgaytra() {
        return ngaytra;
    }

    public void setNgaytra(String ngaytra) {
        this.ngaytra = ngaytra;
    }

    public Phieu() {
    }

    public Phieu(String maP, String maDG, String maS, int sL, float gia, String ngaymuon, String ngaytra) {
        this.maP = maP;
        this.maDG = maDG;
        this.maS = maS;
        this.sL = sL;
        this.gia = gia;
        this.ngaymuon = ngaymuon;
        this.ngaytra = ngaytra;
    }
}
