import configs.AndroidConfig
import configs.KotlinConfig
import configs.ProguardConfig
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id(BuildPlugins.Ids.androidApplication)
    id(BuildPlugins.Ids.kotlinAndroid)
    id(BuildPlugins.Ids.keeper) version BuildPlugins.Versions.keeper
}
repositories {
    google()
    maven(url = "https://jitpack.io")
}

base.archivesBaseName = "clubhouseandroid-${Versioning.version.name}"

android {
    compileSdkVersion(AndroidConfig.compileSdk)
    buildToolsVersion(AndroidConfig.buildToolsVersion)

    defaultConfig {

        minSdkVersion(AndroidConfig.minSdk)
        targetSdkVersion(AndroidConfig.targetSdk)

        applicationId = AndroidConfig.applicationId
        testInstrumentationRunner = AndroidConfig.instrumentationTestRunner
        versionCode = Versioning.version.code
        versionName = Versioning.version.name

        vectorDrawables.apply {
            useSupportLibrary = true
            generatedDensities(*(AndroidConfig.noGeneratedDensities))
        }

        resConfig("en")

        testBuildType = "release"
    }

    signingConfigs {
        create("release") {
            storeFile = rootProject.file("signing/dotanuki-demos.jks")
            storePassword = "dotanuki"
            keyAlias = "dotanuki-alias"
            keyPassword = "dotanuki"
        }
    }

    buildTypes {

        getByName("debug") {
            applicationIdSuffix = ".debug"
            versionNameSuffix = "-DEBUG"
            isTestCoverageEnabled = true
            buildConfigField("String", "CLUBHOUSE_API_URL", "\"${project.evaluateAPIUrl()}\"")
            resValue("bool", "clear_networking_traffic_enabled", "${project.evaluateTestMode()}")
        }

        getByName("release") {
            isMinifyEnabled = true
            isShrinkResources = true

            val proguardConfig = ProguardConfig("$rootDir/proguard")
            proguardFiles(*(proguardConfig.customRules))
            proguardFiles(getDefaultProguardFile(proguardConfig.androidRules))

            buildConfigField("String", "CLUBHOUSE_API_URL", "\"${project.evaluateAPIUrl()}\"")
            resValue("bool", "clear_networking_traffic_enabled", "${project.evaluateTestMode()}")
            signingConfig = signingConfigs.findByName("release")
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    tasks.withType<KotlinCompile> {
        kotlinOptions.jvmTarget = KotlinConfig.targetJVM
    }

    testOptions {
        unitTests.isReturnDefaultValues = true
        unitTests.isIncludeAndroidResources = true
    }
}

dependencies {
    implementation(project(":features:auth"))

    implementation(project(":platform:domain"))
    implementation(project(":platform:logger"))
    implementation(project(":platform:navigator"))
    implementation(project(":platform:networking"))
    implementation(project(":platform:persistence"))
    implementation(project(":platform:rest-clubhouse"))
    implementation(project(":platform:shared-assets"))
    implementation(project(":platform:shared-utilities"))

    implementation(Libraries.kotlinStdlib)
    implementation(Libraries.appCompat)
    implementation(Libraries.swipeToRefresh)
    implementation(Libraries.coreAndroidx)
    implementation(Libraries.lifecycleViewModel)
    implementation(Libraries.lifecycleExtensions)
    implementation(Libraries.kodein)
    implementation(Libraries.okhttp)

    androidTestImplementation(Libraries.jUnit)
    androidTestImplementation(Libraries.androidTestCoreKtx)
    androidTestImplementation(Libraries.androidTestExtJunit)
    androidTestImplementation(Libraries.androidTestExtJunitKtx)
    androidTestImplementation(Libraries.androidTestRunner)
    androidTestImplementation(Libraries.androidTestRules)
    androidTestImplementation(Libraries.androidTestCore)
    androidTestImplementation(Libraries.espressoCore)
    androidTestImplementation(Libraries.barista)
//    androidTestImplementation(Libraries.assertjJava7)
    androidTestImplementation(Libraries.mockWebServer)
}

fun Project.evaluateTestMode(): Boolean =
    properties["testMode"]?.let { true } ?: false

fun Project.evaluateAPIUrl(): String =
    properties["testMode"]?.let { "http://localhost:4242" } ?: "https://www.clubhouseapi.com/api/"