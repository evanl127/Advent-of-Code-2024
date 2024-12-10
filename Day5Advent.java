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
            String[] a = i.split("|");
            parameterInt.add(Integer.parseInt(a[0]));
            parameterInt.add(Integer.parseInt(a[1]));
        }
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
            boolean correct = true;
            for(int k = 0; k < containNum.size(); k++){
                int num = containNum.get(k);
                for(int l = 0; l < a.size(); l++){
                    if(a.get(l) == num){
                        boolean even = checkEven(l);
                        if(!even){
                            int firstNum = a.get(l-1);
                            if(containNum.contains(firstNum)){
                                correct = false;
                            }
                        }
                    }
                }
            }
            if(correct){
                total += containNum.get((containNum.size()-1) / 2);
            }
        }
        return total;
    }
    public static boolean checkEven(int i){
        if(i % 2 == 0)
            return true;
        return false;
    }
}