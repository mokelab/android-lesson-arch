package com.mokelab.lesson.mytodo

import androidx.lifecycle.ViewModel
import com.mokelab.lesson.mytodo.repository.ToDoRepository

class ToDoDetailViewModel(private val toDoRepository: ToDoRepository): ViewModel() {
    fun getById(id: Int) = toDoRepository.getById(id)
}