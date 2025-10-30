package tests.p1;

import p1.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.nio.file.*;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DocumentSaveTest {

    @TempDir Path tmp;

    @Test
    void saveWritesOneLinePerCharacter() throws Exception {
        Document doc = new Document();
        doc.addText("Hi", new Font("Arial"), new Color("Red"), new Size(12));
        Path out = tmp.resolve("doc.txt");
        doc.save(out);

        List<String> lines = Files.readAllLines(out);
        assertEquals(2, lines.size(), "Save should produce one line per character");
        assertTrue(lines.get(0).startsWith("Character: H, Attributes:"),
                   "First line should start with the expected prefix");
    }
}
