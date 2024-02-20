package FileHandling;

// Example using File API
import java.io.*;
import java.util.Scanner;


class FileExample {
    public static void main(String[] args) {
        FileExample obj = new FileExample();
        // Creating a file object
        File file = new File("exampleFile.txt");
        System.out.println("File object created!");

        obj.createFile(file);
        System.out.println("File contents: ");
        obj.readData(file);

        System.out.println("Writing data in the file: ");
        obj.writeData(file);
        System.out.println("File contents after writing data: ");
        obj.readData(file);
        System.out.println("Deleting the file: ");
        obj.deleteFile(file);
    }

    /**
     * Creates a file from File object
     * @param file File object to create a file in directory
     */
    void createFile(File file) {
        try {
            if (file.createNewFile()) {
                System.out.println("New file created!");
            } else {
                System.out.println("File already exists!");
            }
        }
        catch (IOException e) {
            System.out.println("Some error occurred");
            e.printStackTrace();
        }
    }

    /**
     * Reads data from the given File
     * @param file File object to read data from
     */
    void readData(File file) {
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String data = scanner.nextLine();
                System.out.println(data);
            }
            scanner.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("An error has occurred.");
            e.printStackTrace();
        }
    }

    /**
     * Writes text to the File provided
     * @param file File object to write data
     */
    void writeData(File file) {
        try {
            FileWriter writer
                    = new FileWriter(file);
            writer.write(
                    "This text is written by FileWriter." +
                            "\nThis program uses File API.");
            writer.close();
            System.out.println("Successfully written.");
        }
        catch (IOException e) {
            System.out.println("An error has occurred.");
            e.printStackTrace();
        }
    }

    /**
     * Deletes the file provided
     * @param file File object to delete
     */

    void deleteFile(File file) {
        if (file.delete()) {
            System.out.println("The deleted file is : "
                    + file.getName());
        }
        else {
            System.out.println(
                    "Failed in deleting the file.");
        }
    }
}