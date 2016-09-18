package io.github.kschaap1994.imgur.model;

/**
 * Created by IntelliJ IDEA
 * User: Kevin
 * Date: 18-9-2016
 * Time: 21:12
 * To change this template use File | Settings | File Templates.
 */
public final class ImgurComment {

    public int id;
    public String image_id;
    public String comment;
    public String author;
    public int author_id;
    public boolean on_album;
    public String album_cover;
    public int ups;
    public int downs;
    public float points;
    public int datetime;
    public int parent_id;
    public boolean deleted;
    public String vote;
    public ImgurComment[] children;

}
