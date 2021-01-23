package com.shkiper.taskmanager.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Task(
    @PrimaryKey(autoGenerate = true)
    val taskId: Int,

    var title: String,
    val taskType: TaskType = TaskType.LOW,
    var isDone: Boolean = false
) {
}
enum class TaskType{
    HARD,
    MEDIUM,
    LOW
}