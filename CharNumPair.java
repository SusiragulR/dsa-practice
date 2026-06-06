public class CharNumPair {
    char character;
    int num;

    CharNumPair(char first, int second) {
        this.character = first;
        this.num = second;
    }

    @Override
    public String toString() {
        return "<" + character + "," + num + ">";
    }
}