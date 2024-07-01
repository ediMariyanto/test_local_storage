package com.edi_mariyanto.test_local_storage

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.ComponentActivity
import com.edi_mariyanto.test_local_storage.db.DatabaseHelper
import kotlin.math.log

class MainActivity : ComponentActivity() {

    lateinit var etNama: EditText
    lateinit var etKelas: EditText
    lateinit var etMtKul: EditText
    lateinit var tvShowData: TextView
    lateinit var btnInput: Button
    lateinit var db: DatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main)

        db = DatabaseHelper(this, null)
//        db.insertData("EDI", "01234", "Mobile Programming")

        initComponent()
    }


    fun initComponent() {
        etNama = findViewById(R.id.et_nama)
        etKelas = findViewById(R.id.et_kelas)
        etMtKul = findViewById(R.id.et_mt_kul)
        btnInput = findViewById(R.id.btn_input)
        tvShowData = findViewById(R.id.tv_show_data)


        btnInput.setOnClickListener {
            db.insertData(etNama.text.toString(), etKelas.text.toString(), etMtKul.text.toString())
            getData()
        }


    }

    fun getData() {
        val db = DatabaseHelper(this, null)
        tvShowData.text = db.getMahasiswa().toString()
    }

}