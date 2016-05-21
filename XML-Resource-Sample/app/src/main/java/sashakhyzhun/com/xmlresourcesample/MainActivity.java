package sashakhyzhun.com.xmlresourcesample;

import android.app.Activity;
import android.content.res.XmlResourceParser;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import org.xmlpull.v1.XmlPullParser;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView text = (TextView)findViewById(R.id.text);
        StringBuilder data = new StringBuilder();

        try {
            XmlResourceParser parser = getResources().getXml(R.xml.contacts);

            while (parser.getEventType() != XmlPullParser.END_DOCUMENT) {
                if (parser.getEventType() == XmlPullParser.START_TAG
                        && parser.getName().equals("contacts")) {
                    data.append(parser.getAttributeValue(0) + " "
                            + parser.getAttributeValue(1) + ": "
                            + parser.getAttributeValue(2) + "\n");
                }
                parser.next();
            }
            text.setText(data);
        } catch (Throwable t) {
            Toast.makeText(this, "Error loading XML document: " + t.toString(), Toast.LENGTH_SHORT).show();
        }

    }
}
