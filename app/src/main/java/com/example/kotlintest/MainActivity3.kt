package com.example.kotlintest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.view.KeyEvent
import android.view.View
import android.widget.Toast
import androidx.core.content.res.ResourcesCompat
import com.example.kotlintest.databinding.ActivityMain3Binding

class MainActivity3 : AppCompatActivity(), View.OnClickListener {
    lateinit var binding: ActivityMain3Binding
    var pauseTime = 0L
    var initTime = 0L
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
        when (v?.id) {
            R.id.btnStart -> {
                binding.tvMessage.text = getString(R.string.btn_start)
                binding.tvMessage.textSize = resources.getDimension(R.dimen.txt_size_large)
                binding.tvMessage.setTextColor(ResourcesCompat.getColor(resources,R.color.txt_color2,null))
                binding.chronometer.base = SystemClock.elapsedRealtime() + pauseTime
                binding.chronometer.start()
                binding.btnStart.isEnabled = false
                binding.btnStop.isEnabled = true
                binding.btnReset.isEnabled = true
            }
            R.id.btnStop -> {
                binding.tvMessage.text = getString(R.string.btn_stop)
                binding.tvMessage.textSize = resources.getDimension(R.dimen.txt_size_small)
                binding.tvMessage.setTextColor(ResourcesCompat.getColor(resources,R.color.txt_color,null))
                pauseTime = binding.chronometer.base - SystemClock.elapsedRealtime()
                binding.chronometer.stop()
                binding.btnStart.isEnabled = true
                binding.btnStop.isEnabled = false
                binding.btnReset.isEnabled = true
            }
            R.id.btnReset -> {
                binding.tvMessage.text = getString(R.string.btn_reset)
                binding.tvMessage.textSize = resources.getDimension(R.dimen.txt_size_medium)
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

    //백버튼을 가져오려고 한다. ( 볼륨조절, 전원, 백버튼, 키보드)
//    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
//        if(keyCode == KeyEvent.KEYCODE_BACK){
//            if(System.currentTimeMillis() - initTime > 3000){
//                Toast.makeText(this@MainActivity3,"종료를 원하시면 3초이내에 한번 더 눌러주시길 바랍니다.",Toast.LENGTH_SHORT).show()
//                initTime = System.currentTimeMillis()
//                return true
//            }
//        }
//        return super.onKeyDown(keyCode, event)
//    }
    override fun onBackPressed() {
        if (System.currentTimeMillis() - initTime > 3000) {
            binding.tvMessage.text = getString(R.string.btn_back)
            Toast.makeText(
                this@MainActivity3,
                getString(R.string.btn_back),
                Toast.LENGTH_SHORT
            ).show()
            initTime = System.currentTimeMillis()
        } else {
            super.onBackPressed()
        }
    }
}