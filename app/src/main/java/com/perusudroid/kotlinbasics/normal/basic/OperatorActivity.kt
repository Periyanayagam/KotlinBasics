package com.perusudroid.kotlinbasics.normal.basic

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.perusudroid.kotlinbasics.R

class OperatorActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_operator)

        val company = Company(listOf(Employee(1, "Abc")))
        val data = company[0]

        Log.d("OperatorActivity", "data ${data.name}")
    }
}
