# Jetbrains Count DIVs task

Develop a CLI tool that counts the number of <div/> nodes at a given website.

Example:
  ```
   $ ./divcount “https://www.jetbrains.com”
   77
  ```
You can choose any “strongly typed” language and technology stack.
We’re expecting to receive the source code (a .zip file or a GitHub link) accompanied with all necessary instructions.

## Implementation

First of all I want to note, that it was quite an interesting experince, since it was my first time using _Kotlin_, _Selenium_ and _IntelliJ IDEA_, so I have learned a lot

Time spent ~ 5 hours

I have implemented the program in two versions.

First one is naive and only uses http GET query to get html and counts number of divs in it with REGEX
Unfortunately, this only works for static webpages, since we are not executing any JS code in this approach, so bye-bye REACT websites :)
To run it execute:
```shell
kotlinc pure/main-pure.kt -include-runtime -d pure/main-pure.jar && java -jar pure/main-pure.jar <your-url>
```

Second one is version is more safisticated and it uses Selenium to actually render the content of url, 
and only then counts the number of divs.
To run it execute:

```shell
mvn package
java -jar target/consoleApp-1.0-SNAPSHOT-jar-with-dependencies.jar <your-url>
```