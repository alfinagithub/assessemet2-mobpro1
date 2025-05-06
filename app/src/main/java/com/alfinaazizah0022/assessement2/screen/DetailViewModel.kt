package com.alfinaazizah0022.assessement2.screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alfinaazizah0022.assessement2.database.BukuDao
import com.alfinaazizah0022.assessement2.model.Buku
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DetailViewModel(private val dao: BukuDao) : ViewModel() {

    fun insert(judul: String, penulis: String, isbn: String, kategori: String) {
        val buku = Buku(
            judul = judul,
            penulis = penulis,
            isbn = isbn,
            kategori = kategori
        )

        viewModelScope.launch(Dispatchers.IO) {
            dao.insert(buku)
        }
    }

    fun getBuku(id: Long): Buku? {
        return null
    }
}