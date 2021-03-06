package com.example.mmapromotionsnews.presentation.activities

import android.content.Intent
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.transition.Transition
import com.example.mmapromotionsnews.R
import com.example.mmapromotionsnews.databinding.ActivityPromoNavigationBinding
import com.google.android.material.navigation.NavigationView

class PromoNavigationActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityPromoNavigationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityPromoNavigationBinding.inflate(layoutInflater)
        setContentView(binding.root)
        loadJsonPicture()

        actionBar?.title = Intent().getStringExtra("selectedPromotion")

        setSupportActionBar(binding.appBarPromoNavigation.toolbar)

        val drawerLayout: DrawerLayout = binding.drawerLayout
        val navView: NavigationView = binding.navView
        val navController = findNavController(R.id.nav_host_fragment_content_promo_navigation)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow, R.id.nav_p4p, R.id.nav_news
            ), drawerLayout
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.promo_navigation, menu)
        return true
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_promo_navigation)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

    private fun loadJsonPicture() {
        try {
            Glide.with(this).load("http://95.217.132.144/mma/background_image.jpg")
                .into(object : CustomTarget<Drawable>() {
                    override fun onResourceReady(p0: Drawable, p1: Transition<in Drawable>?) {
                        binding.drawerLayout.background = p0
                    }

                    override fun onLoadCleared(p0: Drawable?) {

                    }
                })
        } catch (e: Exception) {
        }
    }
}