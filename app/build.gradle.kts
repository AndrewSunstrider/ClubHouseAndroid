import configs.AndroidConfig
import configs.KotlinConfig
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
    implementation(project(Modules.FEATURE_AUTH))
    implementation(project(Modules.FEATURE_CHANNELS))

    implementation(project(Modules.PLATFORM_DOMAIN))
    implementation(project(Modules.PLATFORM_LOGGER))
    implementation(project(Modules.PLATFORM_NAVIGATOR))
    implementation(project(Modules.PLATFORM_NETWORKING))
    implementation(project(Modules.PLATFORM_PERSISTENCE))
    implementation(project(Modules.PLATFORM_REST_CLUBHOUSE))
    implementation(project(Modules.PLATFORM_SHARED_ASSETS))
    implementation(project(Modules.PLATFORM_SHARED_UTILITIES))

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
    androidTestImplementation(Libraries.assertjJava7)
    androidTestImplementation(Libraries.mockWebServer)
}

fun Project.evaluateTestMode(): Boolean =
    properties["testMode"]?.let { true } ?: false

fun Project.evaluateAPIUrl(): String =
    properties["testMode"]?.let { "http://localhost:4242" } ?: "https://www.clubhouseapi.com/api/"