package com.shkiper.taskmanager.database

class TaskDbSchema {
    object CrimeTable {
        const val NAME = "tasks"

        object Cols {
            const val ID = "id"
            const val TITLE = "title"
            const val DONE = "done"
        }
    }
}