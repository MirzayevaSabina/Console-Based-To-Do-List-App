package com.todo.app;

import java.io.*;
import java.util.List;

public class FileUtility {
    public <T> void writeFile(List<T> list, String fileName){
      try(BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
          for (T item : list) {
              writer.write(item.toString());
              writer.newLine();
          }
      } catch (IOException e) {
          System.err.println("An error occurred while writing the file: " + e.getMessage());
          throw new IllegalStateException("The file could not be written:" + fileName, e);
      }
    }

    public <T> void readFile(List<T> list, String fileName){
        File file = new File(fileName);
        if (!file.exists()){
            return;
        }
        try(ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName))) {
            List<T> loadedList = (List<T>) in.readObject();
            list.addAll(loadedList);
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("An error occurred while reading the file: " + e.getMessage());
            throw new IllegalStateException("The file could not be read:" + fileName, e);
        }
    }
}

