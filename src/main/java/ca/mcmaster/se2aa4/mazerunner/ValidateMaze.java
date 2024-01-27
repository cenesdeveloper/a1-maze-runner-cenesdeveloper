package ca.mcmaster.se2aa4.mazerunner;

import org.apache.commons.cli.ParseException;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Objects;

public class ValidateMaze {
    public static String path_valid(String arg_path, BufferedReader reader) throws IOException, ParseException {
        Maze maze = new Maze();
        char[][] arr = maze.store_maze(reader);
        int[] enter_exit = maze.Enter_Exit(arr);
        int enter_i = enter_exit[0];
        int enter_j = enter_exit[1];
        int exit_i = enter_exit[2];
        int exit_j = enter_exit[3];
        int n = arg_path.length();
        char direction = 'F';

        for (int i = 0; i < n; i++){
            char c = arg_path.charAt(i);
            if (direction == 'F'){
                if (c == 'F'){
                    enter_j++;
                }
                else if (c == 'R'){
                    direction = 'R';
                }
                else if (c == 'L'){
                    direction = 'L';
                }
            }
            else if (direction == 'R'){
                if (c == 'F'){
                    enter_i++;
                }
                else if (c == 'R'){
                    direction = 'B';
                }
                else if (c == 'L'){
                    direction = 'F';
                }
            }
            else if (direction == 'L'){
                if (c == 'F'){
                    enter_i--;
                }
                else if (c == 'R'){
                    direction = 'F';
                }
                else if (c == 'L'){
                    direction = 'B';
                }
            }
            else{
                if (c == 'F'){
                    enter_j--;
                }
                else if (c == 'R'){
                    direction = 'L';
                }
                else if (c == 'L'){
                    direction = 'R';
                }
            }
        }
        if (enter_i == exit_i && enter_j == exit_j){
            return "correct path";
        }
        else {
            return "incorrect path";
        }
    }
}
