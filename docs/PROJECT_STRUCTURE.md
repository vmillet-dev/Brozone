# Project layout

The game project is divided on different modules for each target OS, with a main module
called `core` that contain the game logic.

```
settings.gradle            <- definition of sub-modules. By default core, desktop, android, html, ios
build.gradle               <- main Gradle build file, defines dependencies and plugins
gradlew                    <- local Gradle wrapper
gradlew.bat                <- script that will run Gradle on Windows
gradle                     <- script that will run Gradle on Unix systems
local.properties           <- IntelliJ only file, defines Android SDK location

assets/                    <- contains your graphics, audio, etc.

core/
build.gradle           <- Gradle build file for core project
src/                   <- Source folder for all your game's code

desktop/
build.gradle           <- Gradle build file for desktop project
src/                   <- Source folder for your desktop project, contains LWJGL launcher class

android/
build.gradle           <- Gradle build file for android project
AndroidManifest.xml    <- Android specific config
res/                   <- contains icons for your app and other resources
src/                   <- Source folder for your Android project, contains android launcher class

html/
build.gradle           <- Gradle build file for the html project
src/                   <- Source folder for your html project, contains launcher and html definition
webapp/                <- War template, on generation the contents are copied to war. Contains startup url index page and web
```