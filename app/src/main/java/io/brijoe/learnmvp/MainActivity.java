package io.brijoe.learnmvp;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

public class MainActivity extends Activity {

    private Reference<Integer> ref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        ref = new WeakReference<>(20);
    }

    public void login(View view) {
        Reference<Integer> ref = new WeakReference<>(20);
        Log.e("Bridge", ref.get() + "");
    }

    public void gc(View view) {
        System.gc();
    }


}