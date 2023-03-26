package com.example.recycleview_ex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val items = mutableListOf<String>()

        items.add("a")
        items.add("b")
        items.add("c")


        //rv_item.xml에 있는 TextView인 rv를 불러옴
        val rv = findViewById<RecyclerView>(R.id.rv)


        //RVAdapter.kt 에 items 리스트에 있는 data(a, b, c)들을 넣어준다.
        // adapter에 넣어주면 data들이 rv_item.xml으로 이동해서 치장되고
        // 치장된 얘들이 다시 여기로 와서 rvAdapter 변수에 저장됨?
        val rvAdapter = RVAdapter(items)

        rv.adapter = rvAdapter
        rv.layoutManager = LinearLayoutManager(this)


        //item 클릭 시 toast msg 나오도록 함
        rvAdapter.itemClick = object : RVAdapter.ItemClick {
            override  fun onClick(view: View, position: Int) {
                Toast.makeText(baseContext, items[position], Toast.LENGTH_LONG).show()
            }
        }

    }
}