package io.brijoe.learnmvp;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import androidx.annotation.StringRes;

public class Utils {

    public static void launchActivity(Context context, Class<?> cls) {
        Intent intent = new Intent(context, cls);
        try {
            context.startActivity(intent);
        } catch (ActivityNotFoundException e) {

        }
    }

    public static void showToast(Context context, @StringRes int resId) {
        Toast.makeText(context, resId, Toast.LENGTH_SHORT).show();
    }
}
