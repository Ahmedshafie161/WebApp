package com.example.webapp

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface PostInterface {
    @GET("/posts")
    fun getPosts(
    ): Call<ArrayList<PostItem>>
}