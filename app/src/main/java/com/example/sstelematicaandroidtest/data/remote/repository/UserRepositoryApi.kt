package com.example.sstelematicaandroidtest.data.remote.repository

import com.example.sstelematicaandroidtest.data.remote.api.GithubApi
import com.example.sstelematicaandroidtest.data.remote.mappers.RepositoryMapper.toDomainList
import com.example.sstelematicaandroidtest.data.remote.mappers.UserMapper.toDomainList
import com.example.sstelematicaandroidtest.data.repository.UserRepository
import com.example.sstelematicaandroidtest.domain.model.Repository
import com.example.sstelematicaandroidtest.domain.model.User

class UserRepositoryApi(private val githubApi: GithubApi) : UserRepository {

    override suspend fun getAll(): List<User> {
        return githubApi.fetchUsers().toDomainList()
    }

    override suspend fun getUserRepos(username: String): List<Repository> {
        return githubApi.getUserRepos(username).toDomainList()
    }
}