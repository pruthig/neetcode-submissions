class Tweet {
    int ts;
    int id;
    public Tweet(int ts, int id) {
        this.ts = ts;
        this.id = id;
    }
}
class Twitter {
    Map<Integer, List<Tweet>> tMap;
    Map<Integer, Set<Integer>> frMap; // follower -> followees, which are followd
    Map<Integer, Set<Integer>> feMap; // followee -> followers
    int gts = 0;
    public Twitter() {
        tMap = new HashMap<>();
        frMap = new HashMap<>();
        feMap = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        Tweet tweet = new Tweet(++gts, tweetId);
        tMap.computeIfAbsent(userId, t -> new ArrayList<Tweet>()).add(tweet);
    }
    
    public List<Integer> getNewsFeed(int userId) {

        List<Integer> list = new ArrayList<>();
        PriorityQueue<Tweet> pq = new PriorityQueue<>((a, b) -> Integer.compare(b.ts, a.ts));
        List<Tweet> ownList = tMap.get(userId);
        if(ownList != null && ownList.size() > 0) {
            for(Tweet tweet : ownList) {
                pq.add(tweet);
            }
        }
        // follower Map
        Set<Integer> followeeSet = frMap.get(userId);
        if(followeeSet != null && followeeSet.size() > 0) {
            for(Integer followeeId : followeeSet) {
                ownList = tMap.get(followeeId);
                if(ownList != null && ownList.size() > 0) {
                    for(Tweet tweet : ownList) {
                        pq.add(tweet);
                    }
                } 
            }
        }
        int i=0;
        while(!pq.isEmpty() && i<10) {
            Tweet tweet = pq.poll();
            list.add(tweet.id);
            ++i;
        }
        return list;
    }
    
    public void follow(int followerId, int followeeId) {
        if(followerId == followeeId)
            return;
        frMap.computeIfAbsent(followerId, t -> new HashSet<Integer>()).add(followeeId);
        feMap.computeIfAbsent(followeeId, t -> new HashSet<Integer>()).add(followerId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(followerId == followeeId)
            return;
        if(frMap.containsKey(followerId)) 
            frMap.get(followerId).remove(followeeId);
        if(feMap.containsKey(followeeId)) 
            feMap.get(followeeId).remove(followerId);
    }
}
