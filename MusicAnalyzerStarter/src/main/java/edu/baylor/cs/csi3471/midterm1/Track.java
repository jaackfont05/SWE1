/**
 * Author: Jack Fontenot
 * Course: CSI 3471
 * Assignment: Lab 5
 * File: Track.java
 * Description: song that has statistics
 */

package edu.baylor.cs.csi3471.midterm1;
import java.util.Objects;

public class Track implements Comparable<Track> {
    // Attributes
    private String name;
    private String artist;
    private TrackStatistics statistics;

    // TODO Implement the constructor
    Track(String name, String artist, TrackStatistics statistics) {
        this.name = name;
        this.artist = artist;
        this.statistics = statistics;
    }

    // Accessors
    public String getName() {
        return name;
    }

    public String getArtist() {
        return artist;
    }

    public TrackStatistics getStatistics() {
        return statistics;
    }

    @Override
    public int hashCode() {
        // TODO Implement the hashcode method/
        return Objects.hash(name, artist);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) return true;

        if(obj == null || getClass() != obj.getClass()) return false;

        Track other = (Track) obj;
        if(this.name.equals(other.name) && this.artist.equals(other.artist)){
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        // TODO Implement the toString method\
        return name + " by " + artist;
    }

    @Override
    public int compareTo(Track t) {
        // TODO Implement this to compare two Tracks\
        int num;
        if(this.name.equals(t.name)){
            num = artist.compareTo(t.artist);
        }else{
            num = name.compareTo(t.name);
        }
        return  num;
    }

    public static Track createTrack(String[] trackLine) {
        // TODO Implement this to construct a Track here instead of in MusicAnalyzer
        return null;
    }
}
