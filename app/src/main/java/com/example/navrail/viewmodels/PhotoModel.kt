package com.example.navrail.viewmodels

import android.net.Uri
import androidx.compose.runtime.Immutable

@Immutable
data class PhotoModel(
    val title: String,
    val description: String,
    val uri: Uri? = null
)
