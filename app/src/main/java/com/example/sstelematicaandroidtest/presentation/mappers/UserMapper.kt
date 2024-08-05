package com.example.sstelematicaandroidtest.presentation.mappers

import com.example.sstelematicaandroidtest.domain.model.User
import com.example.sstelematicaandroidtest.presentation.model.UserPresentation

object UserMapper : DomainPresentationMapper<User, UserPresentation> {

    override fun UserPresentation.toDomain() = User(
        id = id,
        login = login,
        avatarUrl = avatarUrl,
        url = url
    )

    override fun User.fromDomain() = UserPresentation(
        id = id,
        login = login,
        avatarUrl = avatarUrl,
        url = url
    )
}