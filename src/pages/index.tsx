import { Capacitor,Plugins } from '@capacitor/core';
import "webxr-native";
import React, { useEffect, useState } from 'react';
import 'cordova-plugin-unityar';
const { UnityAR } = Plugins;



export const IndexPage = (): any => {
    const raf = () => {
        requestAnimationFrame(raf);
    };


  

    const handleTap = async () => {        
        if(UnityAR){
            UnityAR.launchWithMessage("Manager","GetMessageFromCordova","Cordova Msg",
                (data)=>{
                    console.log("success ",data);
                },(err)=>{
                    console.log("error ",err);
            });;
        }
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
