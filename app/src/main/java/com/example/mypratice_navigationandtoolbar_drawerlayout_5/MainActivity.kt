package com.example.mypratice_navigationandtoolbar_drawerlayout_5

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.mypratice_navigationandtoolbar_drawerlayout_5.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        //加載menu
        binding.navDrawerView.inflateMenu(R.menu.menu_drawer)

        //取得navController
        val navController = binding.fragmentContainerView.getFragment<NavHostFragment>().navController

        //將drawer和NavController關聯
        binding.navDrawerView.setupWithNavController(navController)

        //openDrawer()可以打開drawer
        binding.materialToolbar.setOnClickListener {
            binding.main.openDrawer(binding.navDrawerView)
        }
    }
}