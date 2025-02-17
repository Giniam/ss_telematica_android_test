package com.example.sstelematicaandroidtest.presentation.features.user.details

import androidx.annotation.VisibleForTesting
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sstelematicaandroidtest.domain.common.Result
import com.example.sstelematicaandroidtest.domain.usecase.GetRepositoriesFromUserUseCase
import com.example.sstelematicaandroidtest.presentation.mappers.RepositoryMapper.fromDomainList
import com.example.sstelematicaandroidtest.presentation.model.RepositoryPresentation
import com.example.sstelematicaandroidtest.presentation.model.UserPresentation
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class UserDetailViewModel(
    private val getRepositoriesFromUserUseCase: GetRepositoriesFromUserUseCase
) : ViewModel() {

    @Suppress("PropertyName")
    @VisibleForTesting(otherwise = VisibleForTesting.PRIVATE)
    val _fetchRepositoriesState = MutableStateFlow<FetchRepositoriesState>(Fetching)
    val fetchRepositoriesState = _fetchRepositoriesState.asStateFlow()

    fun fetchRepositoriesFromUser(userPresentation: UserPresentation) = viewModelScope.launch {
        val result = getRepositoriesFromUserUseCase(userPresentation.login)
        _fetchRepositoriesState.value = when (result) {
            is Result.Error -> Error(result.throwable)
            is Result.Success -> if (result.data.isEmpty()) {
                EmptyList
            } else {
                Fetched(result.data.fromDomainList())
            }
        }
    }
}

sealed interface FetchRepositoriesState
data object Fetching : FetchRepositoriesState
data object EmptyList : FetchRepositoriesState
data class Error(val throwable: Throwable) : FetchRepositoriesState
data class Fetched(val repositories: List<RepositoryPresentation>) : FetchRepositoriesState
