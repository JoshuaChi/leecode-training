package construct;

/**
 * Created by Joshua on 5/29/17.
 */

/**
 * 控制台打印
 */
class Log {
    public static String baseFieldInit() {
        System.out.println("Base Normal Field");
        return "";
    }

    public static String baseStaticFieldInit() {
        System.out.println("Base Static Field");
        return "";
    }

    public static String fieldInit() {
        System.out.println("Normal Field");
        return "";
    }

    public static String staticFieldInit() {
        System.out.println("Static Field");
        return "";
    }
}

/**
 * 基类
 */
class Base {     /*1*/
    static {
        System.out.println("Base Static Block 1");
    }         /*1*/

    private static String staticValue = Log.baseStaticFieldInit();         /*1*/

    static {
        System.out.println("Base Static Block 2");
    }         /*3*/

    {
        System.out.println("Base Normal Block 1");
    }         /*3*/

    private String value = Log.baseFieldInit();         /*3*/

    {
        System.out.println("Base Normal Block 2");
    }         /*4*/

    Base() {
        System.out.println("Base Constructor");
    }
}

/**
 * 派生类
 */
public class ConstructDemo extends Base {         /*2*/
    static {
        System.out.println("Static Block 1");
    }     /*2*/

    private static String staticValue = Log.staticFieldInit();         /*2*/

    static {
        System.out.println("Static Block 2");
    }         /*5*/

    {
        System.out.println("Normal Block 1");
    }         /*5*/

    private String value = Log.fieldInit();         /*5*/

    {
        System.out.println("Normal Block 2");
    }         /*6*/

    ConstructDemo() {
        System.out.println("Derived Constructor");
    }

    /**
     * MAIN 主线程
     */
    public static void main(String[] args) {
        ConstructDemo d = new ConstructDemo();
    }
}