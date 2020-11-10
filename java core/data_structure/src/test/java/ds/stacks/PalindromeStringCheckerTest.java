package ds.stacks;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PalindromeStringCheckerTest {

    PalindromeStringChecker palindromeStringChecker = new PalindromeStringChecker();

    @Test
    void test_1_check_string_true_successful(){
        boolean result = palindromeStringChecker.check("iTopiNonAvevanoNipoti");
        Assertions.assertTrue(result);
    }

    @Test
    void test_2_check_string_with_symbol_successful(){
        boolean result = palindromeStringChecker.check("Madam I'm Adam");
        Assertions.assertTrue(result);
    }

    @Test
    void test_3_check_string_with_symbol_successful(){
        boolean result = palindromeStringChecker.check("Able was I, ere I saw Elba.");
        Assertions.assertTrue(result);
    }

    @Test
    void test_check_string_false_successful(){
        boolean result = palindromeStringChecker.check("palindromes");
        Assertions.assertFalse(result);
    }


}
