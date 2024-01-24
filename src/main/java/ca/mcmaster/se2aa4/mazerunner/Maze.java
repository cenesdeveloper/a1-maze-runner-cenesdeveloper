package ca.mcmaster.se2aa4.mazerunner;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Maze {
    public static int row = 0;
    public static int column = 0;
    public static String findpath(BufferedReader reader) throws IOException {
        ExploreMaze maze = new ExploreMaze();
        ArrayList<String> str = printmaze(reader);
        char[][] x = storemaze(str);
        String path = maze.explore(x);
        return path;
    }
    public static ArrayList<String> printmaze(BufferedReader reader) throws IOException {
        String line;
        ArrayList<String> arr = new ArrayList<String>();
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
            arr.add(line);
            if (max_wall > column){
                column = max_wall;
            }
            row++;
            System.out.print(System.lineSeparator());
        }
        System.out.println();
        return arr;
    }
    public static char[][] storemaze(ArrayList<String> lst) throws IOException {
        char arr[][] = new char[row][column];
        String line;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                arr[i][j] = ' ';
            }
        }
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
                System.out.print(arr[n][j]);
            }
            System.out.println();
        }
        return arr;
    }
    public static int[] Enter_Exit(char[][] arr){
        int first_i = 0;
        int first_j = 0;
        int last_i = 0;
        int last_j = 0;
        int row = arr.length;
        int col = arr[0].length;

        for (int i = 0; i < row; i++){
            for (int j = 0; j < col; j++){
                if (j == 0 && arr[i][j] == ' '){
                    first_i = i;
                    first_j = j;
                }
                if (j == col-1 && arr[i][j] == ' '){
                    last_i = i;
                    last_j = j;
                }
            }
        }
        System.out.printf("Entrance: [%d, %d]\n", first_i, first_j);
        System.out.printf("Exit: [%d, %d]\n", last_i, last_j);
        int[] entr_end = new int[]{first_i, first_j, last_i, last_j};
        return entr_end;
    }
}
