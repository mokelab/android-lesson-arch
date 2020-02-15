package com.mokelab.lesson.mytodo.repository

import androidx.lifecycle.LiveData
import com.mokelab.lesson.mytodo.db.ToDo
import com.mokelab.lesson.mytodo.db.ToDoDB

class ToDoRepositoryImpl(private val db: ToDoDB): ToDoRepository {
    private val todoDAO = db.toDoDAO()

    override fun getAll(): LiveData<List<ToDo>> {
        return this.todoDAO.getAll()
    }

    override fun getById(id: Int): LiveData<ToDo> {
        return this.todoDAO.getById(id)
    }

    override fun create(title: String, content: String): ToDo {
        val todo = ToDo(id = 0, title = title, content = content)
        this.todoDAO.insert(todo)
        return todo
    }
}