package com.shkiper.taskmanager.models

data class Task(
    val id: Int,
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