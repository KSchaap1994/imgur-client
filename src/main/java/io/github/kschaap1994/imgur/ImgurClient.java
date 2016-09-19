package io.github.kschaap1994.imgur;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.github.kschaap1994.imgur.model.*;
import io.github.kschaap1994.imgur.util.Requests;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.imaging.ImageFormats;
import org.apache.commons.imaging.ImageWriteException;
import org.apache.commons.imaging.Imaging;
import org.apache.http.HttpEntity;
import org.apache.http.client.entity.EntityBuilder;
import org.apache.http.message.BasicNameValuePair;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by IntelliJ IDEA
 * User: Kevin
 * Date: 17-9-2016
 * Time: 20:38
 * To change this template use File | Settings | File Templates.
 */
public final class ImgurClient {

    private final String BASE = "https://api.imgur.com/3/";
    private final String clientId;
    private final Requests requests;

    /**
     * Constructs a new ImgurClient
     *
     * @param clientId the API key
     */

    public ImgurClient(final String clientId) {
        this.clientId = clientId;
        requests = new Requests();
    }

    /**
     * Uploads an image to Imgur
     *
     * @param base64 the base64
     * @return an Image object
     */

    public ImgurImage uploadImage(final byte[] base64) {
        return postFile("/image", ImgurImage.class, base64);
    }

    /**
     * Uploads an image to Imgur
     *
     * @param image  the image to upload
     * @param format the format of the image
     * @return the result from Imgur
     */

    public ImgurImage uploadImage(final BufferedImage image, final ImageFormats format) {
        final Map<String, Object> params = new HashMap<>();
        try {
            return uploadImage(Base64.encodeBase64(Imaging.writeImageToBytes(image, format, params)));
        } catch (ImageWriteException | IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public ImgurImage getImage(final String id) {
        return get("/image/" + id, ImgurImage.class);
    }

    public ImgurAccount getAccount(final String username) {
        return get("/account/" + username, ImgurAccount.class);
    }

    public ImgurAlbum getAlbum(final String id) {
        return get("/album/" + id, ImgurAlbum.class);
    }

    public ImgurGalleryAlbum getGalleryAlbum(final String id) {
        return get("/gallery/album/" + id, ImgurGalleryAlbum.class);
    }

    public ImgurComment getComment(final int id) {
        return get("/comment/" + id, ImgurComment.class);
    }

    /**
     * Makes a POST request
     *
     * @param path   the path to make the request to
     * @param clazz  the model class
     * @param params if the request has any parameters to send
     * @param <T>    the model class
     * @return the response from Imgur
     */

    private <T> T post(final String path, final Class<T> clazz, final BasicNameValuePair... params) {
        final HttpEntity entity = EntityBuilder.create().setParameters(params).build();

        final String response = requests.POST.makeRequest(BASE + path, entity,
                new BasicNameValuePair("Authorization", "Client-ID " + clientId));

        final Gson gson = new GsonBuilder().create();

        return gson.fromJson(response, clazz);
    }

    /**
     * Uploads an image using a POST request
     *
     * @param path   the path to make the request to
     * @param clazz  the model class
     * @param base64 the base64 of the image
     * @param <T>    the model class
     * @return the response from Imgur
     */

    private <T> T postFile(final String path, final Class<T> clazz, final byte[] base64) {
        final HttpEntity entity = EntityBuilder.create().setBinary(base64).build();

        final String response = requests.POST.makeRequest(BASE + path, entity,
                new BasicNameValuePair("Authorization", "Client-ID " + clientId));

        final Gson gson = new GsonBuilder().create();

        return gson.fromJson(response, clazz);
    }

    /**
     * Makes a GET request
     *
     * @param path   the path to make the request to
     * @param clazz  the model class
     * @param params if the request has any parameters to send
     * @param <T>    the model class
     * @return the response from Imgur
     */

    private <T> T get(final String path, final Class<T> clazz, final BasicNameValuePair... params) {
        final String response = requests.GET.makeRequest(BASE + path,
                new BasicNameValuePair("Authorization", "Client-ID " + clientId));

        final Gson gson = new GsonBuilder().create();

        return gson.fromJson(response, clazz);
    }

    private <T> T get(final String path, final Class<T> clazz) {
        final String response = requests.GET.makeRequest(BASE + path,
                new BasicNameValuePair("Authorization", "Client-ID " + clientId));

        final Gson gson = new GsonBuilder().create();

        return gson.fromJson(response, clazz);
    }
}
