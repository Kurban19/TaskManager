package com.shkiper.taskmanager.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Task(
    @PrimaryKey(autoGenerate = true)
    val taskId: Int,

    @ColumnInfo(name = "title")
    var title: String,
    @ColumnInfo(name = "task_type")
    val taskType: TaskType = TaskType.LOW,

    var isDone: Boolean = false
) {
}
enum class TaskType{
    HARD,
    MEDIUM,
    LOW
}