package tests.p1;

import p1.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

class DocumentFlyweightTest {

    @Test
    void charactersShareSameStyleInstance() {
        Document doc = new Document();

        Font f = new Font("Arial");
        Color c = new Color("Red");
        Size  s = new Size(12);

        doc.addLetter('H', f, c, s);
        doc.addLetter('i', new Font("Arial"), new Color("Red"), new Size(12));

        List<Letter> letters = doc.characters();
        assertEquals(2, letters.size());

        LetterAttributes a1 = LetterFactory.getAttributes(f, c, s);
        LetterAttributes a2 = LetterFactory.getAttributes(f, c, s);
        assertSame(a1, a2);
    }

    @Test
    void differentRunsUseDifferentFlyweights() {
        Document doc = new Document();

        doc.addText("Hello", new Font("Arial"),   new Color("Red"),  new Size(12));
        doc.addText("World", new Font("Calibri"), new Color("Blue"), new Size(14));

        List<Letter> letters = doc.characters();
        assertEquals(10, letters.size());

        LetterAttributes sHello = letters.get(0).attributes();
        LetterAttributes sWorld = letters.get(5).attributes();

        assertNotSame(sHello, sWorld, "Different style runs should reference different flyweights");
    }
}
