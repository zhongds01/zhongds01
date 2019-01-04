package com.ai.sacenter.util;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Resizable-array implementation of the {@link Deque} interface.  Array
 * deques have no capacity restrictions; they grow as necessary to support
 * usage.  They are not thread-safe; in the absence of external
 * synchronization, they do not support concurrent access by multiple threads.
 * Null elements are prohibited.  This class is likely to be faster than
 * {@link Stack} when used as a stack, and faster than {@link LinkedList}
 * when used as a queue.
 *
 * <p>Most <tt>ArrayDeque</tt> operations run in amortized constant time.
 * Exceptions include {@link #remove(Object) remove}, {@link
 * #removeHeadOccurrence removeHeadOccurrence}, {@link #removeTailOccurrence
 * removeTailOccurrence}, {@link #contains contains}, {@link #iterator
 * iterator.remove()}, and the bulk operations, all of which run in linear
 * time.
 *
 * <p>The iterators returned by this class's <tt>iterator</tt> method are
 * <i>fail-fast</i>: If the deque is modified at any time after the iterator
 * is created, in any way except through the iterator's own <tt>remove</tt>
 * method, the iterator will generally throw a {@link
 * ConcurrentModificationException}.  Thus, in the face of concurrent
 * modification, the iterator fails quickly and cleanly, rather than risking
 * arbitrary, non-deterministic behavior at an undetermined time in the
 * future.
 *
 * <p>Note that the fail-fast behavior of an iterator cannot be guaranteed
 * as it is, generally speaking, impossible to make any hard guarantees in the
 * presence of unsynchronized concurrent modification.  Fail-fast iterators
 * throw <tt>ConcurrentModificationException</tt> on a best-effort basis.
 * Therefore, it would be wrong to write a program that depended on this
 * exception for its correctness: <i>the fail-fast behavior of iterators
 * should be used only to detect bugs.</i>
 *
 * <p>This class and its iterator implement all of the
 * <em>optional</em> methods of the {@link Collection} and {@link
 * Iterator} interfaces.
 *
 * <p>This class is a member of the
 * <a href="{@docRoot}/../technotes/guides/collections/index.html">
 * Java Collections Framework</a>.
 *
 * @author  Josh Bloch and Doug Lea
 * @since   1.6
 * @param <E> the type of elements held in this collection
 */
