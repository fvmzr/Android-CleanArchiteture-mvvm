package com.example.android_sample.features.view

import android.os.Bundle
import com.example.android_sample.AndroidApplication
import com.example.android_sample.core.di.ApplicationComponent
import com.example.android_sample.core.platform.BaseActivity
import com.example.android_sample.core.platform.BaseFragment

class MoviesActivity : BaseActivity() {
    override fun fragment(): BaseFragment {
       return MoviesFragment()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

}