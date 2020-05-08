package com.shkiper.taskmanager.database

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class TaskBaseHelper(context: Context) : SQLiteOpenHelper(context, "taskBase.db", null, 1) {

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(
            "create table " + TaskDbSchema.CrimeTable.NAME.toString() + "(" +
                    " _id integer primary key autoincrement, " +
                    TaskDbSchema.CrimeTable.Cols.ID.toString() + ", " +
                    TaskDbSchema.CrimeTable.Cols.TITLE.toString() + ", " +
                    TaskDbSchema.CrimeTable.Cols.DONE.toString()  +
                    ")"
        )
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {}
}
