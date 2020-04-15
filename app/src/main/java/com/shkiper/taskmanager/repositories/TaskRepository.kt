package com.shkiper.taskmanager.repositories

import com.shkiper.taskmanager.models.Task
import androidx.lifecycle.MutableLiveData

object TaskRepository {

    private val tasks = MutableLiveData(mutableListOf(Task("3", "Сделать програму")))

    fun loadChats() : MutableLiveData<MutableList<Task>> {
        return tasks
    }

    fun update(task: Task) {
        val copy = tasks.value
        //val ind = tasks.value!!.indexOfFirst { it.id == task.id }
        //if(ind == -1) return
        copy!!.add(task)
        tasks.value = copy
    }

    fun find(taskId: String): Task? {
        val ind = tasks.value!!.indexOfFirst { it.id == taskId}
        return tasks.value!!.getOrNull(ind)
    }


}