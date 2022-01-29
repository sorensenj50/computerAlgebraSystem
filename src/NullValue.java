public class NullValue extends Value {
    public String getSymbol() { return ""; }
    public boolean isKnown() { return true; }
    public boolean isNull() { return true; }
}
