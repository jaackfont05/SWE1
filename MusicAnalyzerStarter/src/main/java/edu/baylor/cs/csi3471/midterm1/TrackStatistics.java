/**
 * Author: Jack Fontenot
 * Course: CSI 3471
 * Assignment: Lab 5
 * File: TrackStatistics.java
 * Description: statistics for a single track
 */

package edu.baylor.cs.csi3471.midterm1;

import java.util.Objects;

public class TrackStatistics {
    // Attributes
    private double duration;
    private long views;
    private long likes;
    private long comments;
    private boolean licensed;
    private boolean official;

    // TODO Implement the constructor
    TrackStatistics(double d, long v, long l, long c, boolean li, boolean o) {
        duration = d;
        views = v;
        likes = l;
        comments = c;
        licensed = li;
        official = o;
    }

    // Accessors
    public double getDuration() {
        return duration;
    }

    public long getViews() {
        return views;
    }

    public long getLikes() {
        return likes;
    }

    public long getComments() {
        return comments;
    }

    public boolean isLicensed() {
        return licensed;
    }

    public boolean isOfficial() {
        return official;
    }

    @Override
    public int hashCode() {
        // TODO Implement the hashcode method
        return Objects.hash(duration, views, likes, comments, licensed, official);
    }

    @Override
    public boolean equals(Object obj) {
        // TODO Implement the equals method
        if(obj == this) return true;

        if(obj == null || getClass() != obj.getClass()) return false;

        TrackStatistics other = (TrackStatistics) obj;
        if(this.duration != other.duration) return false;
        if(this.views != other.views) return false;
        if(this.likes != other.likes) return false;
        if(this.comments != other.comments) return false;
        if(this.licensed != other.licensed) return false;
        if(this.official != other.official) return false;


        return true;
    }

    @Override
    public String toString() {
        String res;
        StringBuilder sb = new StringBuilder();

        sb.append("TrackStatistics{\n");
        sb.append("duration:").append(duration).append("\n");
        sb.append("views:").append(views).append("\n");
        sb.append("likes:").append(likes).append("\n");
        sb.append("comments:").append(comments).append("\n");

        if(licensed){
            sb.append("licensed: yes\n");
        }else{
            sb.append("licensed: no\n");
        }

        if(official){
            sb.append("official: yes\n");
        }else{
            sb.append("official: no\n");
        }

        sb.append("}");
        res = sb.toString();

        return res;
    }

}
