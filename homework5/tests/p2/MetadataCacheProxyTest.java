package tests.p2;

import p2.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RealSongServiceSpy extends RealSongService {
    int idCalls = 0;
    int titleCalls = 0;
    int albumCalls = 0;

    @Override
    public Song searchById(Integer songID) {
        idCalls++;
        return super.searchById(songID);
    }

    @Override
    public List<Song> searchByTitle(String title) {
        titleCalls++;
        return super.searchByTitle(title);
    }

    @Override
    public List<Song> searchByAlbum(String album) {
        albumCalls++;
        return super.searchByAlbum(album);
    }
}

class MetadataCacheProxyTest {

    private RealSongServiceSpy realSpy;
    private SongService proxy;

    @BeforeEach
    void setUp() {
        realSpy = new RealSongServiceSpy();
        realSpy.addSongToDatabase(1, new Song("Hello", "Adele", "25", 295));
        realSpy.addSongToDatabase(2, new Song("Blank Space", "Taylor Swift", "1989", 231));
        realSpy.addSongToDatabase(3, new Song("Numb", "Linkin Park", "Meteora", 185));
        realSpy.addSongToDatabase(4, new Song("Numb", "Another Artist", "Covers", 200));
        realSpy.addSongToDatabase(5, new Song("Believer", "Imagine Dragons", "Evolve", 204));
        proxy = new MetadataCacheProxy(realSpy);
    }

    @Test
    void idisCachedAfterFirstLookup() {
        Song first = proxy.searchById(3);
        assertNotNull(first);
        assertEquals(1, realSpy.idCalls);

        Song second = proxy.searchById(3);
        assertNotNull(second);
        assertSame(first, second);
        assertEquals(1, realSpy.idCalls, "should not call real service again for same id");
    }

    @Test
    void titleisCachedAfterFirstLookup() {
        List<Song> first = proxy.searchByTitle("Numb");
        assertEquals(2, first.size());
        assertEquals(1, realSpy.titleCalls);

        List<Song> second = proxy.searchByTitle("Numb");
        assertEquals(2, second.size());
        assertEquals(1, realSpy.titleCalls, "should not call real service again for same title");
    }

    @Test
    void albumisCachedAfterFirstLookup() {
        List<Song> first = proxy.searchByAlbum("1989");
        assertEquals(1, first.size());
        assertEquals(1, realSpy.albumCalls);

        List<Song> second = proxy.searchByAlbum("1989");
        assertEquals(1, second.size());
        assertEquals(1, realSpy.albumCalls, "should not call real service again for same album");
    }

    @Test
    void proxyHandlesNullsAsSpecified() {
        assertNull(proxy.searchById(null));
        assertNull(proxy.searchByTitle(null));
        assertNull(proxy.searchByAlbum(null));
    }

    @Test
    void notFoundId() {
        Song miss1 = proxy.searchById(999);
        assertNull(miss1);
        int callsAfterFirst = realSpy.idCalls;
        Song miss2 = proxy.searchById(999);
        assertNull(miss2);
        assertEquals(callsAfterFirst, realSpy.idCalls, "null result appears cached in current implementation");
    }
}
