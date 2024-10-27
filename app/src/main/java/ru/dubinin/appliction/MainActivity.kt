package ru.dubinin.appliction

import android.content.res.Configuration
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    lateinit var recyclerView: RecyclerView
    lateinit var button: Button

    private val adapter = ListAdapter()

    companion object SPAN_COUNT {
        const val LANDSCAPE = 4
        const val PORTRAIT = 3
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView = findViewById(R.id.recycler_view)
        button = findViewById(R.id.add_card_button)

        val currentOrientation = resources.configuration.orientation
        val spanCount = if (currentOrientation == Configuration.ORIENTATION_LANDSCAPE) {
            LANDSCAPE
        } else {
            PORTRAIT
        }
        val layoutManager = GridLayoutManager(applicationContext, spanCount)

        recyclerView.adapter = adapter
        recyclerView.layoutManager = layoutManager

        button.setOnClickListener {
            adapter.addItems(adapter.itemCount + 1)
            Log.d("ADD", "${adapter.itemCount + 1}")
        }

        if (savedInstanceState != null) {
            savedInstanceState.getIntegerArrayList("Items")?.let { adapter.items = it }
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        outState.putIntegerArrayList("Items", adapter.items)
    }
}