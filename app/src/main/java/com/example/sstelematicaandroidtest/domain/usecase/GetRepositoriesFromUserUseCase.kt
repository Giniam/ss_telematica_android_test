package com.example.sstelematicaandroidtest.domain.usecase

import com.example.sstelematicaandroidtest.data.repository.UserRepository
import com.example.sstelematicaandroidtest.domain.common.resultBy

class GetRepositoriesFromUserUseCase(
    private val userRepository: UserRepository
) {

    suspend operator fun invoke(name: String) = resultBy {
        userRepository.getUserRepos(name)
    }
}