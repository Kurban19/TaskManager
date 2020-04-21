package com.shkiper.taskmanager.utils

import com.shkiper.taskmanager.models.TaskType

object Utils {

    fun toTaskType(string: String) = when(string){
        "Low" -> TaskType.LOW
        "Medium" -> TaskType.MEDIUM
        else -> TaskType.HARD
    }

    //Calculating percent of done and not done tasks for pie chart
    fun percentOfDone(done: Int, doing: Int): Int {
        if(done == 0){
            return 0
        }
        return (done * 100) / doing
    }

}