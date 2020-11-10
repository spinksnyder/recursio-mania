package ds.stacks;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

class LinkedListStackTest {

    @Test
    void push_element_successful(){
        LinkedListStack<Integer> linkedListStack = new LinkedListStack<>();
        for(int i =0; i < 20; i++){
            linkedListStack.push(i);
        }
        Assertions.assertEquals(20,linkedListStack.size());
    }

    @Test
    void pop_element_successful(){
        LinkedListStack<Integer> linkedListStack = new LinkedListStack<>();
        for(int i =0; i < 20; i++){
            linkedListStack.push(i);
        }
        Assertions.assertEquals(19, linkedListStack.pop());
        Assertions.assertEquals(19,linkedListStack.size());
    }

    @Test
    void pop_element_empty_stack_successful(){
        LinkedListStack<Integer> linkedListStack = new LinkedListStack<>();
        Assertions.assertThrows(NoSuchElementException.class,linkedListStack::pop);
    }

    @Test
    void peek_element_successful(){
        LinkedListStack<Integer> linkedListStack = new LinkedListStack<>();
        for(int i =0; i < 20; i++){
            linkedListStack.push(i);
        }
        Assertions.assertEquals(19, linkedListStack.peek());
        Assertions.assertEquals(20,linkedListStack.size());
    }

    @Test
    void peek_element_empty_stack_successful(){
        LinkedListStack<Integer> linkedListStack = new LinkedListStack<>();
        Assertions.assertNull(linkedListStack.peek());
    }
}
