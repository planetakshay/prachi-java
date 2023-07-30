package practice2023;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.RandomAccessFile;
import java.util.LinkedList;
import java.util.List;

/**
 * Instacart phone screen
 *
 * The followup question was instead of reading file line by line what can be
 * done to improve performance.
 *
 * The answer likes in how much one understands RDBMS indexes.
 * Creating indexes around frequently accessed data from the file
 * will help in looking up specific row and column of the file
 *
 * the problem below is a simulation of DB table query.
 */
public class ReadCharFromFile {

    public static void main(String[] args) {

        System.out.println("character at: " + getChar("src/input.txt"));
    }

    public static char getChar(String filePath) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String input = reader.readLine();
            int row = 0, column = 0, currentRow = 0;
            input = input.substring(1, input.length() - 1);
            String[] rowAndColumn = input.split(", ");
            row = Integer.parseInt(rowAndColumn[0].trim());
            column = Integer.parseInt(rowAndColumn[1].trim());

            List rows = new LinkedList<>();
            while ((input = reader.readLine()) != null) {
                rows.add(input);
            }
            String stringAtRow = (String) rows.get(rows.size() - (row + column));
            return stringAtRow.charAt(column);
        } catch (Exception e) {
            e.printStackTrace();
            return '\0';
        }
    }
}
