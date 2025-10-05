/**
 * Author: Jack Fontenot
 * Course: CSI 3471
 * Assignment: Lab 5
 * File: MusicAnalyzer.java
 * Description: reads in a string and file and outputs
 * according to the selected option
 */

package edu.baylor.cs.csi3471.midterm1;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class MusicAnalyzer {

    private static final int OPTION = 0;
    private static final int FILE_NAME = 1;

    private static int readOption(String[] args) {
        Integer option = null;
        if (args.length != 2) {
            System.err.println("USAGE: java MusicAnalyzer <option> <filename>");
            System.exit(1);
        } else {
            try {
                option = Integer.parseInt(args[OPTION]);
            } catch (NumberFormatException e) {
                System.err.println("call as java MusicAnalyzer <option> <filename>");
                System.exit(1);
            }
        }
        return option;
    }

    private static List<Album> loadCSV(String file) throws FileNotFoundException {
        BufferedReader reader = null;
        try {
            // This is much faster than scanner
            reader = new BufferedReader(new FileReader(new File(file)));
            String line = null;
            List<Album> albums = new ArrayList<>();
            reader.readLine();
            while ((line = reader.readLine()) != null) {
                // Look up the regex if you are interested, but this will allow column values to contain quotes
                String[] split = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");


                // TODO Do the work here to read in all the data and create the Albums and Tracks
                // Look in Track for a hint
                String artist  = split[0];
                String spotifyURL = split[1];
                String track = split[2];
                String album = split[3];
                String albumT = split[4];
                String uri =  split[5];
                String dance  = split[6];
                String energy =  split[7];
                String key = split[8];
                String Loudness = split[9];
                String speech = split[10];
                String acoust =  split[11];
                String instr =  split[12];
                String live =  split[13];
                String val = split[14];
                String temp = split[15];
                String duration = split[16];
                String youURL = split[17];
                String title = split[18];
                String chan =  split[19];
                String sViews = split[20];
                String sLikes = split[21];
                String sComm =  split[22];
                String sLic =  split[23];
                String sOff =   split[24];

                if(split.length > 25){
                    String sStream =  split[25];
                }

                double dur = Double.parseDouble(duration);
                long views = Long.parseLong(sViews);
                long likes = Long.parseLong(sLikes);
                long comments = Long.parseLong(sComm);
                boolean lic = false;
                if (sLic.equals("true")) {
                    lic = true;
                }
                boolean off = false;
                if (sOff.equals("true")) {
                    off = true;
                }

                TrackStatistics ts = new TrackStatistics(dur, views, likes, comments, lic, off);
                Track t = new Track(track, artist, ts);

                Album.AlbumType at;
                if(albumT.equals("album")){
                    at = Album.AlbumType.ALBUM;
                }else if(albumT.equals("single")){
                    at = Album.AlbumType.SINGLE;
                }else{
                    at = Album.AlbumType.COMPILATION;
                }

                Album a = new Album(album, at);

                if(albums.contains(a)){
                    for(int n = 0; n < albums.size(); ++n){
                        if(albums.get(n).equals(a)){
                            albums.get(n).addTrack(t);
                        }
                    }
                }else{
                    albums.add(a);
                    a.addTrack(t);
                }

            }

            // TODO Update this
            return albums;
        } catch (IOException e) {
            String hint = "";
            try {
                hint = "Current dir is: " + new File(".").getCanonicalPath();
            } catch (Exception local) {
                hint = local.getLocalizedMessage();
            }
            throw new FileNotFoundException(e.getLocalizedMessage() + "\n" + hint);

        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    System.err.println(e.getLocalizedMessage());
                }
            }
        }

    }

    public static void main(String[] args) {
        int option = readOption(args);

        List<Album> albums = null;
        try {
            albums = loadCSV(args[FILE_NAME]);

            Collections.sort(albums);
            for(Album a : albums){
                a.sortTrackList();
            }
            // TODO Implement the Options 1 (for assignment 4) and 2-4 (for midterm 1)
            System.out.println("Album Count: " + albums.size());
            System.out.println();
            System.out.println("===============");
            System.out.println(" ");

            for (Album a : albums) {
                System.out.println(a.getName() + ": " + a.getNumberOfTracks());
            }

            System.out.println(" ");
            System.out.println("===============");
            System.out.println(" ");

            for (Album a : albums) {
                System.out.println(a.toString());
            }

        } catch (FileNotFoundException e) {
            System.err.println(e.getLocalizedMessage());
            System.exit(1);
        }
    }
}