
plugins {
    id(BuildPlugins.Ids.kotlinModule)
    id(BuildPlugins.Ids.kotlinxSerialization)
}

dependencies {
    implementation(project(Modules.PLATFORM_DOMAIN))
    implementation(project(Modules.PLATFORM_LOGGER))
    implementation(project(Modules.PLATFORM_NETWORKING))

    implementation(Libraries.kotlinStdlib)
    implementation(Libraries.okhttp)
    implementation(Libraries.okhttpLogger)
    implementation(Libraries.retrofit)
    implementation(Libraries.kotlinSerializationCore)
    implementation(Libraries.kotlinSerializationJson)
    implementation(Libraries.coroutinesCore)
    implementation(Libraries.kodein)

    testImplementation(project(Modules.PLATFORM_COROUTINES_TEST_UTILS))
    testImplementation(Libraries.jUnit)
    testImplementation(Libraries.assertj)
    testImplementation(Libraries.burster)
    testImplementation(Libraries.mockWebServer)
}
