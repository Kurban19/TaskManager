package com.shkiper.taskmanager.utils

import com.shkiper.taskmanager.models.Task


object Utils {

    fun toTaskType(string: String) = when(string){
        "Low" -> Task.TaskType.LOW
        "Medium" -> Task.TaskType.MEDIUM
        else -> Task.TaskType.HARD
    }

    //Calculating percent of done and not done tasks for pie chart
    fun percentOfDone(done: Int, doing: Int): Float {
        if(done == 0){
            return 0F
        }
        return ((done * 100) / doing).toFloat()
    }

}