plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.jetbrainsKotlinAndroid)

    alias(libs.plugins.ksp)
    alias(libs.plugins.hiltAndroid)
}

android {
    namespace = "com.example.registeraddresstestapp"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.registeraddresstestapp"
        minSdk = 24
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)

    //    dagger-hilt
    implementation(libs.dagger)
    implementation(libs.androidx.navigation.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.hilt.navigation.compose)

    ksp(libs.dagger.compiler)
    implementation(libs.dagger.android)

    ksp(libs.dagger.android.processor)
    implementation(libs.dagger.hilt)
    ksp(libs.dagger.hilt.compiler)


    //    retrofit
    implementation(libs.retrofit)
    implementation(libs.retrofit.converter.gson)

//    okhttp3
    implementation(libs.okhttp3)
    implementation(libs.okhttp3.logging.interceptor)


    //Neshan sdk library
    implementation(libs.neshan.android.common.sdk)
    implementation(libs.neshan.android.mobile.sdk)
    implementation(libs.neshan.android.services.sdk)

    //Play Services
    implementation (libs.play.services.gcm)
    implementation (libs.play.services.location)
    implementation (libs.androidx.appcompat)
    implementation (libs.androidx.constraintlayout)

}