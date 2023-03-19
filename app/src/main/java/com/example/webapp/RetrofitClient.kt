package com.example.webapp;

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

object RetrofitClient {
    val retrofit =
        Retrofit.Builder().baseUrl("http://jsonplaceholder.typicode.com").addConverterFactory(
            GsonConverterFactory.create()
        ).build()
    val apiInterface=retrofit.create(PostInterface::class.java)

    fun getPosts(
        onDataRecieved:(ArrayList<PostItem>)->Unit
    ):ArrayList<PostItem>{
        var list:ArrayList<PostItem> = ArrayList()
        apiInterface.getPosts().enqueue(object : Callback<ArrayList<PostItem>>{
            override fun onResponse(call: Call<ArrayList<PostItem>>, response: Response<ArrayList<PostItem>>) {
                list = response.body()?:ArrayList()
                onDataRecieved(list)
            }

            override fun onFailure(call: Call<ArrayList<PostItem>>, t: Throwable) {
                t.printStackTrace()
            }

        })
        return list
    }
}
