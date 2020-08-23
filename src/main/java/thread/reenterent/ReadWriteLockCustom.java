package thread.reenterent;

interface ReadWriteLockCustom {
 
    public ReentrantReadWriteLockCustom.WriteLock writeLock();
    public ReentrantReadWriteLockCustom.ReadLock  readLock();
   
}
 
class ReentrantReadWriteLockCustom implements ReadWriteLockCustom{
 
    //Variables to maintain read and write lock count.
    private int readLockCount;
    private int writeLockCount;
 
    /* Inner class providing readlock */
    private final ReentrantReadWriteLockCustom.ReadLock readerLock;
   
    /* Inner class providing writelock */
    private final ReentrantReadWriteLockCustom.WriteLock writerLock;
 
    public ReentrantReadWriteLockCustom.WriteLock writeLock() {
       return writerLock;
    }
    public ReentrantReadWriteLockCustom.ReadLock  readLock()  {
       return readerLock;
    }
 
   
    /**
     * Constructor
     */
    public ReentrantReadWriteLockCustom() {
        readerLock = new ReadLock();
        writerLock = new WriteLock();
    }
 
 
   
    /**
     * More than one threads can acquire readLock at a time, provided
     * no other thread is acquiring writeLock at same time.
     */
    public class ReadLock{
 
           public synchronized void lock() {
                  /*
                   * More than one threads can acquire readLock at a time, provided
                   * no other thread is acquiring writeLock at same time.
                   */
                  if(writeLockCount==0){
                        readLockCount++;
                  }
                  /*
                   * if some other thread is
                   * acquiring write lock at that time,
                   * than current thread waits.
                   */
                  else{
                        try {
                               wait();
                        } catch (InterruptedException e) {
                               e.printStackTrace();
                        }
                  }
           }
 
           public synchronized void unlock() {
                  readLockCount--; //decrement readLockCount.
                  
                  /*
                   * If readLockCount has become 0,
                   * all threads waiting to write will be notified
                   * and can acquire lock.
                   */
                  if(readLockCount==0)
                        notifyAll();
           }
      
    }
   
   
    /**
     * Only one threads can acquire writeLock at a time. Means writeLock
     * can only be obtained if no other thread is acquiring read or
     * write lock at that time.
     */
    public class WriteLock{
 
           public synchronized void lock() {
                  /*
                * writeLock can only be obtained if no other thread is
                   * acquiring read or write lock at that time.
                   */
                  if(writeLockCount==0 &&
                               readLockCount==0){
                        writeLockCount++;
                  }
                  /*
                   * if some other thread is
                   * acquiring read or write lock at that time,
                   * than current thread waits.
                   */
                  else{
                        try {
                               wait();
                        } catch (InterruptedException e) {
                               e.printStackTrace();
                        }
                  }
           }
 
           public synchronized void unlock() {
                  writeLockCount--; //decrement writeLockCount.
                  notifyAll(); //notify all waiting threads.
                  //Always there will be only one writing thread that is why no checking is required before notifying
           }
      
    }
   
 
 
 
 
}
 
