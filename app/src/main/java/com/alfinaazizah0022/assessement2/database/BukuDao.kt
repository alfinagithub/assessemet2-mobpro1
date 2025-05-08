package com.alfinaazizah0022.assessement2.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.alfinaazizah0022.assessement2.model.Buku
import kotlinx.coroutines.flow.Flow

@Dao
interface BukuDao {

    @Insert
    suspend fun insert(buku: Buku)

    @Update
    suspend fun update(buku: Buku)

    @Query("SELECT * FROM buku WHERE isDeleted = 0 ORDER BY judul ASC")
    fun getBuku(): Flow<List<Buku>>

    @Query("SELECT * FROM buku WHERE isDeleted = 1 ORDER BY judul ASC")
    fun getDeletedBuku(): Flow<List<Buku>>

    @Query("SELECT * FROM buku WHERE id = :id")
    suspend fun getBukuById(id: Long): Buku?

    @Query("DELETE FROM buku WHERE id = :id")
    suspend fun deleteById(id: Long)

    @Query("UPDATE buku SET isDeleted = 1 WHERE id = :id")
    suspend fun softDelete(id: Long)

    @Query("UPDATE buku SET isDeleted = 0 WHERE id = :id")
    suspend fun restore(id: Long)
}
