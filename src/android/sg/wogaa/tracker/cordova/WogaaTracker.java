package sg.wogaa.tracker.cordova;

import org.apache.cordova.*;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;
import android.widget.Toast;

import sg.wogaa.tracker.Environment;
import sg.wogaa.tracker.Tracker;

public class WogaaTracker extends CordovaPlugin{

    @Override
    public boolean execute(String action, JSONArray data, final CallbackContext callbackContext) throws JSONException {
        switch (action) {
          case "start":
            if(data.getString(0).equals("PRODUCTION")) {
              Tracker.start(this.cordova.getActivity(), Environment.PRODUCTION);
            } else {
              Tracker.start(this.cordova.getActivity(), Environment.STAGING);
            }
            break;
          case "trackScreenView":
            Tracker.trackScreenView(data.getString(0));
            break;
          default:
            return false;
        }
        return true;
    }
}