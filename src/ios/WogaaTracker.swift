import Foundation
import Tracker

@objc(WogaaTracker)
public class WogaaTracker : CDVPlugin {
  @objc
  public func check(_ command: CDVInvokedUrlCommand) {
    let message = "Hello !"
    let pluginResult = CDVPluginResult(status: CDVCommandStatus_OK, messageAs: message)
    self.commandDelegate.send(pluginResult, callbackId: command.callbackId)
  }

  @objc
  public func start(_ command: CDVInvokedUrlCommand) {
    let environment = command.argument(at: 0) as! String

    Tracker.setAutotrackScreenViews(enabled: false)

    if environment != nil && environment.count > 0 && environment.lowercased() == "production" {
      Tracker.start(for: .production)
    } else {
      Tracker.start(for: .staging)
    }
  }

  @objc
  public func trackScreenView(_ command: CDVInvokedUrlCommand) {
    let screenName = command.argument(at: 0) as! String

    if screenName != nil && screenName.count > 0 {
      Tracker.trackScreenView(with: screenName)
    }
  }
}