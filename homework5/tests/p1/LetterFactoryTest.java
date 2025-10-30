package tests.p1;

import p1.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LetterFactoryTest {

    @Test
    void sameAttributesReturnSameFlyweight() {
        Font f = new Font("Arial");
        Color c = new Color("Red");
        Size  s = new Size(12);

        LetterAttributes a1 = LetterFactory.getAttributes(f, c, s);
        LetterAttributes a2 = LetterFactory.getAttributes(f, c, s);
        assertSame(a1, a2);
    }

    @Test
    void differentAttributesReturnDifferentFlyweights() {
        LetterAttributes a1 = LetterFactory.getAttributes(new Font("Arial"), new Color("Red"), new Size(12));
        LetterAttributes a2 = LetterFactory.getAttributes(new Font("Calibri"), new Color("Blue"), new Size(14));

        assertNotSame(a1, a2, "Different attribute triplets should yield different flyweights");
    }
}
