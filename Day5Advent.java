import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Day5Advent {

    public static void main(String[] args) {
        ArrayList<ArrayList<String>> fileData = getFileData("src/Day5Input");
        ArrayList<String> parameters = fileData.get(0);
        ArrayList<String> orders = fileData.get(1);
        ArrayList<Integer> parameterInt = new ArrayList<>();
        for(String i : parameters){
            String[] a = i.split("\\|");
            parameterInt.add(Integer.parseInt(a[0]));
            parameterInt.add(Integer.parseInt(a[1]));
        }
        System.out.println(parameterInt + "\n" + orders);
        System.out.println(partOne(parameterInt,orders));

    }

    public static ArrayList<ArrayList<String>> getFileData(String fileName) {
        ArrayList<ArrayList<String>> fileData = new ArrayList<ArrayList<String>>();
        fileData.add(new ArrayList<>());
        fileData.add(new ArrayList<>());
        try {
            File f = new File(fileName);
            Scanner s = new Scanner(f);
            int idx = 0;
            while (s.hasNextLine()) {
                String line = s.nextLine();
                if (!line.equals("")) {
                    fileData.get(idx).add(line);
                } else {
                    idx = 1;
                }
            }
            return fileData;
        } catch (FileNotFoundException e) {
            return fileData;
        }
    }
    public static int partOne(ArrayList<Integer> a, ArrayList<String> b){
        int total = 0;
        for(int i = 0; i < b.size(); i++){
            ArrayList<Integer> containNum = new ArrayList<>();
            String order = b.get(i);
            String[] noComma = order.split(",");
            for(String j : noComma){
                containNum.add(Integer.parseInt(j));
            }
            if(checkNum(a,containNum))

                total += containNum.get((containNum.size() - 1) / 2);
        }
        return total;
    }

    public static boolean checkNum(ArrayList<Integer> a, ArrayList<Integer> b){
        boolean correct = true;

        for(int h = 0; h < b.size(); h++) {
            for (int i = 0; i < a.size(); i++) {
                if (a.get(i) == b.get(h)){
                    if(i % 2 == 1){
                        if(checkBefore(b, a.get(i - 1), b.get(h)))
                            correct = false;
                    }
                    else if(i % 2 == 0){
                        if(checkAfter(b,a.get(i + 1), b.get(h)))
                            correct =false;
                    }
                }
            }
        }
        return correct;
    }
    public static boolean checkBefore (ArrayList<Integer> a, int b, int c){
        if(a.contains(b))
            return (a.indexOf(b) > a.indexOf(c));
        return false;
    }
    public static boolean checkAfter (ArrayList<Integer> a, int b, int c){
        if(a.contains(b))
            return (a.indexOf(b) < a.indexOf(c));
        return false;
    }
    public static int partTwo(ArrayList<Integer> a, ArrayList<String> b) {
        int total = 0;
        for (int i = 0; i < b.size(); i++) {
            ArrayList<Integer> containNum = new ArrayList<>();
            String order = b.get(i);
            String[] noComma = order.split(",");
            for (String j : noComma) {
                containNum.add(Integer.parseInt(j));
            }

        }
        return total;
    }
    public static ArrayList<Integer> orderRight(ArrayList<Integer> a, ArrayList<Integer> b){
        for(int i = 0; i < b.size(); i++){
            int c = b.get(i);
            ArrayList<Integer> without = new ArrayList<>();
            for(int h : b)
                without.add(h);
            without.remove(without.indexOf(c));
            ArrayList<Integer> count = new ArrayList<>();
            for(int j = 0; j < a.size(); j++){

            }
        }
    }
}