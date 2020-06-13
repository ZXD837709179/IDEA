package leetcode;

import java.util.ArrayList;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Collections;

/**
 * @auther: Xudong Zhang
 * @create: 2020/4/13 11:07
 * @description:
 * 设计一个简化版的推特(Twitter)，可以让用户实现发送推文，关注/取消关注其他用户，能够看见关注人（包括自己）的最近十条推文。你的设计需要支持以下的几个功能：
 *
 * postTweet(userId, tweetId): 创建一条新的推文
 * getNewsFeed(userId): 检索最近的十条推文。每个推文都必须是由此用户关注的人或者是用户自己发出的。推文必须按照时间顺序由最近的开始排序。
 * follow(followerId, followeeId): 关注一个用户
 * unfollow(followerId, followeeId): 取消关注一个用户
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/design-twitter
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 * 把所有可能的情况考虑清楚，注意判空
 */
public class Twitter {
    public int userId;
    public int tweetId;
    public static int createTime;
    public int time;

    /**
     * Initialize your data structure here.
     */
    public Twitter() {
        this.time = createTime++;
    }

    HashMap<Integer, List<Twitter>> hashMap = new HashMap();
    HashMap<Integer, List<Integer>> follow = new HashMap();

    /**
     * Compose a new tweet.
     */
    public void postTweet(int userId, int tweetId) {
        Twitter t = new Twitter();
        t.userId = userId;
        t.tweetId = tweetId;
        if (hashMap.containsKey(userId)) {
            List<Twitter> list = hashMap.get(userId);
            list.add(t);
        } else {
            hashMap.put(userId, new ArrayList<Twitter>() {
                {
                    add(t);
                }
            });
        }
    }

    /**
     * Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent.
     */
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> list = follow.get(userId);
        List<Twitter> tmp = new ArrayList();
        if(hashMap.get(userId)!=null){  //自己肯恩更没有发
            tmp.addAll(hashMap.get(userId));
        }


        if(list!=null){  //可能没有关注
            for (Integer i : list) {
                if(i == userId){
                    continue;//还有自己关注自己的骚操作
                }
                if(hashMap.get(i)!=null){  //关注的用户可能没有发
                    tmp.addAll(hashMap.get(i));
                }
            }
        }

        Comparator<Twitter> com = new Comparator<Twitter>() {
            @Override
            public int compare(Twitter o1, Twitter o2) {
                return o2.time-o1.time;
            }
        };
        Collections.sort(tmp,com);

        ArrayList<Integer> res = new ArrayList();
        int len = tmp.size();
        len = (len<=10)?len:10;
        for (int i = 0; i < len; i++) {
            res.add(tmp.get(i).tweetId);
        }

        return res;
    }

    /**
     * Follower follows a followee. If the operation is invalid, it should be a no-op.
     */
    public void follow(int followerId, int followeeId) {
        if (follow.containsKey(followerId)) {
            List<Integer> ii = follow.get(followerId);
            if(!ii.contains(followeeId)){   //关注两次
                ii.add(followeeId);
            }
        } else {
            follow.put(followerId, new ArrayList<Integer>() {
                {
                    add(followeeId);
                }
            });
        }
    }

    /**
     * Follower unfollows a followee. If the operation is invalid, it should be a no-op.
     */
    public void unfollow(int followerId, int followeeId) {
        List<Integer> list = null;
        if(follow.containsKey(followerId)){  //可能没有关注就向取关
            list = follow.get(followerId);

        }else{
            return;
        }

        int index = -1;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == followeeId) {
                index = i;
                break;
            }
        }
        if(index!=-1){

            list.remove(index);
        }
    }

    public static void main(String[] args) {
        Twitter twitter = new Twitter();
        twitter.postTweet(1,5);
        twitter.follow(1,2);
        twitter.follow(1,2);

        System.out.println(twitter.getNewsFeed(1));


    }
}
