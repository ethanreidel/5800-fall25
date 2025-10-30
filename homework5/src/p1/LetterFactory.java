package p1;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

record AttributeTuple(Font font, Color color, Size size) {}

public final class LetterFactory {
    private LetterFactory() {}

    private static final ConcurrentMap<AttributeTuple, LetterAttributes> cache =new ConcurrentHashMap<>();

    public static LetterAttributes getAttributes(Font font, Color color, Size size) {
        AttributeTuple key = new AttributeTuple(font, color, size);
        return cache.computeIfAbsent(key, k -> new LetterAttributes(font, color, size));
    }
}
