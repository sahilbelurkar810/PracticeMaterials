public class mergeAlternatively {
    public String mergeAlternately(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        StringBuilder word3 = new StringBuilder();

        for (int i = 0; i < Math.min(len1, len2); i++) {
            word3.append(word1.charAt(i));
            word3.append(word2.charAt(i));
        }

        if (len1 > len2) {
            word3.append(word1.substring(len2));
        } else if (len2 > len1) {
            word3.append(word2.substring(len1));
        }

        return word3.toString();
    }
}
