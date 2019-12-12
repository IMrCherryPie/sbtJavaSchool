public class Example {
        private final int age;
        private final String name;

        static  boolean run = true;

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public Example(int age, String name) {
            this.age = age;
            this.name = name;
        }

    public static void main(String[] args) {
        Example ex = new Example(12,"Sasha");
        System.out.println("age = " + ex.getAge() + "  name = " + ex.getName());

        Thread thread2 = new Thread(()->{
            while(run);

        });
        String str = "";
        thread2.start();
        long start = System.currentTimeMillis();

        long end = System.currentTimeMillis();
        System.out.println("Время выполнения = " + (end - start)/1000d + "s");

        run = false;
    }
}
