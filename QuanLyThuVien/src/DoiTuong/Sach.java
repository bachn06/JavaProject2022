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
public class Sach implements Serializable{
    private static final long serialVersionUID = 1L;
    private String maS;
    private String tenS;
    private String maTL;
    private String tenTG;
    private int sL;
    private float gia;

    public String getMaS() {
        return maS;
    }

    public void setMaS(String maS) {
        this.maS = maS;
    }

    public String getTenS() {
        return tenS;
    }

    public void setTenS(String tenS) {
        this.tenS = tenS;
    }

    public String getMaTL() {
        return maTL;
    }

    public void setMaTL(String maTL) {
        this.maTL = maTL;
    }

    public String getTenTG() {
        return tenTG;
    }

    public void setTenTG(String tenTG) {
        this.tenTG = tenTG;
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

    public Sach() {
    }

    public Sach(String maS, String tenS, String maTL, String tenTG, int sL, float gia) {
        this.maS = maS;
        this.tenS = tenS;
        this.maTL = maTL;
        this.tenTG = tenTG;
        this.sL = sL;
        this.gia = gia;
    }
}
