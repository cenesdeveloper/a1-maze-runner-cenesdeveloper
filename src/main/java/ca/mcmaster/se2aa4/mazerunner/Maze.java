package ca.mcmaster.se2aa4.mazerunner;

import org.apache.commons.cli.ParseException;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
public class Maze {
    public static int row = 0;
    public static int column = 0;

    public static String find_path(BufferedReader reader) throws IOException{
        ExploreMaze exp = new ExploreMaze();
        String arg_path = exp.explore(reader);
        int n = arg_path.length();
        char last_c;
        StringBuilder factorized_path = new StringBuilder();
        int a, counter, b;
        int i = 0;
        while (i < n){
            a = i+1;
            last_c = arg_path.charAt(i);
            char c = arg_path.charAt(a);
            counter = 1;
            while (a < n && c == last_c){
                counter++;
                a++;
                i++;
            }
            factorized_path.append(counter).append(c);
        }
//        return arg_path;
        return factorized_path.toString();
    }
    public static char[][] store_maze(BufferedReader reader) throws IOException {
        String lines;
        ArrayList<String> arr = new ArrayList<String>();
        while ((lines = reader.readLine()) != null) {
            int max_wall = 0;
            for (int idx = 0; idx < lines.length(); idx++, max_wall++) {
//                if (lines.charAt(idx) == '#') {
//                    System.out.print("WALL ");
//                    max_wall++;
//                } else if (lines.charAt(idx) == ' ') {
//                    System.out.print("PASS ");
//                }
            }
            arr.add(lines);
            if (max_wall > column){
                column = max_wall;
            }
            row++;
//            System.out.print(System.lineSeparator());
        }
//        System.out.println();

        char maze[][] = new char[row][column];
        String line;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                maze[i][j] = ' ';
            }
        }
        for (int i = 0; i < arr.size(); i++) {
            line = arr.get(i);
            for (int j = 0; j < line.length(); j++) {
                if (line.charAt(j) == '#') {
                    maze[i][j] = '#';
                } else {
                    maze[i][j] = ' ';
                }
            }
        }
//        for (int n = 0; n < row; n++){
//            for (int j = 0; j < column; j++){
//                System.out.print(maze[n][j]);
//            }
//            System.out.println();
//        }
        return maze;
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
//        System.out.printf("Entrance: [%d, %d]\n", first_i, first_j);
//        System.out.printf("Exit: [%d, %d]\n", last_i, last_j);
        int[] entr_end = new int[]{first_i, first_j, last_i, last_j};
        return entr_end;
    }
}
