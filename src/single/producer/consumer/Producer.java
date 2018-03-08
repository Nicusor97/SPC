/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package single.producer.consumer;
import java.util.Random;
import java.util.concurrent.locks.Lock;
/**
 *
 * @author nicol
 */
public class Producer extends Thread{
    private final String name = "======";
    private final float price = 10.99f;
    private boolean done = false;
    private Lock lock;

    public Producer(Lock lock){
        this.lock = lock;
    }

    @Override
    public void run(){
        Random rand = new Random();
        while(true){
            done = false;
            Produs product = new Produs(name,price);
            synchronized(lock){
                if(SingleProducerConsumer.lista_produse.size() < SingleProducerConsumer.size){

                    SingleProducerConsumer.lista_produse.add(product);
                    done = true;
                    }
                }
                if(done){
                    try {

                        Thread.sleep(2500 + rand.nextInt(8000));
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println("Producer added to queue!");
                }		
            }
    }
	
}
