package khoapham.ptp.phamtanphat.retrofit210052019;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Requestrepository {
    //định nghĩa chú thích cho request này sử dụng phương thức gì
    //Đường dẫn gốc : (BAseurl : http:// 172.16.1.17:81/)


    //Đoạn còn lại để truy cập tới đoạn request
    //Quanlymonan/server/monan.php
    @GET("Quanlymonan/server/monan.php")
    Call<List<Monan>> getMonan();

}
