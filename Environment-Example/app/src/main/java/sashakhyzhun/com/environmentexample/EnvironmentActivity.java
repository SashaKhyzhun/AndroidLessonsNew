package sashakhyzhun.com.environmentexample;

import android.app.Activity;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class EnvironmentActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_environment);

        TextView text = (TextView)findViewById(R.id.text);

        text.append(
                "My system environment:"
                + "\n\nRoot:\t" + Environment.getRootDirectory()
                + "\nDownload Cache Dir:\t" + Environment.getDownloadCacheDirectory()
                + "\nExternal Storage State:\t" + Environment.getExternalStorageState()
                + "\nData Directory:\t" + Environment.getDataDirectory()
                + "\nisExternal Storage Removable:\t" + Environment.getExternalStorageState()
                + "\nExternal Storage Dir\t" + Environment.getExternalStorageDirectory()

                + "\n\nExternal Storage Public Directory:\t"
                + "\n\tAlarms:\t" + Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_ALARMS)
                + "\n\tDCIM:\t" + Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM)
                + "\n\tDownloads:\t" + Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS)
                + "\n\tMovie:\t" + Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MOVIES)
                + "\n\tMusic:\t" + Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MUSIC)
                + "\n\tNotification:\t" + Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_NOTIFICATIONS)
                + "\n\tPictures:\t" + Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES)
                + "\n\tPodcasts:\t" + Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PODCASTS)
                + "\n\tRingtones:\t" + Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_RINGTONES)
        );

    }
}
