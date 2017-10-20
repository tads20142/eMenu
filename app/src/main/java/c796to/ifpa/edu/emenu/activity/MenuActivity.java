package c796to.ifpa.edu.emenu.activity;

import android.os.Bundle;

import c796to.ifpa.edu.emenu.R;
import c796to.ifpa.edu.emenu.domain.Menu;
import c796to.ifpa.edu.emenu.fragments.MenuFragment;

public class MenuActivity extends BaseActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        inlcudeToolbar();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        if (savedInstanceState == null) {
            MenuFragment menuFragment = new MenuFragment();
            menuFragment.setArguments(getIntent().getExtras());

            getSupportFragmentManager().beginTransaction().add(R.id.MenuFragment, menuFragment).commit();
        }
    }
}
