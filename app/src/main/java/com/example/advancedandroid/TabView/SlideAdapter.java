package com.example.advancedandroid.TabView;


import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.advancedandroid.R;

public class SlideAdapter extends PagerAdapter {

    LayoutInflater inflater;
    Context context;
    public SlideAdapter(Context context){
        this.context = context;
    }

    String[] title = {"1", "2", "3"};
    int[]  lst_backgroundcolor = {
            Color.rgb(55,55,55),
            Color.rgb(239,85,85),
            Color.rgb(110,49,89),
            Color.rgb(1,188,212)
    };

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View v = inflater.inflate(R.layout.slide, container, false);
        ConstraintLayout layout  =  v.findViewById(R.id.layout);
        layout.setBackgroundColor(lst_backgroundcolor[position]);
        TextView text = v.findViewById(R.id.textView);
        text.setText(title[position]);
        container.addView(v);
        return v;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((ConstraintLayout)object);
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return (view == o);
    }
}
