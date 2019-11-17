import java.io.IOException;

public class Example {
    public static void main(String[] args) {
        try {
            someMethod();
        }catch (IOException e){
            e.printStackTrace();
            System.exit(1);
        }
    }
    public static void someMethod() throws IOException{
        throw new IOException("New Exeprion from lesson");
    }
    interface A{
        void m();
    }


    class MyExeption extends Exception {}
    class MeRuntimeException extends RuntimeException {}
}
