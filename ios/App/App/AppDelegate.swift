import UIKit
import Capacitor
import UnityFramework

@UIApplicationMain
class AppDelegate: UIResponder, UIApplicationDelegate {

  var window: UIWindow?
 
    
    
    
  func application(_ application: UIApplication, didFinishLaunchingWithOptions launchOptions: [UIApplication.LaunchOptionsKey: Any]?) -> Bool {
    Unity.shared.setHostMainWindow(window)

    let notificationCenter = NotificationCenter.default
    notificationCenter.addObserver(self, selector: #selector(launchUnity(notification:)), name: Notification.Name("launchUnity"), object: nil)
    return true
  }
    @objc
    func launchUnity(notification:NSNotification)  {
       
        DispatchQueue.main.async {
           
            Unity.shared.show()
            
        }
        
    }
  func applicationWillResignActive(_ application: UIApplication) {
            
  }

  func applicationDidEnterBackground(_ application: UIApplication) {
           
  }

  func applicationWillEnterForeground(_ application: UIApplication) {
           
  }

  func applicationDidBecomeActive(_ application: UIApplication) {
            
  }

  func applicationWillTerminate(_ application: UIApplication) {
            
  }
    
  func application(_ app: UIApplication, open url: URL, options: [UIApplication.OpenURLOptionsKey : Any] = [:]) -> Bool {
    return CAPBridge.handleOpenUrl(url, options)
  }
  
  func application(_ application: UIApplication, continue userActivity: NSUserActivity, restorationHandler: @escaping ([UIUserActivityRestoring]?) -> Void) -> Bool {
    return CAPBridge.handleContinueActivity(userActivity, restorationHandler)
  }

  override func touchesBegan(_ touches: Set<UITouch>, with event: UIEvent?) {
    super.touchesBegan(touches, with: event)

    let statusBarRect = UIApplication.shared.statusBarFrame
    guard let touchPoint = event?.allTouches?.first?.location(in: self.window) else { return }

    if statusBarRect.contains(touchPoint) {
      NotificationCenter.default.post(CAPBridge.statusBarTappedNotification)
    }
  }

  #if USE_PUSH

  func application(_ application: UIApplication, didRegisterForRemoteNotificationsWithDeviceToken deviceToken: Data) {
    NotificationCenter.default.post(name: Notification.Name(CAPNotifications.DidRegisterForRemoteNotificationsWithDeviceToken.name()), object: deviceToken)
  }

  func application(_ application: UIApplication, didFailToRegisterForRemoteNotificationsWithError error: Error) {
    NotificationCenter.default.post(name: Notification.Name(CAPNotifications.DidFailToRegisterForRemoteNotificationsWithError.name()), object: error)
  }

#endif
}

