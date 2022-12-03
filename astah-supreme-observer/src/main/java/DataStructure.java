import java.util.ArrayList;
public class DataStructure {

    public String classname, inheritance;
    public ArrayList<String> aggregation;
    public ArrayList<String> association;

    public DataStructure(){
        this.classname = "";
        this.inheritance = "";
        this.aggregation = new ArrayList<>();
        this.association = new ArrayList<>();
    }

}
