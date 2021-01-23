package com.shkiper.taskmanager.utils

import androidx.room.TypeConverter
import com.shkiper.taskmanager.models.TaskType

class TaskTypeConverter {

    @TypeConverter
    fun toType(value: String): TaskType {
        return TaskType.valueOf(value)
    }

    @TypeConverter
    fun fromType(value: TaskType): String {
        return value.name
    }


}