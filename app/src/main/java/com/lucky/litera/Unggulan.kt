package com.lucky.litera

import android.content.Intent
import android.graphics.Typeface
import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Unggulan : AppCompatActivity() {

    private lateinit var navLibraryIcon: ImageView
    private lateinit var navFeaturedIcon: ImageView
    private lateinit var navExploreIcon: ImageView
    private lateinit var navProfileIcon: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.unggulan)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.unggul)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val tabBuku = findViewById<TextView>(R.id.tab_buku)
        val tabBukuBaru = findViewById<TextView>(R.id.tab_buku_baru)

        // Highlight the Buku tab to indicate it's active
        tabBuku.setTextColor(resources.getColor(R.color.selected_tab_color)) // Highlight this tab

        // Handle navigation to BukuBaruActivity
        tabBukuBaru.setOnClickListener {
            val intent = Intent(this, BukuBaruActivity::class.java)
            startActivity(intent)
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

    private fun highlightTab(activeTab: TextView, inactiveTab: TextView) {
        // Set the active tab to bold
        activeTab.setTypeface(null, Typeface.BOLD)
        activeTab.setTextColor(resources.getColor(R.color.selected_tab_color))

        // Set the inactive tab to normal
        inactiveTab.setTypeface(null, Typeface.NORMAL)
        inactiveTab.setTextColor(resources.getColor(R.color.unselected_tab_color))
    }
}