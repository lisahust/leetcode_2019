package com_NetEase;

/**
 * 网易有道一面
 * 双重检查锁
 */

public class interview03 {
    private static volatile interview03 singleton;
    private interview03(){}

    public static interview03 getInstance() {
        if (singleton == null) {
            synchronized (interview03.class) {
                if (singleton == null) {
                    singleton = new interview03();
                }
            }
        }
        return singleton;
    }

}
