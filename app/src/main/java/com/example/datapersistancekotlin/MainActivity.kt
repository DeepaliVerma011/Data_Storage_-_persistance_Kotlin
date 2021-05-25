package com.example.datapersistancekotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_main.*
import java.io.File

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//kotlin provides direct writeText and readText functions to read and  write files
        write.setOnClickListener{
             val dataDir=ContextCompat.getDataDir(this)
            val myFile= File(dataDir,"file.text")

            myFile.writeText(editTextTextPersonName.text.toString())
        }
        read.setOnClickListener {
            //readText can read only 2 gb data so its for small files only
            val dataDir=ContextCompat.getDataDir(this)
            val myFile= File(dataDir,"file.text")
            textView.text=myFile.readText()
        }
    }
}