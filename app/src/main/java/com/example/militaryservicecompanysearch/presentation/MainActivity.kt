package com.example.militaryservicecompanysearch.presentation

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.militaryservicecompanysearch.R
import com.example.militaryservicecompanysearch.databinding.ActivityMainBinding
import com.example.militaryservicecompanysearch.presentation.adapter.RecruitmentNoticeAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController
    private lateinit var appBarConfiguration: AppBarConfiguration

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        supportActionBar!!.hide()

        initNavigation()
    }

    private fun initNavigation() {
        val host = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = host.navController

        appBarConfiguration = AppBarConfiguration(
            setOf(R.id.fragment_job_board)
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
    }

}