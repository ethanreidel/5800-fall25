package p2;

import java.util.List;

public class Driver {
    public static void main(String[] args) {
        RealSongService real = new RealSongService();
        real.addSongToDatabase(1, new Song("Hello", "Adele", "25", 295));
        real.addSongToDatabase(2, new Song("Blank Space", "Taylor Swift", "1989", 231));
        real.addSongToDatabase(3, new Song("Believer", "Imagine Dragons", "Evolve", 204));
        real.addSongToDatabase(4, new Song("Numb", "Linkin Park", "Meteora", 185));
        real.addSongToDatabase(5, new Song("Bad Guy", "Billie Eilish", "When We All Fall Asleep, Where Do We Go?", 194));
        real.addSongToDatabase(6, new Song("Shape of You", "Ed Sheeran", "÷", 233));

        SongService service = new MetadataCacheProxy(real);

        java.util.function.Supplier<Long> nowMs = () -> System.nanoTime() / 1_000_000;

        long t0 = nowMs.get();
        Song s1 = service.searchById(3);
        long t1 = nowMs.get();
        Song s2 = service.searchById(3);
        long t2 = nowMs.get();

        System.out.printf("searchById(3) first:  %4d ms → %s%n", (t1 - t0), printSong(s1));
        System.out.printf("searchById(3) second: %4d ms → %s%n%n", (t2 - t1), printSong(s2));

        t0 = nowMs.get();
        List<Song> tFirst = service.searchByTitle("Numb");
        t1 = nowMs.get();
        List<Song> tSecond = service.searchByTitle("Numb");
        t2 = nowMs.get();

        System.out.printf("searchByTitle(\"Numb\") first:  %4d ms → %s%n", (t1 - t0), printList(tFirst));
        System.out.printf("searchByTitle(\"Numb\") second: %4d ms → %s%n%n", (t2 - t1), printList(tSecond));

        t0 = nowMs.get();
        List<Song> aFirst = service.searchByAlbum("1989");
        t1 = nowMs.get();
        List<Song> aSecond = service.searchByAlbum("1989");
        t2 = nowMs.get();

        System.out.printf("searchByAlbum(\"1989\") first:  %4d ms → %s%n", (t1 - t0), printList(aFirst));
        System.out.printf("searchByAlbum(\"1989\") second: %4d ms → %s%n", (t2 - t1), printList(aSecond));
    }

    private static String printSong(Song s) {
        if (s == null) return "null";
        return String.format("%s — %s (%s) [%ds]", s.getTitle(), s.getArtist(), s.getAlbum(), s.getDuration());
    }

    private static String printList(List<Song> list) {
        if (list == null || list.isEmpty()) return "[]";
        StringBuilder b = new StringBuilder("[");
        for (int i = 0; i < list.size(); i++) {
            if (i > 0) b.append("; ");
            b.append(printSong(list.get(i)));
        }
        b.append(']');
        return b.toString();
    }
}
