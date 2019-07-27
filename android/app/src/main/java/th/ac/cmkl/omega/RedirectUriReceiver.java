package th.ac.cmkl.omega;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

public class RedirectUriReceiver extends Activity {
    public void onCreate(Bundle savedInstanceBundle){
        super.onCreate(savedInstanceBundle);
        Intent intent = this.getIntent();
        Uri uri = intent.getData();
        assert uri != null;
        String access_token = uri.getQueryParameter("code");
        String error = uri.getQueryParameter("error");
        io.flutter.plugins.flutterauth0.FlutterAuth0Plugin.resolveWebAuthentication(access_token, error);
        Intent openMainAct = new Intent(RedirectUriReceiver.this, th.ac.cmkl.omega.MainActivity.class);
        openMainAct.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        startActivityIfNeeded(openMainAct,0);
        this.finish();
    }
}
