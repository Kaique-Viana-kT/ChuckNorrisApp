package com.rose.ChuckNorrisApp

import android.graphics.Color
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var appBar : AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        installSplashScreen()

        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        window.statusBarColor = ContextCompat.getColor(this,R.color.blue_tertiary)
        WindowInsetsControllerCompat(window, window.decorView).isAppearanceLightStatusBars = false

        val tollbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(tollbar)

        val drawerLayout = findViewById<DrawerLayout>(R.id.drawerlayout)
        val navView = findViewById<NavigationView>(R.id.navi_view)

        val navController = findNavController(R.id.nav_host_fragment_main)

        appBar = AppBarConfiguration(
            setOf(
                R.id.nav_home, R.id.nav_joke_day, R.id.nav_about
            ), drawerLayout
        )

        setupActionBarWithNavController(navController, appBar)

        navView.setupWithNavController(navController)

    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_main)
        return navController.navigateUp(appBar) || super.onSupportNavigateUp()
    }
}