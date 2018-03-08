/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package single.producer.consumer;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/**
 *
 * @author nicol
 */
public class SingleProducerConsumer {

    /**
     * @param args the command line arguments
     */
    public static int size = 10;
    public static Queue<Produs> lista_produse = new LinkedList<Produs>();
    
    public static void main(String[] args) {
        // TODO code application logic here
        Lock lock = new ReentrantLock();

        Producer producer = new Producer(lock);
        Consumer consumer = new Consumer(lock);

        producer.start();
        consumer.start();

        try{
            producer.join();
            consumer.join();
        }catch(InterruptedException e){

            System.out.println(e.getMessage());
        }
    }
    
}
