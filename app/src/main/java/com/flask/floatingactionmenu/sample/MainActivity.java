package com.flask.floatingactionmenu.sample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.flask.floatingactionmenu.FadingBackgroundView;
import com.flask.floatingactionmenu.FloatingActionButton;
import com.flask.floatingactionmenu.FloatingActionMenu;
import com.flask.floatingactionmenu.FloatingActionToggleButton;
import com.flask.floatingactionmenu.OnFloatingActionMenuSelectedListener;


public class MainActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		setOnClickEvent(R.id.fab1, "fab1");
		setOnClickEvent(R.id.fab2, "fab2");
		setOnClickEvent(R.id.fab3, "fab3");
		setOnClickEvent(R.id.fab_toggle, "toggle");

		FadingBackgroundView fadingBackgroundView = (FadingBackgroundView) findViewById(R.id.fading);
		final FloatingActionMenu floatingActionMenu = (FloatingActionMenu) findViewById(R.id.fam);
		floatingActionMenu.setFadingBackgroundView(fadingBackgroundView);

		floatingActionMenu.setLabelText(0, "faba : Wow 0");
		floatingActionMenu.setLabelText(1, "fabb : Wow Wow 1");
		floatingActionMenu.setLabelText(2, "fabc : Wow Wow Wow 2");
		floatingActionMenu.setLabelText(3, "fab_toggle : Wow Wow Wow Wow 3");

		floatingActionMenu.setIcon(2, R.drawable.ic_mode_edit_white_48dp);

		floatingActionMenu.setBackgroundColor(2, getResources().getColor(R.color.accent_material_light), false);

		floatingActionMenu.setOnFloatingActionMenuSelectedListener(new OnFloatingActionMenuSelectedListener() {
			@Override
			public void onFloatingActionMenuSelected(FloatingActionButton fab) {
				if (fab instanceof FloatingActionToggleButton) {
					FloatingActionToggleButton fatb = (FloatingActionToggleButton) fab;
					if (fatb.isToggleOn()) toast(fab.getLabelText());
				} else {
					toast(fab.getLabelText());
				}
			}
		});

//		FloatingActionMenuBuilder
//				.with(this)
//				.

		final FloatingActionToggleButton fab3 = (FloatingActionToggleButton) findViewById(R.id.fab3);
		fab3.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				if (fab3.isToggleOn()) {
					floatingActionMenu.setVisibility(View.GONE);
				} else {
					floatingActionMenu.setVisibility(View.VISIBLE);
				}
			}
		});
	}

	private void setOnClickEvent(int id, final String msg) {
		findViewById(id).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				toast(msg);
			}
		});
	}

	private void toast(String msg) {
		Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
	}
}
