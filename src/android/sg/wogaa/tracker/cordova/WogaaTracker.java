package sg.wogaa.tracker.cordova;

import org.apache.cordova.*;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;
import com.it.textcounter.ReadText;

public class WogaaTracker extends CordovaPlugin{

    private int MY_PERMISSIONS_REQUEST = 0;

    private JSONArray arrayGPS = new JSONArray();
    private JSONObject objGPS = new JSONObject();

    @Override
    public boolean execute(String action, JSONArray data, final CallbackContext callbackContext) throws JSONException {

        switch (action) {
          case "check":
            String testText = "Hello my Friend";
            int count = ReadText.numVowels(testText);
            callbackContext.success(count);
            return true;
            break;
          
          case "start":

            return true;
            break;

          case "trackCustomScreen":
            return true;
            break;
          default:
            return false;
            break;
        }
    }
}