package com.edwinacubillos.itaguitur;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class FragmentexActivity extends AppCompatActivity {

    FragmentManager fm;
    FragmentTransaction ft;
    ParqueDosFragment p2;
    ParqueUnoFragment p1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragmentex);

        fm = getSupportFragmentManager();
        ft = fm.beginTransaction();

        p1 = new ParqueUnoFragment();
        ft.add(android.R.id.content, p1).commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu2, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        ft = fm.beginTransaction();
        if (id == R.id.mFrag1){
            p1 = new ParqueUnoFragment();
            ft.replace(android.R.id.content, p1).commit();
        } else {
            p2 = new ParqueDosFragment();
            ft.replace(android.R.id.content, p2).commit();
        }
        return super.onOptionsItemSelected(item);
    }
}
