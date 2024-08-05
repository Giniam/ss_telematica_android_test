package com.example.sstelematicaandroidtest.data.remote.api

import com.example.sstelematicaandroidtest.data.remote.response.RepositoryResponse
import com.example.sstelematicaandroidtest.data.remote.response.UserResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface GithubApi {

    companion object {
        const val BASE_URL = "https://api.github.com/"
    }

    @GET("users")
    suspend fun fetchUsers(): List<UserResponse>

    @GET("/users/{username}/repos")
    suspend fun getUserRepos(
        @Path("username") username: String
    ): List<RepositoryResponse>
}