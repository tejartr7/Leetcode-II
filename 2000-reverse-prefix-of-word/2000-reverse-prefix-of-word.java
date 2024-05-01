class Solution {
    public String reversePrefix(String word, char ch) {
        int j = word.indexOf(ch);
        if (j == -1) return word;

        char[] arr = word.toCharArray();
        for (int i = 0; i < j; i++, j--) {
            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
        return new String(arr);
    }
}
