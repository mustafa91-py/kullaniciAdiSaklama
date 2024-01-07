package com.mustafauyar.kullaniciadisaklama
import com.mustafauyar.kullaniciadisaklama.databinding.ActivityMainBinding

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    lateinit var sharedPreferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setContentView(binding.root)
        binding = ActivityMainBinding.inflate(layoutInflater)
    sharedPreferences =this.getSharedPreferences("com.mustafauyar.kullaniciadisaklama",
        Context.MODE_PRIVATE)
    }
    fun kaydet(view: View){
        val kullaniciAdiAl = binding.isimText.text.toString()

    }
    fun sil (view: View){

    }
}