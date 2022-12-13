package com.example.bloodpressure

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.bloodpressure.databinding.ActivityMainBinding
import com.example.bloodpressure.utils.ConfigScreen
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    @Inject
    lateinit var config: ConfigScreen
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupView()
    }

    private fun setupView() {
        binding.apply {
            bottomBar.setupWithNavController(findNavController(R.id.flTabContainer))
        }
    }

    fun visibilityBottomBar(isShow: Boolean) {
        binding.bottomBar.visibility = if (isShow) View.VISIBLE else View.GONE
    }
}