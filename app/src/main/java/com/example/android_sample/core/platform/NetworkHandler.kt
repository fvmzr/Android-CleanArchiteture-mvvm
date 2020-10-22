package com.example.android_sample.core.platform

import android.content.Context
import com.example.android_sample.core.extension.networkInfo
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NetworkHandler
@Inject constructor(private val context: Context) {
    val isConnected get() = context.networkInfo?.isConnectedOrConnecting
}