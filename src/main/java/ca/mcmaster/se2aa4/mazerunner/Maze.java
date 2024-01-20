package ca.mcmaster.se2aa4.mazerunner;

import java.io.BufferedReader;
import java.io.IOException;

public class Maze {
    public static String findpath(BufferedReader reader){
        ExploreMaze maze = new ExploreMaze();
        String path = maze.explore();
        return path;
    }
    public static void printmaze(BufferedReader reader) throws IOException {
        String line;
        while ((line = reader.readLine()) != null) {
            for (int idx = 0; idx < line.length(); idx++) {
                if (line.charAt(idx) == '#') {
                    System.out.print("WALL ");
                } else if (line.charAt(idx) == ' ') {
                    System.out.print("PASS ");
                }
            }
            System.out.print(System.lineSeparator());
        }
    }
}
