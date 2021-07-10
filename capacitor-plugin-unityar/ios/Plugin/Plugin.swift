import Foundation
import Capacitor


/**
 * Please read the Capacitor iOS Plugin Development Guide
 * here: https://capacitorjs.com/docs/plugins/ios
 */
@objc(UnityAR)
public class UnityAR: CAPPlugin {
    @objc func execute(_ call: CAPPluginCall) {
        let value = call.getString("value") ?? ""
        NotificationCenter.default.post(name: NSNotification.Name("launchUnity"), object: value)
        call.resolve()

    }
}
