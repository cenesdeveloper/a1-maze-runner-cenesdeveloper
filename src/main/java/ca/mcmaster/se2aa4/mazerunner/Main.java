package ca.mcmaster.se2aa4.mazerunner;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

import org.apache.commons.cli.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {

    private static final Logger logger = LogManager.getLogger();

    public static void main(String[] args) {
        logger.info("** Starting Maze Runner");

        try {
            String line;
            BufferedReader reader = configure(args);
            while ((line = reader.readLine()) != null) {
                for (int idx = 0; idx < line.length(); idx++) {
                    if (line.charAt(idx) == '#') {
                        System.out.print("WALL ");
                    } else if (line.charAt(idx) == ' ') {
                        System.out.print("PASS ");
                    }
                }
                System.out.println(System.lineSeparator());
            }
        } catch(Exception e) {
            logger.error("/!\\ An error has occured /!\\");
            System.exit(1);
        }
        logger.info("**** Computing path");
        logger.info("PATH NOT COMPUTED");
        logger.info("** End of MazeRunner");
    }

    private static BufferedReader configure(String[] args) throws FileNotFoundException, ParseException {
        Options options = new Options();
        options.addOption("i","input", true,"maze file path");
        CommandLineParser parser = new DefaultParser();
        CommandLine cmd = parser.parse(options, args);
        logger.info("**** Reading the maze from file " + cmd.getOptionValue('i'));
        BufferedReader reader = new BufferedReader(new FileReader(cmd.getOptionValue('i')));
        return reader;
    }
}
