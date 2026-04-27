class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits == null || digits.length() == 0)
            return res;
        List<String> map =
            List.of("", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz");
        backTrack(digits, 0, new StringBuilder(), map, res);
        return res;
    }

    private void backTrack(
        String digits, int index, StringBuilder curr, List<String> map, List<String> res) {
        if (index == digits.length()) {
            res.add(curr.toString());
            return;
        }

        String letters = map.get(digits.charAt(index) - '0');
        for (char c : letters.toCharArray()) {
            curr.append(c);
            backTrack(digits, index + 1, curr, map, res);
            curr.deleteCharAt(curr.length() - 1);
        }
    }
}
