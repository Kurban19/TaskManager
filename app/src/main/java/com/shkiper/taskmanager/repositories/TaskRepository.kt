package com.shkiper.taskmanager.repositories

import com.shkiper.taskmanager.models.Task
import androidx.lifecycle.MutableLiveData

object TaskRepository {

    private val tasks = MutableLiveData(mutableListOf(Task(16, "Сделать програму")))

    fun loadChats() : MutableLiveData<MutableList<Task>> {
        return tasks
    }

    fun update(task: Task) {
        val copy = tasks.value
        val ind = tasks.value!!.indexOfFirst { it.id == task.id }
        if(ind == -1) return
        copy!![ind] = task
        tasks.value = copy
    }

    fun add(task: Task) {
        val copy = tasks.value
        copy!!.add(task)
        tasks.value = copy
    }

    fun nextChatId(): Int {
        return tasks.value!!.size
    }

    fun find(taskId: Int): Task? {
        val ind = tasks.value!!.indexOfFirst { it.id == taskId}
        return tasks.value!!.getOrNull(ind)
    }


}