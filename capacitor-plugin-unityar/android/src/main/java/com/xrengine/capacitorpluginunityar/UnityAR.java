package com.xrengine.capacitorpluginunityar;

import com.getcapacitor.NativePlugin;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;
import com.getcapacitor.annotation.CapacitorPlugin;

import android.content.Intent;
import org.json.JSONObject;


@CapacitorPlugin(name = "UnityAR")
public class UnityAR extends Plugin {

    @PluginMethod
    public void execute(PluginCall call) {
        String value = call.getString("value");
        this.launchUnity(value);
         call.resolve();

    }

    private void launchUnity(String message){
        try
        {
            Intent unityIntent = new Intent(getActivity(),MainUnityActivity.class);
            unityIntent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
            //getActivity().startActivityForResult(this,unityIntent,1);



        }
        catch(Exception ex)
        {
            //callbackContext.error("There was an error "+ex);
        }
        
    }

    private void launchUnityMessage(JSONObject messageArg){
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
    }
}
