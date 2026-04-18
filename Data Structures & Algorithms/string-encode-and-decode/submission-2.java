class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String s : strs) {
            sb.append(s.length()).append('#').append(s);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> res = new ArrayList<>();
        int i = 0;

        while (i < str.length()) {
            int j = i;

            // find the separator '#'
            while (str.charAt(j) != '#') j++;

            int len = Integer.parseInt(str.substring(i, j));
            j++; // skip '#'

            String word = str.substring(j, j + len);
            res.add(word);

            i = j + len;
        }

        return res;
    }
}
