package com.shkiper.taskmanager.utils

import androidx.room.TypeConverter
import com.shkiper.taskmanager.models.Task


class TaskTypeConverter {

    @TypeConverter
    fun toTaskType(value: String) = enumValueOf<Task.TaskType>(value)

    @TypeConverter
    fun fromTaskType(value: Task.TaskType) = value.name

}