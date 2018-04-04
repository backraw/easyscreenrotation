package de.tre.easyscreenrotation;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.SparseIntArray;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private SparseIntArray orientationMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        orientationMap = new SparseIntArray(4);

        orientationMap.append(
                R.id.buttonLandscape,
                ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
        );

        orientationMap.append(
                R.id.buttonPortrait,
                ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        );

        orientationMap.append(
                R.id.buttonReverseLandscape,
                ActivityInfo.SCREEN_ORIENTATION_REVERSE_LANDSCAPE
        );

        orientationMap.append(
                R.id.buttonReversePortrait,
                ActivityInfo.SCREEN_ORIENTATION_REVERSE_PORTRAIT
        );
    }

    public void onButtonClick(View view) {
        int orientationId = orientationMap.get(view.getId(), -1);

        if (orientationId > -1) {
            Intent rotationService = new Intent(this, RotationService.class);
            rotationService.putExtra("id", orientationId);

            startService(rotationService);
        }
    }
}
