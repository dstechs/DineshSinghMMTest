package com.dinesh.myapplication

import android.os.Bundle
import android.view.Gravity
import android.view.MotionEvent
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    val boxSize = 3
    val ticTacToe: TicTacToe by lazy {
        TicTacToe(boxSize)
    }

    var clickItem = TicTacToe.userOne

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        createBoxView(boxSize)
    }

    private fun createBoxView(boxNums: Int) {
        ticTacToe.reset()
        llContainer.removeAllViews()
        for (index in 0 until boxNums) {
            val linearLayout = LinearLayout(this)
            linearLayout.orientation = LinearLayout.HORIZONTAL
            linearLayout.id = Random.nextInt()
            val layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )
            linearLayout.layoutParams = layoutParams
            for (column in 0 until boxNums) {
                linearLayout.addView(getTextView(index, column))
            }
            llContainer.addView(linearLayout)
        }
    }


    private fun getTextView(rowIndex: Int, columnIndex: Int) : TextView {
        val view = TextView(this).apply {
            id = Random.nextInt()
            setBackgroundResource(R.drawable.border_box)
            tag = Pair(rowIndex, columnIndex)
            gravity = Gravity.CENTER
        }

        val layoutParams = LinearLayout.LayoutParams(100, 100)
        layoutParams.setMargins(0,0,10,0)
        view.layoutParams = layoutParams

        addTouchListener(view)
        return view
    }

    private fun addTouchListener(view: TextView) {
       view.setOnClickListener {
           val indexes = it.tag as Pair<Int, Int>
           val result = ticTacToe.setSelection(clickItem, indexes.first, indexes.second)

           when(result) {
               TicTacToe.Result.WINNER -> {
                   Toast.makeText(this, "Winner Found $clickItem", Toast.LENGTH_SHORT).show()
                   createBoxView(boxSize)
               }
               TicTacToe.Result.DRAW -> {
                   Toast.makeText(this, "Draw", Toast.LENGTH_SHORT).show()
                   createBoxView(boxSize)
               }
               else -> {
                   view.text = clickItem.toString()
                   clickItem = if(clickItem == TicTacToe.userTwo)
                       TicTacToe.userOne
                   else
                       TicTacToe.userTwo
               }
           }

       }
    }


}

