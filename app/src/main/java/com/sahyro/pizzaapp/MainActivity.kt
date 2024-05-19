package com.sahyro.pizzaapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.sahyro.pizzaapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       // enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.placeOrderBtn.setOnClickListener {
            var pizzaSizePrice = 0.0
            var topppingsTotal = 0.0

            when{
                binding.smalLRB.isChecked -> pizzaSizePrice = 5.0
                binding.mediumRB.isChecked -> pizzaSizePrice = 10.0
                binding.largeRB.isChecked -> pizzaSizePrice = 15.0
            }

            if(binding.onionCB.isChecked){
                topppingsTotal += 1
            }
            if(binding.oliveCB.isChecked){
                topppingsTotal += 2
            }
            if(binding.tomatoCB.isChecked){
                topppingsTotal += 3
            }

            binding.totalTxt.text = "Totak Order Price = RM${pizzaSizePrice + topppingsTotal}"
        }
    }
}