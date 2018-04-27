package com.perusudroid.kotlinbasics.binding.login

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.widget.Toast
import com.perusudroid.kotlinbasics.R
import com.perusudroid.kotlinbasics.databinding.ActivityLoginBinding
import com.perusudroid.kotlinbasics.model.SampleResponse
import com.perusudroid.kotlinbasics.retro.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginBindActivity : AppCompatActivity(), View.OnClickListener, Callback<SampleResponse> {


    var binding: ActivityLoginBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        setAssets();
    }

    private fun setAssets() {
        binding?.btnLogin?.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btnLogin -> if (isValidated()) {
                ApiClient.apiInterface.getSample().enqueue(this)
            }
        }
    }

    private fun isValidated(): Boolean {

        if (binding?.etEmail?.text?.toString().isNullOrEmpty()) {
            Toast.makeText(this, "Email Required", Toast.LENGTH_SHORT).show()
            return false
        }

        if (binding?.etPass?.text?.toString().isNullOrEmpty()) {
            Toast.makeText(this, "Password Required", Toast.LENGTH_SHORT).show()
            return false
        }

        if (!(Integer.parseInt(binding?.etPass?.text.toString()) > 4)) {
            Toast.makeText(this, "Minimum four chars", Toast.LENGTH_SHORT).show()
            return false
        }

        return true

    }

    override fun onFailure(call: Call<SampleResponse>?, t: Throwable?) {
        Log.e("LOG", t?.localizedMessage)
    }

    override fun onResponse(call: Call<SampleResponse>?, sampleResponse: Response<SampleResponse>?) {

        if (sampleResponse!!.isSuccessful) {
            if (sampleResponse.body() != null) {
                if (sampleResponse.code() == 200) {
                    Toast.makeText(this, sampleResponse.message(), Toast.LENGTH_LONG).show()
                }
            }
        }

    }

}
