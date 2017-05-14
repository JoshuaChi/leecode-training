package leetcode.search;

/**
 * Created by Joshua on 5/14/17.
 */

class IceCream implements Comparable{
    int flavor;
    int index;

    public IceCream(int flavor, int index) {
        this.flavor = flavor;
        this.index = index;
    }

    /**
     * if bigger than o, return 1;
     * else return -1;
     *
     */
    public int compareTo(Object o) {
        if(((IceCream)o).flavor > flavor) {
            return -1;
        }
        else {
            return 1;
        }
    }

    @Override
    public boolean equals(Object o){
        if(((IceCream)o).flavor == flavor) {
            return true;
        }
        return false;
    }

}
