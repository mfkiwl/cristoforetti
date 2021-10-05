package com.github.giulioscattolin.collection;

import java.util.Collection;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;

public abstract class CollectionProxy<E> implements Collection<E> {
    protected abstract Collection<E> getCollection();

    @Override
    public int size() {return getCollection().size();}

    @Override
    public boolean isEmpty() {return getCollection().isEmpty();}

    @Override
    public boolean contains(Object o) {return getCollection().contains(o);}

    @Override
    public Iterator<E> iterator() {return getCollection().iterator();}

    @Override
    public Object[] toArray() {return getCollection().toArray();}

    @Override
    public <T> T[] toArray(T[] a) {return getCollection().toArray(a);}

    @Override
    public boolean add(E e) {return getCollection().add(e);}

    @Override
    public boolean remove(Object o) {return getCollection().remove(o);}

    @Override
    public boolean containsAll(Collection<?> c) {return getCollection().containsAll(c);}

    @Override
    public boolean addAll(Collection<? extends E> c) {return getCollection().addAll(c);}

    @Override
    public boolean removeAll(Collection<?> c) {return getCollection().removeAll(c);}

    @Override
    public boolean removeIf(Predicate<? super E> filter) {return getCollection().removeIf(filter);}

    @Override
    public boolean retainAll(Collection<?> c) {return getCollection().retainAll(c);}

    @Override
    public void clear() {getCollection().clear();}

    @Override
    public boolean equals(Object o) {return getCollection().equals(o);}

    @Override
    public int hashCode() {return getCollection().hashCode();}

    @Override
    public Spliterator<E> spliterator() {return getCollection().spliterator();}

    @Override
    public Stream<E> stream() {return getCollection().stream();}

    @Override
    public Stream<E> parallelStream() {return getCollection().parallelStream();}

    @Override
    public void forEach(Consumer<? super E> action) {getCollection().forEach(action);}
}
