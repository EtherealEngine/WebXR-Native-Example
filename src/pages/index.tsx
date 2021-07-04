import { Capacitor,Plugins } from '@capacitor/core';
import "webxr-native";
import React, { useEffect, useState } from 'react';
import 'capacitor-plugin-unityar';
const { UnityAR } = Plugins;



export const IndexPage = (): any => {
    const raf = () => {
        requestAnimationFrame(raf);
    };


  

    const handleTap =() => {   
        UnityAR.execute("launchUnity");
        /*UnityAR.launchUnity().then((result) => {
            console.log(result);
        }).catch((err) => {
            console.log(err);
            console.log('Sorry nav, not going to happen');
        });*/
    };

   
    return (<>
      
          <div className="plugintestControls">
             
              <button type="button" style={{ padding: "1em" }} onClick={() => handleTap()}>Place AR</button>
            
          </div>
        {/* <VolumetricPlayer
                        meshFilePath={meshFilePath}
                        videoFilePath={videoFilePath}
                        cameraVerticalOffset={0.5}
                    /> */}
    </>
    );
};

export default IndexPage;
