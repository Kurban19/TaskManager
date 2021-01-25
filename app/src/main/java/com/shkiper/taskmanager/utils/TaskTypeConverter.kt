package com.shkiper.taskmanager.utils

import androidx.room.TypeConverter
import com.shkiper.taskmanager.models.TaskType

class TaskTypeConverter {

    @TypeConverter
    fun toType(value: String) = enumValueOf<TaskType>(value)

    @TypeConverter
    fun fromHealth(value: TaskType) = value.name

}