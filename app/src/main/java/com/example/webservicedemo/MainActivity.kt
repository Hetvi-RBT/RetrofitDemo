package com.example.webservicedemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.webservicedemo.Model.UserData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var adapter: DataAdapter
    lateinit var rvData: RecyclerView
    var dataList = ArrayList<UserData>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvData = findViewById<View>(R.id.recycler_view) as RecyclerView

        rvData.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        rvData.adapter = DataAdapter(dataList, this)



        getData()
    }


    private fun getData() {

        val call: Call<List<UserData>> = ApiClient.getClient.getuserdata()
        call.enqueue(object : Callback<List<UserData>> {
            override fun onFailure(call: Call<List<UserData>>, t: Throwable) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onResponse(call: Call<List<UserData>>, response: Response<List<UserData>>) {

                if (response.isSuccessful) {

                    for (index in 0..response.body()!!.size - 1) {

                        dataList.add(response.body()!!.get(index))
                    }
                    rvData.adapter?.notifyDataSetChanged()

                    for (index in 0..response.body()!!.size - 1) {
                        Log.e("Id", "" + response.body()!!.get(index).id)
                        Log.e("name", "" + response.body()!!.get(index).name)
                        Log.e("username", "" + response.body()!!.get(index).username)
                        Log.e("email", "" + response.body()!!.get(index).email)
                        Log.e("street", "" + response.body()!!.get(index).address!!.street)
                        Log.e("suite", "" + response.body()!!.get(index).address!!.suite)
                        Log.e("city", "" + response.body()!!.get(index).address!!.city)
                        Log.e("zipcode", "" + response.body()!!.get(index).address!!.zipcode)
                        Log.e("geo", "" + response.body()!!.get(index).address!!.geo!!.lat)
                        Log.e("geo", "" + response.body()!!.get(index).address!!.geo!!.lng)
                        Log.e("phone", "" + response.body()!!.get(index).phone)
                        Log.e("website", "" + response.body()!!.get(index).website)
                        Log.e("company", "" + response.body()!!.get(index).company!!.name)
                        Log.e("company", "" + response.body()!!.get(index).company!!.catchPhrase)
                        Log.e("company", "" + response.body()!!.get(index).company!!.bs)


                    }

                }

            }
        })

    }

}




