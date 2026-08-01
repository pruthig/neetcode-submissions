public class Tweet {
    public int id;
    public int timestamp;
    public Tweet(int id, int timestamp) {
        this.id = id;
        this.timestamp = timestamp;
    }
}
class Twitter {
    int timeStamp = 0;
    Map<Integer, LinkedList<Tweet>> tweetMap;
    // followee -> follwers
    Map<Integer, List<Integer>> followerMap;
    // follower -> followees
    Map<Integer, List<Integer>> followeeMap;
    public Twitter() {
        tweetMap = new HashMap<>();
        followerMap = new HashMap<>();
        followeeMap = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        LinkedList<Tweet> tweetList = null;
        if(tweetMap.containsKey(userId)) {
            tweetList = tweetMap.get(userId);
        } else {
            tweetList = new LinkedList<Tweet>();
        }
        tweetList.addFirst(new Tweet(tweetId, timeStamp++));
        tweetMap.put(userId, tweetList);
    }
    
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<Tweet> pq = new PriorityQueue<>((a, b) -> Integer.compare(b.timestamp, a.timestamp));
        // his owns
        LinkedList<Tweet> tweetList = tweetMap.get(userId);
        if(tweetList != null) {
            for(Tweet id : tweetList) {
                pq.add(id);
            }
        }
        List<Integer> followingList = followerMap.get(userId);
        if(followingList != null) {
            for(int user : followingList) {
                LinkedList<Tweet> tList = tweetMap.get(user);
                for(Tweet id : tList) {
                    pq.add(id);
                }
            }
        }
        List<Integer> res = new ArrayList<>();
        for(int i=0;i<10 && !pq.isEmpty(); ++i) {
            res.add(pq.poll().id);
        }
        return res;
    }
    
    public void follow(int followerId, int followeeId) {
        if(followerId == followeeId)
            return;
        // followers

        if(followerMap.containsKey(followerId)) {
            List<Integer> fl = followerMap.get(followerId);
            if(fl.contains((Integer)followeeId))
                return;
        }
        followerMap.computeIfAbsent(followerId, k -> new ArrayList<>()).add(followeeId);
        followeeMap.computeIfAbsent(followeeId, k -> new ArrayList<>()).add(followerId);

    }
    
    public void unfollow(int followerId, int followeeId) {
                if(followerId == followeeId)
            return;

        if(followerMap.containsKey(followerId)) {
            List<Integer> fl = followerMap.get(followerId);
            if(!fl.contains((Integer)followeeId))
                return;
        }
        List<Integer> frList = followerMap.get(followerId);
        frList.remove((Integer)followeeId);
        followerMap.put(followerId, frList);
        // remove from followee
        List<Integer> frList2 = followeeMap.get(followeeId);
        frList2.remove((Integer)followerId);
        followeeMap.put(followeeId, frList2);
    }
}
