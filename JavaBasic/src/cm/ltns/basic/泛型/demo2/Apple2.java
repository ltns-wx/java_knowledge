package cm.ltns.basic.泛型.demo2;

public class Apple2<Y> {

    public <T> void  fun(T a){
        System.out.println(a);
    }

    public static void main(String[] args) {
        Apple2<String> a = new Apple2<String>() ;
        a.fun("a");
        a.fun(1);
    }
}
