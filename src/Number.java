public class Number extends Value {
    public double value;

    public Number(double value) {
        this.value = value;
    }

    public boolean isKnown() { return true; }
    public String getSymbol() { return String.valueOf(this.value); }
    public boolean isNull() { return false; }
}
