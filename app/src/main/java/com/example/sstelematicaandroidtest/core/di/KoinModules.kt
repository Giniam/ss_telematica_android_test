package com.example.sstelematicaandroidtest.core.di

import com.example.sstelematicaandroidtest.data.fake.UserRepositoryFake
import com.example.sstelematicaandroidtest.data.remote.api.GithubApi
import com.example.sstelematicaandroidtest.data.remote.repository.UserRepositoryApi
import com.example.sstelematicaandroidtest.data.repository.UserRepository
import com.example.sstelematicaandroidtest.domain.usecase.GetAllUsersUseCase
import com.example.sstelematicaandroidtest.domain.usecase.GetRepositoriesFromUserUseCase
import com.example.sstelematicaandroidtest.presentation.features.user.details.UserDetailViewModel
import com.example.sstelematicaandroidtest.presentation.features.user.list.UserListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private val apiModule = module {
    single<Retrofit> {
        Retrofit.Builder()
            .baseUrl(GithubApi.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    single<GithubApi> { get<Retrofit>().create(GithubApi::class.java) }
}

@Suppress("UnusedPrivateProperty")
private val repositoriesFakeModule = module {
    single<UserRepository> { UserRepositoryFake }
}

@Suppress("UnusedPrivateProperty")
private val repositoryApiModule = module {
    single<UserRepository> { UserRepositoryApi(get()) }
}

private val useCaseModule = module {
    single { GetAllUsersUseCase(get()) }
    single { GetRepositoriesFromUserUseCase(get()) }
}

private val viewModelModule = module {
    viewModel { UserDetailViewModel(get()) }
    viewModel { UserListViewModel(get()) }
}

object AppModules {

    val modules = module { }.apply {
        includes(apiModule, repositoryApiModule, useCaseModule, viewModelModule)
    }
}