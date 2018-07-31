package org.wingstudio.riverheaderinstitution;

public class TestJava {
    public static void main(String[] args) {
        Object o = 12;
        System.out.println(o instanceof Number);
        System.out.println(o instanceof Long);
        System.out.println(o instanceof Integer);

        Long l = Long.valueOf(o.toString()
        );
        System.out.println(l);

    }
}
