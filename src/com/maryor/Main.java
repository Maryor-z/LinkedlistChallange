package com.maryor;

import java.util.*;

public class Main {

    private static ArrayList<Album> albums = new ArrayList<Album>();

    public static void main(String[] args) {
        Album album = new Album("Storm bringer", "Deep purple" );
        album.addSong("Storm bringer", 4.6);
        album.addSong("Love dont mean a thing", 4.22);
        album.addSong("Holy man", 4.3);
        album.addSong("hold on", 5.6);
        album.addSong("Lady double dealer", 4.1);
        album.addSong("You cant do it right", 3.6);
        album.addSong("High ball shooter", 4.55);
        album.addSong("The gypsy", 4);
        album.addSong("The gypsSy", 4.3);

        albums.add(album);
        album = new Album("BornSinner", "J cole");

        album.addSong("For those about to rock", 4.4);
        album.addSong("For your eyes only", 5.4);
        album.addSong("she mine", 4.3);
        album.addSong("born sinner", 3.4);
        album.addSong("KOD", 5.44);
        album.addSong("Hello", 4.54);
        album.addSong("Villuminati", 2.4);
        album.addSong("For", 3.14);
        album.addSong("gypsy", 4.22);
        albums.add(album);

        LinkedList<Song> playList = new LinkedList<Song>();
        albums.get(0).addToPlayList("You cant do it right", playList);
        albums.get(0).addToPlayList("Holy man", playList);
        albums.get(0).addToPlayList("Speed king", playList);
        albums.get(0).addToPlayList(9, playList);
        albums.get(1).addToPlayList(8, playList);
        albums.get(1).addToPlayList(3, playList);
        albums.get(1).addToPlayList(2, playList);
        albums.get(1).addToPlayList(24, playList);

        play(playList);
    }

    private static void play(LinkedList<Song> playList){
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        boolean forward = true;
        ListIterator<Song> listIterator = playList.listIterator();
        if (playList.size() == 0) {
            System.out.println("No songs in playlist");
        } else {
            System.out.println("Now playing " + listIterator.next().toString());
            printMenu();
        }

        while (!quit){
            int action = scanner.nextInt();
            scanner.nextLine();

            switch (action){
                case 0:
                    System.out.println("Playlist complete.");
                    quit = true;
                    break;

                case 1:
                    if(!forward){
                        if(listIterator.hasNext()) {
                            listIterator.next();
                        }
                            forward = true;
                    }
                    if (listIterator.hasNext()) {
                        System.out.println("Now playing " + listIterator.next().toString());
                    } else {
                        System.out.println("We have reached the end of the playlist");
                        forward = false;
                    }
                    break;
                case 2:
                    if (forward){
                        if (listIterator.hasPrevious()) {
                            listIterator.previous();
                        }
                        forward = false;
                    }
                    if (listIterator.hasPrevious()){
                        System.out.println("Now playing " + listIterator.previous().toString());
                    } else {
                        System.out.println("We are at the start of the playlist");
                        forward = true;
                    }
                    break;
                case 3:
                    if (forward){
                        if (listIterator.hasPrevious()){
                            System.out.println("Now replaying " + listIterator.previous().toString());
                            forward = false;
                        } else {
                            System.out.println("We are at the start of the list");
                        }
                    } else {
                        if (listIterator.hasNext()) {
                            System.out.println("Now replaying " + listIterator.next().toString());
                            forward = true;
                        } else {
                            System.out.println("We have reached the end of the list");
                        }
                    }
                    break;
                case 4:
                    printList(playList);
                    break;
                case 5:
                    printMenu();
                    break;
                case 6:
                    if(playList.size() > 0){
                        listIterator.remove();
                        if (listIterator.hasNext()){
                            System.out.println("Now playing " + listIterator.next());

                        } else if (listIterator.hasPrevious()) {
                            System.out.println("Now playing " + listIterator.previous());
                        }
                    }
                    break;
            }
        }
    }

    private static void printMenu(){
        System.out.println("Available action:\npress");
        System.out.println("0 - to quit\n" +
                "1 - to play next song\n" +
                "2 - to play previous song\n" +
                "3 - to replay the current song\n" +
                "4 - list songs in the playlist\n" +
                "5 - print available actions\n" +
                "6 - Delete current song from playlist");
    }

    private static void printList(LinkedList<Song> playList){
        Iterator<Song> iterator = playList.iterator();
        System.out.println("============================");
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println("==============================");
    }
}
