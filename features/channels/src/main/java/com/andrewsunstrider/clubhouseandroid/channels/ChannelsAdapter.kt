package com.andrewsunstrider.clubhouseandroid.channels

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ChannelsAdapter(
    private val presentation: List<ChannelDisplayRow>,
    private val shareAction: (ChannelDisplayRow) -> Unit
) : RecyclerView.Adapter<ChannelsHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChannelsHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_channel, parent, false)
        return ChannelsHolder(view)
    }

    override fun getItemCount() = presentation.size

    override fun onBindViewHolder(holder: ChannelsHolder, position: Int) {
        holder.bind(presentation[position], shareAction)
    }
}

class ChannelsHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(row: ChannelDisplayRow, action: (ChannelDisplayRow) -> Unit) {
        itemView.run {

            itemView.findViewById<TextView>(R.id.channel_title).apply {
                text = row.title
            }
            itemView.findViewById<TextView>(R.id.speakers_count).apply {
                text = row.numSpeakers.toString()
            }
            itemView.findViewById<TextView>(R.id.member_count).apply {
                text = row.numAll.toString()
            }

            setOnClickListener { action.invoke(row) }
        }
    }
}
