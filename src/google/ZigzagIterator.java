package src.google;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * 281. Zigzag Iterator
 *
 * using queue, first in first out
 *
 *
 *
 *
 * */
public class ZigzagIterator {
    private Iterator<Integer> i, j, tmp;

    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        i = v2.iterator();
        j = v1.iterator();
    }

    public int next() {
        if (j.hasNext()) {
            tmp = j;
            j = i;
            i = tmp;
        }
        return i.next();
    }

    public boolean hasNext() {
        return j.hasNext() || i.hasNext();
    }

    /*
     * follow up
     *
     * */
    class ZigzagIteratorK {

        Queue<Iterator<Integer>> q;

        public ZigzagIteratorK(List<List<Integer>> lists) {
            q = new LinkedList<Iterator<Integer>>();
            for (int i = 0; i < lists.size(); i++) {
                Iterator<Integer> it = lists.get(i).iterator();
                q.offer(it);
            }
        }

        public int next() {
            Iterator<Integer> it = q.poll();
            int tmp = it.next();
            q.offer(it);
            return tmp;
        }

        public boolean hasNext() {
            while (!q.isEmpty()) {
                if (q.peek().hasNext()) return true;
                else q.poll();
            }
            return false;
        }
    }
}
