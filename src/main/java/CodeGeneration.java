import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Observable;
import java.util.Observer;


public class CodeGeneration extends Observable implements Observer {

    
    private String code ="";

    private void generateCode(Data classes){
        //Data classes = Data.getInstance();

        // LinkedList<DataStructure> classes = data.getClassStructure();
        //String code = " ";

        // for (int i = 0; i < classes.classStructures.size(); i++) {
        //     //hardcode logic to concat generated code
        //     if(classes.classStructures.get(i) != null){
        //         if(classes.classStructures.get(i).inheritance != null)
        //             code = code + "class " + classes.classStructures.get(i).classname + " extends " + classes.classStructures.get(i).inheritance + "{\n";
        //         else{
        //             code = code + "class " + classes.classStructures.get(i).classname +"{" ;
        //         }
                
        //         //myedit
        //         if(classes.classStructures.get(i).aggregation != null){
        //             ArrayList<String> agg = classes.classStructures.get(i).aggregation;
        //             for( int j=0; j < agg.size(); j++){
        //                 code = code+ "\n\tpublic " + agg.get(j) + "; \n";

        //             }
        //         }


        //         //manasi code
        //         // if(classes.classStructures.get(i).aggregation != null){
        //         //     for( String j : classes.classStructures.get(i).aggregation){
        //         //         code = code+ "\n\tpublic " + j + "; \n";

        //         //     }
        //         // }

        //         if(classes.classStructures.get(i).association != null){
        //             for( String j : classes.classStructures.get(i).association){
        //                 code = code+ "\n\tclass exampleMthods( " + j + " variablename )  {\n\t} \n";
        //             }
        //         }
                
        //         code = code + "} \n";
        //     }
        // }

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
        for(DataStructure c : classes.getClassStructure()){
            System.out.println(c.classname);
        }

        System.out.println("Class added to code");
        System.out.println(code);
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
        // TODO Auto-generated method stub
        generateCode(data);
        System.out.println("Update of cg called");
    }
    
}
