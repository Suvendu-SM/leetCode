public class palindromePartioning {
    public List<List<String>> partition(String s) {

        List<List<String>> allPossiblePalindrome = new ArrayList<>();

        getPalindrome(s, allPossiblePalindrome, new ArrayList<String>(), 0);

        return allPossiblePalindrome;
    }

    public void getPalindrome(String str, List<List<String>> allPossiblePalindrome,
            ArrayList<String> possiblePalindrome, int src) {

        if (src >= str.length()) {
            allPossiblePalindrome.add(new ArrayList<>(possiblePalindrome));
            return;
        }

        for (int dst = src; dst < str.length(); dst++) {
            if (isPalindrome(str.substring(src, dst + 1))) {

                possiblePalindrome.add(str.substring(src, dst + 1));

                getPalindrome(str, allPossiblePalindrome, possiblePalindrome, dst + 1);

                possiblePalindrome.remove(possiblePalindrome.size() - 1);
            }
        }

    }

    public boolean isPalindrome(String str) {
        int j = str.length() - 1;
        int i = 0;
        while (i < j) {
            if (str.charAt(i) != str.charAt(j))
                return false;
            i++;
            j--;
        }

        return true;
    }

}
