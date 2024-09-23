package unit13.haunted;

/*  This class reads a .csv of connected rooms and prepares the starting area and list of haunted rooms
    Author: Kayla Van Bortel */

import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.io.File;
import java.io.IOException;

public class BuildingFileParser {
    private final static Random RNG = new Random();
    private List<Area> safeAreas = new ArrayList<>();
    private List<Area> exitAreas = new ArrayList<>();
    private List<Area> hauntedAreas = new ArrayList<>();
    private Map<Area, List<Area>> passages = new HashMap<>();
    private Map<String, Area> uniqueAreas = new HashMap<>();
    private Area startArea;

    /**
     * Construct a new BuildingFileParser from a .csv file
     * @param filename the .csv file
     * @throws IOException if the .csv file couldn't be read
     */
    public BuildingFileParser(String filename) throws IOException {
        Scanner scanner = new Scanner(new File(filename));
        while(scanner.hasNext()) {
            // Split lines into individual rooms
            String[] rooms = scanner.nextLine().split(",");
            // Separate the first area for the passages Map
            Area firstArea = parseArea(rooms[0]);

            // For the rest of the rooms, connect them to the first one
            List<Area> connected = new ArrayList<Area>();
            for (int i = 1; i < rooms.length; i++) {
                Area newArea = parseArea(rooms[i]);
                connected.add(newArea);
            }
            passages.put(firstArea, connected);
        }

        // Choose random startArea
        int rndIndex = RNG.nextInt(safeAreas.size());
        startArea = safeAreas.get(rndIndex);
    }

    /**
     * Create area objects with names and types from the .csv file and randomly haunt some of them
     * @param room a .csv area
     * @return return the new area or pre-existing one
     */
    public Area parseArea(String room) {
        // Split room name and type
        String[] nameAndType = room.split("-");
        String name = nameAndType[0];
        AreaType type = AreaType.valueOf(nameAndType[1]);

        // Ensure that there are no duplicate area objects
        if (uniqueAreas.containsKey(name)) {
            return uniqueAreas.get(name);
        }

        // Haunt some areas that aren't exits and add to respective lists
        Area newArea = new Area(name, type);
        uniqueAreas.put(name, newArea);
        if (newArea.getType() != AreaType.EXIT) {
            String hauntType = EvilPresenceUtil.getRandomPresence();
            newArea.haunt(hauntType);
            if (newArea.isHaunted()) {
                hauntedAreas.add(newArea);
            }
            else {
                safeAreas.add(newArea);
            }
        }
        else {
            exitAreas.add(newArea);
        }
        return newArea;
    }

    public List<Area> getSafeAreas() {
        return safeAreas;
    }

    public List<Area> getExitAreas() {
        return exitAreas;
    }

    public List<Area> getHauntedAreas() {
        return hauntedAreas;
    }

    public Map<Area, List<Area>> getPassages() {
        return passages;
    }

    public Area getStartArea() {
        return startArea;
    }

    public static void main(String[] args) throws IOException {
        // BuildingFileParser building = new BuildingFileParser("src/main/java/unit13/haunted/apartment.csv");
        // System.out.println(building.getPassages());
    }

}
