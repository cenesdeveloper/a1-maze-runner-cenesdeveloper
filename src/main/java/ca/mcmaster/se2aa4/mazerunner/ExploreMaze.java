package ca.mcmaster.se2aa4.mazerunner;

import org.apache.commons.cli.ParseException;

import java.io.BufferedReader;
import java.io.IOException;

public class ExploreMaze {
    public static String explore(BufferedReader reader) throws IOException, ParseException {
        String path = "";
        Maze maze = new Maze();
        char[][] arr = maze.store_maze(reader);
        int[] enter = maze.Enter_Exit(arr);

        int i;
        int j;

        for (i = enter[0]; i < arr.length; i++){
            for (j = enter[1]; j < arr[0].length - 1; j++){
                if (arr[i][j+1] == ' '){
                    path += "F";
                }
            }
        }
        return path;
    }

}
