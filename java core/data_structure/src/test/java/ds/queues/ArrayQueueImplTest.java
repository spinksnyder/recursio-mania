package ds.queues;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

class ArrayQueueImplTest {

    @Test
    void add_elements_successful(){
        IQueue<Integer> integerIQueue = new ArrayQueueImpl<>(10);
        for(int i=0; i<9; i++){
            integerIQueue.add(i);
        }
        Assertions.assertNotNull(integerIQueue);
        Assertions.assertEquals(9,integerIQueue.size());
    }

    @Test
    void add_elements_resized_array_successful(){
        IQueue<Integer> integerIQueue = new ArrayQueueImpl<>(10);
        for(int i=0; i<19; i++){
            integerIQueue.add(i);
        }
        Assertions.assertNotNull(integerIQueue);
        Assertions.assertEquals(19,integerIQueue.size());
    }

    @Test
    void test_1_remove_elements_successful(){
        IQueue<Integer> integerIQueue = new ArrayQueueImpl<>(10);
        for(int i=0; i<9; i++){
            integerIQueue.add(i);
        }
        for(int i=0; i<8; i++){
            integerIQueue.remove();
        }
        Assertions.assertNotNull(integerIQueue);
        Assertions.assertEquals(1,integerIQueue.size());
    }

    @Test
    void test_2_remove_elements_successful(){
        IQueue<Integer> integerIQueue = new ArrayQueueImpl<>(10);
        for(int i=0; i<1000000; i++){
            integerIQueue.add(i);
        }
        for(int i=0; i<8; i++){
            integerIQueue.remove();
        }
        Assertions.assertNotNull(integerIQueue);
        Assertions.assertEquals(999992,integerIQueue.size());
    }

    @Test
    void remove_NoSuchElementException_successful(){
        IQueue<Integer> integerIQueue = new ArrayQueueImpl<>(10);
        Assertions.assertThrows(NoSuchElementException.class,integerIQueue::remove);
    }

    @Test
    void peek_successful(){
        IQueue<Integer> integerIQueue = new ArrayQueueImpl<>(10);
        for(int i=0; i<1000000; i++){
            integerIQueue.add(i);
        }
        Assertions.assertEquals(0,integerIQueue.peek());
        Assertions.assertEquals(1000000,integerIQueue.size());
    }

    @Test
    void peek_EmptyQueue_NoSuchElementException_successful(){
        IQueue<Integer> integerIQueue = new ArrayQueueImpl<>(10);
        Assertions.assertThrows(NoSuchElementException.class,integerIQueue::peek);
    }

    @Test
    void isEmpty_true_successful(){
        IQueue<Integer> integerIQueue = new ArrayQueueImpl<>(10);
        Assertions.assertTrue(integerIQueue.isEmpty());
    }

    @Test
    void isEmpty_nonEmptyQueue_False_successful(){
        IQueue<Integer> integerIQueue = new ArrayQueueImpl<>(10);
        integerIQueue.add(1);
        Assertions.assertFalse(integerIQueue.isEmpty());
    }

}
