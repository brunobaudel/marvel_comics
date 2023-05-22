package com.mobsky.home.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.mobsky.home.data.local.dao.model.CharactersEntity
import com.mobsky.home.data.local.dao.model.ComicsEntity

@Dao
interface MarvelDAO {

    @Query("SELECT * FROM comic_table ORDER BY title ASC")
    fun getComics(): ComicsEntity

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertComics(comics: ComicsEntity): List<Long>

    @Query("SELECT * FROM character_table ORDER BY title ASC")
    fun getCharacters(): CharactersEntity

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertCharacters(comics: CharactersEntity): List<Long>
    
}