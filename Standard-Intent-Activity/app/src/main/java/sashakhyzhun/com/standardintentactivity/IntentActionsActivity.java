package sashakhyzhun.com.standardintentactivity;

import android.app.Activity;
import android.content.Intent;
import android.provider.Browser;
import android.provider.MediaStore;
import android.os.Bundle;
import android.view.View;

public class IntentActionsActivity extends Activity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_actions);
    }

    @Override
    public void onClick(View v) {
        String action = "";

        switch (v.getId()) {
            case R.id.bVideoRecord:
                action = MediaStore.INTENT_ACTION_VIDEO_CAMERA;
                break;
            case R.id.bMusicPlayer:
                action = MediaStore.INTENT_ACTION_MUSIC_PLAYER;
                break;
            case R.id.bOpenCamera:
                action = MediaStore.INTENT_ACTION_STILL_IMAGE_CAMERA;
                break;
            case R.id.bOpenBrowser:
                action = Browser.EXTRA_CREATE_NEW_TAB;
                break;
        }

        Intent intent = new Intent(action);
        startActivity(intent);

    }
}
