package ca.mcmaster.se2aa4.mazerunner;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Options;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.apache.commons.cli.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Configuration {
    private static final Logger logger = LogManager.getLogger();
    public static BufferedReader config(String[] args) throws IOException, ParseException {
        Options options = new Options();
        options.addOption("i","input", true,"maze file path");
        options.addOption("p","path",true,"maze sequence");
        CommandLineParser parser = new DefaultParser();
        CommandLine cmd = parser.parse(options, args);
        BufferedReader reader = new BufferedReader(new FileReader(cmd.getOptionValue('i')));
        Maze explorer = new Maze();
        logger.info("**** Reading the maze from file " + cmd.getOptionValue('i'));
        if (cmd.hasOption('p')){
            ValidateMaze validator = new ValidateMaze();
            String valid = validator.path_valid(cmd.getOptionValue('p'), reader);
            System.out.printf("%s\n", valid);
        }
        else{
            String exp = explorer.find_path(reader);
            System.out.printf("%s\n", exp);
        }
        return reader;
    }
}
