public class wordBreak2 {
    public List<String> wordBreak(String s, List<String> wordDict) {
        HashMap<String, List<String>> memo = new HashMap<>();
        return getCombination(s, wordDict, memo);
    }

    public List<String> getCombination(String str, List<String> wordDict, HashMap<String, List<String>> memo) {

        if (memo.containsKey(str)) {
            return memo.get(str);
        }

        List<String> list = new ArrayList<>();
        for (String word : wordDict) {
            if (str.startsWith(word)) {
                String nextStr = str.substring(word.length());
                if (nextStr.isEmpty())
                    list.add(word);
                else {
                    List<String> list2 = getCombination(nextStr, wordDict, memo);
                    for (String item : list2)
                        list.add(new StringBuilder().append(word).append(" ").append(item).toString());
                }

            }
        }

        memo.put(str, list);

        return list;
    }
}
