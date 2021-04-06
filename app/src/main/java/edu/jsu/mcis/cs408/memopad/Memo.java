package edu.jsu.mcis.cs408.memopad;

public class Memo {

    private int id;
    private String text;

    public Memo(int id, String text) {
        this.id = id;
        this.text = text;
    }

    public Memo(String memo) {
        this.text = memo;
    }

    public int getID() { return id; }
    public void setID(int id) { this.id = id; }
    public String getText() { return text; }
    public void setText(String name) { this.text = name; }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(id).append(": ").append(text).append("\n");
        return s.toString();
    }
}
