package exercise;

import java.util.stream.IntStream;

// BEGIN
class ReversedSequence implements CharSequence{
    StringBuilder reverse;
    public ReversedSequence(String string) {
        this.reverse = new StringBuilder(string).reverse();
    }
    @Override
    public int length() {
        return reverse.length();
    }

    @Override
    public char charAt(int index) {
        return reverse.charAt(index);
    }

    @Override
    public boolean isEmpty() {
        return CharSequence.super.isEmpty();
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        return reverse.subSequence(start, end);
    }

    @Override
    public IntStream chars() {
        return CharSequence.super.chars();
    }

    @Override
    public IntStream codePoints() {
        return CharSequence.super.codePoints();
    }

    @Override
    public String toString() {
        return String.valueOf(reverse);
    }

}
// END
