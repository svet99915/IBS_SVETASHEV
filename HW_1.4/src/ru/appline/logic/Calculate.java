package ru.appline.logic;

public class Calculate {
    private static final Calculate instance = new Calculate();
    public static Calculate getInstance(){return instance;}

    public int sum(int a, int b)
    {
        return a+b;
    }
    public int sub(int a, int b)
    {
        return a-b;
    }
    public int multipli(int a, int b)
    {
        return a*b;
    }
    public int div( int a, int b) { return a/b; }


}
