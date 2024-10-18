plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.navigation.safeargs.kotlin)
}

android {
    namespace = "com.ruben.dam2024"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.ruben.dam2024"
        minSdk = 26
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    //Se crean las librerias en libs.versions.toml

    //Librerias para la app
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.gson.serializer) //Libreria para serializar objetos
    implementation(libs.glide)
    implementation(libs.viewmodel.scope)
    implementation(libs.nav.ui)
    implementation(libs.nav.fragment)
    implementation(libs.nav.fragment.ktx)
    implementation(libs.retrofit)
    implementation(libs.retrofit.converter.gson)

    //Librerias para testing
    testImplementation(libs.junit)
    //Librerias para Android-Testing
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}