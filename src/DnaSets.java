import java.util.ArrayList;

public class DnaSets {
    ArrayList<String> mutants = new ArrayList<>();
    ArrayList<String> Normals = new ArrayList<>();

    public DnaSets(ArrayList<String> mutants, ArrayList<String> normals) {
        this.mutants = mutants;
        Normals = normals;
    }

    public ArrayList<String> getMutants() {
        return mutants;
    }

    public void setMutants(ArrayList<String> mutants) {
        this.mutants = mutants;
    }

    public ArrayList<String> getNormals() {
        return Normals;
    }

    public void setNormals(ArrayList<String> normals) {
        Normals = normals;
    }
}