public class ArrayDeque extends AbstractCollection implements Deque, Cloneable,
		Serializable {
	private static final long serialVersionUID = -571719727074277369L;

	/**
	 * The array in which the elements of the deque are stored. The capacity of
	 * the deque is the length of this array, which is always a power of two.
	 * The array is never allowed to become full, except transiently within an
	 * addX method where it is resized (see doubleCapacity) immediately upon
	 * becoming full, thus avoiding head and tail wrapping around to equal each
	 * other. We also guarantee that all array cells not holding deque elements
	 * are always null.
	 */
	private transient Object[] elements;

	/**
	 * The index of the element at the head of the deque (which is the element
	 * that would be removed by remove() or pop()); or an arbitrary number equal
	 * to tail if the deque is empty.
	 */
	private transient int head;

	/**
	 * The index at which the next element would be added to the tail of the
	 * deque (via addTail(E), add(E), or push(E)).
	 */
	private transient int tail;

	/**
	 * The minimum capacity that we'll use for a newly created deque. Must be a
	 * power of 2.
	 */
	private static final int MIN_INITIAL_CAPACITY = 8;

	public ArrayDeque() {
		super();
		elements = (Object[]) new Object[16];
	}

	/**
	 * Allocate empty array to hold the given number of elements.
	 * 
	 * @param numElements
	 *            the number of elements to hold
	 */
	private void allocateElements(int numElements) {
		int initialCapacity = MIN_INITIAL_CAPACITY;
		if (numElements >= initialCapacity) {
			initialCapacity = numElements;
			initialCapacity |= (initialCapacity >>> 1);
			initialCapacity |= (initialCapacity >>> 2);
			initialCapacity |= (initialCapacity >>> 4);
			initialCapacity |= (initialCapacity >>> 8);
			initialCapacity |= (initialCapacity >>> 16);
			initialCapacity++;

			if (initialCapacity < 0)
				initialCapacity >>>= 1;
		}
		elements = (Object[]) new Object[initialCapacity];
	}

	/**
	 * Double the capacity of this deque. Call only when full, i.e., when head
	 * and tail have wrapped around to become equal.
	 */
	private void doubleCapacity() {
		assert head == tail;
		int p = head;
		int n = elements.length;
		int r = n - p; // number of elements to the right of p
		int newCapacity = n << 1;
		if (newCapacity < 0)
			throw new IllegalStateException("deque too big");
		Object[] a = new Object[newCapacity];
		System.arraycopy(elements, p, a, 0, r);
		System.arraycopy(elements, 0, a, r, p);
		elements = (Object[]) a;
		head = 0;
		tail = n;
	}

	/**
	 * Copies the elements from our element array into the specified array, in
	 * order (from first to last element in the deque). It is assumed that the
	 * array is large enough to hold all elements in the deque.
	 * 
	 * @return its argument
	 */
	private Object[] copyElements(Object[] a) {
		if (head < tail) {
			System.arraycopy(elements, head, a, 0, size());
		} else if (head > tail) {
			int headPortionLen = elements.length - head;
			System.arraycopy(elements, head, a, 0, headPortionLen);
			System.arraycopy(elements, 0, a, headPortionLen, tail);
		}
		return a;
	}

	/**
	 * Inserts the specified element at the front of this deque.
	 * 
	 * @param e
	 *            the element to add
	 * @throws NullPointerException
	 *             if the specified element is null
	 */
	public void addHead(Object element) {
		if (element == null)
			throw new NullPointerException();
		elements[head = (head - 1) & (elements.length - 1)] = element;
		if (head == tail)
			doubleCapacity();
	}

	/**
	 * Inserts the specified element at the end of this deque.
	 * 
	 * <p>
	 * This method is equivalent to {@link #add}.
	 * 
	 * @param e
	 *            the element to add
	 * @throws NullPointerException
	 *             if the specified element is null
	 */
	public void addTail(Object element) {
		if (element == null)
			throw new NullPointerException();
		elements[tail] = element;
		if ((tail = (tail + 1) & (elements.length - 1)) == head)
			doubleCapacity();
	}

	/**
	 * @throws NoSuchElementException
	 *             {@inheritDoc}
	 */
	public Object removeHead() {
		Object x = pollHead();
		if (x == null)
			throw new NoSuchElementException();
		return x;
	}

	/**
	 * @throws NoSuchElementException
	 *             {@inheritDoc}
	 */
	public Object removeTail() {
		Object x = pollTail();
		if (x == null)
			throw new NoSuchElementException();
		return x;
	}

	/**
	 * @throws NoSuchElementException
	 *             {@inheritDoc}
	 */
	public Object getHead() {
		Object x = peekHead();
		if (x == null)
			throw new NoSuchElementException();
		return x;
	}

	/**
	 * @throws NoSuchElementException
	 *             {@inheritDoc}
	 */
	public Object getTail() {
		Object x = peekTail();
		if (x == null)
			throw new NoSuchElementException();
		return x;
	}

	/**
	 * 
	 * @return
	 */
	private Object pollHead() {
		int h = head;
		Object result = elements[h]; // Element is null if deque empty
		if (result == null)
			return null;
		elements[h] = null; // Must null out slot
		head = (h + 1) & (elements.length - 1);
		return result;
	}

	/**
	 * 
	 * @return
	 */
	private Object pollTail() {
		int t = (tail - 1) & (elements.length - 1);
		Object result = elements[t];
		if (result == null)
			return null;
		elements[t] = null;
		tail = t;
		return result;
	}

	/**
	 * 
	 * @return
	 */
	public Object peekHead() {
		return elements[head]; // elements[head] is null if deque empty
	}

	/**
	 * 
	 * @return
	 */
	public Object peekTail() {
		return elements[(tail - 1) & (elements.length - 1)];
	}

	/**
	 * Inserts the specified element at the end of this deque.
	 * 
	 * @param element
	 *            the element to add
	 * @return <tt>true</tt> (as specified by {@link Deque#offerTail})
	 * @throws NullPointerException
	 *             if the specified element is null
	 */
	private boolean offerTail(Object element) {
		addTail(element);
		return true;
	}

	/**
	 * Removes the first occurrence of the specified element in this deque (when
	 * traversing the deque from head to tail). If the deque does not contain
	 * the element, it is unchanged. More formally, removes the first element
	 * <tt>e</tt> such that <tt>o.equals(e)</tt> (if such an element
	 * exists). Returns <tt>true</tt> if this deque contained the specified
	 * element (or equivalently, if this deque changed as a result of the call).
	 * 
	 * @param o
	 *            element to be removed from this deque, if present
	 * @return <tt>true</tt> if the deque contained the specified element
	 */
	private boolean removeHeadOccurrence(Object o) {
		if (o == null)
			return false;
		int mask = elements.length - 1;
		int i = head;
		Object x;
		while ((x = elements[i]) != null) {
			if (o.equals(x)) {
				delete(i);
				return true;
			}
			i = (i + 1) & mask;
		}
		return false;
	}

	/**
	 * Removes the element at the specified position in the elements array,
	 * adjusting head and tail as necessary. This can result in motion of
	 * elements backwards or forwards in the array.
	 * 
	 * <p>
	 * This method is called delete rather than remove to emphasize that its
	 * semantics differ from those of {@link List#remove(int)}.
	 * 
	 * @return true if elements moved backwards
	 */
	private boolean delete(int i) {
		checkInvariants();
		final Object[] elements = this.elements;
		final int mask = elements.length - 1;
		final int h = head;
		final int t = tail;
		final int front = (i - h) & mask;
		final int back = (t - i) & mask;

		// Invariant: head <= i < tail mod circularity
		if (front >= ((t - h) & mask))
			throw new ConcurrentModificationException();

		// Optimize for least element motion
		if (front < back) {
			if (h <= i) {
				System.arraycopy(elements, h, elements, h + 1, front);
			} else { // Wrap around
				System.arraycopy(elements, 0, elements, 1, i);
				elements[0] = elements[mask];
				System.arraycopy(elements, h, elements, h + 1, mask - h);
			}
			elements[h] = null;
			head = (h + 1) & mask;
			return false;
		} else {
			if (i < t) { // Copy the null tail as well
				System.arraycopy(elements, i + 1, elements, i, back);
				tail = t - 1;
			} else { // Wrap around
				System.arraycopy(elements, i + 1, elements, i, mask - i);
				elements[mask] = elements[0];
				System.arraycopy(elements, 1, elements, 0, t);
				tail = (t - 1) & mask;
			}
			return true;
		}
	}

	private void checkInvariants() {
		assert elements[tail] == null;
		assert head == tail ? elements[head] == null
				: (elements[head] != null && elements[(tail - 1)
						& (elements.length - 1)] != null);
		assert elements[(head - 1) & (elements.length - 1)] == null;
	}

	/**
	 * Inserts the specified element at the end of this deque.
	 * 
	 * <p>
	 * This method is equivalent to {@link #addTail}.
	 * 
	 * @param element
	 *            the element to add
	 * @return <tt>true</tt> (as specified by {@link Collection#add})
	 * @throws NullPointerException
	 *             if the specified element is null
	 */
	public boolean add(Object element) {
		addTail(element);
		return true;
	}

	/**
	 * Inserts the specified element at the end of this deque.
	 * 
	 * <p>
	 * This method is equivalent to {@link #offerTail}.
	 * 
	 * @param e
	 *            the element to add
	 * @return <tt>true</tt> (as specified by {@link Queue#offer})
	 * @throws NullPointerException
	 *             if the specified element is null
	 */
	public boolean offer(Object e) {
		return offerTail(e);
	}

	/**
	 * Retrieves and removes the head of the queue represented by this deque.
	 * 
	 * This method differs from {@link #poll poll} only in that it throws an
	 * exception if this deque is empty.
	 * 
	 * <p>
	 * This method is equivalent to {@link #removeHead}.
	 * 
	 * @return the head of the queue represented by this deque
	 * @throws NoSuchElementException
	 *             {@inheritDoc}
	 */
	public Object remove() {
		return removeHead();
	}

	/**
	 * Retrieves and removes the head of the queue represented by this deque (in
	 * other words, the first element of this deque), or returns <tt>null</tt>
	 * if this deque is empty.
	 * 
	 * <p>
	 * This method is equivalent to {@link #pollHead}.
	 * 
	 * @return the head of the queue represented by this deque, or <tt>null</tt>
	 *         if this deque is empty
	 */
	public Object poll() {
		return pollHead();
	}

	/**
	 * Retrieves, but does not remove, the head of the queue represented by this
	 * deque. This method differs from {@link #peek peek} only in that it throws
	 * an exception if this deque is empty.
	 * 
	 * <p>
	 * This method is equivalent to {@link #getHead}.
	 * 
	 * @return the head of the queue represented by this deque
	 * @throws NoSuchElementException
	 *             {@inheritDoc}
	 */
	public Object element() {
		return getHead();
	}

	/**
	 * Retrieves, but does not remove, the head of the queue represented by this
	 * deque, or returns <tt>null</tt> if this deque is empty.
	 * 
	 * <p>
	 * This method is equivalent to {@link #peekHead}.
	 * 
	 * @return the head of the queue represented by this deque, or <tt>null</tt>
	 *         if this deque is empty
	 */
	public Object peek() {
		return peekHead();
	}

	/**
	 * Pushes an element onto the stack represented by this deque. In other
	 * words, inserts the element at the front of this deque.
	 * 
	 * <p>
	 * This method is equivalent to {@link #addHead}.
	 * 
	 * @param e
	 *            the element to push
	 * @throws NullPointerException
	 *             if the specified element is null
	 */
	public void push(Object e) {
		addHead(e);
	}

	/**
	 * Pops an element from the stack represented by this deque. In other words,
	 * removes and returns the first element of this deque.
	 * 
	 * <p>
	 * This method is equivalent to {@link #removeHead()}.
	 * 
	 * @return the element at the front of this deque (which is the top of the
	 *         stack represented by this deque)
	 * @throws NoSuchElementException
	 *             {@inheritDoc}
	 */
	public Object pop() {
		return removeHead();
	}

	/**
	 * Returns the number of elements in this deque.
	 * 
	 * @return the number of elements in this deque
	 */
	public int size() {
		return (tail - head) & (elements.length - 1);
	}

	/**
	 * Returns <tt>true</tt> if this deque contains no elements.
	 * 
	 * @return <tt>true</tt> if this deque contains no elements
	 */
	public boolean isEmpty() {
		return head == tail;
	}

	/**
     * Returns an iterator over the elements in this deque in proper sequence.
     * The elements will be returned in order from first (tail) to last (head).
     *
     * @return an iterator over the elements in this deque in proper sequence
     */
	public Iterator iterator() {
		return new TailIterator();
	}
	/**
     * Returns an iterator over the elements in this deque in reverse
     * sequential order.  The elements will be returned in order from
     * last (head) to first (tail).
     *
     * @return an iterator over the elements in this deque in reverse
     * sequence
     */
	public Iterator descendingIterator() {
		return new HeadIterator();
	}

	private class HeadIterator implements Iterator {
		/**
		 * Index of element to be returned by subsequent call to next.
		 */
		private int cursor = head;

		/**
		 * Tail recorded at construction (also in remove), to stop iterator and
		 * also to check for comodification.
		 */
		private int fence = tail;

		/**
		 * Index of element returned by most recent call to next. Reset to -1 if
		 * element is deleted by a call to remove.
		 */
		private int lastRet = -1;

		public boolean hasNext() {
			return cursor != fence;
		}

		public Object next() {
			if (cursor == fence)
				throw new NullPointerException();
			Object result = elements[cursor];
			// This check doesn't catch all possible comodifications,
			// but does catch the ones that corrupt traversal
			if (tail != fence || result == null)
				throw new ConcurrentModificationException();
			lastRet = cursor;
			cursor = (cursor + 1) & (elements.length - 1);
			return result;
		}

		public void remove() {
			if (lastRet < 0)
				throw new IllegalStateException();
			if (delete(lastRet)) { // if left-shifted, undo increment in next()
				cursor = (cursor - 1) & (elements.length - 1);
				fence = tail;
			}
			lastRet = -1;
		}
	}

	private class TailIterator implements Iterator {
		/**
		 * Index of element to be returned by subsequent call to next.
		 */
		private int cursor = tail;

		/**
		 * Tail recorded at construction (also in remove), to stop iterator and
		 * also to check for comodification.
		 */
		private int fence = head;

		/**
		 * Index of element returned by most recent call to next. Reset to -1 if
		 * element is deleted by a call to remove.
		 */
		private int lastRet = -1;

		public boolean hasNext() {
			return cursor != fence;
		}

		public Object next() {
			if (cursor == fence)
				throw new NullPointerException();
			cursor = (cursor - 1) & (elements.length - 1);
			Object result = elements[cursor];
			if (head != fence || result == null)
				throw new ConcurrentModificationException();
			return result;
		}

		public void remove() {
			if (lastRet < 0)
				throw new IllegalStateException();
			if (!delete(lastRet)) {
				cursor = (cursor + 1) & (elements.length - 1);
				fence = head;
			}
			lastRet = -1;
		}
	}

	/**
	 * Returns <tt>true</tt> if this deque contains the specified element.
	 * More formally, returns <tt>true</tt> if and only if this deque contains
	 * at least one element <tt>e</tt> such that <tt>o.equals(e)</tt>.
	 * 
	 * @param o
	 *            object to be checked for containment in this deque
	 * @return <tt>true</tt> if this deque contains the specified element
	 */
	public boolean contains(Object o) {
		if (o == null)
			return false;
		int mask = elements.length - 1;
		int i = head;
		Object x;
		while ((x = elements[i]) != null) {
			if (o.equals(x))
				return true;
			i = (i + 1) & mask;
		}
		return false;
	}

	/**
	 * Removes a single instance of the specified element from this deque. If
	 * the deque does not contain the element, it is unchanged. More formally,
	 * removes the first element <tt>e</tt> such that <tt>o.equals(e)</tt>
	 * (if such an element exists). Returns <tt>true</tt> if this deque
	 * contained the specified element (or equivalently, if this deque changed
	 * as a result of the call).
	 * 
	 * <p>
	 * This method is equivalent to {@link #removeHeadOccurrence}.
	 * 
	 * @param o
	 *            element to be removed from this deque, if present
	 * @return <tt>true</tt> if this deque contained the specified element
	 */
	public boolean remove(Object o) {
		return removeHeadOccurrence(o);
	}

	/**
	 * Removes all of the elements from this deque. The deque will be empty
	 * after this call returns.
	 */
	public void clear() {
		int h = head;
		int t = tail;
		if (h != t) { // clear all cells
			head = tail = 0;
			int i = h;
			int mask = elements.length - 1;
			do {
				elements[i] = null;
				i = (i + 1) & mask;
			} while (i != t);
		}
	}

	/**
	 * Returns an array containing all of the elements in this deque in proper
	 * sequence (from first to last element).
	 * 
	 * <p>
	 * The returned array will be "safe" in that no references to it are
	 * maintained by this deque. (In other words, this method must allocate a
	 * new array). The caller is thus free to modify the returned array.
	 * 
	 * <p>
	 * This method acts as bridge between array-based and collection-based APIs.
	 * 
	 * @return an array containing all of the elements in this deque
	 */
	public Object[] toArray() {
		return copyElements(new Object[size()]);
	}

	/**
	 * Returns an array containing all of the elements in this deque in proper
	 * sequence (from first to last element); the runtime type of the returned
	 * array is that of the specified array. If the deque fits in the specified
	 * array, it is returned therein. Otherwise, a new array is allocated with
	 * the runtime type of the specified array and the size of this deque.
	 * 
	 * <p>
	 * If this deque fits in the specified array with room to spare (i.e., the
	 * array has more elements than this deque), the element in the array
	 * immediately following the end of the deque is set to <tt>null</tt>.
	 * 
	 * <p>
	 * Like the {@link #toArray()} method, this method acts as bridge between
	 * array-based and collection-based APIs. Further, this method allows
	 * precise control over the runtime type of the output array, and may, under
	 * certain circumstances, be used to save allocation costs.
	 * 
	 * <p>
	 * Suppose <tt>x</tt> is a deque known to contain only strings. The
	 * following code can be used to dump the deque into a newly allocated array
	 * of <tt>String</tt>:
	 * 
	 * <pre>
	 * String[] y = x.toArray(new String[0]);
	 * </pre>
	 * 
	 * Note that <tt>toArray(new Object[0])</tt> is identical in function to
	 * <tt>toArray()</tt>.
	 * 
	 * @param a
	 *            the array into which the elements of the deque are to be
	 *            stored, if it is big enough; otherwise, a new array of the
	 *            same runtime type is allocated for this purpose
	 * @return an array containing all of the elements in this deque
	 * @throws ArrayStoreException
	 *             if the runtime type of the specified array is not a supertype
	 *             of the runtime type of every element in this deque
	 * @throws NullPointerException
	 *             if the specified array is null
	 */
	public Object[] toArray(Object[] a) {
		int size = size();
		if (a.length < size)
			a = (Object[]) java.lang.reflect.Array.newInstance(a.getClass()
					.getComponentType(), size);
		copyElements(a);
		if (a.length > size)
			a[size] = null;
		return a;
	}

	/**
	 * Returns a copy of this deque.
	 * 
	 * @return a copy of this deque
	 */
	public Object clone() {
		try {
			ArrayDeque result = (ArrayDeque) super.clone();
			result.elements = ClassUtils.IClass.arrayCopy(elements,
					elements.length);
			return result;

		} catch (CloneNotSupportedException e) {
			throw new AssertionError();
		}
	}

	/**
	 * Serialize this deque.
	 * 
	 * @serialData The current size (<tt>int</tt>) of the deque, followed by
	 *             all of its elements (each an object reference) in
	 *             first-to-last order.
	 */
	private void writeObject(ObjectOutputStream s) throws IOException {
		s.defaultWriteObject();

		// Write out size
		s.writeInt(size());

		// Write out elements in order.
		int mask = elements.length - 1;
		for (int i = head; i != tail; i = (i + 1) & mask)
			s.writeObject(elements[i]);
	}

	/**
	 * Deserialize this deque.
	 */
	private void readObject(ObjectInputStream s) throws IOException,
			ClassNotFoundException {
		s.defaultReadObject();

		// Read in size and allocate array
		int size = s.readInt();
		allocateElements(size);
		head = 0;
		tail = size;

		// Read in all elements in the proper order.
		for (int i = 0; i < size; i++)
			elements[i] = s.readObject();
	}
}
