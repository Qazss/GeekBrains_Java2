package Annotations;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Comparator;
import java.util.LinkedList;

public class ClassChecker {
    static LinkedList<Method> methodList;
    static int maxPriority = 10;
    static int minPriority = 1;
    static boolean beforeSuite = true;
    static boolean afterSuite = true;

    public static void start(Class testClass){
        methodList = new LinkedList<Method>();
        Method[] methods = testClass.getMethods();

        for(Method m : methods){
            if (m.isAnnotationPresent(Test.class)){
                int priority = m.getAnnotation(Test.class).priority();

                if(priority >= minPriority && priority <= maxPriority){
                    methodList.add(m);
                } else {
                    throw new RuntimeException();
                }
            }
        }

        methodList.sort(new Comparator<Method>() {
            @Override
            public int compare(Method o1, Method o2) {
                return o2.getAnnotation(Test.class).priority() - o1.getAnnotation(Test.class).priority();
            }
        });

        for(Method m : methods){
            if(m.isAnnotationPresent(BeforeSuite.class)){
                if(beforeSuite){
                    methodList.addFirst(m);
                    beforeSuite = false;
                } else {
                    throw new RuntimeException();
                }
            }

            if (m.isAnnotationPresent(AfterSuite.class)) {
                if(afterSuite){
                    methodList.addLast(m);
                    afterSuite = false;
                } else {
                    throw new RuntimeException();
                }
            }
        }


        for(Method method : methodList){
            try {
                method.invoke(testClass);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }
        System.out.println("---------------------------");
    }
}
