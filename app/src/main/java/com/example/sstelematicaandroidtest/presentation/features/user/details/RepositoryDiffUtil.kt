package com.example.sstelematicaandroidtest.presentation.features.user.details

import androidx.recyclerview.widget.DiffUtil
import com.example.sstelematicaandroidtest.presentation.model.RepositoryPresentation

class RepositoryDiffUtil : DiffUtil.ItemCallback<RepositoryPresentation>() {

    override fun areItemsTheSame(
        oldItem: RepositoryPresentation,
        newItem: RepositoryPresentation
    ) = oldItem.id == newItem.id

    override fun areContentsTheSame(
        oldItem: RepositoryPresentation,
        newItem: RepositoryPresentation
    ) = oldItem.name == newItem.name
            && oldItem.url == newItem.url
}