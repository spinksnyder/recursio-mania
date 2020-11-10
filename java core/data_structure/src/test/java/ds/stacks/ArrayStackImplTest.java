package ds.stacks;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.EmptyStackException;

class ArrayStackImplTest {

    @Test
    void push_int_array_resized_successful(){
        IStack<Integer> integerIStack = new ArrayStackImpl<>(10);
        for(int i = 0; i < 20; i++){
            integerIStack.push(i);
        }
        Assertions.assertEquals(20, integerIStack.size());
        Assertions.assertNotNull(integerIStack);
    }

    @Test
    void pop_successful(){
        IStack<Integer> integerIStack = new ArrayStackImpl<>(10);
        for(int i = 0; i < 20; i++){
            integerIStack.push(i);
        }
        Integer result = integerIStack.pop();
        Assertions.assertEquals(19, integerIStack.size());
        Assertions.assertEquals(19, result);
        Assertions.assertNotNull(integerIStack);
    }


    @Test
    void pop_empty_stack_Exception_successful(){
        IStack<Integer> integerIStack = new ArrayStackImpl<>(0);
        Assertions.assertThrows(EmptyStackException.class, integerIStack::pop);
    }

    @Test
    void peek_successful(){
        IStack<Integer> integerIStack = new ArrayStackImpl<>(10);
        for(int i = 0; i < 20; i++){
            integerIStack.push(i);
        }
        Integer result = integerIStack.peek();
        Assertions.assertEquals(20, integerIStack.size());
        Assertions.assertEquals(19, result);
        Assertions.assertNotNull(integerIStack);
    }

    @Test
    void peek_empty_stack_Exception_successful(){
        IStack<Integer> integerIStack = new ArrayStackImpl<>(0);
        Assertions.assertThrows(EmptyStackException.class, integerIStack::peek);
    }
}
