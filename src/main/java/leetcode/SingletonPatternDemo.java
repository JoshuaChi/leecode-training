package leetcode;

/**
 * Created by Joshua on 5/14/17.
 */
public class SingletonPatternDemo {
    private static SingletonPatternDemo singletonPatternDemo = null;

    private SingletonPatternDemo() {

    }

    public SingletonPatternDemo getInstance() {

        if(singletonPatternDemo == null) {

            singletonPatternDemo = new SingletonPatternDemo();
        }
        return  this.singletonPatternDemo;
    }
}
