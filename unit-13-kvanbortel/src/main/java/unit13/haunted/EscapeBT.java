package unit13.haunted;

/*
 * This class implements the configuration by adding to the possible path
 * Author: Kayla Van Bortel
 */

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class EscapeBT implements Configuration<EscapeBT> {
    private List<Area> currentPath = new ArrayList<>();
    private BuildingFileParser fileParser;

    public EscapeBT(BuildingFileParser fileParser) {
        this.fileParser = fileParser;
        currentPath.add(fileParser.getStartArea());
    }

    public EscapeBT(EscapeBT copy) { // Copy constructor which makes a deep copy
        currentPath = new ArrayList<>(copy.currentPath);
        fileParser = copy.fileParser;
    }

    /**
     * Find all of the areas that are connected to the one we're in that we haven't visited and aren't haunted
     */
    @Override
    public Collection<EscapeBT> getSuccessors() {
        List<EscapeBT> neighbors = new ArrayList<>();
        Area currentArea = currentPath.get(currentPath.size() - 1);
        Set<Area> visited = new HashSet<>(currentPath);

        // Create a deep copy of EscapeBT to update the path iteration
        for (Area area: fileParser.getPassages().get(currentArea)) {
            if (!visited.contains(area)) {
                EscapeBT copy = new EscapeBT(this);
                copy.step(area);
                neighbors.add(copy);
            }
        }
 
        return neighbors;
    }

    public void step(Area newArea) {
        currentPath.add(newArea);
    }

    /*
     * The path is valid if the newest area is not haunted
     */
    @Override
    public boolean isValid() {
        return !currentPath.get(currentPath.size() - 1).isHaunted();
    }

    /*
     * The goal is achieved if the path ends with an exit
     */
    @Override
    public boolean isGoal() {
        return currentPath.get(currentPath.size() - 1).getType() == AreaType.EXIT;
    }

    @Override
    public String toString() {
        return currentPath.toString();
    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a building floor plan .csv file: ");
        // src/main/java/unit13/haunted/apartment.csv
        // src/main/java/unit13/haunted/mansion.csv
        String filename = scanner.nextLine();
        scanner.close();
        BuildingFileParser fileParser = new BuildingFileParser(filename);
        Area start = fileParser.getStartArea();
        System.out.println("\nYou awake in the " + start + " and desperately need to find a way out!\n");

        System.out.println("Haunted areas:");
        for (Area area: fileParser.getHauntedAreas()) {
            System.out.println("\t" + area);
        }

        EscapeBT config = new EscapeBT(fileParser);
        Backtracker<EscapeBT> backtracker = new Backtracker<>(false);
        EscapeBT solution = backtracker.solve(config);
        if (solution == null) {
            System.out.println("\nThere is no escape. You will haunt the grounds for all eternity.");
        }
        else {
            System.out.println("\nYou have found a way out!");
            System.out.println(solution.toString());
        }
    }
}
