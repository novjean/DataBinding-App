package com.novatech.databindingapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import com.novatech.databindingapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        // not needed when using data bingin
        //setContentView(R.layout.activity_main)

        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

//        binding.btn.setOnClickListener(){
//            var enteredText :String = binding.editText.text.toString()
//            binding.textView.setText("hello $enteredText")
//        }

        // use this so as to not have to write binding everywhere
        binding.apply {
            btn.setOnClickListener(){
                var enteredText :String = editText.text.toString()
                textView.setText("hello $enteredText")
            }
        }

        var u1 : User = User(1,"jack","123")

        binding.apply {
            textView1.text = u1.id.toString()
            textView2.text = u1.name
            textView3.text = u1.pass
        }
    }
}