package com.rhtop.taskmanager.common.utils;

import java.io.Closeable;
import java.io.IOException;

/**
 * Created by bobowich
 * Time: 2016/12/22.
 * 用于对IO的关闭操作
 */

public class CloseableUtils {
    public static void close(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
