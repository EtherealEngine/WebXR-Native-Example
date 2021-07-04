package com.xrengine.webtestnav;

import com.getcapacitor.BridgeActivity;
import android.os.Bundle;
import android.os.Bundle;
import android.util.Log;

import com.getcapacitor.Plugin;

import java.util.ArrayList;
import cordova.plugin.unityar;

public class MainActivity extends BridgeActivity {

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        this.init(savedInstanceState, new ArrayList<Class<? extends Plugin>>() {{
            add(UnityAR.class);
        }});
    }
}
