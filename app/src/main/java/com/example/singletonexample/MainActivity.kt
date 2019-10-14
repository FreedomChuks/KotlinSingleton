package com.example.singletonexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.singletonexample.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
private lateinit var viewmodel:MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        Log.d("Debug:","${ExampleSingleton.singletonUser.hashCode()}")
        viewmodel=ViewModelProvider(this).get(MainViewModel::class.java)
        subscriberObserver()
        btn_connect.setOnClickListener {
            getUser()
        }
    }

    fun subscriberObserver(){
        viewmodel.user.observe(this, Observer {
            it?.let {
                Log.d("Debug","user is ${it.username}")
            }
        })
    }

    fun getUser(){
        viewmodel.setUserId("1")
    }


}
