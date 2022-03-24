import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Semaphore;

public class SemaphoreSet<E> implements Set<E> {
    Set<E> dataList = new HashSet<>();
    private static final Semaphore semaphore = new Semaphore(3, true);

    @Override
    public int size() {
        int size = 0;
        try {
            semaphore.acquire();
            size = dataList.size();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release();
        }
        return size;
    }

    @Override
    public boolean isEmpty() {
        boolean isEmpty = true;
        try {
            semaphore.acquire();
            isEmpty = dataList.isEmpty();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release();
        }
        return isEmpty;
    }

    @Override
    public boolean contains(Object o) {
        boolean contain = false;
        try {
            semaphore.acquire();
            contain = dataList.contains(o);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release();
        }
        return contain;
    }

    @Override
    public Iterator<E> iterator() {
        Iterator<E> iterator = null;
        try {
            semaphore.acquire();
            iterator = dataList.iterator();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release();
        }
        return iterator;
    }

    @Override
    public Object[] toArray() {
        Object[] objects = null;
        try {
            semaphore.acquire();
            objects = dataList.toArray();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release();
        }
        return objects;
    }

    @Override
    public <T> T[] toArray(T[] a) {
        T[] objects = null;
        try {
            semaphore.acquire();
            objects = dataList.toArray(a);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release();
        }
        return objects;
    }

    @Override
    public boolean add(E ea) {
        boolean result = false;
        try {
            semaphore.acquire();
            result = dataList.add(ea);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release();
        }
        return result;
    }

    @Override
    public boolean remove(Object o) {
        boolean result = false;
        try {
            semaphore.acquire();
            result = dataList.remove(o);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release();
        }
        return result;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        boolean result = false;
        try {
            semaphore.acquire();
            result = dataList.containsAll(c);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release();
        }
        return result;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        boolean result = false;
        try {
            semaphore.acquire();
            result = dataList.addAll(c);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release();
        }
        return result;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        boolean result = false;
        try {
            semaphore.acquire();
            result = dataList.retainAll(c);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release();
        }
        return result;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        boolean result = false;
        try {
            semaphore.acquire();
            result = dataList.removeAll(c);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release();
        }
        return result;
    }

    @Override
    public void clear() {
        try {
            semaphore.acquire();
            dataList.clear();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release();
        }
    }
}
