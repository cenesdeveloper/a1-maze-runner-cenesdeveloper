package ca.mcmaster.se2aa4.mazerunner;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

public class Maze {
    public static String findpath(BufferedReader reader){
        ExploreMaze maze = new ExploreMaze();
        String path = maze.explore();
        return path;
    }
    public static void storemaze(BufferedReader reader) throws IOException {
        String line;
        ArrayList<String> lst = new ArrayList<>();
        int row = 0;
        int column = 0;
        while ((line = reader.readLine()) != null) {
            int max_wall = 0;
            for (int idx = 0; idx < line.length(); idx++) {
                if (line.charAt(idx) == '#') {
                    System.out.print("WALL ");
                    max_wall++;
                } else if (line.charAt(idx) == ' ') {
                    System.out.print("PASS ");
                }
            }
            lst.add(line);
            if (max_wall > column){
                column = max_wall;
            }
            row++;
            System.out.print(System.lineSeparator());
        }

        System.out.println();
        char arr[][] = new char[row][column];

        for (int i = 0; i < lst.size(); i++) {
            line = lst.get(i);
            for (int j = 0; j < line.length(); j++) {
                if (line.charAt(j) == '#') {
                    arr[i][j] = '#';
                } else {
                    arr[i][j] = ' ';
                }
            }
        }

        for (int n = 0; n < row; n++){
            for (int j = 0; j < column; j++){
                System.out.printf("%s", arr[n][j]);
            }
            System.out.println();
        }

//        System.out.printf("Number of columns: %d\n", column);
//        System.out.printf("Number of rows: %d\n", row);
    }
}
