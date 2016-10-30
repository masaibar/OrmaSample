package com.masaibar.ormasample;

import android.content.Context;

/**
 * Created by masaibar on 2016/10/30.
 */

public class OrmaUtil {
    private static OrmaDatabase sOrma = null;

    public static OrmaDatabase getInstance(Context context) {
        if (sOrma == null) {
            sOrma = OrmaDatabase.builder(context).build();
        }

        return sOrma;
    }

    public static void insert(final Context context, final Todo todo) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                getInstance(context).insertIntoTodo(todo);
            }
        }).start();
    }

    public static void runOnBackgroundThread(Runnable runnable) {
        new Thread(runnable).start();
    }
}