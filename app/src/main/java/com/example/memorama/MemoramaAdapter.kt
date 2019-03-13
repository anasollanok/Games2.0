package com.example.memorama

import android.graphics.drawable.Drawable
import android.os.Handler
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.example.games.R
import kotlinx.android.synthetic.main.renglon.view.*
import kotlin.random.Random

class MemoramaAdapter(val chips: ArrayList<Chip>, val img: ArrayList<Int>, val score: TextView):

    RecyclerView.Adapter<MemoramaAdapter.ChipViewHolder>(){
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ChipViewHolder {
        val view =  LayoutInflater.from(p0.context).inflate(R.layout.renglon, p0, false)
        return ChipViewHolder(view)
    }
    var clickCounter = 0
    var pair = ArrayList<Pair<ImageView,Int>>()
    var found = ArrayList<Int>()
    var scoreCount = 0
    override fun getItemCount(): Int {
        return  chips.size
    }

    override fun onBindViewHolder(p0: ChipViewHolder, p1: Int) {
        p0.imageView.setImageResource(chips[p1].idImage)
    }

    fun getDifferentImage(): Int{
        var imindex = img.get(0)
        img.add(img.size,img.get(0))
        img.removeAt(0)
        return imindex
    }

    fun checkIfPair(item : View, imageView : ImageView){
        if(clickCounter==2){
            if(pair.get(0).second==pair.get(1).second){
                found.add(pair.get(1).second)
                scoreCount++
                score.setText(""+scoreCount)
            }else{
                pair.get(0).first.setImageResource(R.mipmap.ic_launcher)
                imageView.setImageResource(R.mipmap.ic_launcher)
            }
            clickCounter=0
            pair.removeAt(0)
            pair.removeAt(0)
        }
    }

    inner class ChipViewHolder(item : View) : RecyclerView.ViewHolder(item){
        val imageView = item.findViewById<ImageView>(R.id.chip)
        val imgN = getDifferentImage()
        init {
            item.setOnClickListener {
                if(!found.contains(imgN)) {
                    imageView.setImageResource(imgN)
                    clickCounter++
                    pair.add(Pair(imageView, imgN))
                    Handler().postDelayed(Runnable {
                        checkIfPair(item, imageView)
                    },500)
                }

            }
        }
    }

}
