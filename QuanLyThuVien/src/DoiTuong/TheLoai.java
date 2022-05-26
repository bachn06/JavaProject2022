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
public class TheLoai implements Serializable{
    private String maTL;
    private String tenTL;

    public TheLoai(String string) {
        
    }

    public String getMaTL() {
        return maTL;
    }

    public void setMaTL(String maTL) {
        this.maTL = maTL;
    }

    public String getTenTL() {
        return tenTL;
    }

    public void setTenTL(String tenTL) {
        this.tenTL = tenTL;
    }

    public TheLoai() {
    }

    public TheLoai(String maTL, String tenTL) {
        this.maTL = maTL;
        this.tenTL = tenTL;
    }
}
