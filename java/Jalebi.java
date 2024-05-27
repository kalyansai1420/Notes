public class Jalebi {
    
    // eager way of creating object
    // new object is created at the time of class loading
    private static Jalebi Jalebi = new Jalebi();

    public static Jalebi getJalebi(){
        return Jalebi;
    }
}
