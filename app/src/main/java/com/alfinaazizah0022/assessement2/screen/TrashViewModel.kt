package com.alfinaazizah0022.assessement2.screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alfinaazizah0022.assessement2.database.BukuDao
import com.alfinaazizah0022.assessement2.model.Buku
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class TrashViewModel(private val dao: BukuDao) : ViewModel() {

    val data: StateFlow<List<Buku>> = dao.getDeletedBuku().stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(),
        initialValue = emptyList()
    )

    fun pulihkan(id: Long) {
        viewModelScope.launch(Dispatchers.IO) {
            dao.restore(id)
        }
    }

    fun hapusPermanen(id: Long) {
        viewModelScope.launch(Dispatchers.IO) {
            dao.deleteById(id)
        }
    }
}