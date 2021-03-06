package th.ac.su.monsterfarm

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Adapter
import android.widget.ArrayAdapter
import android.widget.ListView
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.android.synthetic.main.activity_main.*
import th.ac.su.monsterfarm.Utils.getJsonDataFromAsset
import th.ac.su.monsterfarm.data.Monster
import th.ac.su.monsterfarm.data.MonsterAdapter
import java.util.*


class MainActivity : AppCompatActivity() {
    var itemList:ArrayList<Monster> = ArrayList<Monster>()
    lateinit var arrayAdapter: ArrayAdapter<Monster>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val jsonFileString = getJsonDataFromAsset(applicationContext,"monster_data.json")
        //Log.i("data", jsonFileString)
        val gson = Gson()
        val listItemType = object :TypeToken<ArrayList<Monster>>(){}.type
        var monsterList :ArrayList<Monster> = gson.fromJson(jsonFileString,listItemType)
        //Log.i("data", monsterList[0].monsterName)
        itemList = monsterList
        val adapter = MonsterAdapter(this@MainActivity,itemList)
        listView.adapter = adapter

        listView.setOnItemClickListener { parent, view, position, id ->

            var intent = Intent(this@MainActivity,DetailActivity::class.java)

            intent.putExtra("title",itemList[position].monsterName)
            intent.putExtra("caption",itemList[position].caption)
            intent.putExtra("imageFile",itemList[position].imageFile)

            startActivity(intent)
        }
    }
}