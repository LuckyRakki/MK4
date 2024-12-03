package com.lucky.litera

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class dikembalikan : AppCompatActivity() {

    private lateinit var navLibraryIcon: ImageView
    private lateinit var navFeaturedIcon: ImageView
    private lateinit var navExploreIcon: ImageView
    private lateinit var navProfileIcon: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_dikembalikan)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.kembalikan)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val navLibrary = findViewById<LinearLayout>(R.id.nav_library)
        val navFeatured = findViewById<LinearLayout>(R.id.nav_featured)
        val navExplore = findViewById<LinearLayout>(R.id.nav_explore)
        val navProfile = findViewById<LinearLayout>(R.id.nav_profile)

        // Tambahkan klik listener
        navLibrary.setOnClickListener {
            val intent = Intent(this, Pustaka::class.java)
            startActivity(intent)
        }

        navFeatured.setOnClickListener {
            val intent = Intent(this, Unggulan::class.java)
            startActivity(intent)
        }

        navExplore.setOnClickListener {
            val intent = Intent(this, Explore::class.java)
            startActivity(intent)
        }

        navProfile.setOnClickListener {
            val intent = Intent(this, Profil::class.java)
            startActivity(intent)
        }
    }

    private fun selectTab(tab: String) {
        // Reset all icons to default
        navLibraryIcon.setImageResource(R.drawable.library)
        navFeaturedIcon.setImageResource(R.drawable.featured)
        navExploreIcon.setImageResource(R.drawable.explore)
        navProfileIcon.setImageResource(R.drawable.profile)

        // Highlight the selected tab
        when (tab) {
            "library" -> navLibraryIcon.setImageResource(R.drawable.library_nyala)
            "unggulan" -> navFeaturedIcon.setImageResource(R.drawable.featured_nyala) // Active icon
            "explore" -> navExploreIcon.setImageResource(R.drawable.explore_nyala)
            "profile" -> navProfileIcon.setImageResource(R.drawable.profile_nyala)
        }
    }
}