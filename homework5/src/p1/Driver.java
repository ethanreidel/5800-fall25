package p1;
import java.nio.file.Path;

public class Driver {

    public static void previewDoc(Document doc) {
        StringBuilder preview = new StringBuilder();
        for (Letter l : doc.characters()) preview.append(l.ch());
        System.out.println("Preview: " + preview);
    }

    public static void main(String[] args) {
        try {
            Document doc = Document.createDocument(Path.of("docs/HelloWorldCS5800.txt"));
            doc.addText("Hello",  new Font("Arial"),   new Color("Red"),   new Size(12));
            doc.addText("World",  new Font("Calibri"), new Color("Blue"),  new Size(14));
            doc.addText("CS",     new Font("Verdana"), new Color("Black"), new Size(16));
            doc.addText("5800",   new Font("Arial"),   new Color("Blue"),  new Size(12));
            doc.save();

            previewDoc(doc);

            Document doc2 = Document.createDocument(Path.of("docs/HelloWorldCS5800_ex2.txt"));
            doc2.addText("Hello",  new Font("Times New Roman"), new Color("Green"),   new Size(18));
            doc2.addText("World",  new Font("Courier New"),     new Color("Purple"),  new Size(10));
            doc2.addText("CS",     new Font("Georgia"),         new Color("Orange"),  new Size(20));
            doc2.addText("5800",   new Font("Tahoma"),          new Color("Brown"),   new Size(13));
            doc2.save();

            previewDoc(doc2);

            Document doc3 = Document.createDocument(Path.of("docs/HelloWorldCS5800_ex3.txt"));
            doc3.addText("Hello",  new Font("Arial"),           new Color("Black"),   new Size(11));
            doc3.addText("World",  new Font("Calibri"),         new Color("Teal"),    new Size(15));
            doc3.addText("CS",     new Font("Verdana"),         new Color("Red"),     new Size(18));
            doc3.addText("5800",   new Font("Fira Code"),       new Color("Navy"),    new Size(13));
            doc3.save();

            previewDoc(doc3);


            Document doc4 = Document.createDocument(Path.of("docs/HelloWorldCS5800_ex4.txt"));
            doc4.addText("Hello",  new Font("Helvetica"),       new Color("Crimson"), new Size(12));
            doc4.addText("World",  new Font("Segoe UI"),        new Color("RoyalBlue"), new Size(16));
            doc4.addText("CS",     new Font("Palatino"),        new Color("DarkGreen"), new Size(14));
            doc4.addText("5800",   new Font("Arial"),           new Color("Goldenrod"), new Size(12));
            doc4.save();
            previewDoc(doc4);

        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }
}
