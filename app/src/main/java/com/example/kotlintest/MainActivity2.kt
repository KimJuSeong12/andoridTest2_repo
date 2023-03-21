package com.example.kotlintest

import android.os.Binder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import android.widget.Toast.makeText
import com.example.kotlintest.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity(), View.OnClickListener {
    lateinit var binding: ActivityMain2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnClick1.setOnClickListener(this)
        binding.btnClick2.setOnClickListener(this)

        binding.btnClick3.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                Toast.makeText(applicationContext, "클릭3", Toast.LENGTH_SHORT).show()
            }
        })
        binding.btnClick4.setOnClickListener {
            Toast.makeText(applicationContext, "클릭4", Toast.LENGTH_SHORT).show()
        }
    }
    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btnClick1 -> Toast.makeText(applicationContext, "클릭1", Toast.LENGTH_SHORT).show()
            R.id.btnClick2 -> Toast.makeText(applicationContext, "클릭2", Toast.LENGTH_SHORT).show()
        }
    }
}