src - contains all the code
src/main - contains all the production code
src/test - contains all the test code
gradlew - Gradle wrapper - A shell script that launches gradle
```bash
gradle --version
zsh: command not found: gradle

    ./gradlew --version

------------------------------------------------------------
Gradle 8.8
------------------------------------------------------------
```
settings.gradle.kts - Project settings, includes the name of the project, submodules etc

To run the application
1. Right Click on BookmarksMizoMasaruApplication.kt and select `Run`
2. Open the file BookmarksMizoMasaruApplication.kt and click on the gutter icon
3. Use Intellij Run action menu
4. ./gradlew bootRun


To display web pages in the Spring Boot application please the HTML files in `src/main/resources/static`