import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Example {
    
    public static void main(String[] args) throws IOException {
        // Samosa samosa = Samosa.getSamosa();
        // System.out.println();
        /* Break singleton pattern
         * 1. Reflection API to break singleton pattern
         * solution :
         *     1. we use enum
         *     2. if object is there ==> throw exception from inside constructor 
         * 
         * 2. Serialization and Deserialization
         * solution :
         *     1. we use readResolve() method
         * 
         * 
         */

        Samosa samosa = Samosa.getSamosa();
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("abc.ob"));
        oos.writeObject(samosa);

        System.out.println("serialization done..");

    }
}
