package com.example.navrail.viewmodels

import android.net.Uri
import androidx.lifecycle.ViewModel

class MainActivityViewModel: ViewModel() {

    val items = mutableListOf<PhotoModel>()
        .apply {
            repeat(15){
                add(PhotoModel(title = "Title${it}", description = "Description${it}"))
            }
        }

    fun update(index: Int, uri: Uri){
        val item = items[index].copy(uri = uri)
        items[index] = item

    }

}