package com.example.webservicedemo

import android.content.Context
import android.telecom.Call
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.webservicedemo.Model.UserData

class DataAdapter (private var datalist:List<UserData>, private val context: Context) : RecyclerView.Adapter<DataAdapter.ViewHolder>() {
    class ViewHolder(view:View) : RecyclerView.ViewHolder(view){
        var textView:TextView
        var textView1:TextView
        var textView2:TextView
        var textView3:TextView
        var textView4:TextView
        init {
            textView=view.findViewById(R.id.tv_name)
            textView1=view.findViewById(R.id.tv_email)
            textView2=view.findViewById(R.id.tv_phone)
            textView3=view.findViewById(R.id.tv_username)
            textView4=view.findViewById(R.id.tv_website)
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataAdapter.ViewHolder {

        val v1 = LayoutInflater.from(parent.context).inflate(R.layout.raw,parent,false)
        return ViewHolder(v1)

    }

    override fun getItemCount(): Int {
        return datalist.size

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val userData= datalist.get(position)
        holder.textView.text=userData.name
        holder.textView1.text=userData.email
        holder.textView2.text=userData.phone
        holder.textView3.text=userData.username
        holder.textView4.text=userData.website





    }

}



