package com.eyesfree.corejava.v1;

public class Hello {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        System.out.println(Class.forName("java.util.Date").newInstance());
    }

    public static void aa() {
    }
}
