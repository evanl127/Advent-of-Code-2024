import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.*;
public class Day4Advent {
    public static void main(String[] args) {

        ArrayList<String> fileData = getFileData("src/Day4Input");
        System.out.println(xmasCount(fileData));
    }

    public static ArrayList<String> getFileData(String fileName) {
        ArrayList<String> fileData = new ArrayList<String>();
        try {
            File f = new File(fileName);
            Scanner s = new Scanner(f);
            while (s.hasNextLine()) {
                String line = s.nextLine();
                if (!line.equals(""))
                    fileData.add(line);
            }
            return fileData;
        } catch (FileNotFoundException e) {
            return fileData;
        }
    }
    public static int xmasCount(ArrayList<String> fileData){
        int total;
        total = toRight(fileData) + toUp(fileData) + diagonalDown(fileData) + diagonalUp(fileData);
        return total;
    }
    public static int toRight(ArrayList<String> fileData){
        int count = 0;
        for(String i : fileData){
            for(int j = 0; j < i.length() - 3; j++){
                if(i.substring(j,j+4).equals("XMAS")) {
                    count++;
                }
                else if(i.substring(j,j+4).equals("SAMX")){
                    count++;
                }

            }
        }
        return count;
    }
    public static int toUp(ArrayList<String> fileData) {
        int count = 0;
        for (int i = 0; i < fileData.size() - 3; i++) {
            for (int j = 0; j < fileData.get(0).length(); j++) {
                String combined = "";
                combined += fileData.get(i).substring(j, j + 1);
                combined += fileData.get(i + 1).substring(j, j + 1);
                combined += fileData.get(i + 2).substring(j, j + 1);
                combined += fileData.get(i + 3).substring(j, j + 1);
                if (combined.equals("XMAS"))
                    count++;
                else if(combined.equals("SAMX"))
                    count++;
            }
        }
        return count;
    }

    public static int diagonalDown(ArrayList<String> fileData){
        int count = 0;
        for (int i = 0; i < fileData.size() - 3; i++){
            for (int j = 3; j < fileData.get(0).length(); j++) {
                String combined = "";
                combined += fileData.get(i).substring(j, j + 1);
                combined += fileData.get(i + 1).substring(j - 1, j);
                combined += fileData.get(i + 2).substring(j - 2, j - 1);
                combined += fileData.get(i + 3).substring(j - 3, j - 2);
                if (combined.equals("XMAS"))
                    count++;
                else if(combined.equals("SAMX"))
                    count++;
            }
        }
        return count;
    }
    public static int diagonalUp(ArrayList<String> fileData){
        int count = 0;
        for (int i = 3; i < fileData.size(); i++){
            for (int j = 0; j < fileData.get(0).length() - 3; j++) {
                String combined = "";
                combined += fileData.get(i).substring(j, j + 1);
                combined += fileData.get(i - 1).substring(j + 1, j + 2);
                combined += fileData.get(i - 2).substring(j + 2, j + 3);
                combined += fileData.get(i - 3).substring(j + 3, j + 4);
                if (combined.equals("XMAS"))
                    count++;
                else if(combined.equals("SAMX"))
                    count++;
            }
        }
        return count;
    }

}