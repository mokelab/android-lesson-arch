package com.mokelab.lesson.mytodo.db

import androidx.room.Entity
import androidx.room.PrimaryKey

//@Entity
data class ToDo(
//    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val title: String,
    val content: String)
