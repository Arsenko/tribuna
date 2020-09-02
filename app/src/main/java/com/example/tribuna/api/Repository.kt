package com.example.tribuna.api

import com.example.tribuna.models.CounterChangeDto
import com.example.tribuna.models.CounterType
import com.example.tribuna.models.Idea
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import com.example.tribuna.api.interceptor.InjectAuthTokenInterceptor


object Repository {

    private var retrofit: Retrofit =
        Retrofit.Builder()
            .baseUrl("https://srv-ncms.herokuapp.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    fun createRetrofitWithAuth(authToken: String) {
        val httpLoggerInterceptor = HttpLoggingInterceptor()
        httpLoggerInterceptor.level = HttpLoggingInterceptor.Level.BODY

        val client = OkHttpClient.Builder()
            .addInterceptor(InjectAuthTokenInterceptor(authToken))
            .addInterceptor(httpLoggerInterceptor)
            .build()
        retrofit = Retrofit.Builder()
            .client(client)
            .baseUrl("https://srv-ncms.herokuapp.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        API = retrofit.create(com.example.tribuna.api.API::class.java)
    }

    private var API: API =
        retrofit.create(com.example.tribuna.api.API::class.java)


    suspend fun authenticate(login: String, password: String) =
        API.authenticate(
            AuthRequestParams(login, password)
        )

    suspend fun register(login: String, password: String) =
        API.register(
            RegistrationRequestParams(
                login,
                password
            )
        )

    suspend fun createIdea(idea:Idea) = API.createIdea(idea)

    suspend fun getPosts() = API.getIdea()

    suspend fun likeChange(item: Idea):Idea{
        return if (item.likedByMe) {
            item.likedByMe=false
            API.changeCounter(
                item.id?.let { CounterChangeDto(it, false, CounterType.Like) }!!
            )
        } else {
            item.likedByMe=true
            API.changeCounter(
                item.id?.let { CounterChangeDto(it, true, CounterType.Like) }!!
            )
        }
    }

    suspend fun dislikeChange(item: Idea):Idea {
        return if(item.dislikedByMe) {
            item.dislikedByMe=false
            API.changeCounter(
                item.id?.let { CounterChangeDto(it, false, CounterType.Dislike) }!!
            )
        } else{
            item.dislikedByMe=true
            API.changeCounter(
                item.id?.let { CounterChangeDto(it, true, CounterType.Dislike) }!!
            )
        }
    }
}
