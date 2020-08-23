package revise;
public class ValuePair {

  private int a;
  private int b;

  public synchronized void copy(final ValuePair other) {
    this.a = other.a;
    this.b = other.b;
  }

  public synchronized void setValue(final int value) {
    this.a = value;
    this.b = value;
  }

  @Override
  public synchronized String toString() {
    return String.format("a: %d and b: %d", a, b);
  }

}