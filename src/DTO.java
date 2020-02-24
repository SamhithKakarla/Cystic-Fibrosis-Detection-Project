import java.util.ArrayList;

public class DTO {
    ArrayList<String> normalList = new ArrayList<String>();
    ArrayList<String> mutantList = new ArrayList<String>();


    public DTO(ArrayList<String> normalList, ArrayList<String> mutantList){
        this.normalList = normalList;
        this.mutantList = mutantList;
    }

    public ArrayList<String> getNormalList() {
        return normalList;
    }

    public void setNormalList(ArrayList<String> normalList) {
        this.normalList = normalList;
    }

    public ArrayList<String> getMutantList() {
        return mutantList;
    }

    public void setMutantList(ArrayList<String> mutantList) {
        this.mutantList = mutantList;
    }
}

