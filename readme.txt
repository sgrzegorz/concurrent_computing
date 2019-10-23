wait()
wait musi być zawołane wewnątrz synchronized. Synchronized nakłada lock na obiekcie. Kiedy lock jest nałożony tylko nasz thread ma dostęp do obiektu. jak zawołamy wait() to nasz thread się
zatrzymuje i inne thready mogą zacząć coś działać na obiekcie.
The wait() method causes the current thread to wait indefinitely until another thread either invokes notify() for this object or notifyAll().
wait(long timeout)
Using this method, we can specify a timeout after which thread will be woken up automatically. A thread can be woken up before reaching the timeout using notify() or notifyAll().
Note that calling wait(0) is the same as calling wait().

notify()
musi być wewnątrz bloku synchronized wątku A, zwalnia z inny thread B z wait (który to będzie thread to wie tylko scheduler), ale thread B musi zaczekać aż thread A zwolni lock.
For all threads waiting on this object's monitor (by using any one of the wait() method), the method notify() notifies ANY ONE OF THEM to wake up arbitrarily. The choice of exactly which thread to wake is non-deterministic and depends upon the implementation.
Since notify() wakes up a single random thread it can be used to implement mutually exclusive locking where threads are doing similar tasks, but in most cases, it would be more viable to implement notifyAll().

notifyAll()
This method simply wakes all threads that are waiting on this object's monitor.
The awakened threads will complete in the usual manner – like any other thread.
But before we allow their execution to continue, always define a quick check for the condition required to proceed with the thread – because there may be some situations where the thread got woken up without receiving a notification (this scenario is discussed later in an example).

The wait(), notify(), and notifyAll() methods should be called for an object only when the current thread has already locked the object's lock.
This point sometimes goes unnoticed because programmers are used to calling these methods from within synchronized methods or blocks. Otherwise,
you will get "java.lang.IllegalMonitorStateException: current thread not owner" at runtime.

=================================================================================
If you'd like to get a single numeric value of milliseconds passed since the UNIX epoch, it's as easy as:
System.currentTimeMillis();

=================================================================================

synchronized void zmiana(){}
<=>
void zmiana(){
    synchronized(this){
    }
}
Note: synchronized blocks the next thread's call to method test() as long as the previous thread's execution is not finished. Threads can access this method one at a time. Without synchronized all threads can access this method simultaneously.
When a thread calls the synchronized method 'test' of the object (here object is an instance of 'TheDemo' class)
it acquires the lock of that object, any new thread cannot call ANY synchronized method of the same object as long as previous thread which had acquired the lock does not release the lock.
Similar thing happens when any static synchronized method of the class is called.
The thread acquires the lock associated with the class(in this case any non static synchronized method of an instance of that class can be called by any thread because that object level lock is still available). Any other thread will not be able to call any static synchronized method of the class as long as the class level lock is not released by the thread which currently holds the lock.
Z TEGO CO ROZUMIEM JAK W METODZIE SYNCHRONIZED OBIEKTU Reksio wywołam metodę statyczną Pies.spij() to może być problem bo nie zablokowałem metod statycznych

==================================================================================
INTERRUPTS są kooperatywne
A:
Thread B = new Thread();
B.start();
B.interrupt(); // asking politely to stop

B:
if(Thread.B.isInterrupted()){  //sprawdzam czy została ustwiona flaga
    throw new InterruptedException() //zeby A wiedział, że B przerwał z powodu interrupt, a nie dlatego że zrobił to co chciał i skończył działanie
    return;
}
Thread.interrupted() //zwraca wartość flagi i ją ponownie ustawia na false. Rekomendowany kiedy rzucamy new InterruptedException()

======= REKOMENDACJA use only for cancellation
A:
Thread B = new Thread();
B.start();
B.interrupt(); // asking politely to stop

B:
- waiting for a lock
- IO operation
- condition
- sleep()
1. B automatycznie throw new InterruptedException() (dlatego np. instrukcja wait jest wewnątrz try{}catch(){}
2. B kontynuuje swoje działanie
=================================================================================
VOLATILE    - prevent threads from caching variables when they are not chnged from that thread.

==================================================================================
==================================================================================
==================================================================================
==================================================================================
Lock lock = new ReentrantLock()
Condition cond = lock.newCondition();

T1:
    cond.await()

T2:
    cond.await()


T3:
    cond.signal() //zwalniam z czekania TYLKO jeden wątek T1 lub T2, zeby zwolnić oba trzeba wywołać 2 razy

void signal() Wakes up one waiting thread.
If any threads are waiting on this condition then one is selected for waking up. That thread must then re-acquire the lock before returning from await.
re-acquire the lock - znaczy się że tyle razy ile został wykonane lock.lock() tyle razy musi zostać wykonane lock.unlock() dopiero wtedy wątek return from await .
==========================================================================================================