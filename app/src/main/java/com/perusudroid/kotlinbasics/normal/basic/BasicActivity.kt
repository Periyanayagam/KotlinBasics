package com.perusudroid.kotlinbasics.normal.basic

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.TextView
import com.perusudroid.kotlinbasics.R
import org.jetbrains.anko.toast


class BasicActivity : AppCompatActivity() {


    val name = "10";
    var num = 0;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_basic)


        val tv: TextView = findViewById<TextView>(R.id.tvtxt)

       /* tv.setOnClickListener(){
            activities()
        }*/

        tv.setOnClickListener {
            activities()
        }

        /*printData()
       arrays()
       firstFun(5, 7)
       funAdvanced()
       crapError()
       arrayLists();
       loops()
       Log.d("Switch", switchData("Hello"))
       moreSwitch();
       nullSafety()
       nullSafetyList();
       classesAndObjects();
       makeToasts();*/


    }


    private fun makeToasts() {

        toast("This is a sample lotlin toast")
        //showToast("This is a sample")

    }

    private fun activities() {
        startActivity(Intent(this, DataActivity::class.java))
    }

    private fun classesAndObjects() {

        val sample = Sample("Abc");

    }


    private fun nullSafetyList() {

        val listData = arrayListOf<Any?>("Abc", 1, null)

        for (i in listData) {
            Log.d("NULLIST1", "" + i)
        }

        for (i in listData) {
            i?.let {
                // i not null value alone is filtered
                Log.d("NULLIST2", "" + i)
            }
        }

        val listWithoutNull = listData.filterNotNull()

        for (i in listWithoutNull) {
            Log.d("NULLIST3", i.toString());
        }


    }

    private fun moreSwitch() {

        val mData = arrayOf("A", "B", "C", "D");

        if ("A" in mData) {
            Log.d("MORE SWITCH", "Yes in Data")
        } else {
            Log.e("MORE SWITCH", "Nope")
        }


    }

    private fun arrayLists() {

        val myData = listOf<String>("Periya", "Nayagam")

        //if(myData != null && myData.isNotEmpty())

        Log.d("ALIST", myData.get(0))

    }

    private fun loops() {

        val myData = arrayOf(1, 2, "Periya", "Nayagam");
        var x = 0;

        for (i in myData) {
            Log.d("FOR EACH LOOP", i.toString())
        }

        for (i in myData.indices) {
            Log.d("FOR LOOP", "index ${i} and the values is ${myData[i]}")
        }

        while (x < myData.size) {
            Log.d("WHILE ", "index ${x} and the values is ${myData[x]}")
            x++;
        }


    }

    fun switchData(obj: Any): String =
            when (obj) {
                1 -> "One"
                "Hello" -> "Welcome To Kotlin"
                !is String -> "Invalid String"
                else -> "Unknown"
            }

    private fun funAdvanced() {
        val maxOf = maxOf(8, 9)
        val resOf = getResult(8, 9)

        Log.d("Kotlin", "maxOf " + maxOf)
        Log.d("Kotlin", "resOf " + resOf)
    }

    private fun arrays() {
        val myArray = arrayOf(1, 2, 3, "Perusu")

        Log.d("Kotlin", "myArray ${myArray[3]}")

        //onlyInt

        val myInt = arrayOf<Int>(1, 2, 3)
    }

    private fun printData() {

        num = name.toInt()

        Log.d("Kotlin", "Using dollar $num")


        Log.d("Kotlin", "Your num is ${if (num > 10) " Lesser " else "Greater"}")

    }

    private fun nullSafety() {
        var a: String? = "Perusu"
        a = null
        val b: String? = "Perusudroid"

        // use getStringLengthx for more short form

        val aLength = getStringLength(a);
        Log.d("SIZE", "String ${a} length is.. ${aLength}")

        val bLength = getStringLength(b);

        Log.d("SIZE", "String ${b} length is.. ${bLength}")
    }


    fun crapError() {
        val a = "abc";
        val b = "7";

        if (parseInt(a) != null && parseInt(b) != null) {
            Log.d("Kot", "Numbers ${a} and ${b} are integers")
        } else {
            Log.d("Kot", "either '$a' or '$b' is not a number\"")
        }

    }

    fun firstFun(a: Int, b: Int) {
        Log.d("Kotlin", "Sum of $a and $b is ${a + b}");
    }

    fun maxOf(a: Int, b: Int): Int {
        if (a > b) {
            return a
        } else {
            return b
        }
    }

    private fun getStringLength(str: String?) = if (str != null) str.length else null

    //val l = b?.length ?: -1
    private fun getStringLengthx(str: String?) = (str?.length)

    private fun getResult(a: Int, b: Int) = if (a > b) a else b;


    fun parseInt(str: String): Int? {
        return 0
    }

    fun parseString(str: String): String? {
        return str.trim();
    }
}
