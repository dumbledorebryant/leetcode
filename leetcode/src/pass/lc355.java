package pass;
import java.util.*;

public class lc355 {
    
}
class Twitter {
    private static int timestamp = 0;

    class Tweet {
        private int id;
        private int time;
        private Tweet next;

        public Tweet(int id, int time){
            this.id = id;
            this.time = time;
            this.next = null;
        }
    }

    class User{
        private int id;
        public Set<Integer> followed = new HashSet<>();;
        public Tweet head = null;;

        public User(int userId){
            id = userId;
            followed.add(userId);
        }

        public void follow(int userId){
            followed.add(userId);
        }

        public void unfollow(int userId){
            if (id != userId){
                followed.remove(userId);
            }
        }

        public void post(int tid){
            Tweet twt = new Tweet(tid, timestamp);
            timestamp++;
            twt.next = head;
            head = twt;
        }
    }

    public Twitter() {
        
    }
    
    Map<Integer, User> users = new HashMap<>();

    public void postTweet(int userId, int tweetId) {
        if (!users.containsKey(userId)){
            users.put(userId, new User(userId));
        }
        User user = users.get(userId);
        user.post(tweetId);
        users.put(userId, user);
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> ans = new ArrayList<>();
        if (!users.containsKey(userId)) return ans;
        User user = users.get(userId);
        Set<Integer> set = user.followed;
        PriorityQueue<Tweet> pq = new PriorityQueue<>((a, b) -> b.time - a.time);
        for (int next : set){
            User f = users.get(next);
            if (f.head != null)
                pq.add(f.head);
        }
        
        while (!pq.isEmpty()){
            Tweet twt = pq.poll();
            ans.add(twt.id);
            if (twt.next != null){
                pq.add(twt.next);
            }
            if (ans.size() == 10) break;
        }
        return ans;
    }
    
    public void follow(int followerId, int followeeId) {
        if (!users.containsKey(followerId)){
            users.put(followerId, new User(followerId));
        }
        if (!users.containsKey(followeeId)){
            users.put(followeeId, new User(followeeId));
        }
        users.get(followerId).follow(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if (users.containsKey(followerId)){
            User user = users.get(followerId);
            user.unfollow(followeeId);
        }
    }
}