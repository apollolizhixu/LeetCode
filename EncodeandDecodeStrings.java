public class Codec {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        if (strs == null || strs.size() == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (String s : strs) {
            sb.append(s.length());
            sb.append("/");
            sb.append(s);
        }
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> list = new ArrayList<String>();
        for (int i = 0; i < s.length(); i++) {
            int index = s.indexOf('/', i);
            int len = Integer.valueOf(s.substring(i, index));
            String cur = s.substring(index + 1, (index + len + 1));
            list.add(cur);
            i = index + len;
        }
        return list;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));