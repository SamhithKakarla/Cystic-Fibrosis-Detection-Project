import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        String dna = ReadFromFileUsingScanner.Read();


//        Fixdata(ReadFromFileUsingScanner.Read());
  //    ReturnFrequency(sort(splitString(dna)), "TTCCACAG");


getTable(dna, sort(splitString(dna)), PossCombinations("ATGC", 1));




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
        String last = Chars.substring(n - 1);
        combos.addAll(PossCombinations(Chars.substring(0, n - 1), k));
        for (String subCombo : PossCombinations(Chars.substring(0, n - 1), k - 1))
            combos.add(subCombo + last);

        for (int i = 0; i < combos.size(); i++) {
            for (int j = i + 1; j < combos.size(); j++) {
                if (combos.get(i).equalsIgnoreCase(combos.get(j))) RemoveCombos.add(combos.get(i));
            }
        }

        for (int i = 0; i < combos.size(); i++) {
            for (int j = 0; j < RemoveCombos.size(); j++) {
                if (combos.get(i).equalsIgnoreCase(RemoveCombos.get(j))) {
                    combos.remove(i);
                    RemoveCombos.set(j, " ");
                }
            }
        }
        return combos;
    }


    private static void getTable(String dna, DTO dto, ArrayList<String> listSequences) {
        for (int i = 0; i < listSequences.size(); i++) {
            ReturnFrequency(sort(splitString(dna)), listSequences.get(i));
        }


    }

    private static void ReturnFrequency(DTO dto, String target) {
        System.out.println(target);
        /*MutantList Calculations */
        ArrayList<String> mutantList = dto.getMutantList();
        double mutantListNucCounter = 0;
        double mutantListPatCounter = 0;
        for (int i = 0; i < (mutantList.size() - 1); i++) {
            for (int j = 0; j < mutantList.get(i).length() - (target.length()); j++) {
                if (("ATGCatgc").contains(mutantList.get(i).substring(j, (j + 1)))) {
                    mutantListNucCounter++;
                }
                if (target.equalsIgnoreCase(mutantList.get(i).substring(j, j + (target.length())))) {
                    mutantListPatCounter++;
                }
            }
        }
        double mutant = (mutantListPatCounter / mutantListNucCounter)*100;

        System.out.println(mutant);

//////////////////////////


        /*MutantList Calculations */
        ArrayList<String> normalList = dto.getNormalList();
        double normalListNucCounter = 0;
        double normalListPatCounter = 0;
        for (int i = 0; i < (normalList.size() - 1); i++) {
            for (int j = 0; j < normalList.get(i).length() - (target.length()); j++) {
                if (("ATGCatgc").contains(normalList.get(i).substring(j, (j + 1)))) {
                    normalListNucCounter++;
                }
                if (target.equalsIgnoreCase(normalList.get(i).substring(j, j + (target.length())))) {
                    normalListPatCounter++;
                }
            }
        }
        double normal = (normalListPatCounter / normalListNucCounter)*100;

        System.out.println(normal);


        System.out.println(Math.max(normal/mutant , mutant/normal));
    }

    private static String[] splitString(String input) {
        return input.split(" ");
    }

    private static DTO sort(String[] x) {
        ArrayList<String> MutantList = new ArrayList<String>();
        ArrayList<String> NormalList = new ArrayList<String>();
        for (int i = 0; i < x.length - 1; i++) {
            if (x[i].startsWith("m")) {
                MutantList.add(x[i].substring(0, x[i].length() - 1));
            }
            if (x[i].startsWith("n")) {
                NormalList.add(x[i].substring(0, x[i].length() - 1));
            }
        }

        DTO dto = new DTO(NormalList, MutantList);

        return dto;
    }



    private static void printlist(String print) {
        for (int i = 0; i < print.length(); i++) {
            System.out.print(print.substring(i, i+1));
            if(print.substring(i, i+1).equalsIgnoreCase("m")) {

                System.out.println();

            }

        }

    }


    public static String Fixdata(String input){
        String list;
        int counter = 0;
        list= input.replaceAll(" ", "");
        for (int i = 0; i < input.length(); i++) {
            counter++;
            if(counter == 61){
                System.out.print(list.substring(i-60, i));
                System.out.println(", m");
                counter = 0;
            }
        }


        return list;
    }




}
