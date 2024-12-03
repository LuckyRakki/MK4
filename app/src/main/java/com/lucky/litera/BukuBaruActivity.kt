package com.lucky.litera

import android.graphics.Typeface
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class BukuBaruActivity : AppCompatActivity() {

    private lateinit var navLibraryIcon: ImageView
    private lateinit var navFeaturedIcon: ImageView
    private lateinit var navExploreIcon: ImageView
    private lateinit var navProfileIcon: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_buku_baru) // Link to your BukuBaru XML layout file

        // Set up header navigation between "Buku" and "Buku Baru"
        val tabBuku = findViewById<TextView>(R.id.tab_buku)
        val tabBukuBaru = findViewById<TextView>(R.id.tab_buku_baru)

        // Navigate back to Buku (Unggulan) page
        tabBuku.setOnClickListener {
            finish() // This closes the current activity and goes back to the previous screen
        }

        // Highlight the selected tab (Buku Baru)
        tabBukuBaru.setTextColor(resources.getColor(R.color.white))

    }


    private fun getBooks(): List<Book> {
        // Create a list of books with dummy data
        return listOf(
            Book("The Perfect Run", R.drawable.book_4),
            Book("Circle of Inevitability", R.drawable.book_6),
            Book("Trash of the Count's Family", R.drawable.book_3),
            Book("Re: Zero", R.drawable.book_4),
            Book("Throne of Magical Arcana", R.drawable.book_5),
            Book("Regressor Instruction Manual", R.drawable.book_6)
        )
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
