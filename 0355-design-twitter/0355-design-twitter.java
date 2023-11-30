import java.util.*;

class Linked {
    int x, y;
    Linked next = null;

    Linked(int a, int b) {
        x = a;
        y = b;
    }
}

class Twitter {
    Linked temp;
    Map<Integer, Set<Integer>> following = new HashMap<>();

    public Twitter() {
        Linked tweet = new Linked(-1, -1);
        temp = tweet;
    }

    public void postTweet(int userId, int tweetId) {
        Linked t = new Linked(tweetId, userId);
        t.next = temp;
        temp = t;
    }

    public List<Integer> getNewsFeed(int userId) {
        List<Integer> list = new ArrayList<>();
        Linked curr = temp;
        if(!following.containsKey(userId))
            following.put(userId,new HashSet<>());
        following.get(userId).add(userId);
        Set<Integer> seen = new HashSet<>();
        while (curr != null && curr.x != -1) {
            if (list.size() >= 10)
                break;
            else if (following.get(userId).contains(curr.y)) {
                if (!seen.contains(curr.x)) {
                    list.add(curr.x);
                    seen.add(curr.x);
                }
            }
            curr = curr.next;
        }
        return list;
    }

    public void follow(int followerId, int followeeId) {
        following.putIfAbsent(followerId, new HashSet<>());
        following.get(followerId).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if (following.containsKey(followerId)) {
            following.get(followerId).remove(followeeId);
        }
    }
}
