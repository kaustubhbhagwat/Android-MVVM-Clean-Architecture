package com.example.mvvmcleanarchitecture.di

import android.app.Application
import androidx.room.Room
import com.example.mvvmcleanarchitecture.feature_note.data.data_source.NoteDatabase
import com.example.mvvmcleanarchitecture.feature_note.data.domain.repository.NoteRepository
import com.example.mvvmcleanarchitecture.feature_note.data.domain.use_case.AddNote
import com.example.mvvmcleanarchitecture.feature_note.data.domain.use_case.DeleteNote
import com.example.mvvmcleanarchitecture.feature_note.data.domain.use_case.GetNotes
import com.example.mvvmcleanarchitecture.feature_note.data.domain.use_case.NotesUseCases
import com.example.mvvmcleanarchitecture.feature_note.data.repository.NoteRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideNoteDatabase(app: Application): NoteDatabase {
        return Room.databaseBuilder(app, NoteDatabase::class.java, NoteDatabase.DATABASE_NAME)
            .build()
    }

    @Provides
    @Singleton
    fun provideRepository(db: NoteDatabase): NoteRepository{
        return NoteRepositoryImpl(db.noteDao)
    }

    @Provides
    @Singleton
    fun provideNoteUseCases(repository: NoteRepository): NotesUseCases{
        return NotesUseCases(
            getNotes = GetNotes(repository),
            deleteNote = DeleteNote(repository),
            addNote = AddNote(repository)
        )
    }
}