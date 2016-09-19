package io.github.kschaap1994.imgur.examples;

import io.github.kschaap1994.imgur.ImgurClient;
import io.github.kschaap1994.imgur.model.ImgurImage;
import org.apache.commons.imaging.ImageFormats;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by IntelliJ IDEA
 * User: Kevin
 * Date: 18-9-2016
 * Time: 13:37
 * To change this template use File | Settings | File Templates.
 */
public class Example {

    private static final String CLIENT_ID = "YOUR_API_KEY";

    public static void main(final String... args) {
        final ImgurClient client = new ImgurClient(CLIENT_ID);
        BufferedImage bufferedImage = null;
        try {
            bufferedImage = ImageIO.read(new File("image.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        final ImgurImage image = client.uploadImage(bufferedImage, ImageFormats.PNG); //get any data from the image
        assert image != null;
        System.out.println(image.link);
    }
}