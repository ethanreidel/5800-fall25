package tests.p2;

import p2.*;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ServiceTests {

    private RealSongService real;

    @BeforeEach
    void setUp() {
        real = new RealSongService();
        real.addSongToDatabase(1, new Song("Hello", "Adele", "25", 295));
        real.addSongToDatabase(2, new Song("Blank Space", "Taylor Swift", "1989", 231));
        real.addSongToDatabase(3, new Song("Numb", "Linkin Park", "Meteora", 185));
        real.addSongToDatabase(4, new Song("Numb", "Another Artist", "Covers", 200)); // same title, different album/artist
        real.addSongToDatabase(5, new Song("Believer", "Imagine Dragons", "Evolve", 204));
    }

    @Test
    void searchById_found() {
        Song s = real.searchById(3);
        assertNotNull(s);
        assertEquals("Numb", s.getTitle());
        assertEquals("Meteora", s.getAlbum());
    }

    @Test
    void searchById_notFound() {
        assertNull(real.searchById(99));
    }

    @Test
    void searchByTitle_exactMatch_multipleResults() {
        List<Song> results = real.searchByTitle("Numb");
        assertEquals(2, results.size());
        assertTrue(results.stream().anyMatch(s -> s.getAlbum().equals("Meteora")));
        assertTrue(results.stream().anyMatch(s -> s.getAlbum().equals("Covers")));
    }

    @Test
    void searchByAlbum_exactMatch_singleResult() {
        List<Song> results = real.searchByAlbum("1989");
        assertEquals(1, results.size());
        assertEquals("Blank Space", results.get(0).getTitle());
    }

    @Test
    void searchByTitle_nullReturnsEmptyList() {
        assertTrue(real.searchByTitle(null).isEmpty());
    }

    @Test
    void searchByAlbum_nullReturnsEmptyList() {
        assertTrue(real.searchByAlbum(null).isEmpty());
    }
}
