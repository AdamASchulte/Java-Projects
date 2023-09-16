class main {

  public static void main(String[] args) {
    int n = Integer.parseInt(args[0]);
    Chopstick[] chopsticks = new Chopstick[n];
    for (int j = 0; j < n; j++) {
      chopsticks[j] = new Chopstick();
    }

    Philosopher[] philosophers = new Philosopher[n];
    for (int i = 0; i < philosophers.length; i++) {
      if (i == philosophers.length - 1) {
        philosophers[i] =
          new Philosopher(
            i,
            chopsticks[(i + 1) % chopsticks.length],
            chopsticks[i]
          );
      } else {
        philosophers[i] =
          new Philosopher(
            i,
            chopsticks[i],
            chopsticks[(i + 1) % chopsticks.length]
          );
      }

      Thread t = new Thread(philosophers[i]);
      t.start();
    }
  }
}

class Chopstick {

  public boolean isTaken = false;

  public Chopstick() {}

  public void lock() {
    if (!isTaken) {
      isTaken = true;
    }
  }

  public void Unlock() {
    isTaken = false;
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

  public void takeChopstick(Chopstick chopstick) {
    while (chopstick.isTaken) {}
    chopstick.lock();
  }

  public void releaseChopstick(Chopstick chopstick) {
    chopstick.Unlock();
  }

  public void run() {
    try {
      while (this.hungry) {
        takeChopstick(this.leftChopstick);
        System.out.println(
          "Philosopher " + this.position + " has picked up left chopstick"
        );
        takeChopstick(this.rightChopstick);
        System.out.println(
          "Philosopher " + this.position + " has picked up right chopstick"
        );
        System.out.println(
          "Philosopher " + this.position + " has started eating"
        );
        Thread.sleep(500);
        this.hungry = false;
        System.out.println(
          "Philosopher " + this.position + " has finished eating"
        );
        releaseChopstick(leftChopstick);
        releaseChopstick(rightChopstick);
        System.out.println(
          "Philosopher " + this.position + " has put down his chopsticks"
        );
      }
    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
      return;
    }
  }
}
