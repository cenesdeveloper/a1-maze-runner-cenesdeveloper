package ca.mcmaster.se2aa4.mazerunner;

import java.io.BufferedReader;
import java.io.IOException;
public class ValidateMaze {
    public static String path_valid(String arg_path, BufferedReader reader) throws IOException{
        Maze maze = new Maze();
        char[][] arr = maze.store_maze(reader);
        int[] enter_exit = maze.Enter_Exit(arr);
        int enter_i = enter_exit[0];
        int enter_j = enter_exit[1];
        int exit_i = enter_exit[2];
        int exit_j = enter_exit[3];
        char direction = 'F';
        arg_path = arg_path.replaceAll(" ", "");
        arg_path = defactorize_path(arg_path);
        int n = arg_path.length();
        boolean extra = false;

        for (int i = 0; i < n; i++){
            if (enter_i == exit_i && enter_j == exit_j){
                extra = true;
                break;
            }
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
                else{
                    break;
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
                else {
                    break;
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
                else {
                    break;
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
                else {
                    break;
                }
            }
        }
        if (enter_i == exit_i && enter_j == exit_j && !(extra)){
            return "correct path";
        }
        else {
            return "incorrect path";
        }
    }
    private static String defactorize_path(String arg_path){
        int n = arg_path.length();
        int num;
        int i = 0;
        StringBuilder factorized_path = new StringBuilder();

        while (i < n){
            if (Character.isDigit(arg_path.charAt(i))){
                String count = new String("");
                while (Character.isDigit(arg_path.charAt(i))){
                    count += (arg_path.charAt(i));
                    i++;
                }
                num = Integer.parseInt(count);
                for (int j = 1; j < num; j++){
                    factorized_path.append(arg_path.charAt(i));
                }
            }
            else {
                factorized_path.append(arg_path.charAt(i));
                i++;
            }
        }
        return factorized_path.toString();
    }
}
