package simstation;
import mvc.*;

public enum Heading {
    NORTH, EAST, WEST, SOUTH;

    public static Heading parse(String heading) {
        if (heading.equalsIgnoreCase("north")) return NORTH;
        if (heading.equalsIgnoreCase("east")) return EAST;
        if (heading.equalsIgnoreCase("west")) return WEST;
        if (heading.equalsIgnoreCase("south")) return SOUTH;
        return null;
    }

    public static Heading random() {
        int luck = Utilities.rng.nextInt(4);
        switch (luck) {
            case 0:
                return NORTH;
            case 1:
                return EAST;
            case 2:
                return SOUTH;
            case 3:
                return WEST;
            default:
                return null;
        }
    }
}
