package edu.epam.arraytask.reader.impl;

import edu.epam.arraytask.exceptions.ArrayException;
import edu.epam.arraytask.reader.ArrayReader;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ArrayReaderImpl implements ArrayReader {
    public static final Logger logger = LogManager.getLogger();
    public static final String REGEX_DELIMITER = "\\s+";

    @Override
    public List<List<String>> readArraysFromFile(String path) throws ArrayException {
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            List<List<String>> result = new LinkedList<>();
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.strip();
                String[] array = line.split(REGEX_DELIMITER);
                List<String> list = Arrays.asList(array);
                result.add(list);
            }
            logger.log(Level.INFO, " arrays from file \"" + path + ": " + result);
            return result;
        } catch (IOException e) {
            String message = " unable to read file: " + path;
            logger.log(Level.INFO, message);
            throw new ArrayException(message, e);
        }
    }
}
