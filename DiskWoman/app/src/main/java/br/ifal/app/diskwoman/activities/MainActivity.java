package br.ifal.app.diskwoman.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import br.ifal.app.diskwoman.R;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main);

        BottomAppBar btnApp = findViewById(R.id.bottomAppBar);
        btnApp.replaceMenu(R.menu.bottomappbar_menu);

        FloatingActionButton fab = findViewById(R.id.floatingActionButton);
        fab.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, RegisterOccurrenceActivity.class);
                startActivity(i);

                finish();
            }
        });

        btnApp.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {

            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch(item.getItemId()) {
                    case R.id.app_bar_home:
                        toast("Você está na Página Inicial");
                        break;

                    case R.id.app_bar_phone:
                        Intent i = new Intent(MainActivity.this, CallActivity.class);
                        startActivity(i);
                        break;

                    case R.id.app_bar_info:
                        Intent in = new Intent(MainActivity.this, AboutActivity.class);
                        startActivity(in);
                        break;

                    default:
                        break;
                }

                return false;
            }
        });

    }

    private void toast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }
}
