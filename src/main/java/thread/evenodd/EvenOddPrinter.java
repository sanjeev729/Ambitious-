package thread.evenodd;
public class EvenOddPrinter {
        static boolean flag = true;
        public static void main(String[] args) {
                Runnable odd = () -> {
                        for (int i = 1; i <= 10;) {
                                if (EvenOddPrinter.flag) {
                                        System.out.println(Thread.currentThread().getName() + " " + i);
                                        i += 2;
                                        EvenOddPrinter.flag = !EvenOddPrinter.flag;
                                }
                        }
                };

                Runnable even = () -> {
                        for (int i = 2; i <= 10;) {
                                if (!EvenOddPrinter.flag) {
                                        System.out.println(Thread.currentThread().getName() + " " + i);
                                        i += 2;
                                        EvenOddPrinter.flag = !EvenOddPrinter.flag;
                                }
                        }
                };

                Thread t1 = new Thread(odd, "Odd");
                Thread t2 = new Thread(even, "Even");
                t1.start();
                t2.start();
        }
}