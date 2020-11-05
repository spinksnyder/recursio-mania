package ds.lists;

import ds.helper.Student;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SinglyLinkedListTest {

    private IList<Student> studentList;

    Student student = new Student("James Bond", 50, "United Kingdom");

    @BeforeEach
    void init() {
        studentList = new SinglyLinkedList<>(new Student("John Doe", 28, "USA"));
        studentList.add(new Student("Steve wolf", 30, "Canada"));
        studentList.add(new Student("Heath Ledger", 45, "Poland"));
    }

    @Test
    void add_elements_to_beginning_successful() {
        studentList.add(new Student("Munna Tripathi", 25, "India"));
        Assertions.assertEquals(4, studentList.size());
    }

    @Test
    void remove_element_from_beginning_successful() {
        boolean isRemoved = studentList.remove();
        Assertions.assertEquals(2, studentList.size());
        Assertions.assertTrue(isRemoved);
    }

    @Test
    void isEmpty_true_successful() {
        studentList.remove();
        studentList.remove();
        studentList.remove();
        Assertions.assertTrue(studentList.isEmpty());
    }

    @Test
    void isEmpty_false_successful() {
        Assertions.assertFalse(studentList.isEmpty());
        Assertions.assertEquals(3, studentList.size());
    }

    @Test
    void get_first_element_successful() {
        Student result = studentList.get();
        Assertions.assertEquals("Heath Ledger", result.getName());
        Assertions.assertEquals(45, result.getAge());
        Assertions.assertEquals("Poland", result.getCountry());
    }

    @Test
    void contains_element_True_successful() {
        Student student = new Student("Steve wolf", 30, "Canada");
        boolean result = studentList.contains(student);
        Assertions.assertTrue(result);
    }

    @Test
    void contains_NonExistingElement_False_successful() {
        Student student = new Student("Jack Sparrow", 36, "United Kingdom");
        boolean result = studentList.contains(student);
        Assertions.assertFalse(result);
    }

    @Test
    void traverse_successful() {
        studentList.traverse();
    }

    @Test
    void get_specific_element_successful() {
        studentList.add(student);
        studentList.add(new Student("Kalin Bhaiya", 47, "India"));
        studentList.add(new Student("Guddu Pandit", 27, "India"));
        studentList.add(new Student("Sweety Gupta", 25, "India"));
        studentList.add(new Student("Lala", 54, "India"));
        studentList.add(new Student("Guruji", 42, "India"));
        Student result = studentList.get(new Student(this.student.getName(), this.student.getAge(), this.student.getCountry()));
        boolean isSameReference = student == result;
        Assertions.assertEquals(student, result);
        Assertions.assertTrue(isSameReference);
    }

    @Test
    void get_NonExistingElement_False_successful() {
        studentList.add(new Student("Kalin Bhaiya", 47, "India"));
        studentList.add(new Student("Guddu Pandit", 27, "India"));
        studentList.add(new Student("Sweety Gupta", 25, "India"));
        studentList.add(new Student("Lala", 54, "India"));
        studentList.add(new Student("Guruji", 42, "India"));
        Student result = studentList.get(new Student(this.student.getName(), this.student.getAge(), this.student.getCountry()));
        Assertions.assertNull(result);
    }

    @Test
    void remove_specificElement_True_successful() {
        Student studentToBeRemoved = new Student("Guddu Pandit", 27, "India");
        studentList.add(new Student("Kalin Bhaiya", 47, "India"));
        studentList.add(studentToBeRemoved);
        studentList.add(new Student("Sweety Gupta", 25, "India"));
        studentList.add(new Student("Lala", 54, "India"));
        studentList.add(new Student("Guruji", 42, "India"));
        boolean isRemoved = studentList.remove(studentToBeRemoved);
        Assertions.assertTrue(isRemoved);
        Assertions.assertEquals(7, studentList.size());
        Assertions.assertFalse(studentList.contains(studentToBeRemoved));
    }

    @Test
    void remove_NonExistingElement_False_successful() {
        Student studentToBeRemoved = new Student("Guddu Pandit", 27, "India");
        studentList.add(new Student("Kalin Bhaiya", 47, "India"));
        studentList.add(new Student("Sweety Gupta", 25, "India"));
        studentList.add(new Student("Lala", 54, "India"));
        studentList.add(new Student("Guruji", 42, "India"));
        boolean isRemoved = studentList.remove(studentToBeRemoved);
        Assertions.assertFalse(isRemoved);
        Assertions.assertEquals(7, studentList.size());
    }

    @Test
    void addBefore_newElementToBeAdded_successful() {
        SinglyLinkedList<Student> studentList = new SinglyLinkedList<>(new Student("John Doe", 28, "USA"));
        studentList.add(new Student("Kalin Bhaiya", 47, "India"));
        studentList.add(new Student("Sweety Gupta", 25, "India"));
        studentList.add(new Student("Lala", 54, "India"));
        studentList.add(new Student("Guruji", 42, "India"));
        studentList.add(new Student("Steve wolf", 30, "Canada"));
        studentList.add(new Student("Heath Ledger", 45, "Poland"));

        boolean isAdded = studentList.addBefore(new Student("Inspector Morya", 42, "India"), new Student("Lala", 54, "India"));
        Assertions.assertEquals(8, studentList.size());
        Assertions.assertTrue(isAdded);
    }

    @Test
    void addBefore_newElementToBeAdded_Before_NonExistingElement_False_successful() {
        SinglyLinkedList<Student> studentList = new SinglyLinkedList<>(new Student("John Doe", 28, "USA"));
        studentList.add(new Student("Kalin Bhaiya", 47, "India"));
        studentList.add(new Student("Sweety Gupta", 25, "India"));
        studentList.add(new Student("Lala", 54, "India"));
        studentList.add(new Student("Guruji", 42, "India"));
        studentList.add(new Student("Steve wolf", 30, "Canada"));
        studentList.add(new Student("Heath Ledger", 45, "Poland"));

        Assertions.assertThrows(NoSuchElementException.class, () -> studentList.addBefore(new Student("Inspector Morya", 42, "India"), new Student("Shabnam", 25, "India")), "End of List reached");
    }
}
