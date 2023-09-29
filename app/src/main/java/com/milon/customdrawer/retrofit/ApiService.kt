package com.milon.customdrawer.retrofit


import com.milon.customdrawer.dataclass.MenuItemItem
import retrofit2.Call
import retrofit2.http.GET


interface ApiService {


    //target response

    @GET("/users")
    fun getUsers(): Call<List<MenuItemItem>>

}