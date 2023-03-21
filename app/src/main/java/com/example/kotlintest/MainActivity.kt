package com.example.kotlintest

import android.app.ProgressDialog.show
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.KeyEvent
import android.widget.CompoundButton
import android.widget.CompoundButton.OnCheckedChangeListener
import android.widget.Toast
import android.widget.Toast.makeText
import androidx.lifecycle.ComputableLiveData
import com.example.kotlintest.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), CompoundButton.OnCheckedChangeListener {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //구현객체를 활용한 1번방식
        binding.ckbClick.setOnCheckedChangeListener(this)
        binding.ckbClick2.setOnCheckedChangeListener(this)

        //임시객체를 활용한 2번방식
        binding.ckbClick3.setOnCheckedChangeListener(object :
            CompoundButton.OnCheckedChangeListener {
            override fun onCheckedChanged(buttonView: CompoundButton?, isChecked: Boolean) {
                makeText(applicationContext, "클릭3번.", Toast.LENGTH_SHORT).show()
            }
        })


        //람다식을 활용한 3번방식 SAM(single abstract Method)
        binding.ckbClick4.setOnCheckedChangeListener { buttonView, isChecked ->
            Toast.makeText(applicationContext, "클릭4번", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onCheckedChanged(buttonView: CompoundButton?, isChecked: Boolean) {
        when (buttonView?.id) {
            R.id.ckbClick -> Toast.makeText(applicationContext, "클릭1번", Toast.LENGTH_SHORT).show()
            R.id.ckbClick2 -> Toast.makeText(applicationContext, "클릭4번", Toast.LENGTH_SHORT).show()
        }

    }


//    override fun onCheckedChanged(buttonView: CompoundButton?, isChecked: Boolean) {
//        when (buttonView?.id) {
//            R.id.ckbClick -> {
//                Toast.makeText(applicationContext, "체크박스1번", Toast.LENGTH_SHORT).show()
//            }
//            R.id.ckbClick2 -> {
//                Toast.makeText(applicationContext, "체크박스2번", Toast.LENGTH_SHORT).show()
//            }
//        }
//    }
}

//class A : CompoundButton.OnCheckedChangeListener{
//    override fun onCheckedChanged(buttonView: CompoundButton?, isChecked: Boolean) {
//        if (isChecked) {
//            Log.e("MainActivity","체크했습니다")
//        } else {
//            Log.e("MainActivity","체크해제했습니다")
//        }
//    }
//}