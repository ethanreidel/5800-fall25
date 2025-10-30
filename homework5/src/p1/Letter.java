package p1;
public class Letter {
    private char letter;
    private LetterAttributes attributes; //intrinsic data

    public Letter(char letter, LetterAttributes attributes) {
        this.letter = letter;
        this.attributes = attributes;
    }

    public char ch() {return letter;}
    public LetterAttributes attributes() {return attributes;}
}

