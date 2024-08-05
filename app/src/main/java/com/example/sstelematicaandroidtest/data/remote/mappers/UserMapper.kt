package com.example.sstelematicaandroidtest.data.remote.mappers

import com.example.sstelematicaandroidtest.data.remote.response.UserResponse
import com.example.sstelematicaandroidtest.domain.model.User

object UserMapper : DomainResponseMapper<User, UserResponse> {

    override fun UserResponse.toDomain() = User(
        id = id,
        login = login,
        avatarUrl = avatarUrl,
        url = url
    )

    override fun User.fromDomain() = UserResponse(
        id = id,
        login = login,
        avatarUrl = avatarUrl,
        url = url
    )
}