package com.example.mvvmcleanarchitecture.feature_note.data.domain.use_case

import com.example.mvvmcleanarchitecture.feature_note.data.domain.model.InvalidNoteException
import com.example.mvvmcleanarchitecture.feature_note.data.domain.model.Note
import com.example.mvvmcleanarchitecture.feature_note.data.domain.repository.NoteRepository
import kotlin.jvm.Throws

class AddNote(private val repository: NoteRepository) {

    @Throws(InvalidNoteException::class)
    suspend operator fun invoke(note: Note){
        if (note.title.isBlank()){
            throw InvalidNoteException("The title of the note cannot be empty.")
        }
        if(note.content.isBlank()){
            throw InvalidNoteException("The content of the note cannot be empty.")
        }
        repository.insertNote(note)
    }
}