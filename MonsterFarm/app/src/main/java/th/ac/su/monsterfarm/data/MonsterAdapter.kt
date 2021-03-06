package th.ac.su.monsterfarm.data

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ListView
import android.widget.TextView
import kotlinx.android.synthetic.main.list_item_monster.view.*
import th.ac.su.monsterfarm.R
import java.util.*
import java.util.zip.Inflater
import javax.sql.CommonDataSource

class MonsterAdapter(private val context:Context,
                     private val dataSource: ArrayList<Monster>) : BaseAdapter(){

    private val inflater:LayoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    override fun getCount(): Int {
        return dataSource.size
    }

    override fun getItem(position: Int): Any {
        return dataSource[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View? {
        val rowView = inflater.inflate(R.layout.list_item_monster,null)
        //rowView.tvTitle.text = "Hello"
        rowView.tvTitle.text = dataSource[position].monsterName
        rowView.tvSubtitle.text = dataSource[position].caption
        rowView.tvDetail.text = dataSource[position].price.toString()
        //rowView.imgThumbnail.setImageResource(R.drawable.monster01_tn)
        val res = context.resources
        val drawableId:Int = res.getIdentifier(dataSource[position].imageFile,"drawable",context.packageName)
        rowView.imgThumbnail.setImageResource(drawableId)
        return rowView
    }

}