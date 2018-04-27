package com.perusudroid.kotlinbasics.normal.sample

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.perusudroid.kotlinbasics.R
import com.perusudroid.kotlinrecyclerview.sample.SampleData

class SampleActivity : AppCompatActivity() {

    private var recyclerView: RecyclerView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView?.layoutManager = LinearLayoutManager(this)

        val data = ArrayList<SampleData>()
        data.add(SampleData("Periya", "Nayagam"))
        data.add(SampleData("Android", "Developer"))

        recyclerView?.adapter = SampleAdapter(data)
    }
}
