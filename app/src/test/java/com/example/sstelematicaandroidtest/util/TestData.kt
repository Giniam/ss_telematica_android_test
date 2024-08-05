package com.example.sstelematicaandroidtest.util

import com.example.sstelematicaandroidtest.data.remote.response.RepositoryResponse
import com.example.sstelematicaandroidtest.data.remote.response.UserResponse
import com.example.sstelematicaandroidtest.domain.model.Repository
import com.example.sstelematicaandroidtest.domain.model.User
import com.example.sstelematicaandroidtest.presentation.model.RepositoryPresentation
import com.example.sstelematicaandroidtest.presentation.model.UserPresentation

object TestData {
    val FIRST_USER = User(
        id = 1,
        login = "mojombo",
        avatarUrl = "https://avatars.githubusercontent.com/u/1?v=4",
        url = "https://api.github.com/users/mojombo"
    )

    val SECOND_USER = User(
        id = 2,
        login = "defunkt",
        avatarUrl = "https://avatars.githubusercontent.com/u/2?v=4",
        url = "https://api.github.com/users/defunkt"
    )

    val FIRST_USER_RESPONSE = UserResponse(
        id = 1,
        login = "mojombo",
        avatarUrl = "https://avatars.githubusercontent.com/u/1?v=4",
        url = "https://api.github.com/users/mojombo"
    )

    val SECOND_USER_RESPONSE = UserResponse(
        id = 2,
        login = "defunkt",
        avatarUrl = "https://avatars.githubusercontent.com/u/2?v=4",
        url = "https://api.github.com/users/defunkt"
    )

    val FIRST_USER_PRESENTATION = UserPresentation(
        id = 1,
        login = "mojombo",
        avatarUrl = "https://avatars.githubusercontent.com/u/1?v=4",
        url = "https://api.github.com/users/mojombo"
    )

    val SECOND_USER_PRESENTATION = UserPresentation(
        id = 2,
        login = "defunkt",
        avatarUrl = "https://avatars.githubusercontent.com/u/2?v=4",
        url = "https://api.github.com/users/defunkt"
    )


    val FIRST_REPO = Repository(
        id = 1861402,
        name = "ace",
        url = "https://github.com/defunkt/ace"
    )

    val SECOND_REPO = Repository(
        id = 3594,
        name = "acts_as_textiled",
        url = "https://github.com/defunkt/acts_as_textiled"
    )

    val FIRST_REPO_RESPONSE = RepositoryResponse(
        id = 1861402,
        name = "ace",
        url = "https://github.com/defunkt/ace"
    )

    val SECOND_REPO_RESPONSE = RepositoryResponse(
        id = 3594,
        name = "acts_as_textiled",
        url = "https://github.com/defunkt/acts_as_textiled"
    )

    val FIRST_REPO_PRESENTATION = RepositoryPresentation(
        id = 1861402,
        name = "ace",
        url = "https://github.com/defunkt/ace"
    )

    val SECOND_REPO_PRESENTATION = RepositoryPresentation(
        id = 3594,
        name = "acts_as_textiled",
        url = "https://github.com/defunkt/acts_as_textiled"
    )
}