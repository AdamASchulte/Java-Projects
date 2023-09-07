class main {

  public static void main(String args[]) {
    Chopstick[] chopsticks = new Chopstick[args[0]];
    for (int j = 0; j < args[0]; j++) {
      chopsticks[i] = new Chopstick();
    }

    Thread[] philosophers = new Thread[args[0]];
    philosophers[0] =
      new Thread(new Philosopher(0, chopsticks[args[0]], chopsticks[0]));
    for (int i = 1; i < philosophers.length; i++) {
      philosophers[i] =
        new Thread(new Philosopher(i, chopsticks[i - 1], chopsticks[i]));
      threads[i].start();
    }
  }
}

class Chopstick {

  private bool isTaken = false;

  public Chopstick() {}
}

class Philosoper implements Runnable {

  private int position;
  private Chopstick leftChopstick;
  private Chopstick rightChopstick;
  private boolean hungry = true;

  public Philosopher(int pos, Chopstick left, Chopstick right) {
    position = pos;
    leftChopstick = left;
    rightChopstick = right;
  }

  public void run() {}
}

