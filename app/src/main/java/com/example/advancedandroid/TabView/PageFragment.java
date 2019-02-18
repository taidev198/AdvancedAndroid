package com.example.advancedandroid.TabView;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.advancedandroid.R;

import org.jetbrains.annotations.NotNull;

public   class PageFragment extends Fragment {
    public static final String ARG_OBJECT = "object";

    @Override
    public View onCreateView(@NotNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        // The last two arguments ensure LayoutParams are inflated
        // properly.
        View rootView = inflater.inflate(
                R.layout.page_fragment, container, false);
        Bundle args = getArguments();
        ((TextView) rootView.findViewById(R.id.textView)).setText("Fragment " +
                Integer.toString(args.getInt(ARG_OBJECT)));
        return rootView;
    }
}
