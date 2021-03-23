# wogaa-tracker-cordova

This is a Wogaa Tracker Cordova plugin to integrate for your iOS and Android app.

## Supported Platforms

- Android
- iOS

## Installation
    cordova plugin add https://github.com/wogaa/cordova-plugin-aar-integration.git


## Usage in javascript

```js
document.addEventListener("deviceready", onDeviceReady, false);

function onDeviceReady() {
  window.plugins.aarintegration.check(successCallback, errorCallback);
}

function successCallback(result) {
  console.log(result);
}

function errorCallback(error) {
  console.log(error);
}
```

## Usage in typescript

```ts

  (<any>window).plugins.aarintegration.check((a) => this.successCallback(a), (b) => this.errorCallback(b));


  successCallback(result) {
    console.log(result);
  }

  errorCallback(error) {
    console.log(error);
  }

```