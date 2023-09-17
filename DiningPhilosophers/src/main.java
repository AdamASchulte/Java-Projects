class main {

  public static void main(String[] args) {
    int n = Integer.parseInt(args[0]);
    System.out.println(n);
    Chopstick[] chopsticks = new Chopstick[n];
    for (int j = 0; j < n; j++) {
      chopsticks[j] = new Chopstick();
    }

    Philosopher[] philosophers = new Philosopher[n];
    for (int i = 0; i < philosophers.length; i++) {
      philosophers[i] =
          new Philosopher(
            i + 1,
            chopsticks[i],
            chopsticks[(i + 1) % chopsticks.length]
          );

      Thread t = new Thread(philosophers[i]);
      t.start();
    }
  }
}

class Chopstick {

  public boolean isTaken = false;
  public Philosopher owner;

  public Chopstick() {}

  public void lock(Philosopher phil) {
    if (!isTaken) {
      isTaken = true;
      owner = phil;
    }
  }

  public void Unlock() {
    isTaken = false;
    owner = null;
  }
}

class Philosopher implements Runnable {

  private int position;
  private Chopstick leftChopstick;
  private Chopstick rightChopstick;
  private boolean hungry = true;

  public Philosopher(int pos, Chopstick left, Chopstick right) {
    this.position = pos;
    this.leftChopstick = left;
    this.rightChopstick = right;
  }

  public void takeChopstick(Chopstick chopstick) throws InterruptedException {
    chopstick.lock(this);
  }

  public void releaseChopstick(Chopstick chopstick) {
    chopstick.Unlock();
  }

  public void run() {
    System.out.println("Thread " + position + " has begun");
    try {
      while(this.hungry)
      {
        if(leftChopstick.owner != this)
        {
          synchronized (leftChopstick) {takeChopstick(this.leftChopstick);
          if(leftChopstick.owner == this)
          {
            System.out.println("Philosopher " + this.position + " has picked up left chopstick");
          }
        

        }
      }
        
        if(rightChopstick.owner != this)
        {
          synchronized(rightChopstick) {takeChopstick(this.rightChopstick);
          if(rightChopstick.owner == this)
          {
            System.out.println("Philosopher " + this.position + " has picked up right chopstick");
          }
        }
      }
        

        if(leftChopstick.owner == this && rightChopstick.owner == this)
        {
          System.out.println(
            "Philosopher " + this.position + " has started eating"
          );
          Thread.sleep(500 * (int) Math.random());
          this.hungry = false;
          System.out.println(
            "Philosopher " + this.position + " has finished eating"
          );
          releaseChopstick(leftChopstick);
          releaseChopstick(rightChopstick);
          System.out.println(
            "Philosopher " + this.position + " has put down his chopsticks");
        }
        else
        {
          if(leftChopstick.owner == this)
          {
            releaseChopstick(leftChopstick);
            System.out.println("Philosopher " + position + " has put down his left chopstick");
          }
          if(rightChopstick.owner == this)
          {
            releaseChopstick(rightChopstick);
            System.out.println("Philosopher " + position + " has put down his right chopstick");
          }
        }
      }
    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
      return;
    }
  }
}


