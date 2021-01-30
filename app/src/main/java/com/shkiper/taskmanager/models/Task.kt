package com.shkiper.taskmanager.models

import androidx.room.*
import com.shkiper.taskmanager.utils.TaskTypeConverter

@Entity(tableName = "Task")
data class Task(

    @ColumnInfo(name = "title")
    var title: String,

    @ColumnInfo(name = "task_type")
    @TypeConverters(TaskTypeConverter::class)
    val taskType: TaskType = TaskType.LOW,

    @ColumnInfo(name = "is_complete")
    var isComplete: Boolean = false
) {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "taskId")
    var taskId: Int = 0



enum class TaskType(val value: Int){
    HARD(0),
    MEDIUM(1),
    LOW(2)
    }
}