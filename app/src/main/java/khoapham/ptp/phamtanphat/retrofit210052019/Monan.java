package khoapham.ptp.phamtanphat.retrofit210052019;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Monan {

    //ctrl + shift + L
    @SerializedName("Id")
    @Expose
    private String id;
    @SerializedName("Ten")
    @Expose
    private String ten;
    @SerializedName("Gia")
    @Expose
    private String gia;
    @SerializedName("Hinhanh")
    @Expose
    private String hinhanh;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getGia() {
        return gia;
    }

    public void setGia(String gia) {
        this.gia = gia;
    }

    public String getHinhanh() {
        return hinhanh;
    }

    public void setHinhanh(String hinhanh) {
        this.hinhanh = hinhanh;
    }

}