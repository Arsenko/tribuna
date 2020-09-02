package com.example.tribuna.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tribuna.R
import com.example.tribuna.models.Idea
import kotlinx.android.synthetic.main.item_idea.view.*
import java.text.SimpleDateFormat

class IdeaAdapter(val list: MutableList<Idea>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    var likeBtnClickListener: OnLikeBtnClickListener? = null
    var dislikeBtnClickListener: OnDislikeBtnClickListener? = null
    var seeBtnClickListener: OnSeeBtnClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_idea, parent, false)
        return IdeaViewHolder(this, view)
    }

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        Log.v("test", "position is $position")
        with(holder as IdeaViewHolder) {
            bind(list[position])
        }
    }

    interface OnLikeBtnClickListener {
        fun onLikeBtnClicked(item: Idea, position: Int, list: MutableList<Idea>)
    }

    interface OnDislikeBtnClickListener {
        fun onDislikeBtnClicked(item: Idea, position: Int, list: MutableList<Idea>)
    }

    interface OnSeeBtnClickListener {
        fun onSeeBtnClicked(item: Idea, position: Int, list: MutableList<Idea>)
    }
}


class IdeaViewHolder(val adapter: IdeaAdapter, view: View) : RecyclerView.ViewHolder(view) {
    init {
        with(itemView) {
            likeBtn.setOnClickListener {
                val currentPosition = adapterPosition
                if (currentPosition != RecyclerView.NO_POSITION) {
                    val item = adapter.list[currentPosition]
                    adapter.likeBtnClickListener?.onLikeBtnClicked(
                        item,
                        currentPosition,
                        adapter.list
                    )
                }
            }
            dislikeBtn.setOnClickListener {
                val currentPosition = adapterPosition
                if (currentPosition != RecyclerView.NO_POSITION) {
                    val item = adapter.list[currentPosition]
                    adapter.dislikeBtnClickListener?.onDislikeBtnClicked(
                        item,
                        currentPosition,
                        adapter.list
                    )
                }
            }
            seeBtn.setOnClickListener {
                val currentPosition = adapterPosition
                if (currentPosition != RecyclerView.NO_POSITION) {
                    val item = adapter.list[currentPosition]
                    adapter.seeBtnClickListener?.onSeeBtnClicked(
                        item,
                        currentPosition,
                        adapter.list
                    )
                }
            }
        }
    }

    fun bind(idea: Idea) {
        with(itemView) {
            val format = SimpleDateFormat("H:mm dd/MM/yyyy")
            authorTv.text = idea.authorName
            createdTv.text = format.format(idea.ideaDate)
            contentTv.text = idea.ideaText
        }
    }
}

