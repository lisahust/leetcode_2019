package DesignPatterns;

/**
 * 立即加载-饿汉式
 * 线程安全
 */
public class Singleton {
    // 主动创建指向自己实例的私有静态引用
    private static Singleton singleton = new Singleton();
    // 私有的构造方法
    private Singleton(){}
    public static Singleton getInstance() {
        return singleton;
    }
}


/**
 * 延迟加载-懒汉式
 * 非线程安全，会出现多个实例
 */
class Singleton2 {
    // 指向自己实例的私有静态引用
    private static Singleton2 singleton2;
    private Singleton2(){}

    public static Singleton2 getSingleton2(){
        // 被动创建，在真正需要使用的时候才需要创建
        if (singleton2 == null) {
            singleton2 = new Singleton2();
        }

        return singleton2;
    }
}

/**
 * 同步延迟加载-懒汉式-synchronized方法
 * 线程安全
 * 保证了对临界资源的同步互斥访问，也就保证了单例
 */
class Singleton3 {
    // 指向自己实例的私有静态引用
    private static Singleton3 singleton3;
    private Singleton3(){}

    public static synchronized Singleton3 getSingleton3(){
        // 被动创建，在真正需要使用的时候才需要创建
        if (singleton3 == null) {
            singleton3 = new Singleton3();
        }

        return singleton3;
    }
}

/**
 * 同步延迟加载-懒汉式-synchronized块
 * 线程安全
 * 保证了对临界资源的同步互斥访问，也就保证了单例
 */
class Singleton4 {
    // 指向自己实例的私有静态引用
    private static Singleton4 singleton4;
    private Singleton4(){}

    public static Singleton4 getSingleton4(){
        // 被动创建，在真正需要使用的时候才需要创建
        synchronized (Singleton4.class) {
            if (singleton4 == null) {
                singleton4 = new Singleton4();
            }
        }
        return singleton4;
    }
}

/**
 * 使用内部类实现延迟加载
 * 线程安全
 */
class Singleton5{
    // 私有内部类，按需加载，用时加载，也就是延迟加载
    private static class Holder {
        private static Singleton5 singleton5 = new Singleton5();
    }
    private Singleton5(){}
    public static Singleton5 getSingleton5() {
        return Holder.singleton5;
    }
}

/**
 * 懒汉式-synchronized方法
 * 线程安全
 * 使用双重检测同步延迟加载去创建单例
 * 不仅保证了单例，而且切实提高了程序运行效率
 * 必须使用volatile关键字修饰单例引用。
 */
class Singleton6 {
    // 指向自己实例的私有静态引用
    private static volatile Singleton6 singleton6;
    private Singleton6(){}

    public static Singleton6 getSingleton6(){
        if (singleton6 == null) {
            synchronized (Singleton6.class) {
                // 只需在第一次创建实例时才同步
                if (singleton6 == null) {
                    singleton6 = new Singleton6();
                }
            }
        }
        return singleton6;
    }
}










