package thread.cyclicbarrier;

class CyclicBarrierCustom{

	  

    int initialParties; //total parties

    int partiesAwait; //parties yet to arrive

 Runnable cyclicBarrrierEvent;

    

    /**

     * New CyclicBarrier is created where parties number of thread wait for each

     * other to reach common barrier point, when all threads have reached common

     * barrier point, parties number of waiting threads are released and

     * barrierAction (event) is triggered.

     */

    public CyclicBarrierCustom(int parties, Runnable cyclicBarrrierEvent) {

           initialParties=parties;

           partiesAwait=parties;   

           this.cyclicBarrrierEvent=cyclicBarrrierEvent;

    }

 

    /**

     *  If the current thread is not the last to arrive(i.e. call await() method) then

     it waits until one of the following things happens -

                  - The last thread to call arrive(i,.e. call await() method), or

                  - Some other thread interrupts the current thread, or

                  - Some other thread interrupts one of the other waiting threads, or

                  - Some other thread times out while waiting for barrier, or

                  - Some other thread invokes reset() method on this cyclicBarrier.

     */

    public synchronized void await() throws InterruptedException {

           //decrements awaiting parties by 1.

           partiesAwait--;

           

           //If the current thread is not the last to arrive, thread will wait.

           if(partiesAwait>0){

                  this.wait();

           }

           /*If the current thread is last to arrive, notify all waiting threads, and

            launch event*/

           else{

                  /* All parties have arrive, make partiesAwait equal to initialParties,

                    so that CyclicBarrier could become cyclic. */

                  partiesAwait=initialParties;

                  

                  notifyAll(); //notify all waiting threads

                  

                  cyclicBarrrierEvent.run(); //launch event

           }

    }

}

 



 

/**

 * Main class

 */

public class CyclicBarrierCustomTest {

    public static void main(String[] args) {

           /*

            * Create CountDownLatch with 3 parties, when all 3 parties

            * will reach common barrier point CyclicBarrrierEvent will be

            * triggered i.e. run() method of CyclicBarrrierEvent will be called

            */

           CyclicBarrierCustom cyclicBarrierCustom=new CyclicBarrierCustom(3 ,new CyclicBarrrierEvent());

           System.out.println("CountDownLatch has been created with parties=3,"

                        + " when all 3 parties will reach common barrier point "

                        + "CyclicBarrrierEvent will be triggered");

 

           MyRunnable myRunnable1=new MyRunnable(cyclicBarrierCustom);

           

           //Create and start 3 threads

           new Thread(myRunnable1,"Thread-1").start();

           new Thread(myRunnable1,"Thread-2").start();

           new Thread(myRunnable1,"Thread-3").start();

    

           

           

    }

 

}

 





class MyRunnable implements Runnable{

 

    CyclicBarrierCustom cyclicBarrierCustom;

    

    MyRunnable(CyclicBarrierCustom cyclicBarrierCustom){

           this.cyclicBarrierCustom=cyclicBarrierCustom;

    }

    

    @Override

    public void run() {

           

           System.out.println(Thread.currentThread().getName() +

                        " is waiting for all other threads to reach common barrier point");

 

           try {

                  Thread.sleep(1000);

                  /*

                   * when all 3 parties will call await() method (i.e. common barrier point)

                   * CyclicBarrrierEvent will be triggered and all waiting threads will

                   * be released.

                   */

 

                  cyclicBarrierCustom.await();

           } catch (InterruptedException e) {

                  e.printStackTrace();

           }

           System.out.println("As all threads have reached common barrier point "

                        + Thread.currentThread().getName() +

                        " has been released");

    }

    

}

 

 



class CyclicBarrrierEvent implements Runnable{

 

    public void run() {

           System.out.println("As all threads have reached common barrier point "

                        + ", CyclicBarrrierEvent has been triggered");

    }

    

}