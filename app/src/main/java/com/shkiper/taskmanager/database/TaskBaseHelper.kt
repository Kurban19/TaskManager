package com.shkiper.taskmanager.database

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class TaskBaseHelper(context: Context) : SQLiteOpenHelper(context, "taskBase.db", null, 1) {

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(
            "create table " + TaskDbSchema.CrimeTable.NAME + "(" +
                    " _id integer primary key autoincrement, " +
                    TaskDbSchema.CrimeTable.Cols.ID + ", " +
                    TaskDbSchema.CrimeTable.Cols.TITLE + ", " +
                    TaskDbSchema.CrimeTable.Cols.DONE +
                    ")"
        )
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {}
}
