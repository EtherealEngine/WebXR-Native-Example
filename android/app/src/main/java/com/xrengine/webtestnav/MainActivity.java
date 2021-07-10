package com.xrengine.webtestnav;

import com.getcapacitor.BridgeActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Bundle;
import android.util.Log;

import com.getcapacitor.Plugin;
import com.xrengine.capacitorpluginunityar.MainUnityActivity;
import com.xrengine.capacitorpluginunityar.UnityAR;

import java.util.ArrayList;

public class MainActivity extends BridgeActivity {

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        this.init(savedInstanceState, new ArrayList<Class<? extends Plugin>>() {{
            add(UnityAR.class);
        }});
    }
}
