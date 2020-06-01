package com.example.cartrigerecharge

import android.content.res.TypedArray
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.main_content.*

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    var adapter: MyAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        nav_view.setNavigationItemSelectedListener(this)

        var list = ArrayList<ListItem>()

        list.addAll(fillArrays(resources.getStringArray(R.array.hp),
        resources.getStringArray(R.array.hp_content),
        getImmageId(R.array.hp_immage_array)))

        contView.hasFixedSize()
        contView.layoutManager = LinearLayoutManager(this)
        adapter = MyAdapter(list, this)
        contView.adapter = adapter

    }
    override fun onNavigationItemSelected(item: MenuItem): Boolean { // прослушивание нажатий по идентификаторам
        when (item.itemId){
            R.id.id_hp -> {
                Toast.makeText(this, "id hp", Toast.LENGTH_SHORT ).show()
                adapter?.updatedapter(
                    fillArrays(resources.getStringArray(R.array.hp),
                        resources.getStringArray(R.array.hp_content),getImmageId(R.array.hp_immage_array)) as ArrayList<ListItem>
                )

            }
            R.id.id_can -> {
                Toast.makeText(this, "id can", Toast.LENGTH_SHORT ).show()
                adapter?.updatedapter(
                    fillArrays(resources.getStringArray(R.array.Canon),
                        resources.getStringArray(R.array.can_content),getImmageId(R.array.can_immage_array)) as ArrayList<ListItem>
                )

            }
            R.id.id_kyo -> Toast.makeText(this, "id can", Toast.LENGTH_SHORT ).show()
            R.id.id_Sam -> Toast.makeText(this, "id sam", Toast.LENGTH_SHORT ).show()


        }


        return true
    }
    fun fillArrays(titleArray: Array<String>, contentArray: Array<String>, immageArray: IntArray):List<ListItem>
    {
        var listItemArray = java.util.ArrayList<ListItem>()
        for (n in 0..titleArray.size - 1)
        {
            var  listItem = ListItem(immageArray[n], titleArray[n], contentArray[n])
            listItemArray.add(listItem)
        }
        return listItemArray

    }
    fun getImmageId(immageArrayId: Int): IntArray
    {
        var tArray: TypedArray = resources.obtainTypedArray(immageArrayId)
        val cont = tArray.length()
        val ids = IntArray(cont)
        for (i in ids.indices){
            ids[i] = tArray.getResourceId(i, 0)
        }
        tArray.recycle()
        return ids
    }
}
