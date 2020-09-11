package com.example.myapp2;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface ApiInterface {

    @GET("/api/hours")
    Call<List<SkillsIqList>> getskillsdata();

    @GET("/api/skilliq")
    Call<List<LeaderList>> getlearnersdata();

    @Headers("Content-Type: application/x-www-form-urlencoded")
    @FormUrlEncoded

    @POST("/forms/d/e/1FAIpQLSf9d1TcNU6zc6KR8bSEM41Z1g1zl35cwZr2xyjIhaMAz8WCh")
    Call<ResponseBody> SubmitProject(
            @Field("entry.1824927963") String email,
            @Field("entry.1877115667") String firstName,
            @Field("entry.2006916086") String lastName,
            @Field("entry.284483984") String projectLink

    );

}