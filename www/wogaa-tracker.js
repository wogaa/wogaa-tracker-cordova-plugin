var wogaatracker = {
  check: function (successCallback, errorCallback) {
    cordova.exec(successCallback, errorCallback, "WogaaTracker", "check", []);
  },

  start: function (successCallback, errorCallback) {
    cordova.exec(successCallback, errorCallback, "WogaaTracker", "start", []);
  },

  trackCustomScreen: function (screenName, successCallback, errorCallback) {
    cordova.exec(
      successCallback,
      errorCallback,
      "WogaaTracker",
      "trackCustomScreen",
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
