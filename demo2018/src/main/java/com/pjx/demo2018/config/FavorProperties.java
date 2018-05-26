package com.pjx.demo2018.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 *
 * @author juqi
 * @date 18/5/24
 */
@Component
@ConfigurationProperties(prefix = "favor.song")
public class FavorProperties {
    private String name;
    private String singer;
    private int count;
    private String album;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    @Override
    public String toString() {
        return "FavorProperties{" +
                "name='" + name + '\'' +
                ", singer='" + singer + '\'' +
                ", count=" + count +
                ", album='" + album + '\'' +
                '}';
    }
}
