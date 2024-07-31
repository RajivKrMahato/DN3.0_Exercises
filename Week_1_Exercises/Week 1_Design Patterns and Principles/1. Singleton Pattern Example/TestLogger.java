public class TestLogger {
    public static void main(String[] args) {

        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();

        System.out.println("logger1 hashcode: " + logger1.hashCode());
        System.out.println("logger2 hashcode: " + logger2.hashCode());

        logger1.log("This is the first log message.");
        logger2.log("This is the second log message.");
        
        if (logger1 == logger2) {
            System.out.println("Both references point to the same Logger instance.");
        } else {
            System.out.println("Different instances of Logger.");
        }
    }
}
