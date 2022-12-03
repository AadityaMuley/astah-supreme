import java.util.LinkedList;
import java.util.Observable;
public class Data extends Observable {
    private static Data datainstance = null;

    public LinkedList<DataStructure> classStructures = new LinkedList<>();
    DataStructure classobj;

    private Data(){}

    public void addClass(String classname){
        classobj = new DataStructure();
        classobj.classname = classname;
        classobj.inheritance = null;

        classStructures.add(classobj);

        setChanged();
        notifyObservers();
    }

    public void updateClass(String classname, int relationship, String end){
        for(DataStructure c : classStructures){
            if( c.classname.equals(classname)){
                if(relationship == 3){
                    c.inheritance = end;
                }
                else if(relationship == 2){
                    c.aggregation.add(end);
                }
                else{
                    c.association.add(end);
                }
            }
        }
        setChanged();
        notifyObservers();
    }
    
    public void newClass(LinkedList<DataStructure> classStructures) {
        this.classStructures = classStructures;
    
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
