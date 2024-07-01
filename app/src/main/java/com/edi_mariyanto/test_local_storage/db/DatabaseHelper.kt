package com.edi_mariyanto.test_local_storage.db

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.edi_mariyanto.test_local_storage.model.MahasiswaModel

class DatabaseHelper(context: Context, factory: SQLiteDatabase.CursorFactory?) :
    SQLiteOpenHelper(context, DATABASE_NAME, factory, DATABASE_VERSION) {

    override fun onCreate(db: SQLiteDatabase?) {
        val query = ("CREATE TABLE " + TABLE_NAME + " ("
                + ID_COL + " INTEGER PRIMARY KEY, " +
                NAMA_COl + " TEXT," +
                KELAS_COL + " TEXT," +
                MT_KUL_COL + " TEXT" + ")")

        db?.execSQL(query)
    }

    override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int) {
        db?.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME)
        onCreate(db)
    }

    fun insertData(nama: String, kelas: String, mtKul: String) {
        val db = this.writableDatabase
        val values = ContentValues()

        values.put(NAMA_COl, nama)
        values.put(KELAS_COL, kelas)
        values.put(MT_KUL_COL, mtKul)

        db.insert(TABLE_NAME, null, values)
        db.close()
    }

    fun getMahasiswa(): MutableList<MahasiswaModel>? {
        val db = this.readableDatabase
        val cursorCourses = db.rawQuery("SELECT * FROM " + TABLE_NAME, null)

        val mahasiswaModelList: ArrayList<MahasiswaModel>? = null
        if (cursorCourses.moveToFirst()) {
            do {
                mahasiswaModelList?.add(
                    MahasiswaModel(
                        cursorCourses.getString(1),
                        cursorCourses.getString(2),
                        cursorCourses.getString(3)
                    )
                )

            } while (cursorCourses.moveToNext())

        }
        cursorCourses.close()

        return mahasiswaModelList
    }

    companion object {
        private val DATABASE_NAME = "unpam"
        private val DATABASE_VERSION = 1
        val TABLE_NAME = "mahasiswa"
        val ID_COL = "id"
        val NAMA_COl = "nama"
        val KELAS_COL = "kelas"
        val MT_KUL_COL = "mt_kul"
    }


}
