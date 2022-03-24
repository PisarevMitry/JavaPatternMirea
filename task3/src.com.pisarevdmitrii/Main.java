import java.util.*;
import java.util.stream.IntStream;

/*Создать свои потокобезопасные имплементации интерфейсов Set с использованием Semaphore, List с использованием ключевого слова synchronized*/

public class Main {
    static volatile int counter1 = 0;
    static volatile int counter2 = 0;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int res = scanner.nextInt();

        switch (res) {
            case 1: {
                List<Integer> list = new SynchronizedList<>();

                Thread threadOfList1 = new Thread(() -> {
                    for (int i = 0; i < 59; i++) {
                        list.add(new Random().nextInt(100));
                        System.out.println("поток 1 добавил узел");
                        switch (new Random().nextInt(4)) {
                            case 0: {
                                list.get(list.size() - 1);
                                System.out.println("поток 1 считал узел");
                            }
                            break;
                            case 1: {
                                list.remove(list.size() - 1);
                                System.out.println("поток 1 удалил узел");
                            }
                            break;
                            default:
                                break;
                        }
                    }
                });

                Thread threadOfList2 = new Thread(() -> {
                    for (int i = 0; i < 100; i++) {
                        list.add(new Random().nextInt(134));
                        System.out.println("поток 2 добавил узел");
                        switch (new Random().nextInt(3)) {
                            case 0: {
                                list.get(list.size() - 1);
                                System.out.println("поток 2 считал узел");
                            }
                            break;
                            case 1: {
                                list.remove(list.size() - 1);
                                System.out.println("поток 2 удалил узел");
                            }
                            break;
                            default:
                                break;
                        }
                    }
                });

                threadOfList1.start();
                threadOfList2.start();
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("Размер списка: " + list.size());
                for (Integer e : list) {
                    System.out.println(e);
                }
            }
            break;
            case 2: {
                Set<Integer> set = new SemaphoreSet<>();

                Thread threadOfSet1 = new Thread(() -> {
                    for (int i = 0; i < 59; i++) {
                        set.add(new Random().nextInt(100));
                        System.out.println("поток 1 добавил узел");
                        switch (new Random().nextInt(6)) {
                            case 0: {
                                set.clear();
                                System.out.println("поток 1 очистил список");
                            }
                            break;
                            case 1: {
                                set.remove(set.size() - 1);
                                System.out.println("поток 1 удалил узел");
                            }
                            break;
                            default:
                                break;
                        }
                    }
                });

                Thread threadOfSet2 = new Thread(() -> {
                    for (int i = 0; i < 100; i++) {
                        set.add(new Random().nextInt(134));
                        System.out.println("поток 2 добавил узел");
                        switch (new Random().nextInt(3)) {
                            case 0: {
                                set.clear();
                                System.out.println("поток 1 очистил список");
                            }
                            break;
                            case 1: {
                                set.remove(set.size() - 1);
                                System.out.println("поток 2 удалил узел");
                            }
                            break;
                            default:
                                break;
                        }
                    }
                });

                threadOfSet1.start();
                threadOfSet2.start();
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("Размер списка: " + set.size());
                for (Integer e : set) {
                    System.out.println(e);
                }
            }
            break;
        }
    }
}

