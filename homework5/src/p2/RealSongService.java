package p2;

import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Collections;

public class RealSongService implements SongService {

    public ArrayList<IDSongPair> songDatabase = new ArrayList<>();

    public record IDSongPair(Integer songID, Song song) {}

    public void addSongToDatabase(Integer songID, Song song) {
        songDatabase.add(new IDSongPair(songID, song));
    }

    @Override
    public Song searchById(Integer songID) {
        sleepOneSecond(); 
        Collections.sort(songDatabase, Comparator.comparing(pair -> pair.songID()));
        //list is now sorted by key
        int index = Collections.binarySearch(songDatabase, new IDSongPair(songID, null), Comparator.comparing(IDSongPair::songID));
        if (index >= 0) {
            return songDatabase.get(index).song();
        } else {
            return null;
        }
    }
    @Override
    public List<Song> searchByTitle(String title) {
        sleepOneSecond();
        if (title == null) {
            return List.of();
        }

        List<Song> matches = new ArrayList<>();
        for (IDSongPair pair : songDatabase) {
            Song s = pair.song();
            String getTitle = s.getTitle();
            if (title.equals(getTitle)) {
                matches.add(s);
            }
        }
        return List.copyOf(matches);
    }
    @Override
    public List<Song> searchByAlbum(String album) {
        sleepOneSecond();
        if (album == null) {
            return List.of();
        }
        String key = album;

        List<Song> matches = new ArrayList<>();
        for (IDSongPair pair : songDatabase) {
            Song s = pair.song();
            String a = s.getAlbum();
            if (a.equals(key)) {
                matches.add(s);
            }
        }
        return List.copyOf(matches);
    }

    private static void sleepOneSecond() {
        try { Thread.sleep(1000); } catch (InterruptedException ignored) { Thread.currentThread().interrupt(); }
    }
}
