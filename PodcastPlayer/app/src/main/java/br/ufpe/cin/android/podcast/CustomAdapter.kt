package br.ufpe.cin.android.podcast

import android.content.ContentValues.TAG
import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.itemlista.view.*

class CustomAdapter (private val Episodes : ArrayList<ItemFeed>, private val c : Context) : RecyclerView.Adapter<CustomAdapter.MyViewHolder>() {
    private var TAG : String = "AdapterLog"

    override fun getItemCount() =
        Episodes.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(c).inflate(R.layout.itemlista,parent,false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val episode = Episodes[position]
        holder.title?.text = episode.title
        holder.date?.text = episode.pubDate
    }



    inner class MyViewHolder(v : View) : RecyclerView.ViewHolder(v), View.OnClickListener{
        val title = v.item_title
        val date = v.item_date

        init {
            v.setOnClickListener(this)
        }

        override fun onClick(p0: View) {
            val position = adapterPosition
            val episode = Episodes[position]
            val intent = Intent(c,EpisodeDetailActivity::class.java)
            intent.putExtra("description",episode.description)
            intent.putExtra("link",episode.link)
            c.startActivity(intent)
        }
    }
}