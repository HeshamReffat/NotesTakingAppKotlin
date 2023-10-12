package com.hisham.noteappkotlin.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.hisham.noteappkotlin.model.Note

@Dao
interface NoteDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNote(note: Note)

    @Update
    suspend fun updateNote(note: Note)

    @Delete
    suspend fun deleteNote(note: Note)

    @Query("Select * From NOTES Order by id Desc")
    fun getAllNote(): LiveData<List<Note>>

    @Query("Select * From NOTES Where noteTitle like :query Or noteBody like:query")
    fun searchNote(query: String?): LiveData<List<Note>>
}