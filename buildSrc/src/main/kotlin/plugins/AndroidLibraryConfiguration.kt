package plugins

import Versioning
import com.android.build.gradle.BaseExtension
import configs.AndroidConfig
import org.gradle.api.JavaVersion
import org.gradle.api.Project

fun Project.configureAsAndroidLibrary() {
    val android = extensions.findByName("android") as BaseExtension

    android.apply {
        compileSdkVersion(AndroidConfig.compileSdk)
        buildToolsVersion(AndroidConfig.buildToolsVersion)

        defaultConfig {

            minSdkVersion(AndroidConfig.minSdk)
            targetSdkVersion(AndroidConfig.targetSdk)
            versionCode = Versioning.version.code
            versionName = Versioning.version.name

            vectorDrawables.apply {
                useSupportLibrary = true
                generatedDensities(*(AndroidConfig.noGeneratedDensities))
            }

            resConfig("en")
        }

        buildTypes {
            getByName("debug") {
                isTestCoverageEnabled = true
            }

            getByName("release") {
                isMinifyEnabled = true
            }
        }

        compileOptions {
            sourceCompatibility = JavaVersion.VERSION_1_8
            targetCompatibility = JavaVersion.VERSION_1_8
        }

        testOptions {
            unitTests.isReturnDefaultValues = true
            unitTests.isIncludeAndroidResources = true
        }
    }
}
