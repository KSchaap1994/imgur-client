package io.github.kschaap1994.imgur.model;

import java.util.Arrays;

/**
 * Created by IntelliJ IDEA
 * User: Kevin
 * Date: 18-9-2016
 * Time: 21:01
 * To change this template use File | Settings | File Templates.
 */
public final class ImgurGalleryAlbum {

    public String id;
    public String title;
    public String description;
    public int datetime;
    public String cover;
    public int cover_width;
    public int cover_height;
    public String account_url;
    public int account_id;
    public String privacy;
    public String layout;
    public int views;
    public String link;
    public int ups;
    public int downs;
    public int points;
    public int score;
    public boolean is_album;
    public String vote;
    public boolean favorite;
    public boolean nsfw;
    public int comment_count;
    public String topic;
    public int topic_id;
    public int images_count;
    public ImgurImage[] images;

    @Override
    public String toString() {
        return "ImgurGalleryAlbum{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", datetime=" + datetime +
                ", cover='" + cover + '\'' +
                ", cover_width=" + cover_width +
                ", cover_height=" + cover_height +
                ", account_url='" + account_url + '\'' +
                ", account_id=" + account_id +
                ", privacy='" + privacy + '\'' +
                ", layout='" + layout + '\'' +
                ", views=" + views +
                ", link='" + link + '\'' +
                ", ups=" + ups +
                ", downs=" + downs +
                ", points=" + points +
                ", score=" + score +
                ", is_album=" + is_album +
                ", vote='" + vote + '\'' +
                ", favorite=" + favorite +
                ", nsfw=" + nsfw +
                ", comment_count=" + comment_count +
                ", topic='" + topic + '\'' +
                ", topic_id=" + topic_id +
                ", images_count=" + images_count +
                ", images=" + Arrays.toString(images) +
                '}';
    }
}
