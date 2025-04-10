public class reverseString {
    public String reverseWords(String s) {
            String[] words = s.split(" ");
            StringBuilder reversed = new StringBuilder();
        for (int i= words.length-1;i>=0;i--) {
            if(words[i].isEmpty()) {
                continue;
            }
            reversed.append(words[i]).append(" ");
        }
        return reversed.toString().trim();
    }

    public static void main(String[] args) {
        reverseString rs = new reverseString();
        String input = "Hello      World";
        String result = rs.reverseWords(input);
        System.out.println(result); // Output: "World Hello"
    }
}
