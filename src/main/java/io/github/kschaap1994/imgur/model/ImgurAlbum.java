package io.github.kschaap1994.imgur.model;

/**
 * Created by IntelliJ IDEA
 * User: Kevin
 * Date: 18-9-2016
 * Time: 21:07
 * To change this template use File | Settings | File Templates.
 */
public final class ImgurAlbum {

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
    public boolean favorite;
    public boolean nsfw;
    public String section;
    public int order;
    public String deletehash; //OPTIONAL, the deletehash, if you're logged in as the album owner
    public int images_count;
    public ImgurImage[] images;
    public boolean in_gallery;

}
