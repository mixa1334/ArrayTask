package edu.epam.arraytask.reader;

import edu.epam.arraytask.exception.ArrayException;

import java.util.List;

public interface ArrayReader {
    List<List<String>> readArraysFromFile(String path) throws ArrayException;
}
