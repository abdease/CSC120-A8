import java.util.ArrayList;
/**
 * runs all of the implemented methods from the Contract interface
 */
public class Garden implements Contract {

    private ArrayList<String> gardenItems;
    private String[] itemDetails;
    private int axisX;
    private int axisY;
    private final int gardenSize = 10;
    private int height;
    private final int minHeight = 1;
    private final int maxHeight = 4;
    private final int shrinkage = 2;
    private String recentItem;
/**
 * primary garden method that stores all other method attributes
 */
    public Garden() {
        gardenItems = new ArrayList<>();
        itemDetails = new String[3];
        gardenItems.add("cucumber");
        itemDetails[0] = "A green vine plant! This is a pickling cucumber";
        gardenItems.add("gardening gloves");
        itemDetails[1] = "A pair of purple gardening gloves.";
        gardenItems.add("tulip");
        itemDetails[2] = "A beautiful orange tulip!";
        axisX = gardenSize/2;
        axisY = gardenSize/2;
        
    }
    /**
     * welcome method to greet users to the garden
     * @param greeting
     */

    public void welcome(String greeting) {
        System.out.println("Welcome to the garden! Check out the cucumber, gardening gloves, or tulip.");;
    }
    /**
     * method to grab items in garden
     * @param item
     */
    public void grab(String item) {
        if (gardenItems.contains(item)) {
            System.out.println("Grabbing the " + item);
        } else {
            System.out.println("You cannot grab" + item);
        }
    }
    /**
     * method to drop items in garden
     * @param item
     */
    public String drop(String item) {
        if (gardenItems.contains(item)) {
            gardenItems.remove(item);
            return("Dropping the" + item);
        } else
        return("You cannot drop" + item);
    }
    /**
     * method to examine items in garden
     * @param item
     */
    public void examine(String item) {
        int index = gardenItems.indexOf(item);
        if (index != -1) {
            System.out.println("Examining the " + item + "; " + itemDetails[index]);
        } else {
            System.out.println("You cannot examine the" + item);
        }
    }
    /**
     * method to use items in garden
     * @param item
     */
    public void use(String item) {
        if (gardenItems.contains(item)) {
            switch (item) {
                case "cucumber":
                    System.out.println("The cucumber is ripe and ready to eat!");
                    break;
                case "gardening gloves":
                    System.out.println("The garden gloves help protect your hands while gardening.");
                    break;
                case "tulip bulb":
                    System.out.println("You plant the tulip bulb!");
                    break;
                default:
                    System.out.println("This item is hard to use. You can't quite figure it out.");
            }
        } else {
            System.out.println("You cannot use" + item);
        }

    }
    /**
     * boolean for user to walk in certain directions
     * @param direction
     */
    public boolean walk(String direction) {
        int newX = axisX;
        int newY = axisY;
        switch (direction) {
            case "north":
                newY--;
                break;
            case "south":
                newY++;
                break;
            case "east":
                newX++;
                break;
            case "west":
                newX--;
                break;
            default:
                System.out.println("You can't walk that direction!");
                return false;
        }
        if (newX >= 0 && newX < gardenSize && newY >= 0 && newY < gardenSize) {
            axisX = newX;
            axisY = newY;
            System.out.println("You are headed " + direction);
            return true;
        } else {
            System.out.println("You cannot walk " + direction);
        } return false;
    }
    /**
     * boolean for user to fly to coordinates in garden
     */
    public boolean fly(int x, int y) {
        if (x >= 0 && x < gardenSize && y >= 0 && y < gardenSize) {
            axisX = x;
            axisY = y;
            System.out.println("You fly to the (" + x + ", " + y + ") postion in the garden."  );
            return true;
        } else {
            System.out.println("You can't fly there.");
            return false;
        }
    }
    /*
     * shrink user in half
     */
    public Number shrink() {
        if (height > minHeight) {
            height /= shrinkage;
            System.out.println("You've shrunk in half to " + height);
        } else {
            System.out.println("You're too small to shrink any more!");
        }
        return height;
        }
    /*
     * double the user in size
     */
    public Number grow() {
        if (height < maxHeight) {
            height *= shrinkage;
            System.out.println("You've doubled in size to " + height);
        } else {
            System.out.println("You are too big to grow any more!");
        }
        return height;
    }
    /*
     * method to print rest statement 
     */
    public void rest() {
        System.out.println("Relax and enjoy the garden!");

    }
    /*
     * undo last grabbed item
     */
    public void undo() {
        if (recentItem != null) {
            System.out.println("Putting back the last item you grabbed...oops: " +recentItem);
            recentItem = null;
        } else {
            System.out.println("Nothing to put back.");
        }
    }
    
    public static void main(String[] args) {
        Garden abbysGarden = new Garden();
        abbysGarden.welcome(null);
        abbysGarden.grab("cucumber");
        abbysGarden.examine("cucumber");
        abbysGarden.use("cucumber");
        abbysGarden.walk("east");
        abbysGarden.fly(3,4);
        abbysGarden.grow();
        abbysGarden.shrink();
        abbysGarden.undo();
        abbysGarden.rest();

    }


}
