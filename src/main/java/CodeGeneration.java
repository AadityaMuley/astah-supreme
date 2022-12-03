import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;


public class CodeGeneration extends Observable implements Observer {

    
    private String code ="";

    private void generateCode(Data classes){

        for(DataStructure c : classes.getClassStructure() ){
            if(c != null)
                if(c.inheritance != null)
                    code = code + "class " + c.classname + " extends " + c.inheritance + "{\n";
                else
                    code = code + "class " + c.classname +"{" ;

                if(c.aggregation != null){
                    ArrayList<String> agg = c.aggregation;
                    for( String j : agg){
                        code = code+ "\n\tpublic " + j + "; \n";
                    }
                }
                if(c.association != null){
                    ArrayList<String> ass = c.association;
                    for( int j=0; j < ass.size(); j++){
                        code = code+ "\n\tclass exampleMthods( " + ass.get(j) + " variablename )  {\n\t} \n";
                    }
                }
                code = code + "} \n";
        }
        
        setChanged();
        notifyObservers();
    }

    public String getCode(){
        String temp = code;
        code = "";
        return temp;
    }

    @Override
    public void update(Observable o, Object arg1) {
        Data data = ((Data)o).getInstance();
        generateCode(data);
    }
    
}
