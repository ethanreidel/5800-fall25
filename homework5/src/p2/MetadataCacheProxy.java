package p2;

import java.util.HashMap;
import java.util.Map;
import java.util.List;

public class MetadataCacheProxy implements SongService {
    private final Map<Integer, Song> idCache = new HashMap<>();
    private final Map<String, List<Song>> titleCache = new HashMap<>();
    private final Map<String, List<Song>> albumCache = new HashMap<>();
    private final SongService realService;

    public MetadataCacheProxy(SongService realService) {
        this.realService = realService;
    }

    @Override
    public Song searchById(Integer songID) {
        if (songID == null) {
            return null;
        }
        if (!idCache.containsKey(songID)) {
            idCache.put(songID, realService.searchById(songID));
        }
        return idCache.get(songID);
    }
    @Override
    public List<Song> searchByTitle(String title) {
        if (title == null) {
            return null;
        }
        if (!titleCache.containsKey(title)) {
            titleCache.put(title, realService.searchByTitle(title));
        }
        return titleCache.get(title);
    }
    @Override
    public List<Song> searchByAlbum(String album) {
        if (album == null) {
            return null;
        }
        if (!albumCache.containsKey(album)) {
            albumCache.put(album, realService.searchByAlbum(album));
        }
        return albumCache.get(album);
    }



}
