package com.example.sstelematicaandroidtest.domain.usecase

import com.example.sstelematicaandroidtest.data.repository.UserRepository
import com.example.sstelematicaandroidtest.domain.common.resultBy

class GetAllUsersUseCase(
private val userRepository: UserRepository
) {

    suspend operator fun invoke() = resultBy {
        userRepository.getAll()
    }
}