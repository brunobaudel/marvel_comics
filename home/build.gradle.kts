plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
}

android {
    namespace = "com.mobsky.home"
    compileSdk = 33

    defaultConfig {
        minSdk = 24
        targetSdk = 33

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
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
}

dependencies {

    implementation(project(mapOf("path" to ":navigation")))
    implementation(project(mapOf("path" to ":network")))

    implementation("androidx.core:core-ktx:1.8.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.9.0")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    implementation(Koin.koinAndroid)
    implementation(Koin.koinAndroidCompat)
    implementation(Koin.koinAndroidxWorkmanager)
    implementation(Koin.koinAndroidxCompose)

    implementation(Retrofit.retrofitCore)

    implementation(Gson.gsonCore)

    implementation(Room.roomRuntime)
    implementation(Room.roomKtx)
    annotationProcessor(Room.roomCompiler)
    kapt(Room.roomCompiler)

    //Compose
    val composeBom = platform(Compose.bom)
    implementation(composeBom)

    implementation(Compose.material3)
    implementation(Compose.material)
    implementation(Compose.foundation)
    implementation(Compose.ui)
    implementation(Compose.uiUtil)
    implementation(Compose.preview)
    debugImplementation(Compose.tooling)
    implementation(Compose.iconsCore)
    implementation(Compose.windowSizeClass)
    // Integration with activities
    implementation(Compose.activityCompose)
    // Integration with ViewModels
    implementation(Compose.viewModelCompose)
    // Integration with LiveData
    implementation(Compose.livedataCompose)
    // Navigation
    implementation(Compose.navigationCompose)

    implementation(Glide.glideCompose)
}