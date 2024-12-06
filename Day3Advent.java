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
        StringBuilder concan = new StringBuilder(new String());
        for(String i : fileData)
            concan.append(i);
        combined.add(concan.toString());
        System.out.println(mulTimes(combined));
        System.out.println(mulTimes2(combined));
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
        String regex = "mul\\([1-9][0-9]{0,2},[1-9][0-9]{0,2}\\)";
        for(String i : a) {
            Matcher m = Pattern.compile(regex).matcher(i);
            while (m.find()) {
                allMatches.add(m.group());
            }
        }
        for(String j : allMatches){
            String h = j.substring(3);
            int k = h.indexOf(",");
            int numberOne = Integer.parseInt(h.substring(1,k));
            int numberTwo = Integer.parseInt(h.substring(k+1,h.length()-1));
            total += numberTwo * numberOne;
        }
        return total;
    }
    public static int mulTimes2(ArrayList<String> a){
        int total = 0;
        ArrayList<String> allMatches = new ArrayList<>();
        String regex = "mul\\([1-9][0-9]{0,2},[1-9][0-9]{0,2}\\)|do\\(\\)|don't\\(\\)";
        for(String i : a) {
            Matcher m = Pattern.compile(regex).matcher(i);
            while (m.find()) {
                allMatches.add(m.group());
            }
        }
        boolean count = true;
        for(String j : allMatches){
            if(j.equals("don't()")){
                count = false;
            }
            else if(j.equals("do()")){
                count=true;
            }
            else if(count) {
                String h = j.substring(3);
                int k = h.indexOf(",");
                int numberOne = Integer.parseInt(h.substring(1, k));
                int numberTwo = Integer.parseInt(h.substring(k + 1, h.length() - 1));
                total += numberTwo * numberOne;
            }
        }
        return total;
    }
}