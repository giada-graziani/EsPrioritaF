package com.example;

public class Main {
    public static void main(String[] args) {
        Bagno b1 = new Bagno();
        String[] nomi = {"Marco", "Fra","Lorenzo", "Giulia", "Sara", "Paola", "Marta","Francesca"};
        char[] sessi = {'M', 'M', 'M','F' ,'F', 'F', 'F', 'F'};

        for(int i=0; i<nomi.length; i++) {
            Persona t = new Persona(b1, nomi[i], sessi[i]);
            t.start();
        }
    }
}