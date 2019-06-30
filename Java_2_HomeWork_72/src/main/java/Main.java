import Annotations.ClassChecker;
import TestClasses.TestClass;
import TestClasses.TestClass1;

public class Main {
    public static void main(String[] args) {
        ClassChecker.start(TestClass.class);
        ClassChecker.start(TestClass1.class);
    }
}
