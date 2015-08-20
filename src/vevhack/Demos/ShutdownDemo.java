package vevhack.Demos;

/**
 * Description: ShutdownDemo
 * Author: Zen
 * Update: Zen(2015-08-20 14:30)
 */
public class ShutdownDemo {
    public static void main(String[] args) {
        /*不好的做法*/
        Object f = new Object() {
            @Override
            protected void finalize() throws Throwable {
                System.out.println("Running finalize()");
                super.finalize();
            }
        };
        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                System.out.println("Running Shutdown Hook");
            }
        });
        if (args.length == 1 && args[0].equals("")) {
            f = null;
            System.gc();
        }
        System.out.println("Calling System exit(),with f=" + f);
    }
}
