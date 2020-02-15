package com.mokelab.lesson.mytodo.db

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [ToDo::class], version = 1)
abstract class ToDoDB: RoomDatabase() {
    abstract fun toDoDAO(): ToDoDAO
}