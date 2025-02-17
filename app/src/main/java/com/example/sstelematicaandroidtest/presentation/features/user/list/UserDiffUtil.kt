package com.example.sstelematicaandroidtest.presentation.features.user.list

import androidx.recyclerview.widget.DiffUtil
import com.example.sstelematicaandroidtest.presentation.model.UserPresentation

class UserDiffUtil : DiffUtil.ItemCallback<UserPresentation>() {

    override fun areItemsTheSame(
        oldItem: UserPresentation,
        newItem: UserPresentation
    ) = oldItem.id == newItem.id

    override fun areContentsTheSame(
        oldItem: UserPresentation,
        newItem: UserPresentation
    ) = oldItem.login == newItem.login
            && oldItem.avatarUrl == newItem.avatarUrl
}