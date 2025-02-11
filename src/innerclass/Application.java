package innerclass;

import innerclass.OuterClass;

public class Application {

    public static void main(String[] args) {
        OuterClass outerClass = new OuterClass();
        outerClass.hi();

        OuterClass.Inner inner = outerClass.new Inner();
        inner.hi();

        OuterClass.InnerStatic innerStatic = new OuterClass.InnerStatic();
        innerStatic.hi();
    }
}
