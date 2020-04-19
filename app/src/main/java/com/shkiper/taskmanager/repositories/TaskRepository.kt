package com.shkiper.taskmanager.repositories

import androidx.lifecycle.LiveData
import com.shkiper.taskmanager.models.Task
import androidx.lifecycle.MutableLiveData

object TaskRepository {
    private val mutableList = mutableListOf<Task>()
    private val tasks = MutableLiveData(mutableList)
    private val sizeOfTasks = MutableLiveData(0)

    fun loadChats() : LiveData<MutableList<Task>> {
        return tasks
    }
    fun getSizeOfTasks(): LiveData<Int> {
        return sizeOfTasks
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
        sizeOfTasks.value = tasks.value!!.size
    }

    fun nextChatId(): Int {
        return tasks.value!!.size
    }

    fun find(taskId: Int): Task? {
        val ind = tasks.value!!.indexOfFirst { it.id == taskId}
        return tasks.value!!.getOrNull(ind)
    }


}