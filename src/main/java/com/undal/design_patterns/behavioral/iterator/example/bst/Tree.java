package com.undal.design_patterns.behavioral.iterator.example.bst;

import java.util.*;

public interface Tree<E> extends Collection<E> {
    public abstract Iterator<E> iterator();
    boolean search(E e);

    boolean insert(E e);

    boolean delete(E e);

    default void inorder() {
    }



    default void preorder() {
    }

    ;

    default void postorder() {
    }

    ;

    public int getSize();

    default boolean isEmpty() {
        return size() == 0;
    }

    @Override
    default boolean contains(Object o) {
        return search((E) o);
    }
    void clear();

    /******@OVERRIDE METHODS******/

    @Override
   default Object[] toArray(){
        Object[] objects = new Object[size()];
        Iterator<E> it= iterator();
        for (int i = 0; i<objects.length; i++) {
            if(!it.hasNext()){
                return Arrays.copyOf(objects, i);
            }
            objects[i] = it.next();
        }
        return it.hasNext() ? finisToArray(objects, it) : objects;
    }

    private static <T>T[] finisToArray(T[] objects, Iterator<?> it){
        int len = objects.length;
        int i = len;
        while(it.hasNext()){
            if(i == len){
                len = Util.newLength(len,
                        1,
                        (len >> 1 ) + 1);
                objects = Arrays.copyOf(objects, len);
            }
            objects[i++] = (T)it.next();
        }
        return (i == len) ? objects : Arrays.copyOf(objects, i);
    };

    @Override
     default <T> T[] toArray(T[] a){
        int size =size();
        T[] r = a.length >= size ? a : (T[])java.lang.reflect.Array.newInstance(a.getClass().getComponentType(), size);
        Iterator<E> it = iterator();

        for (int i = 0; i < r.length; i++) {
            if(! it.hasNext()){
                if( a == r){
                    r[i] = null;
                } else if(a.length < i){
                    return Arrays.copyOf(r, i);
                } else{
                    System.arraycopy(r, 0, a, 0, i);
                    if(a.length > i){
                        a[i] = null;
                    }
                }
                return a;
            }
            r[i] = (T)it.next();
        }
        return it.hasNext() ? finisToArray(r, it) : r;
    };

    @Override
    default boolean add(E e) {
        return insert(e);
    }



    @Override
    default boolean remove(Object o){
        return delete((E) o);
    };

    @Override
    default boolean containsAll(Collection<?> c){
        for (Object o: c
             ) {
            if(!contains(o)) return false;
        }
        return true;
    }

    @Override
    default boolean addAll(Collection<? extends E> c){
        boolean modified = false;
        for (E o: c
             ) {
            if(add(o)) modified = true;
        }
        return modified;
    }
    @Override
    default boolean removeAll(Collection<?> c){
        Objects.requireNonNull(c);
        boolean modified = false;
        Iterator<?> it = iterator();
        while(it.hasNext()){
            if(c.contains(it.next())){
                it.remove();
                modified = true;
            }
        }
        return modified;
    };

    @Override
   default boolean retainAll(Collection<?> c){
        Objects.requireNonNull(c);
        boolean modified = false;
        Iterator<?> it = iterator();
        while(it.hasNext()){
            if(!c.contains(it.next())){
                it.remove();
                modified = true;
            }
        }
        return modified;
    }
}
