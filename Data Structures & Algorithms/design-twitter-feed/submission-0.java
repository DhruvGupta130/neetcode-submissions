class Twitter {
    record Tweet(int tweetId, int time) {}
    Map<Integer, Set<Integer>> followMap;
    Map<Integer, List<Tweet>> tweetMap;
    int time;

    public Twitter() {
        followMap = new HashMap<>();
        tweetMap = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {
        tweetMap.computeIfAbsent(userId, k -> new ArrayList<>()).add(new Tweet(tweetId, time++));
    }

    public List<Integer> getNewsFeed(int userId) {
        Set<Integer> users = followMap.getOrDefault(userId, new HashSet<Integer>());

        PriorityQueue<Tweet> pq = new PriorityQueue<>((a, b) -> b.time() - a.time());

        followMap.putIfAbsent(userId, new HashSet<>());
        followMap.get(userId).add(userId);

        for (int user : followMap.get(userId)) {
            tweetMap.getOrDefault(user, List.of()).forEach(pq::offer);
        }

        List<Integer> res = new ArrayList<>();

        int count = 0;
        while (!pq.isEmpty() && count < 10) {
            res.add(pq.poll().tweetId());
            count++;
        }

        return res;
    }

    public void follow(int followerId, int followeeId) {
        followMap.computeIfAbsent(followerId, k -> new HashSet<>()).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if (followMap.containsKey(followerId)) {
            followMap.get(followerId).remove(followeeId);
        }
    }
}
