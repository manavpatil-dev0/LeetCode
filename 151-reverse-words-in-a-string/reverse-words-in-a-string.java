class Solution {
    public String reverseWords(String s) {

        StringBuilder result = new StringBuilder();

        int i = s.length() - 1;

        while (i >= 0) {

            // Skip spaces
            while (i >= 0 && s.charAt(i) == ' ') {
                i--;
            }

            if (i < 0)
                break;

            int j = i;

            // Find beginning of current word
            while (i >= 0 && s.charAt(i) != ' ') {
                i--;
            }

            result.append(s.substring(i + 1, j + 1));

            // Add space only if another word exists
            while (i >= 0 && s.charAt(i) == ' ') {
                i--;
            }

            if (i >= 0) {
                result.append(" ");
            }
        }

        return result.toString();
    }
}