package com.example.sstelematicaandroidtest.presentation.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class RepositoryPresentation(
    val id: Int,
    val name: String,
    val url: String,
) : Parcelable