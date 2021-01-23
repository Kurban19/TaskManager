package com.shkiper.taskmanager.db

import android.content.Context
import android.util.Log
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.shkiper.taskmanager.dao.DaoAccess
import com.shkiper.taskmanager.models.Task
import com.shkiper.taskmanager.utils.TaskTypeConverter


@Database(entities = [Task::class], version = 1, exportSchema = false)
@TypeConverters(TaskTypeConverter::class)
abstract class TaskDataBase : RoomDatabase() {

    abstract fun getDaoAccess(): DaoAccess

    companion object {
        private const val TAG = "AppDatabase"
        private const val DATABASE_NAME = "APP_DATABASE"

        // Singleton prevents multiple instances of database opening at the
        // same time.
        @Volatile
        private var INSTANCE: TaskDataBase? = null

        fun getInstance(context: Context): TaskDataBase? {
            if (INSTANCE == null) {
                synchronized(this) {
                    Log.d(TAG, " >>> Creating new database instance")
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        TaskDataBase::class.java,
                        DATABASE_NAME).build()
                }
            }
            Log.d(TAG, " >>> Getting the database instance")
            return INSTANCE
        }

        fun destroyInstance() {
            INSTANCE = null
        }
    }
}