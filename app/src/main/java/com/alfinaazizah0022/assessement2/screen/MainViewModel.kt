package com.alfinaazizah0022.assessement2.screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alfinaazizah0022.assessement2.database.BukuDao
import com.alfinaazizah0022.assessement2.model.Buku
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn

class MainViewModel(private val dao: BukuDao) : ViewModel() {

    val data: StateFlow<List<Buku>> = dao.getBuku().stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(),
        initialValue = emptyList()
    )
}