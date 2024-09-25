package com.example.buffetec.network

import com.example.buffetec.model.User
import retrofit2.Call
import retrofit2.http.*


    interface ApiService {
        @POST("register")
        fun registerUser(@Body user: User): Call<Void>
    }


