package com.masaibar.ormasample;

import android.support.annotation.Nullable;

import com.github.gfx.android.orma.annotation.Column;
import com.github.gfx.android.orma.annotation.PrimaryKey;
import com.github.gfx.android.orma.annotation.Table;

/**
 * Created by masaibar on 2016/10/30.
 */

@Table
public class Todo {

    @PrimaryKey(autoincrement = true)
    public long id;

    @Column(indexed = true)
    public String title;

    @Column
    @Nullable
    public String content;

    @Column
    public long createdTimeMillis;

    @Override
    public String toString() {
        return String.format("id = %s, title = %s, content = %s, time = %s",
                id, title, content, createdTimeMillis);
    }
}
