package com.xrengine.example;

import android.os.Bundle;

import com.getcapacitor.BridgeActivity;
import com.getcapacitor.Plugin;

import java.util.ArrayList;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import android.view.View;
import android.widget.Toast;

public class MainActivity extends BridgeActivity {
    boolean isUnityLoaded = false;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        isUnityLoaded=true;
        Intent intent = new Intent(this, MainUnityActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        startActivityForResult(intent, 1);
    }
    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        handleIntent(intent);
        setIntent(intent);
    }

    void handleIntent(Intent intent) {

    }


   /* @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == 1) isUnityLoaded = false;
    }*/

    public void unloadUnity(Boolean doShowToast) {
        if(isUnityLoaded) {
            Intent intent = new Intent(this, MainUnityActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
            intent.putExtra("doQuit", true);
            startActivity(intent);
            isUnityLoaded = false;
        }
        else if(doShowToast) showToast("Show Unity First");
    }


    public void showToast(String message) {
        CharSequence text = message;
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(getApplicationContext(), text, duration);
        toast.show();
    }

    @Override
    public void onBackPressed() {
        finishAffinity();
    }
}
