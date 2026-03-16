

public class RecentCounter {
    private Queue<Integer> q;

    public RecentCounter() {
        q = new LinkedList<>();
    }

    public int ping(int t) {
        q.offer(t);
        int min = t - 3000;
        while (min > q.peek()) {
            q.poll();
        }
        return q.size();
    }
}
