package com.example.mvvmcleanarchitecture.feature_note.data.domain.use_case

import com.example.mvvmcleanarchitecture.feature_note.data.domain.model.Note
import com.example.mvvmcleanarchitecture.feature_note.data.domain.repository.NoteRepository
import com.example.mvvmcleanarchitecture.feature_note.data.domain.util.NoteOrder
import com.example.mvvmcleanarchitecture.feature_note.data.domain.util.OrderType
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetNotes(private val repository: NoteRepository) {

    operator fun invoke(noteOrder: NoteOrder = NoteOrder.Date(orderType = OrderType.Descending)
    ): Flow<List<Note>> {
        return repository.getNotes().map { notes->
            when(noteOrder.orderType){
                is OrderType.Ascending->{
                    when(noteOrder){
                        is NoteOrder.Date -> notes.sortedBy { it.title.lowercase() }
                        is NoteOrder.Title -> notes.sortedBy { it.timeStamp }
                        is NoteOrder.Color -> notes.sortedBy { it.color }
                    }
                }
                is OrderType.Descending->{
                    when(noteOrder){
                        is NoteOrder.Date -> notes.sortedByDescending{ it.title.lowercase() }
                        is NoteOrder.Title -> notes.sortedByDescending { it.timeStamp }
                        is NoteOrder.Color -> notes.sortedByDescending { it.color }
                    }
                }
            }
        }

    }

}