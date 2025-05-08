package com.alfinaazizah0022.assessement2.util

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.alfinaazizah0022.assessement2.database.BukuDb
import com.alfinaazizah0022.assessement2.screen.DetailViewModel
import com.alfinaazizah0022.assessement2.screen.MainViewModel
import com.alfinaazizah0022.assessement2.screen.TrashViewModel

class ViewModelFactory(
    private val context: Context
) : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        val dao = BukuDb.getInstance(context).dao
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(dao) as T
        } else if (modelClass.isAssignableFrom(DetailViewModel::class.java)) {
            return DetailViewModel(dao) as T
        } else if (modelClass.isAssignableFrom(TrashViewModel::class.java)) {
            return TrashViewModel(dao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}