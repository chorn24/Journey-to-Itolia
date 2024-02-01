import java.util.Arrays;
import java.util.Scanner;
import java.util.HashSet;
import java.util.Set;
import java.util.Random;

public class Main {
    static void print(String text) {
        System.out.println(text);
    }

    static String input() {
        Scanner i = new Scanner(System.in);
        return i.nextLine();
    }

    static String TravelQuestion(int ID) {
        print("Where to?");
        print(Arrays.toString(Locations.Where_To[ID]));
        return input().toLowerCase();
    }



    public static void main(String[] args) {
        Random rand = new Random();
        Random Medium = new Random();
        Random Major = new Random();
        Random rand2 = new Random();
        Random rand3 = new Random();

        Character_names Names = new Character_names();

        Locations L = new Locations();
        int ID = 0;
        String Current_Location = "Path to Lucario";
//        String Current_Description = L.Location_Description[0];
        Set<String> MapMarks = new HashSet<String>();
        MapMarks.add("Lucario");
        MapMarks.add("Itolia");
        print("You are Martini Martano, a Traveller that is running short on supplies on your journey to the grand kingdom of Itolia.");
        print("Looking at your map you have marked down the nearest town, Lucario.");
        String Directive = "Start";
        Supplies SupplyType = new Supplies();
        SupplyType.drink = 20;
        SupplyType.food = 20;
        SupplyType.gold = 100;
        boolean Market = false;
        boolean Itolia = false;
        boolean quit = false;
        while (!Directive.equals("quit") || !Current_Location.equals("Itolia")) {
            if (SupplyType.drink > 0) {
                if (SupplyType.gold < 0) {
                    SupplyType.gold = 0;
                }
                // The section for if you are in a market, its duplicated but has the Buy option
                if (Market) {
                    Locations.ReadLocation(ID);
                    print("[Travel], [Map], [Check] Supplies, [Buy], [Quit]");
                    Directive = input().toLowerCase();
                    switch (Directive) {
                        case "travel" -> {
                            switch (Current_Location) {
                                case "Lucario Market" -> {
                                    String Direction = TravelQuestion(ID);
                                    if (Direction.equals("admin")) {
                                        String AL;
                                        SupplyType.drink = 10000;
                                        SupplyType.food = 10000;
                                        print("Set the location");
                                        AL = input();
                                        Current_Location = AL;
                                    } else if (Direction.equals("grove path")) {
                                        ID = 3;
                                        Current_Location = "Grove Path";
                                        Market = false;
                                    }

                                }
                                case "Taris Market" -> {
                                    String Direction = TravelQuestion(ID);
                                    if (Direction.equals("admin")) {
                                        String AL;
                                        SupplyType.drink = 10000;
                                        SupplyType.food = 10000;
                                        print("Set the location");
                                        AL = input();
                                        Current_Location = AL;
                                    } else if (Direction.equals("desert path")) {
                                        Current_Location = "Desert Path";
                                        ID = 9;
                                        Market = false;
                                    } else if (Direction.equals("taris")) {
                                        Current_Location = "Taris";
                                        ID = 7;
                                        Market = false;
                                    }


                                }
                                case "Olera Market" -> {
                                    String Direction = TravelQuestion(ID);
                                    if (Direction.equals("admin")) {
                                        String AL;
                                        SupplyType.drink = 10000;
                                        SupplyType.food = 10000;
                                        print("Set the location");
                                        AL = input();
                                        Current_Location = AL;
                                    } else if (Direction.equals("snowy path")) {
                                        Current_Location = "Snowy Path";
                                        ID = 16;
                                        Market = false;
                                    } else if (Direction.equals("olera")) {
                                        Current_Location = "Olera";
                                        ID = 14;
                                        Market = false;

                                    }

                                }
                            }
                        }
                        case "map" -> {
                            String MapDir = "Start";
                            print("You open up your map, what would you like to do?");
                            while (!MapDir.equals("close")) {
                                print("[Mark] Town, [Read] map, [Remove] from map, [Close] the map");
                                MapDir = input().toLowerCase();
                                switch (MapDir) {
                                    case "mark" -> {
                                        print("Do you want to mark the current location on your map?");
                                        print("[Yes] or [No]");
                                        String MarkConfirm = input().toLowerCase();
                                        if (MarkConfirm.equals("yes")) {
                                            MapMarks.add(Current_Location);
                                        } else if (MarkConfirm.equals("no")) {
                                            print("You decide not to mark a location");
                                        } else {
                                            print("Invalid Action");
                                        }
                                    }
                                    case "read" -> {
                                        print("Your marked locations:");
                                        for (String Marks : MapMarks) {
                                            print(Marks);
                                        }
                                    }
                                    case "remove" -> {
                                        print("What location do you want to remove? (Q to cancel)");
                                        String Remove = input();
                                        if (MapMarks.contains(Remove)) {
                                            print("You remove " + Remove + " From your map");
                                            MapMarks.remove(Remove);
                                        } else {
                                            print("That location is not marked");
                                        }
                                    }
                                    case "close" -> print("You closed the map");
                                    default -> print("Not a valid option");
                                }
                            }
                        }
                        case "check" -> {
                            print("You check your supplies");
                            print("Food: " + SupplyType.drink);
                            print("Drink: " + SupplyType.food);
                            print("Gold: " + SupplyType.gold);
                        }
                        case "quit" -> {
                            print("Quitting...");
                            quit = true;
                            Market = false;
                        }
                        case "buy" -> {
                            int RandomName = rand.nextInt(25);
                            print(Names.Name[RandomName] + " the merchant says:");
                            print("I have many fresh fruits, vegetables, and I have fresh water for sale!");
                            print("Do you want to buy?");
                            print("[Yes] or [No]");
                            String Confirm = input().toLowerCase();
                            if (Confirm.equals("yes")) {
                                if (SupplyType.gold < 40) {
                                    print("You dont have enough gold");
                                }
                                else {
                                    print("Thank you for buying!");
                                    SupplyType.drink += 60;
                                    SupplyType.food += 60;
                                    SupplyType.gold -= 40;
                                }
                            } else if (Confirm.equals("no")) {
                                print("You tell the merchant no and walk away");
                            } else {
                                print(Names.Name[RandomName] + " says they dont speak that language");
                            }

                        }
                        default -> print("Not a valid option");
                    }

                }

                else if (Itolia) {
                    print("You reached the grand kingdom of Itolia, you celebrate with a feast with all your friends");
                    print("Congratulations, you have won!");
                    break;

                }

                else if (quit) {
                    break;
                }

                else {
                    int Supply_Use = rand.nextInt(10);
                    int Supply_Use_Medium = Medium.nextInt(25);
                    int Supply_Use_Major = Major.nextInt(40);
                    Locations.ReadLocation(ID);
                    if (Current_Location.equals("Cave") || Current_Location.equals("Pyramid") || Current_Location.equals("Snowy Path")) {
                        int gold_chance = rand2.nextInt(100);
                        if (gold_chance > 60) {
                            int gold_gain = rand3.nextInt(100);
                            SupplyType.gold += gold_gain;
                            print("You found " + gold_gain + " Gold!");
                        } else {
                            print("You found a empty treasure chest");
                        }
                    }
                    print("[Travel], [Map], [Check] Supplies, [Quit]");
                    Directive = input().toLowerCase();
                    label:
                    switch (Directive) {
                        case "travel" -> {

                            switch (Current_Location) {
                                case "Path to Lucario": {
                                    SupplyType.drink -= Supply_Use;
                                    SupplyType.food -= Supply_Use;
                                    String Direction = TravelQuestion(ID);
                                    if (Direction.equals("admin")) {
                                        String AL;
                                        SupplyType.drink = 10000;
                                        SupplyType.food = 10000;
                                        print("Set the location");
                                        AL = input();
                                        Current_Location = AL;

                                    } else if (Direction.equals("lucario")) {
                                        ID = 1;
                                        Current_Location = "Lucario";
                                    } else {
                                        print("Invalid Choice");
                                    }
                                    break;
                                }
                                case "Lucario": {
                                    SupplyType.drink -= Supply_Use;
                                    SupplyType.food -= Supply_Use;
                                    String Direction = TravelQuestion(ID);
                                    switch (Direction) {
                                        case "admin" -> {
                                            String AL;
                                            SupplyType.drink = 10000;
                                            SupplyType.food = 10000;
                                            print("Set the location");
                                            AL = input();
                                            Current_Location = AL;
                                        }
                                        case "path to lucario" -> {
                                            ID = 0;
                                            Current_Location = "Path to Lucario";
                                        }
                                        case "lucario market" -> {
                                            ID = 2;
                                            Current_Location = "Lucario Market";
                                            Market = true;
                                        }
                                    }
                                    break;
                                }
                                case "Lucario Market": {
                                    String Direction = TravelQuestion(ID);
                                    switch (Direction) {
                                        case "admin" -> {
                                            String AL;
                                            SupplyType.drink = 10000;
                                            SupplyType.food = 10000;
                                            print("Set the location");
                                            AL = input();
                                            Current_Location = AL;
                                        }
                                        case "grove path" -> {
                                            ID = 3;
                                            Current_Location = "Grove Path";
                                        }
                                        case "lucario" -> {
                                            ID = 1;
                                            Current_Location = "Lucario";
                                        }
                                        default -> print("Invalid Choice");
                                    }

                                    break;
                                }
                                case "Grove Path": {
                                    SupplyType.drink -= Supply_Use;
                                    SupplyType.food -= Supply_Use;
                                    String Direction = TravelQuestion(ID);
                                    switch (Direction) {
                                        case "admin" -> {
                                            String AL;
                                            SupplyType.drink = 10000;
                                            SupplyType.food = 10000;
                                            print("Set the location");
                                            AL = input();
                                            Current_Location = AL;
                                        }
                                        case "lucario market" -> {
                                            ID = 2;
                                            Current_Location = "Lucario Market";
                                            Market = true;
                                        }
                                        case "valley path" -> {
                                            ID = 4;
                                            Current_Location = "Valley Path";
                                        }
                                        default -> print("Invalid Choice");
                                    }

                                    break;
                                }
                                case "Valley Path": {
                                    SupplyType.drink -= Supply_Use_Medium;
                                    SupplyType.food -= Supply_Use_Medium;
                                    String Direction = TravelQuestion(ID);
                                    switch (Direction) {
                                        case "admin" -> {
                                            String AL;
                                            SupplyType.drink = 10000;
                                            SupplyType.food = 10000;
                                            print("Set the location");
                                            AL = input();
                                            Current_Location = AL;
                                        }
                                        case "grove path" -> {
                                            ID = 3;
                                            Current_Location = "Grove Path";
                                        }
                                        case "cave" -> {
                                            ID = 5;
                                            Current_Location = "Cave";

                                        }
                                        default -> print("Invalid Choice");
                                    }

                                    break;
                                }
                                case "Cave": {
                                    SupplyType.drink -= Supply_Use_Major;
                                    SupplyType.food -= Supply_Use_Major;
                                    String Direction = TravelQuestion(ID);
                                    switch (Direction) {
                                        case "admin" -> {
                                            String AL;
                                            SupplyType.drink = 10000;
                                            SupplyType.food = 10000;
                                            print("Set the location");
                                            AL = input();
                                            Current_Location = AL;
                                        }
                                        case "path to taris" -> {
                                            ID = 6;
                                            Current_Location = "Path to Taris";
                                        }
                                        case "valley path" -> {
                                            ID = 4;
                                            Current_Location = "Valley Path";
                                        }
                                        default -> print("Invalid Choice");
                                    }

                                    break;
                                }
                                case "Path to Taris": {
                                    SupplyType.drink -= Supply_Use;
                                    SupplyType.food -= Supply_Use;
                                    String Direction = TravelQuestion(ID);
                                    switch (Direction) {
                                        case "admin" -> {
                                            String AL;
                                            SupplyType.drink = 10000;
                                            SupplyType.food = 10000;
                                            print("Set the location");
                                            AL = input();
                                            Current_Location = AL;
                                        }
                                        case "taris" -> {
                                            ID = 7;
                                            Current_Location = "Taris";
                                        }
                                        case "cave" -> {
                                            ID = 5;
                                            Current_Location = "Cave";
                                        }
                                        default -> print("Invalid Choice");
                                    }

                                    break;
                                }
                                case "Taris": {
                                    SupplyType.drink -= Supply_Use;
                                    SupplyType.food -= Supply_Use;
                                    String Direction = TravelQuestion(ID);
                                    switch (Direction) {
                                        case "admin" -> {
                                            String AL;
                                            SupplyType.drink = 10000;
                                            SupplyType.food = 10000;
                                            print("Set the location");
                                            AL = input();
                                            Current_Location = AL;
                                        }
                                        case "taris market" -> {
                                            ID = 8;
                                            Current_Location = "Taris Market";
                                            Market = true;
                                        }
                                        case "path to taris" -> {
                                            ID = 6;
                                            Current_Location = "Path to Taris";
                                        }
                                        default -> print("Invalid Choice");
                                    }

                                    break;
                                }
                                case "Taris Market": {
                                    Market = true;
                                    String Direction = TravelQuestion(ID);
                                    if (Direction.equals("admin")) {
                                        String AL;
                                        SupplyType.drink = 10000;
                                        SupplyType.food = 10000;
                                        print("Set the location");
                                        AL = input();
                                        Current_Location = AL;
                                    }

                                    break;
                                }
                                case "Desert Path": {
                                    SupplyType.drink -= Supply_Use;
                                    SupplyType.food -= Supply_Use;
                                    String Direction = TravelQuestion(ID);
                                    switch (Direction) {
                                        case "admin" -> {
                                            String AL;
                                            SupplyType.drink = 10000;
                                            SupplyType.food = 10000;
                                            print("Set the location");
                                            AL = input();
                                            Current_Location = AL;
                                        }
                                        case "dunes path" -> {
                                            ID = 10;
                                            Current_Location = "Dunes Path";
                                        }
                                        case "taris market" -> {
                                            ID = 8;
                                            Current_Location = "Taris Market";
                                            Market = true;
                                        }
                                        default -> print("Invalid Choice");
                                    }

                                    break;
                                }
                                case "Dunes Path": {
                                    SupplyType.drink -= Supply_Use_Medium;
                                    SupplyType.food -= Supply_Use_Medium;
                                    String Direction = TravelQuestion(ID);
                                    switch (Direction) {
                                        case "admin" -> {
                                            String AL;
                                            SupplyType.drink = 10000;
                                            SupplyType.food = 10000;
                                            print("Set the location");
                                            AL = input();
                                            Current_Location = AL;
                                        }
                                        case "pyramid" -> {
                                            ID = 11;
                                            Current_Location = "Pyramid";
                                        }
                                        case "desert path" -> {
                                            ID = 9;
                                            Current_Location = "Desert Path";
                                        }
                                        default -> print("Invalid Choice");
                                    }

                                    break;
                                }
                                case "Pyramid": {
                                    SupplyType.drink -= Supply_Use_Major;
                                    SupplyType.food -= Supply_Use_Major;
                                    String Direction = TravelQuestion(ID);
                                    switch (Direction) {
                                        case "admin" -> {
                                            String AL;
                                            SupplyType.drink = 10000;
                                            SupplyType.food = 10000;
                                            print("Set the location");
                                            AL = input();
                                            Current_Location = AL;
                                        }
                                        case "desert outpost" -> {
                                            ID = 12;
                                            Current_Location = "Desert Outpost";
                                        }
                                        case "dunes path" -> {
                                            ID = 10;
                                            Current_Location = "Dunes Path";
                                        }
                                        default -> print("Invalid Choice");
                                    }

                                    break;
                                }
                                case "Desert Outpost": {
                                    SupplyType.drink -= Supply_Use_Major;
                                    SupplyType.food -= Supply_Use_Major;
                                    String Direction = TravelQuestion(ID);
                                    switch (Direction) {
                                        case "admin" -> {
                                            String AL;
                                            SupplyType.drink = 10000;
                                            SupplyType.food = 10000;
                                            print("Set the location");
                                            AL = input();
                                            Current_Location = AL;
                                        }
                                        case "path to olera" -> {
                                            ID = 13;
                                            Current_Location = "Path to Olera";
                                        }
                                        case "pyramid" -> {
                                            ID = 11;
                                            Current_Location = "Pyramid";
                                        }
                                        default -> print("Invalid Choice");
                                    }

                                    break;
                                }
                                case "Path to Olera": {
                                    SupplyType.drink -= Supply_Use;
                                    SupplyType.food -= Supply_Use;
                                    String Direction = TravelQuestion(ID);
                                    switch (Direction) {
                                        case "admin" -> {
                                            String AL;
                                            SupplyType.drink = 10000;
                                            SupplyType.food = 10000;
                                            print("Set the location");
                                            AL = input();
                                            Current_Location = AL;
                                        }
                                        case "olera" -> {
                                            ID = 14;
                                            Current_Location = "Olera";
                                        }
                                        case "desert outpost" -> {
                                            ID = 12;
                                            Current_Location = "Desert Outpost";
                                        }
                                        default -> print("Invalid Choice");
                                    }

                                    break;
                                }
                                case "Olera": {
                                    SupplyType.drink -= Supply_Use;
                                    SupplyType.food -= Supply_Use;
                                    String Direction = TravelQuestion(ID);
                                    switch (Direction) {
                                        case "admin" -> {
                                            String AL;
                                            SupplyType.drink = 10000;
                                            SupplyType.food = 10000;
                                            print("Set the location");
                                            AL = input();
                                            Current_Location = AL;
                                        }
                                        case "olera market" -> {
                                            ID = 15;
                                            Current_Location = "Olera Market";
                                            Market = true;
                                        }
                                        case "path to olera" -> {
                                            ID = 13;
                                            Current_Location = "Path to Olera";
                                        }
                                        default -> print("Invalid Choice");
                                    }


                                    break;
                                }
                                case "Olera Market": {
                                    Market = true;
                                    String Direction = TravelQuestion(ID);
                                    switch (Direction) {
                                        case "admin" -> {
                                            String AL;
                                            SupplyType.drink = 10000;
                                            SupplyType.food = 10000;
                                            print("Set the location");
                                            AL = input();
                                            Current_Location = AL;
                                        }
                                        case "snowy path" -> {
                                            ID = 16;
                                            Current_Location = "Snowy Path";
                                        }
                                        case "olera" -> {
                                            ID = 14;
                                            Current_Location = "Olera";
                                        }
                                    }

                                    break;
                                }
                                case "Snowy Path": {
                                    SupplyType.drink -= Supply_Use;
                                    SupplyType.food -= Supply_Use;
                                    String Direction = TravelQuestion(ID);
                                    switch (Direction) {
                                        case "admin" -> {
                                            String AL;
                                            SupplyType.drink = 10000;
                                            SupplyType.food = 10000;
                                            print("Set the location");
                                            AL = input();
                                            Current_Location = AL;
                                        }
                                        case "mountain path" -> {
                                            ID = 17;
                                            Current_Location = "Mountain Path";
                                        }
                                        case "olera market" -> {
                                            ID = 15;
                                            Current_Location = "Olera Market";
                                            Market = true;
                                        }
                                        default -> print("Invalid Choice");
                                    }

                                    break;
                                }
                                case "Mountain Path": {
                                    SupplyType.drink -= Supply_Use_Medium;
                                    SupplyType.food -= Supply_Use_Medium;
                                    String Direction = TravelQuestion(ID);
                                    switch (Direction) {
                                        case "admin" -> {
                                            String AL;
                                            SupplyType.drink = 10000;
                                            SupplyType.food = 10000;
                                            print("Set the location");
                                            AL = input();
                                            Current_Location = AL;
                                        }
                                        case "volcano" -> {
                                            ID = 18;
                                            Current_Location = "Volcano";
                                        }
                                        case "snowy path" -> {
                                            ID = 16;
                                            Current_Location = "Snowy Path";
                                        }
                                        default -> print("Invalid Choice");
                                    }

                                    break;
                                }
                                case "Volcano": {
                                    SupplyType.drink -= Supply_Use_Major;
                                    SupplyType.food -= Supply_Use_Major;
                                    String Direction = TravelQuestion(ID);
                                    switch (Direction) {
                                        case "admin" -> {
                                            String AL;
                                            SupplyType.drink = 10000;
                                            SupplyType.food = 10000;
                                            print("Set the location");
                                            AL = input();
                                            Current_Location = AL;
                                        }
                                        case "descent to itolia" -> {
                                            ID = 19;
                                            Current_Location = "Descent to Itolia";
                                        }
                                        case "mountain path" -> {
                                            ID = 17;
                                            Current_Location = "Mountain Path";
                                        }
                                        default -> print("Invalid Choice");
                                    }

                                    break;
                                }
                                case "Descent to Itolia": {
                                    SupplyType.drink -= Supply_Use;
                                    SupplyType.food -= Supply_Use;
                                    String Direction = TravelQuestion(ID);
                                    switch (Direction) {
                                        case "admin" -> {
                                            String AL;
                                            SupplyType.drink = 10000;
                                            SupplyType.food = 10000;
                                            print("Set the location");
                                            AL = input();
                                            Current_Location = AL;
                                        }
                                        case "itolia" -> {
                                            ID = 20;
                                            Current_Location = "Itolia";
                                            Itolia = true;

                                        }
                                        case "volcano" -> {
                                            ID = 18;
                                            Current_Location = "Volcano";
                                        }
                                        default -> print("Invalid Choice");
                                    }

                                    break;
                                }
                                case "Itolia":
                                    print("You reached the grand kingdom of Itolia, you celebrate with a feast with all your friends");
                                    print("Congratulations, you have won!");
                                    break;
                            }


                        }
                        case "map" -> {
                            String MapDir = "Start";
                            print("You open up your map, what would you like to do?");
                            while (!MapDir.equals("close")) {
                                print("[Mark] Town, [Read] map, [Remove] from map, [Close] the map");
                                MapDir = input().toLowerCase();
                                switch (MapDir) {
                                    case "mark" -> {
                                        print("Do you want to mark the current location on your map?");
                                        print("[Yes] or [No]");
                                        String MarkConfirm = input().toLowerCase();
                                        if (MarkConfirm.equals("yes")) {
                                            MapMarks.add(Current_Location);
                                        } else if (MarkConfirm.equals("no")) {
                                            print("You decide not to mark a location");
                                        } else {
                                            print("Invalid Action");
                                        }
                                    }
                                    case "read" -> {
                                        print("Your marked locations:");
                                        for (String Marks : MapMarks) {
                                            print(Marks);
                                        }
                                    }
                                    case "remove" -> {
                                        print("What location do you want to remove? (Q to cancel)");
                                        String Remove = input();
                                        if (MapMarks.contains(Remove)) {
                                            print("You remove " + Remove + " From your map");
                                            MapMarks.remove(Remove);
                                        } else {
                                            print("That location is not marked");
                                        }
                                    }
                                    case "close" -> print("You closed the map");
                                    default -> print("Not a valid option");
                                }
                            }
                        }
                        case "check" -> {
                            print("You check your supplies");
                            print("Food: " + SupplyType.drink);
                            print("Drink: " + SupplyType.food);
                            print("Gold: " + SupplyType.gold);
                        }
                        case "quit" -> {
                            print("Quitting...");
                            quit = true;
                        }

                        default -> print("Not a valid option");
                    }
                }

            } else {
                print("You check your supplies, only to find you have no more. Unfortunately you couldnt make it anywhere else..");
                print("GAME OVER");
                Directive = "quit";
                break;
            }
        }
    }
}