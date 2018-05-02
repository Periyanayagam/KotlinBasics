package com.perusudroid.kotlinbasics.binding.fragment

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.perusudroid.kotlinbasics.R
import com.perusudroid.kotlinbasics.databinding.FragmentTwoBinding


/**
 * Created by Intel on 02-05-2018.
 */
class TwoFrag : Fragment() {

    private var binding: FragmentTwoBinding? = null

    private val receiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent?) {
            when (intent?.action) {
                "TXT_ACTION" -> {

                    // print bundle intent values
                    val bundle = intent.extras
                    if (bundle != null) {
                        for (key in bundle.keySet()) {
                            val value = bundle.get(key)
                            Log.d("TwoFrag", String.format("%s %s (%s)", key,
                                    value!!.toString(), value.javaClass.name))
                        }
                    }

                    val extra: Bundle? = intent.extras
                    val data: String = extra?.get("data").toString()
                    Log.d("TwoFrag", "in bbcast${data}")
                    binding?.tvTxt?.text = data
                }
            }
        }

    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_two, container, false)
        activity.registerReceiver(receiver, IntentFilter("TXT_ACTION"))
        return binding?.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
    }

}