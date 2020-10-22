plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("android.extensions")
    kotlin("kapt")
    apply { "kotlin" }

}
android {
    compileSdkVersion(29)
    buildToolsVersion("29.0.2")

    defaultConfig {
        applicationId = "com.example.gradelkts"
        minSdkVersion(23)
        targetSdkVersion(29)
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = true
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
        }
    }

    kapt {
        generateStubs = true
    }
    androidExtensions {
        isExperimental = true
    }
    sourceSets["main"].java.srcDir("src/main/kotlin")
}




dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk7:1.3.72")
    implementation("androidx.appcompat:appcompat:1.1.0")
    implementation("androidx.core:core-ktx:1.3.0")
    implementation("androidx.constraintlayout:constraintlayout:1.1.3")
    implementation("com.google.android.material:material:1.1.0")
    testImplementation("junit:junit:4.12")
    androidTestImplementation("androidx.test.ext:junit:1.1.1")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.2.0")

    //dagger
    implementation("com.google.dagger:dagger:2.24")
    implementation("com.google.dagger:dagger-android:2.24")
    implementation("com.google.dagger:dagger-android-support:2.24")

    kapt("com.google.dagger:dagger-compiler:2.24")

    kapt("com.google.dagger:dagger-android-processor:2.24")

    compileOnly("javax.annotation:jsr250-api:1.0")
    implementation("javax.inject:javax.inject:1")

    //retrofit
    implementation("com.squareup.retrofit2:retrofit:2.3.0")
    implementation("com.squareup.retrofit2:converter-gson:2.3.0")
    
    implementation ("com.squareup.retrofit2:adapter-rxjava2:2.3.0")
    implementation ("io.reactivex.rxjava2:rxjava:2.2.6")
    implementation ("io.reactivex.rxjava2:rxandroid:2.1.1")

    implementation ("com.squareup.okhttp3:okhttp:3.10.0")
    implementation ("com.squareup.okhttp3:logging-interceptor:3.10.0")

    //OkHttpp


    // coroutine
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.3.7")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.3.7")

    //viewModelProvieder
    implementation("androidx.lifecycle:lifecycle-extensions:2.2.0")
    // glide
    implementation("com.github.bumptech.glide:glide:4.9.0")


    //appbar
    implementation("com.google.android.material:material:1.1.0")
    implementation("androidx.appcompat:appcompat:1.1.0")

//    implementation ("org.conscrypt:conscrypt-android:2.2.1")

    //add ssp and sdp
    implementation("com.intuit.ssp:ssp-android:1.0.6")
    implementation("com.intuit.sdp:sdp-android:1.0.6")
}
