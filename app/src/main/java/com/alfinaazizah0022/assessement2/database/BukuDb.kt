package com.alfinaazizah0022.assessement2.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.alfinaazizah0022.assessement2.model.Buku

@Database(entities = [Buku::class], version = 2, exportSchema = false)
abstract class BukuDb : RoomDatabase() {

    abstract val dao: BukuDao

    companion object {

        @Volatile
        private var INSTANCE: BukuDb? = null

        private val MIGRATION_1_2 = object : Migration(1,2) {
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL(
                    "ALTER TABLE buku ADD COLUMN isDeleted INTEGER NOT NULL DEFAULT 0"
                )
            }
        }


        fun getInstance(context: Context): BukuDb {
            synchronized(this) {
                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        BukuDb::class.java,
                        "buku.db"
                    )
                        .addMigrations(MIGRATION_1_2)
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}