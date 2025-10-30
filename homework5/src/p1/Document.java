package p1;
import java.util.ArrayList;
import java.util.List;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;



public class Document {
    private ArrayList<Letter> characters = new ArrayList<>();
    private Path filePath;

    public void addLetter(char letter, Font font, Color color, Size size) {
        LetterAttributes attribs = LetterFactory.getAttributes(font, color, size);
        characters.add(new Letter(letter, attribs));
    }
    public void addText(String text, Font font, Color color, Size size) {
        LetterAttributes attribs = LetterFactory.getAttributes(font, color, size);
        for (int i = 0; i < text.length(); i++) {
            characters.add(new Letter(text.charAt(i), attribs));
        }
    }

    public void save(Path path) throws IOException {

        //we have access to characters (list of letters with their attributes)

        String nl = System.lineSeparator();
        StringBuilder sb = new StringBuilder();

        for (Letter let : characters) {
            Font font = let.attributes().font();
            Color color = let.attributes().color();
            Size size = let.attributes().size();

            sb.append("Character: ").append(let.ch())
            .append(", Attributes: ")
            .append(font.fontType())
            .append(", ")
            .append(color.color())
            .append(", ")
            .append(size.size())
            .append(nl);
        }

        Files.createDirectories(path.getParent() == null ? Path.of(".") : path.getParent());
        Files.writeString(path, sb.toString(), StandardCharsets.UTF_8);
    }

    public void save() throws IOException {
        if (filePath == null) {
            throw new IllegalStateException("No default path set. Call save(Path) or createDocument(Path) first.");
        }
        save(filePath);
    }

    public static Document load(Path path) throws IOException {
        List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);
        Document doc = new Document();
        for (String line : lines) {
            if (line.isBlank()) {
                continue;
            }
            int start = line.indexOf("Character: ");
            int comma = line.indexOf(',', start);
            if (start < 0 || comma < 0) {
                continue;
            }
            char ch = line.substring(start + "Character: ".length(), comma).trim().charAt(0);
            doc.addLetter(ch, new Font("Default"), new Color("Default"), new Size(12));
        }
        return doc;
    }

    public static Document createDocument(Path path) throws IOException {
        if (path.getParent() != null) {
            Files.createDirectories(path.getParent());
        }

        Document doc = new Document();
        doc.filePath = path;
        System.out.println("Document created at: " + path.toAbsolutePath());
        return doc;
    }

    public static void printText(Document doc) {
        StringBuilder sb = new StringBuilder();
        for (Letter l : doc.characters()) {
            sb.append(l.ch());
        }
        System.out.println(sb.toString());
    }

    public ArrayList<Letter> characters() {return characters;}
}
