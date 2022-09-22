package com.company;

public class Main {

    public static void main(String[] args) {
        Arvore<String> a = new Arvore<String>();
        Arvore<String> b = new Arvore<String>();

        try
        {
            a.inclua("Java");
            a.inclua("C");
            a.inclua("Python");
            a.inclua("C++");

            b.inclua("Java");
            b.inclua("C");
            b.inclua("Python");
            b.inclua("C++");


        }
        catch (Exception erro)
        {}

        System.out.println(a.tem("Java"));
        System.out.println(a.getQtdNos()); // 4

    }
}
