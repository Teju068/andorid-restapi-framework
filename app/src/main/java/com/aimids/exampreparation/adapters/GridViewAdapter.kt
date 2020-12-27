package com.aimids.exampreparation.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.aimids.exampreparation.R
import com.aimids.exampreparation.models.GridViewData
import com.squareup.picasso.Picasso

class GridViewAdapter(grids: List<GridViewData>) :
    RecyclerView.Adapter<GridViewAdapter.BaseViewHolder>() {
    private var mGrids = mutableListOf<GridViewData>()
    private lateinit var mClickListener: OnItemClickListener

    init {
        mGrids = grids as MutableList<GridViewData>
    }

    inner class BaseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener {

        init {
            itemView.setOnClickListener(this)
        }

        val imageView: ImageView = itemView.findViewById(R.id.grid_view_image)
        val imageDescription: TextView = itemView.findViewById(R.id.image_description)
        override fun onClick(v: View?) {
            mClickListener.onItemClick()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        val view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.gridview_layout_item, parent, false)
        return BaseViewHolder(view)
    }

    override fun getItemCount(): Int {
        return mGrids.size
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        val gridViewData: GridViewData = mGrids[position]
        val imageView = holder.imageView
        if (gridViewData.imageUrl != null) {
            Picasso.get().load(gridViewData.imageUrl).fit().into(imageView)
        } else {
            imageView.setImageResource(R.drawable.round_expand_more_black_24dp)
        }
        holder.imageDescription.text = gridViewData.displayText
    }

    fun setOnItemClickListener(onItemClickListener: OnItemClickListener) {
        this.mClickListener = onItemClickListener
    }

    interface OnItemClickListener {
        fun onItemClick()
    }
}
