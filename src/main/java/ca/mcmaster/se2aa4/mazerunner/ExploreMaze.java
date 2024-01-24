package ca.mcmaster.se2aa4.mazerunner;

public class ExploreMaze {
    public static String explore(char[][] arr) {
        String path = "";
        Maze maze = new Maze();
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
