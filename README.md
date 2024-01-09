# Brozone

![build status](https://img.shields.io/github/actions/workflow/status/vmillet-dev/Brozone/gradle.yml?label=build
)
[![Quality gate](https://sonarcloud.io/api/project_badges/quality_gate?project=vmillet-dev_Brozone)](https://sonarcloud.io/summary/new_code?id=vmillet-dev_Brozone)
[![Maintainability Rating](https://sonarcloud.io/api/project_badges/measure?project=vmillet-dev_Brozone&metric=sqale_rating)](https://sonarcloud.io/summary/new_code?id=vmillet-dev_Brozone)
[![Coverage](https://sonarcloud.io/api/project_badges/measure?project=vmillet-dev_Brozone&metric=coverage)](https://sonarcloud.io/summary/new_code?id=vmillet-dev_Brozone)
[![Lines of Code](https://sonarcloud.io/api/project_badges/measure?project=vmillet-dev_Brozone&metric=ncloc)](https://sonarcloud.io/summary/new_code?id=vmillet-dev_Brozone)

## Table of contents

- [Feature](#Features)
- [Project layout](#Project-layout)
- [Development](#Development)
- [Tests](#Tests)
- [Deploying](#Deploying)

## Features

### Gameplay

- Not implemented

### Environment

- [x] Windows / MacOS / Android / web server support (not Linux yet)
- [x] Support Java 17
- [x] Auto-upload release on merge in main branch

## Project layout

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

## Development

### Requirements

- Download and install OpenJDK 17 [[ here ]](https://jdk.java.net/archive/)
- Download Android SDK and unpack somewhere on your device
- Set up the path of this SDK in the local.properties file

### Importing the Project
1. In **IntelliJ IDEA**, you can choose to open the `build.gradle` file and select "Open as Project" to get started.

2. You may need to refresh the Gradle project after the initial import if some dependencies weren't downloaded yet.

   In **IntelliJ IDEA**, the `Reimport all Gradle projects` button is a pair of circling arrows at the top left in the Gradle tool window, which can be opened with `View -> Tool Windows -> Gradle`.

### Getting it Running on IntelliJ

If you want to execute your freshly imported project, you have to follow different steps, depending on the platform you are targeting.

#### Desktop
1. Extend the Gradle tab on the right sight of your window: <br/>
   ![](/docs/img/intellij-config-plugin-gradle.png)
2. Expand the tasks of your project and then select: desktop -> other -> run.

#### Android
- Right click AndroidLauncher -> Run AndroidLauncher


#### HTML
HTML is best suited to be run on command line. You are welcome to manually setup GWT in the IDE of your choice if you are familiar with it, but the recommended way is to drop down to terminal or command prompt.

The HTML target can be run in **Super Dev** mode, which allows you to recompile on the fly, and debug your application in browser.

To do so, open up your favourite shell or terminal, change directory to the project directory and invoke the respective gradle task:

```
./gradlew html:superDev
```

**On Unix:** If you get a permission denied error, set the execution flag on the gradlew file: `chmod +x gradlew`
{: .notice--primary}

You should see lots of text wizzing by, and if all goes well you should see the following line at the end:

![](/docs/img/html-superdev.png)

You can then go to [`http://localhost:8080/index.html`](http://localhost:8080/index.html), to see your application running, with a recompile button.

For further info on configuring and debugging with SuperDev check the [GWT documentation](http://www.gwtproject.org/articles/superdevmode.html).

### Command Line
All the targets can be run and deployed to via the command line interface.

**Desktop:**
```
./gradlew desktop:run
```

**Android:**
```
./gradlew android:installDebug android:run
```

The `ANDROID_HOME` environment variable needs to be pointing to a valid android SDK before you can do any command line wizardry for Android. On Windows, use: `set ANDROID_HOME=​C:/Path/To/Your/Android/Sdk`; on Linux and macOS: `export ANDROID_HOME=​/Path/To/Your/Android/Sdk`. Alternatively you can create a file called "local.properties" with the following content: `sdk.dir /Path/To/Your/Android/Sdk`.

**HTML:**
```
./gradlew html:superDev
```

Then go to [`http://localhost:8080/index.html`](http://localhost:8080/index.html).

### Gradle tasks are failing?
If whenever you invoke Gradle, the build or refresh fails to get more information, run the same command again and add the `--debug` parameter to the command, e.g.:

```
./gradlew desktop:run --debug
```

## Tests

You can run the test(s) on command line in the project folder:

`./gradlew test`

## Deploying

### Build release

### Packaging

