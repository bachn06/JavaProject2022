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
public class TaiKhoan implements Serializable{
    private static final long serialVersionUID = 1L;
    private String tenTK;
    private String pass;
    private String loaiTK;

    public String getTenTK() {
        return tenTK;
    }

    public void setTenTK(String tenTK) {
        this.tenTK = tenTK;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getLoaiTK() {
        return loaiTK;
    }

    public void setLoaiTK(String loaiTK) {
        this.loaiTK = loaiTK;
    }

    public TaiKhoan() {
    }

    public TaiKhoan(String tenTK, String pass, String loaiTK) {
        this.tenTK = tenTK;
        this.pass = pass;
        this.loaiTK = loaiTK;
    }
}
