package com.example;

public class Bagno {
    private boolean disponibile = true;
    private int contaF=0;
    private int contaDonneTot=0;
    //ogni 3F 1M
   
    public synchronized void entra(Persona p) {
        String name = Thread.currentThread().getName();
        char sesso = p.getSesso();
       
        
        
        if(sesso=='F'){
            contaDonneTot++;
            //System.out.println(contaDonneTot);
        }

        try {
            
            while ( !disponibile || (sesso == 'M' && contaF<3 && contaDonneTot!=0) || (sesso=='F' && contaF==4) ) {// se è verificata questa condizione vengono seguite istruzioni
                    // se non è disponibile o se è maschio e contaF è minore di 3
                wait();//aspetta
            }
            } catch ( InterruptedException e) { }
           

            if(sesso=='F'){ 
                contaF++;
                contaDonneTot--;
                //System.out.println(contaDonneTot);
            }

            
            if (sesso=='M' || contaDonneTot==0){ // gli ultimi M due non entrano qua perchè non escon dal while
                //System.out.println("sono entratooooooooo");
                contaF=0;
            }
               
           
            
            disponibile = false; //entra 
            
            System.out.println(name + " entra in bagno");
    }

    public synchronized void esci() {
        String name = Thread.currentThread().getName();
        System.out.println(name + " esce dal bagno");
        disponibile = true;
        notifyAll();
    }
}