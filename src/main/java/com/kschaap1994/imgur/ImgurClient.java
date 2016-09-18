package com.kschaap1994.imgur;

import com.google.gson.Gson;
import com.kschaap1994.imgur.model.Image;
import com.kschaap1994.imgur.util.Requests;
import org.apache.http.HttpEntity;
import org.apache.http.client.entity.EntityBuilder;
import org.apache.http.message.BasicNameValuePair;

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
    private final Requests requests = new Requests();

    public ImgurClient(final String clientId) {
        this.clientId = clientId;
    }

    public Image uploadImage(final byte[] base64) {
        return postFile("/image", Image.class, base64);
    }

    private <T> T post(final String path, final Class<T> clazz, final BasicNameValuePair... params) {
        final HttpEntity entity = EntityBuilder.create().setParameters(params).build();

        final String response = requests.POST.makeRequest(BASE + path, entity,
                new BasicNameValuePair("Authorization", "Client-ID " + clientId));

        final Gson gson = new Gson();
        return gson.fromJson(response, clazz);
    }

    private <T> T postFile(final String path, final Class<T> clazz, final byte[] base64) {
        final HttpEntity entity = EntityBuilder.create().setBinary(base64).build();

        final String response = requests.POST.makeRequest(BASE + path, entity,
                new BasicNameValuePair("Authorization", "Client-ID " + clientId));

        final Gson gson = new Gson();
        return gson.fromJson(response, clazz);
    }
}
