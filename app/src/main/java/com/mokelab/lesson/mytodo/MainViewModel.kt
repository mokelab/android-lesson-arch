package com.mokelab.lesson.mytodo

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.room.Room
import com.mokelab.lesson.mytodo.db.ToDoDB
import com.mokelab.lesson.mytodo.repository.ToDoRepositoryImpl

class MainViewModel(app: Application): AndroidViewModel(app) {
    private val db = Room.databaseBuilder(
        app, ToDoDB::class.java,"todo-db")
        .build()
    val todoRepository = ToDoRepositoryImpl(db)
}