package io.github.kschaap1994.imgur;

import io.github.kschaap1994.imgur.model.*;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.imaging.ImageFormats;
import org.apache.commons.imaging.ImageWriteException;
import org.apache.commons.imaging.Imaging;
import org.junit.Assert;
import org.junit.Test;

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
public class ExampleTest {

    private static final String CLIENT_ID = "fdaa08c932d9a7e";
    private static final ImgurClient CLIENT;

    static {
        CLIENT = new ImgurClient(CLIENT_ID);
    }

    @Test
    public void uploadImage() {
        BufferedImage bufferedImage = null;
        try {
            bufferedImage = ImageIO.read(new File("image.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        final ImgurImage image = CLIENT.uploadImage(bufferedImage, ImageFormats.PNG); //get any data from the image
        Assert.assertNotNull(image);
        System.out.println(image);
    }

    @Test
    public void uploadImageAsByteArray() {
        BufferedImage bufferedImage;
        try {
            bufferedImage = ImageIO.read(new File("image.jpg"));
            final ImgurImage image = CLIENT.
                    uploadImage(Base64.encodeBase64(Imaging.writeImageToBytes(bufferedImage, ImageFormats.PNG, null)));
            Assert.assertNotNull(image);
        } catch (IOException | ImageWriteException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getImage() {
        final ImgurImage image = CLIENT.getImage("r9jTPAq");
        Assert.assertNotNull(image);
        System.out.println(image);
    }

    @Test
    public void getAccount() {
        final ImgurAccount account = CLIENT.getAccount("kschaap1994");
        Assert.assertNotNull(account);
        System.out.println(account);
    }

    @Test
    public void getAlbum() {
        final ImgurAlbum album = CLIENT.getAlbum("skffp");
        Assert.assertNotNull(album);
        System.out.println(album);
    }

    @Test
    public void getComment() {
        final ImgurComment comment = CLIENT.getComment(30337502);
        Assert.assertNotNull(comment);
        System.out.println(comment);
    }

    @Test
    public void getGalleryAlbum() {
        final ImgurGalleryAlbum galleryAlbum = CLIENT.getGalleryAlbum("KCJ4I");
        Assert.assertNotNull(galleryAlbum);
        System.out.println(galleryAlbum);
    }

}
