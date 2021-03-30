var wogaatracker = {
  check: function (successCallback, errorCallback) {
    console.log("Called check function!");
    cordova.exec(successCallback, errorCallback, "WogaaTracker", "check", []);
    alert("Executed cordova");
  },
  start: function (environment, successCallback, errorCallback) {
    cordova.exec(successCallback, errorCallback, "WogaaTracker", "start", [
      environment,
    ]);
  },
  trackScreenView: function (screenName, successCallback, errorCallback) {
    cordova.exec(
      successCallback,
      errorCallback,
      "WogaaTracker",
      "trackScreenView",
      [screenName]
    );
  },
};

cordova.addConstructor(function () {
  if (!window.plugins) {
    window.plugins = {};
  }

  window.plugins.wogaatracker = wogaatracker;
  return window.plugins.wogaatracker;
});
