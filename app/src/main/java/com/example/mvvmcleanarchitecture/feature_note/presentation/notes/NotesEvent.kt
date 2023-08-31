package com.example.mvvmcleanarchitecture.feature_note.presentation.notes

import com.example.mvvmcleanarchitecture.feature_note.data.domain.model.Note
import com.example.mvvmcleanarchitecture.feature_note.data.domain.util.NoteOrder

sealed class NotesEvent {
    data class Order(val noteOrder: NoteOrder): NotesEvent()
    data class DeleteNote(val note: Note): NotesEvent()
    object RestoreNote: NotesEvent()
    object ToggleOrderSelection: NotesEvent()
}
