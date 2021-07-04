package com.xrengine.example;

import com.getcapacitor.JSObject;
import com.getcapacitor.NativePlugin;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;


import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.PluginResult;

import android.content.Intent;


@NativePlugin
public class UnityAR extends Plugin {

    @PluginMethod
    public void execute(PluginCall call) {
        String value = call.getString("value");

         if(value.equals("launchUnity")){
            String message = args.getString(0);
            this.launchUnity(message);
            return true;
        }
        else if(value.equals("launchwithMessage")){
            JSONObject jsonObject = args.getJSONObject(0);
            this.launchUnityMessage(jsonObject);
            return true;
        }
         call.success();
    }

    private void launchUnity(String message){
        try
        {
            //Intent unityIntent = new Intent(cordova.getActivity().getApplicationContext(),MainUnityActivity.class);
            //unityIntent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
            //cordova.startActivityForResult(this,unityIntent,1);        

            Intent unityIntent = new Intent(Intent.ACTION_VIEW);
            unityIntent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
            getActivity().startActivity(unityIntent);    
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
