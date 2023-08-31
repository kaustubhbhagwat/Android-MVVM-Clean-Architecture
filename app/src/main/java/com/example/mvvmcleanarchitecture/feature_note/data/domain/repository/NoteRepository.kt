package com.example.mvvmcleanarchitecture.feature_note.data.domain.repository

import com.example.mvvmcleanarchitecture.feature_note.data.domain.model.Note
import kotlinx.coroutines.flow.Flow

//Definitions

interface NoteRepository {

    fun getNotes() : Flow<List<Note>>

    suspend fun getNoteById(id: Int): Note?

    suspend fun insertNote(note: Note)

    suspend fun deleteNote(note: Note)
}