
plugins {
    id(BuildPlugins.Ids.androidModule)
}

dependencies {
    implementation(project(Modules.PLATFORM_SHARED_ASSETS))

    implementation(Libraries.kotlinStdlib)
    implementation(Libraries.kodein)
    implementation(Libraries.appCompat)
    implementation(Libraries.lifecycleExtensions)
    implementation(Libraries.lifecycleViewModel)
    implementation(Libraries.coil)
}
