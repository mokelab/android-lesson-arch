package com.mokelab.lesson.mytodo

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.mokelab.lesson.mytodo.db.ToDo
import com.mokelab.lesson.mytodo.repository.ToDoRepository

class TopViewModel(
    private val toDoRepository: ToDoRepository
): ViewModel() {
    val todoList: LiveData<List<ToDo>> by lazy {
        toDoRepository.getAll()
    }
}