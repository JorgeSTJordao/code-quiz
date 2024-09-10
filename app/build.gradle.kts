plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    id("kotlin-kapt")
    id ("com.google.dagger.hilt.android")
}

android {
    namespace = "com.masterjorge.codequiz"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.masterjorge.codequiz"
        minSdk = 28
        targetSdk = 34
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

    //AVISO: siga essa ordem de dependências para não dar erro
    //WARNING: follow this order dependecy to avoid getting some error

    //Navigation
    //https://developer.android.com/develop/ui/compose/navigation?hl=pt-br

    //Permitir a navegação entre os composables
    implementation(libs.androidx.navigation.compose)

    //ViewModel
    //https://developer.android.com/jetpack/androidx/releases/lifecycle

    //Permitir que os composable interajam com o cilo de vida do Compose
    implementation(libs.androidx.lifecycle.runtime.compose)
    //Acessa a ViewModel no interior dos composables
    implementation(libs.androidx.lifecycle.viewmodel.compose)

    //Room
    //https://developer.android.com/training/data-storage/room

    //Permite acessar as classes principais do Room
    implementation(libs.androidx.room.runtime)
    //Gera o código a partir das anotações como @Database, @Dao, @Entity
    kapt(libs.androidx.room.compiler)
    //Extensões para utilizar corrotinas e realizar operações de forma assíncrona
    implementation(libs.androidx.room.ktx)

    //Hilt
    //https://developer.android.com/training/dependency-injection/hilt-android
    //https://developer.android.com/develop/ui/compose/libraries#hilt-navigation

    //Permite o uso da biblioteca, incluindo o uso das anotações
    implementation(libs.hilt.android)

    //Permite usar o hiltViewModel no contexto de composable
    implementation(libs.androidx.hilt.navigation.compose)

    //Permite processar as anotações, caso contrário não seria possível compilar
    kapt(libs.hilt.compiler)

}