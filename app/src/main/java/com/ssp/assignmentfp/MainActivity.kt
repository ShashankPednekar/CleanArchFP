package com.ssp.assignmentfp

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.ssp.assignmentfp.di.DaggerAppComponentProvider
import com.ssp.core.ImageLoader
import com.ssp.feature_one.FeatureOneActivity
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        DaggerAppComponentProvider.getAppComponent().inject(mainActivity = this)

        //Decide Activity based on authentication if any
        startActivity(Intent(this, FeatureOneActivity::class.java))
    }
}