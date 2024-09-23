package unit10.midtermpractice.other;

public interface Stack extends Iterable<String> {
    public abstract void push (String value);
    String top();
    String pop();
    int size();
}
