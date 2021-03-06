package com.example.sergio.t2ej24_tabs;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TabHost;

public class MainActivity extends AppCompatActivity {

    private Menu menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //tabs
        TabHost tabs = (TabHost) findViewById(android.R.id.tabhost);
        tabs.setup();

        TabHost.TabSpec spec = tabs.newTabSpec("tab1");
        spec.setContent(R.id.tab1);
        spec.setIndicator(getString(R.string.llamadas));
        tabs.addTab(spec);

        spec = tabs.newTabSpec("tab2");
        spec.setContent(R.id.tab2);
        spec.setIndicator(getString(R.string.chats));
        tabs.addTab(spec);

        spec = tabs.newTabSpec("tab3");
        spec.setContent(R.id.tab3);
        spec.setIndicator(getString(R.string.contactos));
        tabs.addTab(spec);

        tabs.setCurrentTab(0);

        tabs.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            public void onTabChanged(String selected) {
                Log.i("AndroidTabsDemo", "Pulsada pestaña: " + selected);
                MenuItem i = menu.findItem(R.id.otro);

                switch (selected){
                    case "tab1":
                        i.setIcon(R.drawable.ic_llamadas);
                        break;
                    case "tab2":
                        i.setIcon(R.drawable.ic_chats);
                        break;
                    case "tab3":
                        i.setIcon(R.drawable.ic_contactos);
                        break;
                }
            }
        });

    }

    public boolean onCreateOptionsMenu(Menu menu){
        this.menu = menu;

        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }
}
