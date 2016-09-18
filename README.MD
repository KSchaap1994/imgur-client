#imgur-client [![CircleCI](https://circleci.com/gh/KSchaap1994/imgur-client.svg?style=svg)](https://circleci.com/gh/KSchaap1994/imgur-client) [![Jitpack](https://jitpack.io/v/KSchaap1994/imgur-client.svg)](https://jitpack.io/#KSchaap1994/imgur-client) [![Dependency Status](https://www.versioneye.com/user/projects/57de6bccbf3e4c0034e229f4/badge.svg?style=flat-square)](https://www.versioneye.com/user/projects/57de6bccbf3e4c0034e229f4)

Java wrapper for the Imgur API, written in Java 8. 

#Adding imgur-client as dependency for your project

If you are using Maven, add the following in `pom.xml`:

```xml
...
<repositories>
    <repository>
        <id>jitpack.io</id>
        <url>https://jitpack.io</url>
    </repository>
</repositories>
...
<dependency>
    <groupId>com.github.KSchaap1994</groupId>
    <artifactId>imgur-client</artifactId>
    <version>0.05</version>
</dependency>
...
```
For Gradle, add in your root `build.gradle` at the end of repositories:

```xml
allprojects {
    repositories {
        ...
        maven { url "https://jitpack.io" }
	}
	...
	dependencies {
	    ...
	    compile 'com.github.KSchaap1994:imgur-client:0.05'
    }
}
```
#Usage

Example class:

```java
public class Example {

    private final String CLIENT_ID = "API_KEY_HERE";

    private void getImage() {
        final ImgurClient client = new ImgurClient(CLIENT_ID);
        BufferedImage bufferedImage = null;
        try {
            bufferedImage = ImageIO.read(new File("image.png"));
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        final Image image = client.uploadImage(bufferedImage, ImageFormats.PNG); //get any data from the image
    }
}
```

#Development

This Java wrapper is still in development. Any function can break at any time. If this happens please contact me or request a PR.
