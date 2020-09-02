package com.example.tribuna.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tribuna.R
import com.example.tribuna.models.Idea
import com.example.tribuna.adapter.IdeaAdapter
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity(),
    IdeaAdapter.OnLikeBtnClickListener,
    IdeaAdapter.OnDislikeBtnClickListener,
    IdeaAdapter.OnSeeBtnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }

    private fun init() {
        val debugIdeaList = mutableListOf(
            Idea(
                "Debug", "it test", Date(), getDrawable(R.drawable.finger_neutral)
            ),
            Idea(
                "Debuging", "it's test too", Date(), getDrawable(R.drawable.finger_neutral)
            )
        )
        with(container) {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = IdeaAdapter(debugIdeaList).apply {
                likeBtnClickListener = this@MainActivity
                dislikeBtnClickListener = this@MainActivity
                seeBtnClickListener = this@MainActivity
            }
        }
    }

    override fun onLikeBtnClicked(item: Idea, position: Int, list: MutableList<Idea>) {
        TODO("Not yet implemented")
    }

    override fun onDislikeBtnClicked(item: Idea, position: Int, list: MutableList<Idea>) {
        TODO("Not yet implemented")
    }

    override fun onSeeBtnClicked(item: Idea, position: Int, list: MutableList<Idea>) {
        TODO("Not yet implemented")
    }
}