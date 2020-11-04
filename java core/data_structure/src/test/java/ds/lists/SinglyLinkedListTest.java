package ds.lists;

import ds.helper.Student;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SinglyLinkedListTest {

    @Test
    void add_elements_to_beginning_successful(){
        IList<Student> studentList = new SinglyLinkedList<>(new Student("John Doe",28,"USA"));
        studentList.add(new Student("Steve wolf",30,"Canada"));
        studentList.add(new Student("Heath Ledger",45,"Poland"));
        Assertions.assertEquals(3,studentList.size());
    }

    @Test
    void remove_element_from_beginning_successful(){
        Student john = new Student("John Doe", 28, "USA");
        Student steve = new Student("Steve wolf", 30, "Canada");
        Student heath = new Student("Heath Ledger", 45, "Poland");
        IList<Student> studentList = new SinglyLinkedList<>(john);
        studentList.add(steve);
        studentList.add(heath);
        boolean isRemoved = studentList.remove();
        Assertions.assertEquals(2,studentList.size());
        Assertions.assertTrue(isRemoved);
    }

    @Test
    void isEmpty_true_successful(){
        Student john = new Student("John Doe", 28, "USA");
        Student steve = new Student("Steve wolf", 30, "Canada");
        Student heath = new Student("Heath Ledger", 45, "Poland");
        IList<Student> studentList = new SinglyLinkedList<>(john);
        studentList.add(steve);
        studentList.add(heath);
        studentList.remove();
        studentList.remove();
        studentList.remove();
        Assertions.assertTrue(studentList.isEmpty());
    }

    @Test
    void isEmpty_false_successful(){
        Student john = new Student("John Doe", 28, "USA");
        Student steve = new Student("Steve wolf", 30, "Canada");
        Student heath = new Student("Heath Ledger", 45, "Poland");
        IList<Student> studentList = new SinglyLinkedList<>(john);
        studentList.add(steve);
        studentList.add(heath);
        Assertions.assertFalse(studentList.isEmpty());
        Assertions.assertEquals(3,studentList.size());
    }
}
