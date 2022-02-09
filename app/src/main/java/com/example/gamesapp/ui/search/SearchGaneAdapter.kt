package com.example.gamesapp.ui.search

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.gamesapp.R
import com.example.gamesapp.databinding.ListItemSearchBinding
import com.example.gamesapp.domain.model.DataGame
import com.squareup.picasso.Picasso

class SearchGaneAdapter : RecyclerView.Adapter<SearchGaneAdapter.ListViewHolder>() {
    private val listData = ArrayList<DataGame>()

    fun setData(newListData: List<DataGame>?) {
        if (newListData == null) return
        listData.clear()
        listData.addAll(newListData)
        notifyDataSetChanged()
    }

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = ListItemSearchBinding.bind(itemView)
        fun bind(data: DataGame) {
            with(binding) {
                tvNameGame.text = data.name
                Picasso.get().load(data.background_image).into(ivThumbnailGame)
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): SearchGaneAdapter.ListViewHolder {
        return ListViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.list_item_search, parent, false))
    }

    override fun onBindViewHolder(holder: SearchGaneAdapter.ListViewHolder, position: Int) {
        val data = listData[position]
        holder.bind(data)
    }

    override fun getItemCount(): Int {
        return listData.size
    }
}