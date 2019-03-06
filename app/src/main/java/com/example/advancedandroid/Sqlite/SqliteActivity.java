package com.example.advancedandroid.Sqlite;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;

import com.example.advancedandroid.Drawer.LoginFragment;
import com.example.advancedandroid.R;

public class SqliteActivity extends FragmentActivity {


    FragmentTransaction fragmentTransaction;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlite);
        fragmentTransaction = getSupportFragmentManager().beginTransaction();
        LoginFragment loginFragment = new LoginFragment(getSupportFragmentManager());
        fragmentTransaction.add(R.id.frame_layout, loginFragment);
        fragmentTransaction.commit();
    }




    @Override
    protected void onDestroy() {
        super.onDestroy();

    }
}
