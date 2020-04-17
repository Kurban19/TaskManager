package com.shkiper.taskmanager.models

data class Task(
    val id: Int,
    var title: String,
    val taskType: TaskType = TaskType.Low,
    var isDone: Boolean = false
) {
}
enum class TaskType{
    Hard,
    Medium,
    Low
}