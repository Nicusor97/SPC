/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package single.producer.consumer;
import java.util.concurrent.locks.Lock;
import java.util.Random;
/**
 *
 * @author nicol
 */
public class Consumer extends Thread{
    
   private Lock lock;
	private boolean done = false;
	
	public Consumer(Lock lock){
		this.lock = lock;
	}
	
	@Override
	public void run(){
		Random rand = new Random();
		
		while(true){
			
		    done = false;
			Produs product = null;
			
			synchronized(lock){
				if(SingleProducerConsumer.lista_produse.size() > 0){
					product = SingleProducerConsumer.lista_produse.poll();
					done = true;
				}
			}
			if(done){
				
				try {
					
					Thread.sleep(1500 + rand.nextInt(5000));
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("Consumer, consumed product "+product.GetName()+" with price "+product.GetPret()+"$");
			}
		}
	}
}
