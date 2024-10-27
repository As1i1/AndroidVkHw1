package ru.dubinin.appliction

import android.graphics.Color
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    val text = view.findViewById<TextView>(R.id.text_1)
    val image = view.findViewById<ImageView>(R.id.image_view)

    fun bind(number: Int) {
        text.text = "$number"
        image.setBackgroundColor(getColor(number))
    }

    fun getColor(number: Int): Int = if (number % 2 == 0) {
        Color.RED
    } else {
        Color.BLUE
    }

}