package com.example.practic1504;


import com.example.practic1504.SendCodeResponse;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.PUT;

public interface ApiService {
    @POST("sendCode")
    Call<SendCodeResponse> sendCode(@Header("email") String email);
    @POST("signin")
    Call<SendCodeResponse> signin(@Header("email") String email , @Header("code") String code);



}
