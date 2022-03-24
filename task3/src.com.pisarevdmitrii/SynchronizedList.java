import java.util.*;
import java.util.concurrent.Semaphore;

public class SynchronizedList<E> implements List<E> {
    List<E> dataList = new ArrayList<>();

    @Override
    synchronized public int size() {
        return dataList.size();
    }

    @Override
    synchronized public boolean isEmpty() {
        return dataList.isEmpty();
    }

    @Override
    synchronized public boolean contains(Object o) {
        return dataList.contains(o);
    }

    @Override
    synchronized public Iterator<E> iterator() {
        return dataList.iterator();
    }

    @Override
    synchronized public Object[] toArray() {
        return dataList.toArray();
    }

    @Override
    synchronized public <T> T[] toArray(T[] a) {
        return dataList.toArray(a);
    }

    @Override
    synchronized public boolean add(E e) {
        return dataList.add(e);
    }

    @Override
    synchronized public boolean remove(Object o) {
        return dataList.remove(o);
    }

    @Override
    synchronized public boolean containsAll(Collection<?> c) {
        return dataList.containsAll(c);
    }

    @Override
    synchronized public boolean addAll(Collection<? extends E> c) {
        return dataList.addAll(c);
    }

    @Override
    synchronized public boolean addAll(int index, Collection<? extends E> c) {
        return dataList.addAll(index, c);
    }

    @Override
    synchronized public boolean removeAll(Collection<?> c) {
        return dataList.removeAll(c);
    }

    @Override
    synchronized public boolean retainAll(Collection<?> c) {
        return dataList.retainAll(c);
    }

    @Override
    synchronized public void clear() {
        dataList.clear();
    }

    @Override
    synchronized public E get(int index) {
        return dataList.get(index);
    }

    @Override
    synchronized public E set(int index, E element) {
        return dataList.set(index, element);
    }

    @Override
    synchronized public void add(int index, E element) {
        dataList.set(index, element);
    }

    @Override
    synchronized public E remove(int index) {
        return dataList.remove(index);
    }

    @Override
    synchronized public int indexOf(Object o) {
        return dataList.indexOf(o);
    }

    @Override
    synchronized public int lastIndexOf(Object o) {
        return dataList.lastIndexOf(o);
    }

    @Override
    synchronized public ListIterator<E> listIterator() {
        return dataList.listIterator();
    }

    @Override
    synchronized public ListIterator<E> listIterator(int index) {
        return dataList.listIterator(index);
    }

    @Override
    synchronized public List<E> subList(int fromIndex, int toIndex) {
        return dataList.subList(fromIndex, toIndex);
    }
}
