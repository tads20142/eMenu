package c796to.ifpa.edu.emenu.activity;

import android.os.Bundle;

import c796to.ifpa.edu.emenu.R;
import c796to.ifpa.edu.emenu.fragments.MenuFragment;
import c796to.ifpa.edu.emenu.fragments.MenusFragment;

public class MainActivity extends BaseActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inlcudeToolbar();
        setupNavDrawer();

        //determinar qual fragment iniciar
        replaceFragment(MenusFragment.newInstance(R.string.refrigerantes));

    }
}
