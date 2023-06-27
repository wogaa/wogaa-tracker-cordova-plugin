package sg.wogaa.tracker.cordova;

import org.apache.cordova.*;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;
import android.widget.Toast;

import sg.wogaa.tracker.Environment;
import sg.wogaa.tracker.Tracker;
import sg.wogaa.tracker.TrackerConfig;

public class WogaaTracker extends CordovaPlugin{

    @Override
    public boolean execute(String action, JSONArray data, final CallbackContext callbackContext) throws JSONException {
        TrackerConfig trackerConfig = new TrackerConfig();
        trackerConfig.setScreenviewEventsEnabled(false);

        if(data.getString(0).equals("PRODUCTION")) {
          trackerConfig.setEnvironment(Environment.PRODUCTION);
        } else {
          trackerConfig.setEnvironment(Environment.STAGING);
        }

        switch (action) {
          case "start":
            Tracker.start(this.cordova.getActivity(), trackerConfig);
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