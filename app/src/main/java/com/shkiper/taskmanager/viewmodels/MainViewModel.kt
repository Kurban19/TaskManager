package com.shkiper.taskmanager.viewmodels

import androidx.lifecycle.*
import com.shkiper.taskmanager.models.Task
import com.shkiper.taskmanager.repositories.TaskRepository


class MainViewModel(private val taskRepository: TaskRepository) : ViewModel() {

    private val tasks = Transformations.map(taskRepository.loadChats()) { tasks ->
        return@map tasks.filter {!it.isComplete}
    }

    private val taskDoneSizeInt = MutableLiveData(taskRepository.loadChats().value?.filter {it.isComplete}?.size ?: 0)
    private val taskSizeInt = MutableLiveData(taskRepository.loadChats().value?.filter {!it.isComplete}?.size ?: 0)


    fun getTaskData(): LiveData<List<Task>> {
        return tasks
    }

    fun insertTask(task: Task){
        taskRepository.insert(task)
    }


    fun addToDone(task: Task) {
        task.isComplete = true
        taskRepository.updateTask(task)
    }

    fun restoreFromDone(task: Task) {
        task.isComplete = false
        taskRepository.updateTask(task)
    }

    fun deleteAll(){
        taskRepository.deleteAll()
    }

    fun getSizeOfTasks(): MutableLiveData<Int> {
        return taskSizeInt
    }

    fun getSizeOfDoneTasks(): MutableLiveData<Int> {
        return taskDoneSizeInt
    }


}