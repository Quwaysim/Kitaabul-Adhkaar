package com.amc.astc.adhkaar.adapters;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.amc.astc.adhkaar.R;

public class MyListAdapter extends ArrayAdapter<String> {

    private String[] stringArray;
    private int textSize;

    public MyListAdapter(@NonNull Context context, int resource, @NonNull String[] objects, int textSize) {
        super(context, resource, objects);
        stringArray = objects;
        this.textSize = textSize;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        super.getView(position, convertView, parent);

        if (convertView == null) {
            LayoutInflater vi = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = vi.inflate(R.layout.adhkar_list_item, null);
        }
        assert convertView != null;
        TextView tv = (TextView) convertView.findViewById(R.id.textview_adhkar_list);
        tv.setTextSize(textSize);
        tv.setText(stringArray[position]);
        if (position== 0){
            tv.setTypeface(tv.getTypeface(), Typeface.BOLD);
        }
        return convertView;
    }
}
