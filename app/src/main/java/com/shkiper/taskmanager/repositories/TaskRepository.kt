package com.shkiper.taskmanager.repositories

import androidx.lifecycle.LiveData
import com.shkiper.taskmanager.models.Task
import androidx.lifecycle.MutableLiveData
import com.shkiper.taskmanager.models.TaskType

object TaskRepository {
    private val mutableList = mutableListOf<Task>(
        Task(1, "Do work", TaskType.HARD),
        Task(2, "Byu a bear", TaskType.LOW),
        Task(3, "Go to Bank", TaskType.MEDIUM),
        Task(4, "Create a programm", TaskType.HARD)
    )
    private val tasks = MutableLiveData(mutableList)
    private val sizeOfTasks = MutableLiveData(4)
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