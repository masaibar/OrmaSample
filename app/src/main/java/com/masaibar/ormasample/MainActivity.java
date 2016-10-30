package com.masaibar.ormasample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.button_insert).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickedInsert();
            }
        });

        findViewById(R.id.button_select).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickSelect();
            }
        });
    }

    private void onClickedInsert() {
        final Todo todo = new Todo();
        todo.title = "title";
        todo.content = "contentttt";
        todo.createdTimeMillis = new Date().getTime();
        Log.d("!!!!!", "hogehoge");
        OrmaUtil.runOnBackgroundThread(new Runnable() {
            @Override
            public void run() {
                OrmaUtil.getInstance(getApplicationContext()).insertIntoTodo(todo);
            }
        });
    }

    private void onClickSelect() {
        OrmaUtil.runOnBackgroundThread(new Runnable() {
            @Override
            public void run() {
                List<Todo> todoList =
                        OrmaUtil.getInstance(getApplicationContext()).selectFromTodo().toList();
                for (Todo todo : todoList) {
                    Log.d(
                            "!!!!",
                            String.format("id = %d, title = %s, content = %s, time = %s",
                                    todo.id, todo.title, todo.content, todo.createdTimeMillis)
                    );
                }
            }
        });
    }
}
