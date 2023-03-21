package com.example.kotlintest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.view.View
import com.example.kotlintest.databinding.ActivityMain3Binding

class MainActivity3 : AppCompatActivity(), View.OnClickListener{
    lateinit var binding: ActivityMain3Binding
    var pauseTime = 0L
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain3Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnStart.setOnClickListener(this)
        binding.btnStop.setOnClickListener(this)
        binding.btnReset.setOnClickListener(this)
    }
    // SystemClock.elapsedRealtime() : 컴퓨터부팅부터 시작하여 경과된시간
    override fun onClick(v: View?) {
        when(v?.id){
            R.id.btnStart -> {
                binding.chronometer.base = SystemClock.elapsedRealtime() + pauseTime
                binding.chronometer.start()
                binding.btnStart.isEnabled = false
                binding.btnStop.isEnabled = true
                binding.btnReset.isEnabled = true
            }
            R.id.btnStop -> {
                pauseTime = binding.chronometer.base - SystemClock.elapsedRealtime()
                binding.chronometer.stop()
                binding.btnStart.isEnabled = true
                binding.btnStop.isEnabled = false
                binding.btnReset.isEnabled = true
            }
            R.id.btnReset -> {
                binding.chronometer.base = SystemClock.elapsedRealtime()
                binding.chronometer.stop()
                pauseTime = 0L
                binding.btnStart.isEnabled = true
                binding.btnStop.isEnabled = false
                binding.btnReset.isEnabled = false
            }
            else -> {}
        }
    }
}