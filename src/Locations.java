import java.util.Scanner;

public class Locations {
    static void print(String text) {
        System.out.println(text);
    }

    static String input() {
        Scanner i = new Scanner(System.in);
        return i.nextLine();
    }
    static String[] Location_Names = {
            "Path to Lucario",
            "Lucario",
            "Lucario Market",
            "Grove Path",
            "Valley Path",
            "Cave",
            "Path to Taris",
            "Taris",
            "Taris Market",
            "Desert Path",
            "Dunes Path",
            "Pyramid",
            "Desert Outpost",
            "Path to Olera",
            "Olera",
            "Olera Market",
            "Snowy Path",
            "Mountain Path",
            "Volcano",
            "Descent to Itolia",
            "Itolia"
    };



    static String[] Location_Description = {
            "", //Path to Lucario
            "A small town with a large market", //Lucario
            "A place of economy, many stalls selling supplies", //Lucario Market
            "A path through a forest grove", //Grove Path
            "A path down a winding valley, the path leads to a cave", //Valley Path
            "A path inside a cave, its dark but lanterns light the pathway. You hear scuttling in the darkness", //Cave
            "A path to Taris, its in open grassy fields. The closer you get the warmer it is", //Path to Taris
            "A large town bordering the great desert, the market here is bustling", //Taris
            "A crowded market, supply stalls are uncommon but there", //Taris Market
            "A path going through a flatter portion of the desert, in the distance are large dunes", //Desert Path
            "A sandy path, its hard to see where the path is and where it isn't, the dunes are large and the sand is coarse and rough, it appears to have gotten everywhere", //Dunes Path
            "A pyramid near the end of the desert, it was used to honor kings of Olera", //Pyramid
            "A seemingly abandoned outpost, there is a bunker that you think you hear stuff from", //Desert Outpost
            "The desert begins to clear and you are back in grasslands", //Path to Olera
            "The center of many biomes, Olera is home to many cultures", //Olera
            "A simple market, not busy", //Olera Market
            "A cold path through the snow", //Snowy Path
            "Its more so Stairs then a path, your legs are sore, you feel the heat rise as you get higher", //Mountain Path
            "A volcanic zone, its very hot but you see Itolia in the distance!", //Volcano
            "Almost there!", //Descent to Itolia
            "A grand kingdom with many opportunities, the majority of your friends moved here", //Itolia
    };

    static String[][] Where_To = {
            {"Lucario"}, //Path to Lucario 0
            {"Path to Lucario","Lucario Market"}, //Lucario 1
            {"Lucario","Grove Path"}, //Lucario Market 2
            {"Lucario Market","Valley Path"}, //Grove Path 3
            {"Grove Path","Cave"}, //Valley Path 4
            {"Valley Path","Path to Taris"}, //Cave 5
            {"Cave","Taris"}, //Path to Taris 6
            {"Path to Taris","Taris Market"}, //Taris 7
            {"Taris","Desert Path"}, //Taris Market 8
            {"Taris Market","Dunes Path"}, //Desert Path 9
            {"Desert Path","Pyramid"}, //Dunes path 10
            {"Dunes Path","Desert Outpost"}, //Pyramid 11
            {"Pyramid","Path to Olera"}, //Desert Outpost 12
            {"Desert Outpost","Olera"}, //Path to Olera 13
            {"Path to Olera","Olera Market"}, //Olera 14
            {"Olera","Snowy Path"}, //Olera Market 15
            {"Olera Market","Mountain Path"}, //Snowy Path 16
            {"Snowy Path","Volcano"}, //Mountain Path 17
            {"Mountain Path","Descent to Itolia"}, //Volcano 18
            {"Volcano","Itolia"}, //Descent to Itolia 19
            {"Why do you want to leave?"}, //Itolia 20

    };




    static void  ReadLocation(int ID) {
        print("You are at "  + Location_Names[ID]);
        print("< " + Location_Description[ID] + " >");

    }
}


