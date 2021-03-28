package com.andrewsunstrider.clubhouseandroid.channels

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.andrewsunstrider.clubhouseandroid.utilities.load
import java.util.stream.Collectors

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

            itemView.findViewById<TextView>(R.id.speaker_name_one).apply {
                text = row.users.stream()
                    .map { user -> if (user.isSpeaker) (user.name + " 💬") else user.name }
                    .collect(Collectors.joining("\n"))
            }

            val avatarFirst = itemView.findViewById<ImageView>(R.id.speaker_avatar_first)
            val avatarSecond = itemView.findViewById<ImageView>(R.id.speaker_avatar_second)

            row.users
                .filterIndexed { index, _ -> index <= 1 }
                .mapIndexed { index, channelUser ->
                    when (index) {
                        0 -> avatarFirst.load(channelUser.photoUrl)
                        else -> avatarSecond.apply {
                            visibility = View.VISIBLE
                            load(channelUser.photoUrl)
                        }
                    }
                }

            setOnClickListener { action.invoke(row) }
        }
    }
}
