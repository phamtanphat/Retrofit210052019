package khoapham.ptp.phamtanphat.retrofit210052019;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.sql.Time;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 1 : Khởi tạo retrofit
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .readTimeout(60 , TimeUnit.SECONDS)
                .writeTimeout(60 , TimeUnit.SECONDS)
                .connectTimeout(60 , TimeUnit.SECONDS)
                .retryOnConnectionFailure(true)
                .protocols(Arrays.asList(Protocol.HTTP_1_1))
                .build();

        Gson gson = new GsonBuilder().disableHtmlEscaping().create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://172.16.1.17:81/")
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        //2 : Khởi tạo interface request

        Requestrepository requestrepository = retrofit.create(Requestrepository.class);

        Call<List<Monan>> callback = requestrepository.getMonan();
        // 3 : Nhận giá trị qua callback

        callback.enqueue(new Callback<List<Monan>>() {
            @Override
            public void onResponse(Call<List<Monan>> call, Response<List<Monan>> response) {
                List<Monan> mangmonan = response.body();
                for (Monan monan : mangmonan){
                    Log.d("BBB",monan.getHinhanh());
                }
            }

            @Override
            public void onFailure(Call<List<Monan>> call, Throwable t) {

            }
        });

    //1 : Get : https://server2301.herokuapp.com/word
    //2 : Post : https://server2301.herokuapp.com/word
//        +Gửi lên 2 giá trị có keyword "en" , "vn"
    //3 : Put : https://server2301.herokuapp.com/word/id gia tri
//            +Gửi lên 1 giá trị có keyword "isMemorized"
    //4 : Delete : https://server2301.herokuapp.com/word/id gia tri


    }
}
