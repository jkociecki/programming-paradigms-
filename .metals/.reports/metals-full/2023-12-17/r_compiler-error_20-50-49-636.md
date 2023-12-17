file:///C:/OCaml64/home/Flex5IIL/ocaml_projects/cwiczenia/cw08/Queue.java
### java.util.NoSuchElementException: next on empty iterator

occurred in the presentation compiler.

action parameters:
offset: 541
uri: file:///C:/OCaml64/home/Flex5IIL/ocaml_projects/cwiczenia/cw08/Queue.java
text:
```scala
package cw08;

import java.util.ArrayList;

public class Queue<E> implements MyQueue<E>
{
    private final ArrayList<E> queue;
    private int front = 0, rear = 0;
    public Queue(int size)
    {
        queue = new ArrayList<>(size + 1);
        for(int i = 0; i <= size; i++)
        {
            queue.add(i, null);
        }

    }
    @Override
    public void enqueue(E x) throws FullException
    {
        if(isFull()) throw new FullException("Queue is full");
        else
        {
            queue.set(rear, x);
            re@@ar = (rear + 1) % queue.size();
        }
    }

    @Override
    public void dequeue()
    {
        if(!isEmpty())
        {
            queue.set(front, null);
            front = (front + 1) % queue.size();
        }
    }

    @Override
    public E first() throws EmptyException
    {
        if(isEmpty()) throw new EmptyException("Queue is empty");
        else return queue.get(front);
    }

    @Override
    public boolean isEmpty() {
        return front == rear;
    }

    @Override
    public boolean isFull() {
        return (rear + 1) % queue.size() == front;
    }

    public static void main(String[] args) throws FullException, EmptyException
    {
    MyQueue<String> q = new Queue<String>(3);
    q.enqueue("1");
    q.enqueue("2");
    q.enqueue("3");
    System.out.println(q.first());
    q.dequeue();
    q.enqueue("4");
    System.out.println(q.first());
    q.dequeue();
    q.enqueue("5");
    q.dequeue();
    q.enqueue("6");
    System.out.println(q.first());
    q.dequeue();
    q.dequeue();
    System.out.println(q.first());
    }

}


```



#### Error stacktrace:

```
scala.collection.Iterator$$anon$19.next(Iterator.scala:973)
	scala.collection.Iterator$$anon$19.next(Iterator.scala:971)
	scala.collection.mutable.MutationTracker$CheckedIterator.next(MutationTracker.scala:76)
	scala.collection.IterableOps.head(Iterable.scala:222)
	scala.collection.IterableOps.head$(Iterable.scala:222)
	scala.collection.AbstractIterable.head(Iterable.scala:933)
	dotty.tools.dotc.interactive.InteractiveDriver.run(InteractiveDriver.scala:168)
	scala.meta.internal.pc.MetalsDriver.run(MetalsDriver.scala:45)
	scala.meta.internal.pc.HoverProvider$.hover(HoverProvider.scala:34)
	scala.meta.internal.pc.ScalaPresentationCompiler.hover$$anonfun$1(ScalaPresentationCompiler.scala:342)
```
#### Short summary: 

java.util.NoSuchElementException: next on empty iterator