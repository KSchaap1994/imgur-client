package io.github.kschaap1994.imgur.model;

/**
 * Created by IntelliJ IDEA
 * User: Kevin
 * Date: 18-9-2016
 * Time: 20:02
 * To change this template use File | Settings | File Templates.
 */
public final class ImgurAccount {

    public int id;
    public String url;
    public String bio;
    public float reputation;
    public int created;
    public Object pro_expiration; //returns a boolean or int

    @Override
    public String toString() {
        return "ImgurAccount{" +
                "id=" + id +
                ", url='" + url + '\'' +
                ", bio='" + bio + '\'' +
                ", reputation=" + reputation +
                ", created=" + created +
                ", pro_expiration=" + pro_expiration +
                '}';
    }
}
