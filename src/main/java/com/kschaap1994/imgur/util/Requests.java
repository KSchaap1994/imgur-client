package com.kschaap1994.imgur.util;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.methods.*;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by IntelliJ IDEA
 * User: Kevin
 * Date: 17-9-2016
 * Time: 20:51
 * To change this template use File | Settings | File Templates.
 */
public final class Requests {

    public final Request POST;
    public final Request GET;
    public final Request PUT;
    public final Request DELETE;
    public final Request PATCH;

    public Requests() {
        POST = new Request(HttpPost.class);
        GET = new Request(HttpGet.class);
        PUT = new Request(HttpPut.class);
        DELETE = new Request(HttpDelete.class);
        PATCH = new Request(HttpPatch.class);
    }

    public final class Request {

        private final CloseableHttpClient CLIENT = HttpClients.createDefault();
        private final Class<? extends HttpUriRequest> method; //request class

        /**
         * Constructs a Request
         *
         * @param method the method class
         */

        private Request(Class<? extends HttpUriRequest> method) {
            this.method = method;
        }

        /**
         * Makes a request to the URL with the specified headers
         *
         * @param url the url to make the request to
         * @param headers the headers, if any
         * @return Request#request
         */

        public String makeRequest(final String url, final BasicNameValuePair... headers) {
            try {
                final HttpUriRequest request = method.getConstructor(String.class).newInstance(url);

                for (BasicNameValuePair header : headers) {
                    request.addHeader(header.getName(), header.getValue());
                }

                return request(request);
            } catch (NoSuchMethodException | InvocationTargetException | InstantiationException |
                    IllegalAccessException e) {
                e.printStackTrace();
                return null;
            }
        }

        /**
         * Makes a request to the URL with parameters and the specified headers
         *
         * @param url the url to make the request to
         * @param entity the parameters, if any
         * @param headers the headers, if any
         * @return Request#request
         */

        public String makeRequest(final String url, final HttpEntity entity, final NameValuePair... headers) {
            try {
                final HttpEntityEnclosingRequestBase request = (HttpEntityEnclosingRequestBase)
                        method.getConstructor(String.class).newInstance(url);

                for (NameValuePair header : headers) {
                    request.addHeader(header.getName(), header.getValue());
                }

                request.setEntity(entity);

                return request(request);
            } catch (NoSuchMethodException | InvocationTargetException | InstantiationException |
                    IllegalAccessException e) {
                e.printStackTrace();
                return null;
            }
        }

        /**
         * Makes the actual request
         *
         * @param request the request to do
         * @return the response
         */

        private String request(final HttpUriRequest request) {
            try {
                final CloseableHttpResponse response = CLIENT.execute(request);
                final HttpEntity entity = response.getEntity();

                return EntityUtils.toString(entity);
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        }
    }
}