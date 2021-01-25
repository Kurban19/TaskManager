package com.shkiper.taskmanager.models

import androidx.room.*
import com.shkiper.taskmanager.utils.TaskTypeConverter

@Entity
data class Task(
    @PrimaryKey(autoGenerate = true)
    val taskId: Int,

    @ColumnInfo(name = "title")
    var title: String,

    @ColumnInfo(name = "task_type")
    @TypeConverters(TaskTypeConverter::class)
    val taskType: TaskType = TaskType.LOW,

    @ColumnInfo(name = "is_complete")
    var isComplete: Boolean = false
) {
}
enum class TaskType(val value: Int){
    HARD(0),
    MEDIUM(1),
    LOW(2)
}