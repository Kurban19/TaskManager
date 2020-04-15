package com.shkiper.taskmanager.repositories

import com.shkiper.taskmanager.models.Task
import androidx.lifecycle.MutableLiveData

object TaskRepository {

    private val tasks = MutableLiveData<List<Task>>()

    fun loadChats() : MutableLiveData<List<Task>> {
        return tasks
    }

    fun update(task: Task) {
        val copy = tasks.value!!.toMutableList()
        val ind = tasks.value!!.indexOfFirst { it.id == task.id }
        if(ind == -1) return
        copy[ind] = task
        tasks.value = copy
    }

    fun find(taskId: String): Task? {
        val ind = tasks.value!!.indexOfFirst { it.id == taskId}
        return tasks.value!!.getOrNull(ind)
    }


}