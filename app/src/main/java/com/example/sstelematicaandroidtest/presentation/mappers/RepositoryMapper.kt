package com.example.sstelematicaandroidtest.presentation.mappers

import com.example.sstelematicaandroidtest.domain.model.Repository
import com.example.sstelematicaandroidtest.presentation.model.RepositoryPresentation

object RepositoryMapper : DomainPresentationMapper<Repository, RepositoryPresentation> {

    override fun RepositoryPresentation.toDomain() = Repository(
        id = id,
        name = name,
        url = url,
    )

    override fun Repository.fromDomain() = RepositoryPresentation(
        id = id,
        name = name,
        url = url,
    )
}