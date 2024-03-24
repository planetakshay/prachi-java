package practice2023.binarysearch;

public class Ball {

    int id;
    int color;
    public Ball(int id, int color) {
        this.id = id;
        this.color = color;
    }
    public int getColor() {
        return color;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Ball {" +
                "id = " + id +
                ", color = " + color +
                "}";
    }

    public enum Color {
        GREEN(1, "green"),
        YELLOW(2, "yellow"),
        RED(3, "red"),
        VIOLATE(4, "violate");

        final int id;
        final String name;
        Color(int id, String name) {
            this.id = id;
            this.name = name;
        }
        public int getId() {
            return id;
        }
        public String getName() {
            return name;
        }
    }
}