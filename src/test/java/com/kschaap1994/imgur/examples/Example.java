package com.kschaap1994.imgur.examples;

import com.kschaap1994.imgur.ImgurClient;
import com.kschaap1994.imgur.model.Image;
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

    private final String CLIENT_ID = "API_KEY_HERE";

    private void getImage() {
        final ImgurClient client = new ImgurClient(CLIENT_ID);
        BufferedImage bufferedImage = null;
        try {
            bufferedImage = ImageIO.read(new File("image.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        final Image image = client.uploadImage(bufferedImage, ImageFormats.PNG); //get any data from the image
    }
}
