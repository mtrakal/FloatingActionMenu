package com.flask.floatingactionmenu.sample;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.flask.floatingactionmenu.FadingBackgroundView;
import com.flask.floatingactionmenu.FloatingActionButton;
import com.flask.floatingactionmenu.FloatingActionMenu;
import com.flask.floatingactionmenu.FloatingActionToggleButton;

import java.util.Random;


public class MainActivity extends AppCompatActivity {

    FloatingActionMenu floatingActionMenu;
    Button refresh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        floatingActionMenu = (FloatingActionMenu) findViewById(R.id.fam);
        refresh = (Button) findViewById(R.id.refresh);
        refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initFabs();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        initFabs();
    }

    private void initFabs() {
        FadingBackgroundView fadingBackgroundView = (FadingBackgroundView) findViewById(R.id.fading);
        floatingActionMenu.removeAllButtons();
        LayoutInflater li = LayoutInflater.from(this);
        int FABS_COUNT = 2 + new Random().nextInt(3);
        for (int i = 0; i < FABS_COUNT; i++) {

            FloatingActionButton fab;
            if (i == FABS_COUNT - 1) {
                fab = (FloatingActionToggleButton) li.inflate(R.layout.include_fab_togle, null);
            } else {
                fab = (FloatingActionButton) li.inflate(R.layout.include_fab_mini, null);
            }
            fab.setLabelText("asd " + i);
            if (i != FABS_COUNT - 1) {
                fab.setIconDrawable(R.drawable.ic_mode_edit_white_18dp);
            }
            fab.setBackgroundColor(R.color.remainder, R.color.inbox_fab);
            setOnClickEvent(floatingActionMenu, fab, FABS_COUNT);
            if (i == FABS_COUNT - 1) {
                floatingActionMenu.setFloatingActionToggleButton((FloatingActionToggleButton) fab);
            } else {
                floatingActionMenu.addFloatingActionButton(fab);
            }
        }

        floatingActionMenu.setFadingBackgroundView(fadingBackgroundView);
        floatingActionMenu.build();
    }

    private void setOnClickEvent(final FloatingActionMenu floatingActionMenu, @NonNull final FloatingActionButton fab, final int fabCount) {
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (fab instanceof FloatingActionToggleButton) {
                    FloatingActionToggleButton fatb = (FloatingActionToggleButton) fab;
                    if (fatb.isToggleOn() || fabCount == 1) {
                        toast(fatb.getLabelText());
                    }
                } else {
                    toast(fab.getLabelText());
                    floatingActionMenu.toggleOffImmediately();
//                    startActivity(new Intent(MainActivity.this, EmptyActivity.class));
                }
            }
        });
    }

    private void toast(String msg) {
        Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
    }
}
