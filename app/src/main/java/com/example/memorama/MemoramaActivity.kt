package com.example.memorama

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.view.View
import android.widget.ImageView
import com.example.games.R
import kotlinx.android.synthetic.main.activity_memorama.*
import android.util.Log

class MemoramaActivity : AppCompatActivity() {

    val chips = ArrayList<Chip>()
    var player = 1
    var player1 = 0
    var player2 = 0
    var firstCard = 0
    var secondCard = 0
    var numberImages = mutableListOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    var imagesArr: ArrayList<Int>? = null

    var img1: ImageView? = null; var img2 = 0; var img3 = 0; var img4 = 0; var img5 = 0
    var img6 = 0; var img7 = 0; var img8 = 0; var img9 = 0; var img10 = 0
    var img11 = 0; var img12 = 0; var img13 = 0; var img14 = 0; var img15 = 0
    var img16 = 0; var img17 = 0; var img18 = 0; var img19 = 0; var img20 = 0
    var count = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_memorama)

        val rv = recyclerView1
        rv.setHasFixedSize(true)
        var grid = GridLayoutManager(this, 4)
        rv.layoutManager = grid

        setImagesToPositions()
        var adapter = MemoramaAdapter(chips, this)
        rv.adapter = adapter
    }

    private fun setImagesToPositions() {
        numberImages.shuffle()
        for(i in 0..19) {
            chips.add(Chip(R.mipmap.ic_launcher, numberImages[i%10]))
        }
    }

    fun getImage(position: Int): Int {
        var id = when (chips[position].front) {
            1 -> R.drawable.beach
            2 -> R.drawable.bowling
            3 -> R.drawable.cocktail
            4 -> R.drawable.earth
            5 -> R.drawable.ironman
            6 -> R.drawable.moon
            7 -> R.drawable.ozzy
            8 -> R.drawable.radio
            9 -> R.drawable.rocket
            10 -> R.drawable.time
            else -> 0
        }
        return id
    }

    fun gameOn() {
        if (player == 1) {

            if (checkForEqual()) {
                player1++
            }
            player = 2
        }
        else if (player == 2) {

            if (checkForEqual()) {
                player2++
            }
            player = 1
        }
        firstCard = 0
        secondCard = 0
    }

    fun setCard(card: Int, item: View) {
        item.isEnabled = false
        if (firstCard == 0) {
            firstCard = card
        }
        else {
            secondCard = card
        }
    }

    fun checkForEqual(): Boolean {
        if (firstCard == secondCard) {

            return true
        }
        return false
    }

}
