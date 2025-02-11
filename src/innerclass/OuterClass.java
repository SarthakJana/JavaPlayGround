package innerclass;

public class OuterClass {

    public void hi() {
        System.out.println("Hi from outer");

        class LocalInner {

        }
    }

    public class Inner {
        public void hi() {
            System.out.println("Hi from Inner class");
        }
    }

    public static class InnerStatic {

        public void hi() {
            System.out.println("Hi from InnerStatic");
        }
    }
}
