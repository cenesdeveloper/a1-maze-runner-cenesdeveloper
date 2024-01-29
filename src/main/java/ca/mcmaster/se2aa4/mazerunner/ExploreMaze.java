package ca.mcmaster.se2aa4.mazerunner;

import java.io.BufferedReader;
import java.io.IOException;
public class ExploreMaze {
    public static String explore(BufferedReader reader) throws IOException{
        String path = "";
        Maze maze = new Maze();
        char[][] arr = maze.storeMaze(reader);
        int[] enter_exit = maze.enterExit(arr);
        int enter_i = enter_exit[0];
        int enter_j = enter_exit[1];
        int exit_i = enter_exit[2];
        int exit_j = enter_exit[3];
        char direction = 'F';

        while (enter_i != exit_i || enter_j != exit_j){
            if (direction == 'F'){
                if (arr[enter_i+1][enter_j] == '#'){
                    if (arr[enter_i][enter_j+1] == ' '){
                        enter_j++;
                        path += 'F';
                    }
                    else if (arr[enter_i][enter_j+1] == '#'){
                        path += 'L';
                        direction = 'L';
                    }
                }
                else if (arr[enter_i+1][enter_j] == ' '){
                    path += 'R';
                    enter_i++;
                    path += 'F';
                    direction = 'R';
                }
            }
            else if (direction == 'R'){
                if (arr[enter_i][enter_j-1] == '#'){
                    if (arr[enter_i+1][enter_j] == ' '){
                        enter_i++;
                        path += 'F';
                    }
                    else if (arr[enter_i][enter_j-1] == '#'){
                        path += 'L';
                        direction = 'F';
                    }
                }
                else if (arr[enter_i][enter_j-1] == ' '){
                    path += 'R';
                    enter_j--;
                    path += 'F';
                    direction = 'B';
                }
            }
            else if (direction == 'L'){
                if (arr[enter_i][enter_j+1] == '#'){
                    if (arr[enter_i-1][enter_j] == ' '){
                        enter_i--;
                        path += 'F';
                    }
                    else if (arr[enter_i-1][enter_j] == '#'){
                        path += 'L';
                        direction = 'B';
                    }
                }
                else if (arr[enter_i][enter_j+1] == ' '){
                    path += 'R';
                    enter_j++;
                    path += 'F';
                    direction = 'F';
                }
            }
            else {
                if (arr[enter_i-1][enter_j] == '#'){
                    if (arr[enter_i][enter_j-1] == ' '){
                        enter_j--;
                        path += 'F';
                    }
                    else if (arr[enter_i][enter_j-1] == '#'){
                        path += 'L';
                        direction = 'R';
                    }
                }
                else if (arr[enter_i-1][enter_j] == ' '){
                    path += 'R';
                    enter_i--;
                    path += 'F';
                    direction = 'L';
                }
            }
        }
        return path;
    }
}
