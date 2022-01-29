public class Variable extends Value {
    public String symbol;

    public Variable(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() { return this.symbol; }
    public boolean isKnown() { return false; }
    public boolean isNull() { return false; }
}

