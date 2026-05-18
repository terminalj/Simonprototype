package com.example.simonprototype

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHelper(context: Context) : SQLiteOpenHelper(context, "SimonGameDB", null, 1) {

    override fun onCreate(db: SQLiteDatabase) {
        val createTable = "CREATE TABLE Games (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "score INTEGER," +
                "errorIndex INTEGER," +
                "sequence TEXT)"
        db.execSQL(createTable)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS Games")
        onCreate(db)
    }

    fun insertGame(score: Int, errorIndex: Int, sequence: String) {
        val db = this.writableDatabase
        val values = ContentValues()
        values.put("score", score)
        values.put("errorIndex", errorIndex)
        values.put("sequence", sequence)
        db.insert("Games", null, values)
        db.close()
    }

    fun getAllGames(): ArrayList<Item> {
        val gameList = ArrayList<Item>()
        val db = this.readableDatabase
        val cursor = db.rawQuery("SELECT * FROM Games", null)
        if (cursor.moveToFirst()) {
            do {
                val id = cursor.getLong(0)
                val score = cursor.getInt(1)
                val errorIndex = cursor.getInt(2)
                val sequence = cursor.getString(3)
                gameList.add(Item(id, score, errorIndex, sequence))
            } while (cursor.moveToNext())
        }
        cursor.close()
        db.close()
        return gameList
    }
}