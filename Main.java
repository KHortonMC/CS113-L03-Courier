import java.util.*;

abstract class Item {
    String name;
    Item(String name) { this.name = name; }
    public String toString() { return name; }
}

class Weapon extends Item {
    Weapon(String name) { super(name); }
}

class Potion extends Item {
    Potion(String name) { super(name); }
}

class Misc extends Item {
    Misc(String name) { super(name); }
}

public class Main {
    static final int SIZE = 5; 
    static char[][] map = new char[SIZE][SIZE];
    static int playerX = 1, playerY = 1; // Player start position
    static int dropZoneX = 2, dropZoneY = 0;
    static ArrayList<Item> inventory = new ArrayList<>();
    static HashMap<String, Item> itemsOnMap = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        initializeMap();
        
        while (true) {
            printMap();
            System.out.println("Inventory: " + inventory);
            System.out.print("Move (WASD) or Drop Items (X)? ");
            char command = scanner.next().toUpperCase().charAt(0);

            if (command == 'X') {
                dropItems();
            } else {
                movePlayer(command);
                checkForItem();
            }
        }
    }

    static void initializeMap() {
        for (int i = 0; i < SIZE; i++) {
            Arrays.fill(map[i], '.');
        }
        map[playerX][playerY] = 'P';
        map[dropZoneX][dropZoneY] = 'D';

        // Place random items
        placeItem(0, 2, new Weapon("Sword"), 'W');
        placeItem(1, 3, new Potion("Health Potion"), 'H');
        placeItem(2, 4, new Misc("Rope"), 'M');
    }

    static void placeItem(int x, int y, Item item, char symbol) {
        map[x][y] = symbol;
        itemsOnMap.put(x + "," + y, item);
    }

    static void printMap() {
        System.out.println("\nDungeon Map:");
        for (char[] row : map) {
            System.out.println(Arrays.toString(row));
        }
    }

    static void movePlayer(char direction) {
        int newX = playerX, newY = playerY;

        switch (direction) {
            case 'W': newX--; break;
            case 'S': newX++; break;
            case 'A': newY--; break;
            case 'D': newY++; break;
            default: return;
        }

        if (newX >= 0 && newX < SIZE && newY >= 0 && newY < SIZE) {
            if (playerX == dropZoneX && playerY == dropZoneY) {
                map[dropZoneX][dropZoneY] = 'D';
            } else {
                map[playerX][playerY] = '.';
            }
            
            playerX = newX;
            playerY = newY;
            map[playerX][playerY] = 'P';
        } else {
            System.out.println("You can't move there!");
        }
    }

    static void checkForItem() {
        String key = playerX + "," + playerY;
        if (itemsOnMap.containsKey(key)) {
            Item item = itemsOnMap.get(key);
            inventory.add(item);
            itemsOnMap.remove(key);
            System.out.println("Picked up: " + item);
        }
    }

    static void dropItems() {
        if (playerX == dropZoneX && playerY == dropZoneY && !inventory.isEmpty()) {
            System.out.println("Dropping off items: " + inventory);
            inventory.clear();
        } else {
            System.out.println("No items to drop or not at drop zone.");
        }
    }
}
