package ds.stacks;

import java.util.LinkedList;

public class PalindromeStringChecker {

    public boolean check(String input) {
        String cleanedString = removeSpecialCharacters(input).toLowerCase();

        LinkedList<Character> charLinkedList = getCharacterList(cleanedString);

        String reversedString = getStringFromList(charLinkedList);

        return cleanedString.equals(reversedString);
    }

    private String removeSpecialCharacters(String input) {
        return input.replaceAll("[^a-zA-Z0-9]", "");
    }

    private LinkedList<Character> getCharacterList(String input) {
        LinkedList<Character> charLinkedList = new LinkedList<>();
        for (int i = 0; i < input.length(); i++) {
            charLinkedList.push(input.charAt(i));
        }
        return charLinkedList;
    }

    private String getStringFromList(LinkedList<Character> charLinkedList) {
        int length = charLinkedList.size();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < length; i++) {
            stringBuilder.append(charLinkedList.pop());
        }
        return stringBuilder.toString();
    }
}
