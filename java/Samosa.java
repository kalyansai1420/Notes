import java.io.Serializable;

public class Samosa implements Serializable{

    private static Samosa samosa;
    // constructor
    // if its private then it can't be accessed from outside the class
    private Samosa(){
        
    }
    // used to static 
    // if its non static then we have to create object of Samosa class to access
    //if its static then we can access it without creating object of Samosa class
    //then we no need of object to access this method
    //but inside static we can't access non static members because static members are loaded first
    // lazy way of creating object
    public static Samosa getSamosa(){ //method synchronized not used

        if(samosa==null){
            
            // object of this class
            synchronized(Samosa.class){
                if(samosa==null){
                    
                    samosa= new Samosa();
                }
            }
            }
        
        return samosa;

    }
}