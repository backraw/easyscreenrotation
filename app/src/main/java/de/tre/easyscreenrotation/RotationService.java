package de.tre.easyscreenrotation;

import android.app.Service;
import android.content.Intent;
import android.graphics.PixelFormat;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;

public class RotationService extends Service {

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Bundle extras = intent.getExtras();

        if (extras != null) {
            int id = extras.getInt("id", -1);

            if (id > -1) {
                // rotate screen
                LinearLayout orientationChanger = new LinearLayout(this);
                WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams(
                        WindowManager.LayoutParams.TYPE_APPLICATION_PANEL,
                        0,
                        PixelFormat.RGBA_8888
                );

                layoutParams.screenOrientation = id;

                WindowManager windowManager = (WindowManager) getSystemService(Service.WINDOW_SERVICE);

                if (windowManager != null) {
                    windowManager.addView(orientationChanger, layoutParams);
                    orientationChanger.setVisibility(View.VISIBLE);
                }
            }
        }

        return Service.START_STICKY;
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
