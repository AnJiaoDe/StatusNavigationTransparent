pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()

        google()
        maven {
            url = uri("https://repo1.maven.org/maven2/")
        }
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()

        google()
        maven {
            url = uri("https://www.jitpack.io")
        }
    }
}
rootProject.name = "StatusNavigationTransparent"
include(":app")
include ("translucentparent")
