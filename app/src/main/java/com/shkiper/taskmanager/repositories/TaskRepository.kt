package com.shkiper.taskmanager.repositories

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.shkiper.taskmanager.models.Task
import com.shkiper.taskmanager.models.TaskType


object TaskRepository {
    private val tasks = MutableLiveData(mutableListOf<Task>())
    private val sizeOfTasks = MutableLiveData(0)
    private val sizeOfDoneTasks = MutableLiveData(0)


    fun loadChats(): LiveData<MutableList<Task>> {
        return tasks
    }


    fun getSizeOfTasks(): LiveData<Int> {
        return sizeOfTasks
    }

    fun getSizeOfDoneTasks(): LiveData<Int> {
        return sizeOfDoneTasks
    }

    fun clearData(){
        tasks.value = mutableListOf<Task>()
        sizeOfDoneTasks.value = 0
        sizeOfTasks.value = 0
    }

    fun update(task: Task) {
        val copy = tasks.value
        val ind = tasks.value!!.indexOfFirst { it.id == task.id }
        if (ind == -1) return
        copy!![ind] = task
        tasks.value = copy
        sizeOfDoneTasks.value = tasks.value!!.filter { it.isDone }.size
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
        val ind = tasks.value!!.indexOfFirst { it.id == taskId }
        return tasks.value!!.getOrNull(ind)
    }

}