package com.perusudroid.kotlinbasics.binding.fragment

import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.perusudroid.kotlinbasics.R
import com.perusudroid.kotlinbasics.databinding.FragmentOneBinding

/**
 * Created by Intel on 02-05-2018.
 */
class OneFrag : Fragment(), View.OnClickListener {

    var binding: FragmentOneBinding? = null

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_one, container, false)
        setAssets()
        return binding?.root
    }

    private fun setAssets() {
        binding?.btnSend?.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.btnSend -> {
                if (!binding?.etTxt?.text?.trim().isNullOrEmpty()) {
                    val i = Intent()
                    i.action = "TXT_ACTION"
                    i.putExtra("data", binding?.etTxt?.text)
                    activity.sendBroadcast(i)
                } else {
                    Toast.makeText(activity, "Enter something!", Toast.LENGTH_LONG).show()
                }
            }
        }
    }

}