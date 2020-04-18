package com.shkiper.taskmanager.utils

import com.shkiper.taskmanager.models.TaskType

object Utils {

    fun toTaskType(string: String) = when(string){
        "Low" -> TaskType.LOW
        "Medium" -> TaskType.MEDIUM
        else -> TaskType.HARD
    }
}