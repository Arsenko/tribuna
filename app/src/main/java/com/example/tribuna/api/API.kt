package com.example.tribuna.api

import com.example.tribuna.models.Author
import com.example.tribuna.models.CounterChangeDto
import com.example.tribuna.models.Idea
import retrofit2.Response
import retrofit2.http.*

data class AuthRequestParams(val username: String, val password: String)

data class Token(val token: String)

data class RegistrationRequestParams(val username: String, val password: String)

interface API {
  @POST("api/v1/authentication")
  suspend fun authenticate(@Body authRequestParams: AuthRequestParams): Response<Token>

  @POST("api/v1/registration")
  suspend fun register(@Body registrationRequestParams: RegistrationRequestParams): Response<Token>

  @POST("api/v1/posts")
  suspend fun createIdea(@Body idea: Idea): Response<Void>

  @GET("api/v1/posts")
  suspend fun getIdea(): Response<MutableList<Idea>>

  @POST("api/v1/posts/changeCounter")
  suspend fun changeCounter(@Body counterChange: CounterChangeDto): Idea

  @POST("api/v1/author")
  suspend fun getAuthorByName(@Body authorName: String):Author
}