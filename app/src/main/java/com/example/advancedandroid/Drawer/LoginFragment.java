package com.example.advancedandroid.Drawer;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.advancedandroid.R;
import com.example.advancedandroid.Sqlite.DataBaseHelper;
import com.example.advancedandroid.Sqlite.SignupFragment;

public class LoginFragment extends Fragment {


    EditText username;
    EditText password;
    Button loginBtn;
    Button signupBtn;
    DataBaseHelper db;
    FragmentManager fm;
    @SuppressLint("ValidFragment")
    public LoginFragment(FragmentManager fm){
        this.fm = fm;
    }


    public LoginFragment(){

    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.login_fragment, container, false);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        db =  new DataBaseHelper(getContext());
        // db.addRow(new User("taidev198", "03031998", 4));
        // System.out.println(db.getRowAsObject(1).get(0).getUsername());
        //db.deleteRowAlternative(1);
        //db.updateRow(4, new User("tai", "12345", 4));
        username = getActivity().findViewById(R.id.usernameSignup);
        loginBtn = getActivity().findViewById(R.id.login_btn);
        password = getActivity().findViewById(R.id.passwordSignup);
        signupBtn = getActivity().findViewById(R.id.signupBtn);
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (db.getRowAsObjectByUsername(username.getText().toString(), password.getText().toString()))
                    Toast.makeText(getActivity(), "correct", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(getActivity(), "incorrect", Toast.LENGTH_SHORT).show();
            }
        });
        signupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SignupFragment signupFragment = new SignupFragment(fm);
                //add to back stack to be able come back the previous fragment.
                fm.beginTransaction().replace(R.id.frame_layout, signupFragment).addToBackStack(null).commit();

            }
        });
    }

    @Override
    public void onDestroyView() {
        db.db.close();
        super.onDestroyView();
    }
}
