package io.github.kschaap1994.imgur.model;

/**
 * Created by IntelliJ IDEA
 * User: Kevin
 * Date: 17-9-2016
 * Time: 22:15
 * To change this template use File | Settings | File Templates.
 */
public final class ImgurImage {

    public String id;
    public String title;
    public String description;
    public long datetime;
    public String type;
    public boolean animated; //gif
    public int width;
    public int height;
    public int size;
    public int views;
    public int bandwith;
    public String vote;
    public boolean favorite;
    public boolean nsfw;
    public String section;
    public String account_url;
    public int account_id;
    public String comment_preview;
    public String deletehash;
    public String name;
    public String link;
    public boolean success;
    public int status;

    @Override
    public String toString() {
        return "ImgurImage{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", datetime=" + datetime +
                ", type='" + type + '\'' +
                ", animated=" + animated +
                ", width=" + width +
                ", height=" + height +
                ", size=" + size +
                ", views=" + views +
                ", bandwith=" + bandwith +
                ", vote='" + vote + '\'' +
                ", favorite=" + favorite +
                ", nsfw=" + nsfw +
                ", section='" + section + '\'' +
                ", account_url='" + account_url + '\'' +
                ", account_id=" + account_id +
                ", comment_preview='" + comment_preview + '\'' +
                ", deletehash='" + deletehash + '\'' +
                ", name='" + name + '\'' +
                ", link='" + link + '\'' +
                ", success=" + success +
                ", status=" + status +
                '}';
    }
}
