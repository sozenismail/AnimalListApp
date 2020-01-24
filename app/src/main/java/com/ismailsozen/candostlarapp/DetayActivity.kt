package com.ismailsozen.candostlarapp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_detay.*

class DetayActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detay)

        var gelenIntent= intent

        if (gelenIntent != null)
        {
            textViewDetay.text=gelenIntent.getStringExtra("ad")
            imageViewDetay.setImageResource(gelenIntent.getIntExtra("resim",0))
        }


    }
}
