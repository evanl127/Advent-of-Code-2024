import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.*;
public class Day2Advent {
    public static void main(String[] args) {

        ArrayList<String> fileData = getFileData("src/Day2Input");
        System.out.println(findSafe(fileData));
        ArrayList<String> test = new ArrayList<>();
        test.add("1 2 7 8 9");
        System.out.println(dampener(fileData));
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

    public static int findSafe(ArrayList<String> fileData) {
        int safeReports = 0;
        for (String i : fileData) {
            String[] strList = i.split(" ");
            ArrayList<Integer> a = new ArrayList<>();
            for (String j : strList) {
                int b = Integer.parseInt(j);
                a.add(b);
            }
            ArrayList<Integer> difference = new ArrayList<>();
            for(int k = 0; k < a.size()-1; k++){
                difference.add(a.get(k) - a.get(k + 1));
            }
            if(checkNeg(difference)){
                safeReports++;
            } else if (checkPos(difference)) {
                safeReports++;
            }
        }
        return safeReports;
    }
    public static boolean checkNeg(ArrayList<Integer> a){
        for(int i = 0; i < a.size(); i++){
            if(!(a.get(i) > -4 && a.get(i) < 0))
                return false;
        }
        return true;
    }
    public static boolean checkPos(ArrayList<Integer> a){
        for(int i = 0; i < a.size(); i++){
            if(!(a.get(i) > 0 && a.get(i) < 4))
                return false;
        }
        return true;
    }
    public static int dampener(ArrayList<String> fileData){
        int safeReports = 0;
        for (String i : fileData) {
            String[] strList = i.split(" ");
            ArrayList<Integer> a = new ArrayList<>();
            for (String j : strList) {
                int b = Integer.parseInt(j);
                a.add(b);
            }
            ArrayList<Integer> difference = new ArrayList<>();
            for(int k = 0; k < a.size()-1; k++){
                difference.add(a.get(k) - a.get(k + 1));
            }
            if(checkNeg(difference)){
                safeReports++;
            } else if (checkPos(difference)) {
                safeReports++;
            }
            else if (possibility(a)){
                safeReports++;
            }
        }
        return safeReports;
    }
    public static boolean possibility(ArrayList<Integer> a)
    {
        for(int i = 0; i < a.size() - 1; i++){
            ArrayList<Integer> tester = a;
            tester.remove(i);
            ArrayList<Integer> difference = new ArrayList<>();
            for(int k = 0; k < tester.size()-1; k++){
                difference.add(tester.get(k) - tester.get(k + 1));
            }
            if(checkNeg(difference)){
                return true;
            } else if (checkPos(difference)) {
                return true;
            }
        }
        return false;
    }
}
