package com.example.recyclerviewtest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {

    private val fruitList = ArrayList<Fruit>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //准备数据
        initFruits()
        //找到RecyclerView,用extension插件之间找

        //创建布局管理器
        val layoutManager = StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL)
        //设置布局管理器
        recyclerView.layoutManager = layoutManager
        //创建+设置适配器
        recyclerView.adapter = FruitAdapter(fruitList)

    }

    private fun initFruits() {
        repeat(5)
        {
            fruitList.add(Fruit(getRandomLengthName("apple"), R.drawable.apple_pic))
            fruitList.add(Fruit(getRandomLengthName("banana"), R.drawable.banana_pic))
            fruitList.add(Fruit(getRandomLengthName("cherry"), R.drawable.cherry_pic))
            fruitList.add(Fruit(getRandomLengthName("grape"), R.drawable.grape_pic))
            fruitList.add(Fruit(getRandomLengthName("mango"), R.drawable.mango_pic))
            fruitList.add(Fruit(getRandomLengthName("orange"), R.drawable.orange_pic))
            fruitList.add(Fruit(getRandomLengthName("pear"), R.drawable.pear_pic))
            fruitList.add(Fruit(getRandomLengthName("pineapple"), R.drawable.pineapple_pic))
            fruitList.add(Fruit(getRandomLengthName("strawberry"), R.drawable.strawberry_pic))
            fruitList.add(Fruit(getRandomLengthName("watermelon"), R.drawable.watermelon_pic))
        }
    }

    private fun getRandomLengthName(name: String): String {
        val length = Random().nextInt(20) + 1
        val builder = StringBuilder()
        for (i in 0 until length) {
            builder.append(name)
        }
        return builder.toString()
    }

}
