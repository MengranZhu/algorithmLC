package src.airbnb;
/*
 * leetcode: 251. Flatten 2D Vector
 *Implement an iterator to flatten a 2d vector.
 *set two index for 2D vector
 *
 *
 *
 * */

import src.tag.Design;

import java.util.Iterator;
import java.util.List;

@Design
public class Flatten2DVector {
    public class Vector2D implements Iterator<Integer> {
        private int listIndex;
        private int index;
        private List<List<Integer>> list;

        public Vector2D(List<List<Integer>> vec2d) {
            listIndex = 0;
            index = 0;
            this.list = vec2d;
        }

        //@Override
        public Integer next() {
            return list.get(listIndex).get(index++);
        }

        //@Override
        public boolean hasNext() {
            while (listIndex < list.size()) {
                if (index < list.get(listIndex).size()) {
                    return true;
                } else {
                    listIndex++;
                    index = 0;
                }
            }
            return false;
        }
    }
}
