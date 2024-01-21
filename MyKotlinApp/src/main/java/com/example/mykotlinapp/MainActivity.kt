package com.example.mykotlinapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.mykotlinapp.databinding.ActivityMainBinding
import java.lang.Exception

class MainActivity : AppCompatActivity() , View.OnClickListener{

    lateinit var binding: ActivityMainBinding
    lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        binding.btnAdd.setOnClickListener(this)
        binding.btnSub.setOnClickListener(this)
        binding.btnMulti.setOnClickListener(this)
        binding.btnDiv.setOnClickListener(this)

        binding.resultTv.text = "Result \n ${viewModel.result}"
    }

    override fun onClick(v: View?) {

        try {
            var a = binding.etA.text.toString().toDouble()
            var b = binding.etB.text.toString().toDouble()
            when (v?.id) {
                R.id.btn_add -> {
                    viewModel.result = a + b
                }

                R.id.btn_sub -> {
                    viewModel.result = a - b
                }

                R.id.btn_multi -> {
                    viewModel.result = a * b
                }

                R.id.btn_div -> {
                    viewModel.result = a / b
                }
            }
            binding.resultTv.text = "Result \n ${viewModel.result}"
        }catch(e : Exception){
            Toast.makeText(applicationContext,"Something went wrong", Toast.LENGTH_SHORT).show()
        }
    }

}