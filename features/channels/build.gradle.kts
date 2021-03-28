
plugins {
    id(BuildPlugins.Ids.androidModule)
}

dependencies {
    implementation(project(Modules.PLATFORM_DOMAIN))
    implementation(project(Modules.PLATFORM_LOGGER))
    implementation(project(Modules.PLATFORM_NAVIGATOR))
    implementation(project(Modules.PLATFORM_SHARED_ASSETS))
    implementation(project(Modules.PLATFORM_SHARED_UTILITIES))

    implementation(Libraries.kotlinStdlib)
    implementation(Libraries.kodein)
    implementation(Libraries.coroutinesCore)
    implementation(Libraries.coroutinesAndroid)
    implementation(Libraries.lifecycleExtensions)
    implementation(Libraries.lifecycleRuntime)
    implementation(Libraries.lifecycleViewModel)
    implementation(Libraries.coreAndroidx)
    implementation(Libraries.appCompat)
    implementation(Libraries.materialDesign)
    implementation(Libraries.constraintLayout)

    testImplementation(project(Modules.PLATFORM_COROUTINES_TEST_UTILS))
    testImplementation(Libraries.jUnit)
    testImplementation(Libraries.assertj)
    testImplementation(Libraries.turbine)
}
