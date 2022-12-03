import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Observable;
import java.util.Observer;
public class Data extends Observable {
    private static Data datainstance = null;

    public LinkedList<DataStructure> classStructures = new LinkedList<>();
    DataStructure classobj;

    private Data(){}

    public void addClass(String classname, String inheritance, ArrayList<String> aggregation, ArrayList<String> association){
        classobj = new DataStructure();
        classobj.classname = classname;
        classobj.inheritance = inheritance;
        classobj.aggregation = aggregation;
        classobj.association = association;

        classStructures.add(classobj);

        setChanged();
        notifyObservers();
    }

    public static Data getInstance()
    {
        if (datainstance == null)
            datainstance = new Data();

        return datainstance;
    }

    public LinkedList<DataStructure> getClassStructure(){
        return classStructures;
    }
}
