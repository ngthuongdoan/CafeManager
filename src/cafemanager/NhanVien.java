/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cafemanager;

/**
 *
 * @author ASUS
 */
public class NhanVien {
    
    private int maNVInt;
    private String hoTenNVString;
    private String chucVuNVString;
    private String diaChiNVString;
    private String sdtNVString;
    private String taiKhoanNVString;
    private String matKhauNVString;
    

    public NhanVien() {
        this.maNVInt = 0;
        this.hoTenNVString = "";
        this.chucVuNVString = "";
        this.diaChiNVString = "";
        this.sdtNVString = "";
        this.taiKhoanNVString = "";
        this.matKhauNVString = "";
    }

    public NhanVien(int maNVString, String hoTenNVString, String chucVuNVString, String diaChiNVString, String sdtNVString, String taiKhoanNVString, String matKhauNVString) {
        this.maNVInt = maNVString;
        this.hoTenNVString = hoTenNVString;
        this.chucVuNVString = chucVuNVString;
        this.diaChiNVString = diaChiNVString;
        this.sdtNVString = sdtNVString;
        this.taiKhoanNVString = taiKhoanNVString;
        this.matKhauNVString = matKhauNVString;
    }

    public int getMaNVInt() {
        return maNVInt;
    }

    public void setMaNVInt(int maNVInt) {
        this.maNVInt = maNVInt;
    }

    public String getHoTenNVString() {
        return hoTenNVString;
    }

    public void setHoTenNVString(String hoTenNVString) {
        this.hoTenNVString = hoTenNVString;
    }

    public String getChucVuNVString() {
        return chucVuNVString;
    }

    public void setChucVuNVString(String chucVuNVString) {
        this.chucVuNVString = chucVuNVString;
    }

    public String getDiaChiNVString() {
        return diaChiNVString;
    }

    public void setDiaChiNVString(String diaChiNVString) {
        this.diaChiNVString = diaChiNVString;
    }

    public String getSdtNVString() {
        return sdtNVString;
    }

    public void setSdtNVString(String sdtNVString) {
        this.sdtNVString = sdtNVString;
    }

    public String getTaiKhoanNVString() {
        return taiKhoanNVString;
    }

    public void setTaiKhoanNVString(String taiKhoanNVString) {
        this.taiKhoanNVString = taiKhoanNVString;
    }

    public String getMatKhauNVString() {
        return matKhauNVString;
    }

    public void setMatKhauNVString(String matKhauNVString) {
        this.matKhauNVString = matKhauNVString;
    }
    
}
