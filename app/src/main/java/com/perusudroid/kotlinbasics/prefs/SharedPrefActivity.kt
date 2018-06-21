package com.perusudroid.kotlinbasics.prefs

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.perusudroid.kotlinbasics.R
import com.perusudroid.kotlinbasics.prefs.SharedPref.get
import com.perusudroid.kotlinbasics.prefs.SharedPref.set

class SharedPrefActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shared_pref)

        // PreferenceHelper.setValue(this, "name", "Perusudroid")

        // Log.d("SharedPrefActivity", PreferenceHelper.getValue(this, "name", String::class.java, ""))


        //get default prefs
        val prefs = SharedPref.defaultPrefs(this)
//        prefs.set("Name", "Perusudroid")
//        prefs.set("Age", 24)
        //set any type of value in prefs
        prefs["PREF_NAME"] = "Perusudroid"
        prefs["PREF_AGE"] = 23

        //get any value from prefs
        val name: String? = prefs["PREF_NAME"]

        //get value from prefs (with default value)
        val age: Int? = prefs["PREF_AGE", 23]

        Log.d("SharedPrefActivity", "name : $name")
        Log.d("SharedPrefActivity", "age : $age")


    }
}
