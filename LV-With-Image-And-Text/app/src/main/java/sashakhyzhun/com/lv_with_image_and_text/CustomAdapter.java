package sashakhyzhun.com.lv_with_image_and_text;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomAdapter extends BaseAdapter {

    private LayoutInflater inflater;

    private static final String[] contacts = {
            "Sasha", "Masha", "Pasha", "Natasha", "Misha", "Alexey",
            "Igor", "Maxim", "Andrew", "Joseph", "Sasha", "Masha",
            "Pasha", "Natasha", "Misha", "Oleg", "David", "Pytin Loh" };

    private static final int[] images = {
            R.mipmap.ic_launcher,
            R.mipmap.ic_launcher,
            R.mipmap.ic_launcher,
            R.mipmap.ic_launcher,
            R.mipmap.ic_launcher,
            R.mipmap.ic_launcher,
            R.mipmap.ic_launcher,
            R.mipmap.ic_launcher,
            R.mipmap.ic_launcher,
            R.mipmap.ic_launcher,
            R.mipmap.ic_launcher,
            R.mipmap.ic_launcher,
            R.mipmap.ic_launcher,
            R.mipmap.ic_launcher,
            R.mipmap.ic_launcher,
            R.mipmap.ic_launcher,
            R.mipmap.ic_launcher,
            R.mipmap.ic_launcher
    };

    public CustomAdapter(Context context) {
        super();
        inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return contacts.length;
    }

    @Override
    public String getItem(int position) {
        return contacts[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //получаем компоновку строки
        View view = inflater.inflate(R.layout.row, null);

        //загружаем в строку данные из массивов
        ImageView image = (ImageView)view.findViewById(R.id.option_id);
        image.setImageResource(images[position]);

        TextView text = (TextView)view.findViewById(R.id.option_text);
        text.setText(contacts[position]);

        return view;
    }


}
