import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.*;
public class Day3Advent {
    public static void main(String[] args) {

        ArrayList<String> fileData = getFileData("src/Day3Input");
        ArrayList<String> combined = new ArrayList<>();
        for(String i : fileData)
            combined.add(i);
        mulTimes(combined);
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
    public static int mulTimes(ArrayList<String> a){
        int total = 0;
        ArrayList<String> allMatches = new ArrayList<>();
        String regex = "mul\\([1-9][0-9]{0,2},[1-9][0,9]{0,2}\\)";
        for(String i : a) {
            Matcher m = Pattern.compile(regex).matcher(i);
            while (m.find()) {
                allMatches.add(m.group());
            }
        }
        ArrayList<String> noMul = new ArrayList<>();
        for(String j : allMatches){
            String[] mulLess = j.split("mul");
            ArrayList<String> mulLessAL = new ArrayList<>();
            for(String k : mulLess){
                mulLessAL.add(k);
            }
            for(int l = mulLessAL; l < mulLessAL.size(); l-=2) {

            }
        }
        return total;
    }
}