class Tweet {
    public int id;
    public int ts;
    public Tweet(int id, int ts) {
        this.id = id;
        this.ts = ts;
    }
}
class Twitter {

    int gts;
    Map<Integer, LinkedList<Tweet>> tset;
    Map<Integer, Set<Integer>> frSet, fweSet;
    public Twitter() {
        gts = 0;
        tset = new HashMap<>();
        frSet = new HashMap<>();
        fweSet = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        ++gts;
        Tweet td = new Tweet(tweetId, gts);
        tset.computeIfAbsent(userId, k -> new LinkedList<Tweet>()).addFirst(td);
    }
    
    public List<Integer> getNewsFeed(int userId) {

        PriorityQueue<Tweet> pq = new PriorityQueue<>((a, b) -> Integer.compare(b.ts, a.ts));
        LinkedList<Tweet> list = tset.get(userId);
        if(list != null ) {
            for(Tweet tweet : list) {
                pq.add(tweet);
            }
        }
        if(frSet != null && frSet.get(userId) != null) {

            for(Integer il : frSet.get(userId)) {
                    if(tset != null) {
                    list = tset.get(il);
                    if(list != null ) {
                        for(Tweet tweet : list) {
                            pq.add(tweet);
                        }
                    }
                }
            }
        }
        int i=0;
        List<Integer> res = new ArrayList<>();
        for(;!pq.isEmpty() && i<10; ++i) {
            res.add(pq.poll().id);
        }
        return res;
        
    }
    
    public void follow(int followerId, int followeeId) {
if(followerId == followeeId)
    return;
        frSet.computeIfAbsent(followerId, k -> new HashSet<Integer>()).add(followeeId);
        fweSet.computeIfAbsent(followeeId, k -> new HashSet<Integer>()).add(followerId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(followerId == followeeId)
    return;
        frSet.get(followerId).remove((Integer)followeeId);
        fweSet.get(followeeId).remove((Integer)followerId);
    }
}
