package com.aimids.exampreparation.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.annotation.NonNull
import androidx.recyclerview.widget.RecyclerView
import com.aimids.exampreparation.R
import com.aimids.exampreparation.models.CardViewData
import com.squareup.picasso.Picasso

class CardViewAdapter(cards: List<CardViewData>) :
    RecyclerView.Adapter<CardViewAdapter.BaseViewHolder>() {

    private var mCards = mutableListOf<CardViewData>()
    private lateinit var mClickListener: OnItemClickListener

    init {
        this.mCards = cards as MutableList<CardViewData>
    }

    inner class BaseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener {
        var imageView: ImageView = itemView.findViewById(R.id.background_image)
        override fun onClick(v: View?) {
            mClickListener.onItemClick()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        val view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.cardview_layout_item, parent, false)
        return BaseViewHolder(view)
    }

    override fun getItemCount(): Int {
        return mCards.size
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        val cardViewData: CardViewData = mCards[position]
        val imageView = holder.imageView
        Picasso.get().load(cardViewData.imageUrl).fit().into(imageView)
    }

    fun setOnItemClickListener(@NonNull clickListener: OnItemClickListener) {
        this.mClickListener = clickListener
    }

    interface OnItemClickListener {
        fun onItemClick()
    }
}
