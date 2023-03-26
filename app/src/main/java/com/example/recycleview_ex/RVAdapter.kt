package com.example.recycleview_ex

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


// recycler의 item을 불러오는 작업
class RVAdapter (val items : MutableList<String>) : RecyclerView.Adapter<RVAdapter.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RVAdapter.ViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.rv_item, parent, false)

        return ViewHolder(view)

    }

    //item 클릭 시 event 처리하기 위해 만듬
    interface  ItemClick {
        fun onClick(view : View, position: Int)
    }

    var itemClick : ItemClick? = null

    override fun onBindViewHolder(holder: RVAdapter.ViewHolder, position: Int) {

        //item을 binding해주는 것. 즉 view binding을 해주는 것
        // view binding이란 Adapter에 들어온 data를 recyclerview_item.xml로
        // 넣어준 뒤 최종적으로 사용자에게 보여줄 화면인 activity_main에 보여주는 작업을 의미
       holder.bindItems(items[position])


        //item 클릭 시 event 처리하기 위해 만듬
        if(itemClick != null) {
            holder.itemView.setOnClickListener { v->
            itemClick?.onClick(v, position)

            }
        }

    }


    // 전체 리사이클러뷰의 갯수
   override fun getItemCount(): Int {
        return items.size
    }


    //ViewHolder를 만들어 줌
    inner class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {

        fun bindItems(item: String) {

            //아래를 적어주지 않으면 item 글씨에는 rv만 뜬다. a, b, c가 뜨지 않음
            val rv_text = itemView.findViewById<TextView>(R.id.rvItem)
            rv_text.text = item
        }

    }

}