package com.example.advancedandroid.Sqlite;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.advancedandroid.Drawer.LoginFragment;
import com.example.advancedandroid.R;

public class SignupFragment extends Fragment {

    public  interface onReceivedDataListener{
        void onReceivedData(User user);
    }
    onReceivedDataListener mListener;
   FragmentManager fm;
   Button signup;
   TextView usernameSignup;
   TextView passwordSignup;
   TextView confirmpasswordSignup;

   DataBaseHelper db;
    @SuppressLint("ValidFragment")
    public SignupFragment(FragmentManager fm) {
        // Required empty public constructor
        this.fm = fm;

    }

    public SignupFragment(){

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_signup, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        db = new DataBaseHelper(getContext());
        signup = getActivity().findViewById(R.id.signupBtnSignup);
        usernameSignup = getActivity().findViewById(R.id.usernameSignup);
        passwordSignup = getActivity().findViewById(R.id.passwordSignup);
        confirmpasswordSignup = getActivity().findViewById(R.id.confirmpasswordSignup);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(usernameSignup.getText().length() != 0 && passwordSignup.getText().length() != 0
                && confirmpasswordSignup.getText().length() != 0){
                    if (!passwordSignup.getText().toString().equals(confirmpasswordSignup.getText().toString()))
                        Toast.makeText(getContext(), "password and confirm password are not matched", Toast.LENGTH_SHORT).show();
                    else {
                        db.addRow(new User(usernameSignup.getText().toString(), passwordSignup.getText().toString(), 0));
//                        LoginFragment loginFragment = new LoginFragment(fm);
//                        fm.beginTransaction().replace(R.id.frame_layout, loginFragment).commit();
                        mListener.onReceivedData(new User(usernameSignup.getText().toString(), passwordSignup.getText().toString(), 5));
                    }
                }else
                Toast.makeText(getContext(), "please typed something", Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try{
            mListener = (onReceivedDataListener) context;
        }catch (ClassCastException e){
            e.printStackTrace();
        }



    }

    @Override
    public void onDetach() {

        super.onDetach();

    }

    @Override
    public void onDestroyView() {

        super.onDestroyView();
    }

    @Override
    public void onDestroy() {

        super.onDestroy();
    }


}
