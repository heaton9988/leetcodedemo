import java.util.*;

/**
 * 设计难点:
 * 1. 合并N个链表, 输出前10个最小的值
 * 2. timestamp用int的形式表达出来, 用时间戳的话, 占用的空间比较大, 而且容易出错, 并且找不到原因
 * 3. 用链表更好, 用数组的话, 每次添加到0的位置, 后面的元素都需要往后移动, 性能耗费较大
 */
public class Design355_Twitter {
    HashMap<Integer, HashSet<Integer>> follower2followees;
    HashMap<Integer, Tweet> userId2tweets;
    int timestamp = 0;

    public Design355_Twitter() {
        follower2followees = new HashMap<>();
        userId2tweets = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {
        timestamp++;
        Tweet head = userId2tweets.get(userId);
        if (head == null) {
            head = new Tweet(tweetId, timestamp);
            userId2tweets.put(userId, head);
        } else {
            Tweet newHead = new Tweet(tweetId, timestamp);
            newHead.next = head;
            userId2tweets.put(userId, newHead);
        }
    }

    /**
     * Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent.
     */
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new ArrayList<>();
        HashSet<Integer> set = follower2followees.getOrDefault(userId, new HashSet<>());
        set.add(userId);
        PriorityQueue<Tweet> queue = new PriorityQueue<Tweet>((a, b) -> b.timestamp - a.timestamp);
        for (Integer uId : set) {
            if (userId2tweets.containsKey(uId)) {
                queue.add(userId2tweets.get(uId));
            }
        }
        while (!queue.isEmpty()) {
            Tweet max = queue.poll();
            res.add(max.tweetId);
            if (res.size() == 10) break;
            if (max.next != null) {
                queue.add(max.next);
            }
        }
        return res;
    }

    /**
     * Follower follows a followee. If the operation is invalid, it should be a no-op.
     */
    public void follow(int followerId, int followeeId) {
        HashSet<Integer> set = follower2followees.computeIfAbsent(followerId, k -> new HashSet<Integer>());
        set.add(followeeId);
    }

    /**
     * Follower unfollows a followee. If the operation is invalid, it should be a no-op.
     */
    public void unfollow(int followerId, int followeeId) {
        HashSet<Integer> set = follower2followees.get(followerId);
        if (set != null) {
            set.remove(followeeId);
        }
    }

    static class Tweet {
        int timestamp;
        int tweetId;
        Tweet next;

        Tweet(int tweetId, int timestamp) {
            this.tweetId = tweetId;
            this.timestamp = timestamp;
        }
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        Design355_Twitter twitter = new Design355_Twitter();
//        {
//            twitter.postTweet(1, 5);
//            System.out.println(twitter.getNewsFeed(1));
//            twitter.follow(1, 2);
//            twitter.postTweet(2, 6);
//            System.out.println(twitter.getNewsFeed(1));
//            twitter.unfollow(1, 2);
//            System.out.println(twitter.getNewsFeed(1));
//        }
        {
//["Twitter","postTweet","postTweet","unfollow","follow","getNewsFeed"]
//[[],[1,4],[2,5],[1,2],[1,2],[1]]
            twitter.postTweet(1, 4);
            twitter.postTweet(2, 5);
            twitter.unfollow(1, 2);
            twitter.follow(1, 2);
            System.out.println(twitter.getNewsFeed(1));
        }

        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}