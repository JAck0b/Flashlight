package com.example.jakub.myapplication;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {
  Button button;
  TextView textView;
  EditText editText;
  Button enableButton;

  private static final int CAMERA_REQUEST = 50;

  List<Integer> integerList;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    button = (Button)findViewById(R.id.button);
    textView = (TextView)findViewById(R.id.textView);
    editText = (EditText)findViewById(R.id.editText);
    enableButton = (Button) findViewById(R.id.button2);

    final boolean hasCameraFlash = getPackageManager().
      hasSystemFeature(PackageManager.FEATURE_CAMERA_FLASH);
    boolean isEnabled = ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA)
      == PackageManager.PERMISSION_GRANTED;

    enableButton.setEnabled(!isEnabled);
    if (isEnabled) {
      enableButton.setVisibility(View.INVISIBLE);
    }
    button.setEnabled(isEnabled);

    enableButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        ActivityCompat.requestPermissions(MainActivity.this, new String[] {Manifest.permission.CAMERA}, CAMERA_REQUEST);
      }
    });
    /*
    This override method check entered text.
     */
    button.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        String message = editText.getText().toString();
        if (hasCameraFlash) {
          if (Word.checkWord(message)) {
            Word word = new Word(message);
            integerList = word.getIntegerList();
            for (Integer x: integerList) {
              switch (x) {
                case 0:
                  flashLightOn();
                  try {
                    Thread.sleep(500);
                  } catch (Exception e) {
                    e.printStackTrace();
                  }
                  flashLightOff();
                  break;
                case 1:
                  flashLightOn();
                  try {
                    Thread.sleep(1000);
                  } catch (Exception e) {
                    e.printStackTrace();
                  }
                  flashLightOff();
                  break;
                case 2:
                  try {
                    Thread.sleep(2000);
                  } catch (Exception e) {
                    e.printStackTrace();
                  }

                  break;
              }
            }
            System.out.println();
          } else {
            Toast.makeText(MainActivity.this, "Invalid data",
              Toast.LENGTH_SHORT).show();
          }
        } else {
          Toast.makeText(MainActivity.this, "No flash available on your device",
            Toast.LENGTH_SHORT).show();
        }
      }
    });
  }

  private void flashLightOn() {
    CameraManager cameraManager = (CameraManager) getSystemService(Context.CAMERA_SERVICE);

    try {
      String cameraId = cameraManager.getCameraIdList()[0];
      cameraManager.setTorchMode(cameraId, true);
    } catch (CameraAccessException e) {
      e.printStackTrace();
    }
  }

  private void flashLightOff() {
    CameraManager cameraManager = (CameraManager) getSystemService(Context.CAMERA_SERVICE);

    try {
      String cameraId = cameraManager.getCameraIdList()[0];
      cameraManager.setTorchMode(cameraId, false);
    } catch (CameraAccessException e) {
      e.printStackTrace();
    }
  }

  @Override
  public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
    switch(requestCode) {
      case CAMERA_REQUEST :
        if (grantResults.length > 0  &&  grantResults[0] == PackageManager.PERMISSION_GRANTED) {
          enableButton.setEnabled(false);
          enableButton.setText(getString(R.string.camera_enable));
          enableButton.setVisibility(View.INVISIBLE);
          button.setEnabled(true);
        } else {
          Toast.makeText(MainActivity.this, "Permission Denied for the Camera", Toast.LENGTH_SHORT).show();
        }
        break;
    }
  }
}
