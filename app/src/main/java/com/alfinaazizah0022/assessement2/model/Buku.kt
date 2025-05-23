package com.alfinaazizah0022.assessement2.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "buku")
data class Buku(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0L,
    val judul: String,
    val penulis: String,
    val isbn: String,
    val kategori: String,
    val isDeleted: Boolean = false
)
