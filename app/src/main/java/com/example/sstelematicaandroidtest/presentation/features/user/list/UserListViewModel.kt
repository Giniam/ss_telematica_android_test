package com.example.sstelematicaandroidtest.presentation.features.user.list

import androidx.annotation.VisibleForTesting
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sstelematicaandroidtest.domain.common.Result
import com.example.sstelematicaandroidtest.domain.usecase.GetAllUsersUseCase
import com.example.sstelematicaandroidtest.presentation.mappers.UserMapper.fromDomainList
import com.example.sstelematicaandroidtest.presentation.model.UserPresentation
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class UserListViewModel(
    private val getAllUsersUseCase: GetAllUsersUseCase
) : ViewModel() {

    @Suppress("PropertyName")
    @VisibleForTesting(otherwise = VisibleForTesting.PRIVATE)
    val _fetchUsersState = MutableStateFlow<FetchUserState>(Fetching)
    val fetchUsersState = _fetchUsersState.asStateFlow()

    fun fetchAllUsers() = viewModelScope.launch {
        val result = getAllUsersUseCase()
        _fetchUsersState.value = when (result) {
            is Result.Error -> Error(result.throwable)
            is Result.Success -> Fetched(result.data.fromDomainList())
        }
    }
}

sealed interface FetchUserState
data object Fetching : FetchUserState
data class Error(val throwable: Throwable) : FetchUserState
data class Fetched(val users: List<UserPresentation>) : FetchUserState
