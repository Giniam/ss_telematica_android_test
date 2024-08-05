package com.example.sstelematicaandroidtest.presentation.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class UserPresentation(
    val id: Int,
    val login: String,
    val avatarUrl: String,
    val url: String,
) : Parcelable
