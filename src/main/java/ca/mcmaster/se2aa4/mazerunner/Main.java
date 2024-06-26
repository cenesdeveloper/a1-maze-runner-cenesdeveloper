package ca.mcmaster.se2aa4.mazerunner;

import java.io.BufferedReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
public class Main {
    private static final Logger logger = LogManager.getLogger();
    public static void main(String[] args) {
        logger.info("** Starting Maze Runner");
        try {
            Configuration configure = new Configuration();
            BufferedReader reader = configure.config(args);
            Maze maze = new Maze();
            maze.storeMaze(reader);
        } catch(Exception e) {
            logger.error("/!\\ An error has occured /!\\");
            System.exit(1);
        }
        logger.info("**** Computing path");
        logger.info("PATH NOT COMPUTED");
        logger.info("** End of MazeRunner");
    }
}
