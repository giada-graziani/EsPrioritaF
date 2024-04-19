package com.example;

public class Persona extends Thread{
    private Bagno b;
    private char sesso;

    public Persona(Bagno b, String name, char sesso){
        super(name);
        this.b = b;
        this.sesso = sesso;
    }
   
    public char getSesso() {
        return this.sesso;
    }

    public void run(){
        String name = Thread.currentThread().getName();
        try{
            b.entra(this);
            int t = 2000 + (int) (Math.random()*3000);
            System.out.println(name + " occupa il bagno per: " + (t/1000) + " secondi");
            Thread.sleep(t);
            b.esci();
        }
        catch(InterruptedException i){
            i.printStackTrace();
        }
    }
}
