import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class wpjsvw {
    public static void main(String[] args) {
        System.out.println(PossCombinations("AGTCAGTCAGTCAGTC", 4));

    }

    public static DnaSets readFile(String name) {
        ArrayList<String> normals = new ArrayList<String>();
        ArrayList<String> mutants = new ArrayList<String>();
        Scanner scanner;
        try {
            scanner = new Scanner(new FileReader(name));
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();

                if (line.substring(line.length() - 2, line.length() - 1).equals("n")) {
                    normals.add(line.substring(0, line.length() - 3));
                }

                if (line.substring(line.length() - 2, line.length() - 1).equals("m")) {
                    mutants.add(line.substring(0, line.length() - 3));
                }
            }

            scanner.close();

        } catch (FileNotFoundException e) {
            System.out.println(" File not found" + name);
        }

        DnaSets dna = new DnaSets(mutants, normals);
        return dna;
    }

    public static ArrayList<String> PossCombinations(String Chars, int k) {
        int n = Chars.length();
        ArrayList<String> combos = new ArrayList<>();
        ArrayList<String> RemoveCombos = new ArrayList<>();
        if (k == 0) {
            combos.add("");
            return combos;
        }
        if (n < k || n == 0)
            return combos;
        String last = Chars.substring(n-1);
        combos.addAll(PossCombinations(Chars.substring(0, n-1), k));
        for (String subCombo : PossCombinations(Chars.substring(0, n-1), k-1))
            combos.add(subCombo + last);

        for (int i = 0; i < combos.size(); i++) {
            for (int j = i + 1; j < combos.size(); j++) {
                if(combos.get(i).equals(combos.get(j))) RemoveCombos.add(combos.get(i));
            }
        }

        for (int i = 0; i < combos.size(); i++) {
            for (int j = 0; j < RemoveCombos.size(); j++) {
                if(combos.get(i).equals(RemoveCombos.get(j))){
                    combos.remove(i);
                    RemoveCombos.set(j, " ");
                }
            }
        }
        return combos;
    }


}
