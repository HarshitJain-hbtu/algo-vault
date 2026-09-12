class ZeroEvenOdd {

    private int n;

    // 0 = zero's turn
    // 1 = odd's turn
    // 2 = even's turn
    private int turn = 0;

    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    public synchronized void zero(IntConsumer printNumber)
            throws InterruptedException {

        for (int i = 1; i <= n; i++) {

            while (turn != 0) {
                wait();
            }

            printNumber.accept(0);

            if (i % 2 == 1) {
                turn = 1;       // odd's turn
            } else {
                turn = 2;       // even's turn
            }

            notifyAll();
        }
    }

    public synchronized void odd(IntConsumer printNumber)
            throws InterruptedException {

        // Number of odd numbers from 1 to n
        for (int i = 1; i <= (n + 1) / 2; i++) {

            while (turn != 1) {
                wait();
            }

            printNumber.accept(2 * i - 1);

            turn = 0;           // zero's turn
            notifyAll();
        }
    }

    public synchronized void even(IntConsumer printNumber)
            throws InterruptedException {

        // Number of even numbers from 1 to n
        for (int i = 1; i <= n / 2; i++) {

            while (turn != 2) {
                wait();
            }

            printNumber.accept(2 * i);

            turn = 0;           // zero's turn
            notifyAll();
        }
    }
}