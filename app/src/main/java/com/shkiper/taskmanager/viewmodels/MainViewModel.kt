package com.shkiper.taskmanager.viewmodels

import androidx.lifecycle.*
import com.shkiper.taskmanager.models.Task
import com.shkiper.taskmanager.repositories.TaskRepository
import com.shkiper.taskmanager.utils.Utils

class MainViewModel : ViewModel() {

    private val taskRepository = TaskRepository
    private val sizeOfTasks = taskRepository.getSizeOfTasks()
    private val sizeOfDoneTasks = taskRepository.getSizeOfDoneTasks()
    //private val percentOfDone = MutableLiveData(Utils.percentOfDone(sizeOfDoneTasks.value!!, sizeOfTasks.value!!))
    private var mediatorLiveData = MediatorLiveData<Int>()
    private val tasks = Transformations.map(taskRepository.loadChats()) { tasks ->
        return@map tasks.filter {!it.isDone}
            .sortedBy { it.id }
    }

    init {
        mediatorLiveData.addSource(sizeOfDoneTasks) {
            mediatorLiveData.value = sizeOfDoneTasks.value
        }

        mediatorLiveData.addSource(sizeOfTasks){
            mediatorLiveData.value = sizeOfTasks.value
        }
    }

    fun getMediatorLiveData(): MediatorLiveData<Int> {
        return mediatorLiveData
    }

//    fun getPercentOfDone(): LiveData<Int> {
//        return percentOfDone
//    }


    fun getTaskData(): LiveData<List<Task>> {
        return tasks
    }

    fun getSizeOfDoneTasks(): LiveData<Int>{
        return sizeOfDoneTasks
    }

    fun getSizeOfTasks(): LiveData<Int> {
        return sizeOfTasks
    }

    fun addToDone(taskId: Int) {
        val task = taskRepository.find(taskId)
        task ?: return
        taskRepository.update(task.copy(isDone = true))
    }

}