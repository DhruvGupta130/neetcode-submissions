class TimeMap {
    record Pair(String value, int timestamp) {}
    Map<String, List<Pair>> store;

    public TimeMap() {
        store = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        store.computeIfAbsent(key, k -> new ArrayList<>()).add(new Pair(value, timestamp));
    }

    public String get(String key, int timestamp) {
        var list = store.get(key);
        if (list == null)
            return "";

        int left = 0, right = list.size() - 1;
        String res = "";
        while (left <= right) {
            int mid = left + (right - left) / 2;

            Pair pair = list.get(mid);

            if (pair.timestamp() <= timestamp) {
                res = pair.value();
                left = mid + 1;
            } else
                right = mid - 1;
        }

        return res;
    }
}
