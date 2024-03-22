package pass.ICC.Singleton;

public final class Singleton {

    private static Singleton instance;

    public String value;

    private Singleton(){
        this.value = "xxx";
    }

    public static Singleton getInstance(){
        if (instance == null){
            instance = new Singleton();
        }
        return instance;
    }
}
