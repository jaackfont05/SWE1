/**
 * Author: Jack Fontenot
 * Course: CSI 3471
 * Assignment: Lab 5
 * File: Album.java
 * Description: a ~collection of tracks
 */

package edu.baylor.cs.csi3471.midterm1;
import java.util.*;

public class Album implements Comparable<Album>{
    public enum AlbumType {
        ALBUM("Album"),
        SINGLE("Single"),
        COMPILATION("Compilation");

        private String description;
        AlbumType(String type) {
            description = type;
        }

        String getDescription() {
            return description;
        }

        static AlbumType getType(String description) {
            if(description.equals("Single")){
                return SINGLE;
            }else if(description.equals("Compilation")){
                return COMPILATION;
            }else if(description.equals("Album")){
                return ALBUM;
            }

            return null;
        }
    }

    private List<Track> trackList;
    private String name;
    private AlbumType type;

    // TODO Implement the constructor
    Album(String name, AlbumType type) {
        this.name = name;
        this.type = type;
        trackList = new ArrayList<>();
    }

    public List<Track> getTrackList() {
        return trackList;
    }

    public int getNumberOfTracks() {
        if(trackList == null){
            return 0;
        }
        return trackList.size();
    }

    public void sortTrackList(){
        Collections.sort(trackList);
    }

    public String getName() {
        return name;
    }

    public AlbumType getType() {
        return type;
    }

    public boolean addTrack(Track newTrack) {
        // TODO Implement add
        if(trackList == null){
            trackList = new ArrayList<>();
            trackList.add(newTrack);
        }else if(trackList.contains(newTrack)) {
            trackList.remove(newTrack);
            trackList.add(newTrack);
        }else{
            trackList.add(newTrack);
        }

        return true;
    }

    @Override
    public int compareTo(Album o){
        return name.toLowerCase().compareTo(o.name.toLowerCase());
    }

    @Override
    public int hashCode() {
        // TODO Implement the hashcode method
        return Objects.hash(name, type);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if(obj == null || getClass() != obj.getClass()) return false;

        Album t2 = (Album)obj;
        if(!t2.getName().equals(this.name) || !t2.getType().equals(this.type)) return false;

        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        String res;

        sb.append(name + " - "+ type + "\n");
        sb.append("Tracks:");

        Collections.sort(trackList);
        for(Track track : trackList){
            sb.append("\n");
            sb.append(track.toString());
        }

        res = sb.toString();

        return res;
    }
}