package com.alfinaazizah0022.assessement2.database

import androidx.room.Dao
import androidx.room.Delete
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

    @Delete
    suspend fun delete(buku: Buku)

    @Query("SELECT * FROM buku ORDER BY judul DESC")
    fun getBuku(): Flow<List<Buku>>

    @Query("SELECT * FROM buku WHERE id = :id")
    suspend fun getBukuById(id: Long): Buku?

    @Query("DELETE FROM buku WHERE id = :id")
    suspend fun deleteById(id: Long)
}
