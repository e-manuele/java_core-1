public enum Color {
    BLACK("\u001B[30m"),
    WHITE("\u001B[37m");

    public final String label;
    private Color(String label) {
        this.label = label;
    }

}
