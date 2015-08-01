package com.example.sony1.Seyedpour;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;

public class FishAdapter extends ArrayAdapter<Fish>
{
    private Context context;
    private List<Fish> objects;
    public FishAdapter(Context context, int resource, List<Fish> objects) {
       super(context, resource, objects);
       this.context=context;
       this.objects=objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Fish fish=objects.get(position);
        LayoutInflater inflater=(LayoutInflater)context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);

        View view= inflater.inflate(R.layout.item_fish, null);

        ImageView image=(ImageView)view.findViewById(R.id.imageView3);
        image.setImageResource(fish.imageResource);

        TextView tv=(TextView)view.findViewById(R.id.textView2);
        tv.setText(fish.fishName);
        return view;
    }
}
