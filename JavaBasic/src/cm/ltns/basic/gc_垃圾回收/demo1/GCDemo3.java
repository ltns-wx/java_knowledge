package cm.ltns.basic.gc_垃圾回收.demo1;

public class GCDemo3 {

    public static void main(String[] args) {
        for (int i = 0; i < 4; i++) {
            new GCDemo3();
        }
        System.gc();
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("该对象被删除");
    }
}
