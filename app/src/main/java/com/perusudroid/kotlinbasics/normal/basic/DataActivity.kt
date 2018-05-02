package com.perusudroid.kotlinbasics.normal.basic

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.perusudroid.kotlinbasics.R

class DataActivity : AppCompatActivity() {

    var iData: IData? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_data)

        iData = DataProcessor() // normal Interface
        iData?.doSomething("Perusudroid", this)

        // calling two processors simultaneously
        /*var iMultipleDataProcessor : MultipleDataProcessor? = MultipleDataProcessor()
        iMultipleDataProcessor?.showMsg("This is a sample msg for both ProcessorOne and ProcessorTwo", this)*/
    }
}
