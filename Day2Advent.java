import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.*;
public class Day2Advent {
    public static void main(String[] args) {

        ArrayList<String> fileData = getFileData("src/Day2Input.txt");
        ArrayList<String> test = new ArrayList<>();
        test.add("19 20 23 26 28 30 33 36");
        System.out.println(findSafe(fileData));

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
        }
        catch (FileNotFoundException e) {
            return fileData;
        }
    }
    public static int findSafe(ArrayList<String> fileData){
        int safeReports = 0;
        for(String i : fileData){
            String[] strList = i.split(" ");
            ArrayList<Integer> a = new ArrayList<>();
            for(String j : strList){
                int b = Integer.parseInt(j);
                a.add(b);
            }
            ArrayList<Integer> reverse = a;
            Collections.sort(reverse, Collections.reverseOrder());
            ArrayList<Integer> forward = a;
            forward.sort(Comparator.naturalOrder());
            if(reverse.equals(a)){
                boolean decrease = true;
                for(int k = 0; k < a.size() - 1; k ++){
                    if(!((a.get(k) - a.get(k + 1) > 0 && a.get(k)-a.get(k + 1) < 4)))
                    {
                        decrease = false;
                    }
                }
                if(decrease)
                    safeReports++;
            }
            if(forward.equals(a)){
                boolean increase = true;
                for(int k = 0; k < a.size() - 1; k ++){
                    if(!((Math.abs(a.get(k) - a.get(k + 1)) > 0 && Math.abs(a.get(k) - a.get(k + 1)) < 4)))
                    {
                        increase = false;
                    }
                }
                if(increase)
                    safeReports++;
            }

        }
        return safeReports;
    }
}