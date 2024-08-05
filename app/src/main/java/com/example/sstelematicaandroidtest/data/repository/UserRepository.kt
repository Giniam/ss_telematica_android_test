package com.example.sstelematicaandroidtest.data.repository

import com.example.sstelematicaandroidtest.domain.model.Repository
import com.example.sstelematicaandroidtest.domain.model.User

interface UserRepository {

    suspend fun getAll(): List<User>

    suspend fun getUserRepos(username: String): List<Repository>
}