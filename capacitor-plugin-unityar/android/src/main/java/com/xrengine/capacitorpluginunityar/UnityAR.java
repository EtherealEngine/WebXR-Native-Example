package com.xrengine.capacitorpluginunityar;

import com.company.product.OverrideUnityActivity;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;
import com.getcapacitor.annotation.ActivityCallback;
import com.getcapacitor.annotation.CapacitorPlugin;
import com.unity3d.player.UnityPlayerActivity;

import android.app.Instrumentation;
import android.content.Intent;
import android.util.Log;

import androidx.annotation.UiThread;


@CapacitorPlugin(name = "UnityAR")
public class UnityAR extends Plugin {

    @PluginMethod()
    public void execute(PluginCall call) {
        String value = call.getString("value");
        Log.e("===>>>","Unity Launch");
        this.launchUnity(call,value);
         call.resolve();
    }

    private void launchUnity(PluginCall call ,String message){
        try
        {
            Intent unityIntent = new Intent(getContext(), MainUnityActivity.class);
            unityIntent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
            //startActivityForResult(call,unityIntent,1000);
            startActivityForResult(call,unityIntent,"unityCallback");
        }
        catch(Exception ex)
        {
            Log.e("===>>","There was an error "+ex);
        }
    }
    @ActivityCallback
    void unityCallback (PluginCall call, Instrumentation.ActivityResult result){
            Log.e("CallBack","Unity Call Back");
    }

    /* private void launchUnityMessage(JSONObject messageArg){
        try
        {
            //Intent unityIntent = new Intent(cordova.getActivity().getApplicationContext(),MainUnityActivity.class);
            //unityIntent.putExtra("messageJson",messageArg.toString());
            //unityIntent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
            //cordova.startActivityForResult(this,unityIntent,RQCODE);
            //PluginResult pluginResult = new PluginResult(PluginResult.Status.OK, "Launched Unity with message");
            //pluginResult.setKeepCallback(true);
            
        }
        catch(Exception ex)
            {
                //callbackContext.error("There was an error "+ex);
            }
    }*/
}
