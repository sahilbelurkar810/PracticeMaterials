import java.util.HashSet;
import java.util.Set;

class Vowel {
    public String reverseVowels(String s) {
        Set<Character> vowels = new HashSet<>(Set.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
        char[] chars = s.toCharArray();
        int left = 0, right = chars.length - 1;

        while (left < right) {
            if (!vowels.contains(chars[left])) {
                left++;
            } else if (!vowels.contains(chars[right])) {
                right--;
            } else {
                // Swap the vowels
                char temp = chars[left];
                chars[left] = chars[right];
                chars[right] = temp;
                left++;
                right--;
            }
        }

        return new String(chars);
    }

  
}

