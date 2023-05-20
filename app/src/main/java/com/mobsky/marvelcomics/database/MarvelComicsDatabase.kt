package com.mobsky.marvelcomics.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

//@Database(
//    entities = [BookEntity::class],
//    version = 1,
//    exportSchema = false
//)
abstract class MarvelComicsDatabase : RoomDatabase() {

//    abstract fun aBibliaDigitalDAO(): ABibliaDigitalDAO

    companion object {
        @Volatile
        private var instance: MarvelComicsDatabase? = null

        fun getDatabase(context: Context): MarvelComicsDatabase =
            instance ?: synchronized(this) {
                buildDatabase(context).also { instance = it }
            }

        private fun buildDatabase(appContext: Context): MarvelComicsDatabase {
            return Room
                .databaseBuilder(
                    appContext,
                    MarvelComicsDatabase::class.java,
                    "MarvelComicsDB"
                )
                .fallbackToDestructiveMigration()
                .build()
        }
    }

}