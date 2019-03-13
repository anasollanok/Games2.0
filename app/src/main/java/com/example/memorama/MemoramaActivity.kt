package com.example.memorama

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.widget.TextView
import com.example.games.R
import kotlinx.android.synthetic.main.activity_memorama.*

class MemoramaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_memorama)
        val rv = recyclerView1
        rv.setHasFixedSize(true)
        val score = score
        var grid = GridLayoutManager(this, 4)
        rv.layoutManager = grid

        val chips = ArrayList<Chip>()
        for( i  in 0..15)
            chips.add(Chip(R.mipmap.ic_launcher))
        val img = ArrayList<Int>()
        img.add(R.drawable.pusheen1)
        img.add(R.drawable.pusheen2)
        img.add(R.drawable.pusheen3)
        img.add(R.drawable.pusheen4)
        img.add(R.drawable.pusheen5)
        img.add(R.drawable.pusheen6)
        img.add(R.drawable.pusheen7)
        img.add(R.drawable.pusheen8)
        img.add(R.drawable.pusheen1)
        img.add(R.drawable.pusheen2)
        img.add(R.drawable.pusheen3)
        img.add(R.drawable.pusheen4)
        img.add(R.drawable.pusheen5)
        img.add(R.drawable.pusheen6)
        img.add(R.drawable.pusheen7)
        img.add(R.drawable.pusheen8)
        img.shuffle()
        var  adapter = MemoramaAdapter(chips, img, score)
        rv.adapter = adapter

        score.setText("0")

    }

}
