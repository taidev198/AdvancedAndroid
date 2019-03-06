package com.example.advancedandroid.DataAndFile;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.advancedandroid.R;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class SavingFileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saving_file);
        //creating a new file ....
        File file = new File( getFilesDir().toString()+"test.txt");
        if (!file.exists()) {
            try {
                System.out.println("created file");
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //showing all files on device.
        System.out.println(Arrays.toString(fileList()));

        //Writing to file
//        try {
//            FileOutputStream fos = openFileOutput("text.txt", Context.MODE_PRIVATE);
//            fos.write("thanh tai nguyen".getBytes());
//            fos.close();
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }


        //open the exist file
        try {
            FileInputStream fis = openFileInput("text.txt");
            System.out.println();
            fis.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
