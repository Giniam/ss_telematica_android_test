package com.example.sstelematicaandroidtest.data.remote.mappers

import com.example.sstelematicaandroidtest.data.remote.response.RepositoryResponse
import com.example.sstelematicaandroidtest.domain.model.Repository

object RepositoryMapper : DomainResponseMapper<Repository, RepositoryResponse> {

    override fun RepositoryResponse.toDomain() = Repository(
        id = id,
        name = name,
        url = url,
    )

    override fun Repository.fromDomain() = RepositoryResponse(
        id = id,
        name = name,
        url = url,
    )
}