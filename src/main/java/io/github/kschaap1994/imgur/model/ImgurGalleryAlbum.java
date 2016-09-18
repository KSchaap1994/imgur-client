package io.github.kschaap1994.imgur.model;

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
}
