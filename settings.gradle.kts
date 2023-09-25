pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
    }
}


dependencyResolutionManagement {
    repositories {
        mavenLocal()
        google()
        mavenCentral()
    }
}

rootProject.name = "Kadoc"
include(":androidApp")
include(":shared")