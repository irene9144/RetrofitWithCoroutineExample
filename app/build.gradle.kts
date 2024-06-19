plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")

    // serialization
    id("org.jetbrains.kotlin.plugin.serialization")

    // Room database
    id("kotlin-kapt")
    id("com.google.devtools.ksp")
}

android {
    namespace = "com.example.coroutineexample2"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.coroutineexample2"
        minSdk = 29
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        viewBinding = true
        buildConfig = true
    }
}

dependencies {

    // kotlin serialization
    // noinspection GradleDependency
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.5.0")
    implementation ("com.squareup.retrofit2:converter-gson:2.6.0")

    // android gps api library
    implementation("com.google.android.gms:play-services-location:21.2.0")

    // Room database
    implementation("androidx.room:room-runtime:2.6.1")
    annotationProcessor("androidx.room:room-compiler:2.6.1")
    ksp("androidx.room:room-compiler:2.6.1")
    kapt ("android.arch.persistence.room:compiler:1.1.1")

    // coroutine
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.4.2")

    // Retrofit
    implementation ("com.squareup.retrofit2:retrofit:2.6.2")
    implementation ("com.squareup.retrofit2:converter-gson:2.6.0")
    // Scalars 변환기 라이브러리
    implementation ("com.squareup.retrofit2:converter-scalars:2.6.4")

    implementation ("androidx.lifecycle:lifecycle-livedata-ktx:2.4.0")
    implementation ("androidx.activity:activity-ktx:1.1.0")
    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.appcompat:appcompat:1.7.0")
    implementation("com.google.android.material:material:1.12.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}