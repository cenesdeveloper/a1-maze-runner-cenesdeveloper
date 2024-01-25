package ca.mcmaster.se2aa4.mazerunner;

import org.apache.commons.cli.ParseException;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Objects;

public class ValidateMaze {
    public static String path_valid(String arg_path, BufferedReader reader) throws IOException, ParseException {
        Maze exp = new Maze();
        String path = exp.find_path(reader);
        if (Objects.equals(arg_path, path)){
            return "correct path";
        }
        else{
            return "incorrect path";
        }
    }
}
