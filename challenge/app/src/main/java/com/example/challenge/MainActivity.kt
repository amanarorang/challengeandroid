package com.example.challenge

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.challenge.databinding.ActivityMainBinding

import com.example.challenge.presentation.viewmodel.DeliveryViewModel
import com.example.challenge.presentation.viewmodel.DeliveryViewModelFactory
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    @Inject
    lateinit var factory: DeliveryViewModelFactory

    lateinit var viewModel: DeliveryViewModel
    lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController
    private lateinit var  navHostFragment:NavHostFragment
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        navHostFragment = supportFragmentManager
            .findFragmentById(R.id.fragment) as NavHostFragment
         navController = navHostFragment.navController

        viewModel = ViewModelProvider(this,factory)
            .get(DeliveryViewModel::class.java)
    }


}