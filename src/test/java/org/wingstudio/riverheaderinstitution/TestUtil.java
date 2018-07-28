package org.wingstudio.riverheaderinstitution;

public class TestUtil {
    public static void print(Object o) {
        System.out.println("############################################");
        if (o == null)
            System.out.println("null");
        else
            System.out.println(o.toString());
        System.out.println("############################################");
    }
}
