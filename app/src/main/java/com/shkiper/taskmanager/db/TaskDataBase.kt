package com.shkiper.taskmanager.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.shkiper.taskmanager.dao.DaoAccess
import com.shkiper.taskmanager.models.Task


@Database(entities = [Task::class], version = 1, exportSchema = false)
abstract class TaskDataBase : RoomDatabase() {

    abstract fun getDaoAccess(): DaoAccess
}