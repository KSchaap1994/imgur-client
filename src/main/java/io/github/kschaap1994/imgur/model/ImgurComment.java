package io.github.kschaap1994.imgur.model;

import java.util.Arrays;

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

    @Override
    public String toString() {
        return "ImgurComment{" +
                "id=" + id +
                ", image_id='" + image_id + '\'' +
                ", comment='" + comment + '\'' +
                ", author='" + author + '\'' +
                ", author_id=" + author_id +
                ", on_album=" + on_album +
                ", album_cover='" + album_cover + '\'' +
                ", ups=" + ups +
                ", downs=" + downs +
                ", points=" + points +
                ", datetime=" + datetime +
                ", parent_id=" + parent_id +
                ", deleted=" + deleted +
                ", vote='" + vote + '\'' +
                ", children=" + Arrays.toString(children) +
                '}';
    }
}
