public enum Operation {
    SUM("+"),
    SUBTRACT("-"),
    PRODUCT("*"),
    DIVIDE("/"),
    NONE("");

    private final String displayString;

    Operation(final String displayString) {
        this.displayString = displayString;
    }

    public String getDisplayString() {
        return displayString;
    }
}
