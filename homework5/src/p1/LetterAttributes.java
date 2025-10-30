package p1;
public class LetterAttributes {
    private final Font font;
    private final Color color;
    private final Size size;

    public LetterAttributes(Font font, Color color, Size size) {
        this.font = font;
        this.color = color;
        this.size = size;
    }
    public Font font() {return font;}
    public Color color() {return color;}
    public Size size() {return size;}

}
