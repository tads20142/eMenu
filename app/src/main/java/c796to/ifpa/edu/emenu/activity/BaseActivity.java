package c796to.ifpa.edu.emenu.activity;

import android.support.v4.app.Fragment;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import c796to.ifpa.edu.emenu.R;
import c796to.ifpa.edu.emenu.fragments.MenuFragment;
import c796to.ifpa.edu.emenu.fragments.MenusFragment;

/**
 * Created by Renan on 19/10/2017.
 */

public class BaseActivity extends AppCompatActivity {

    protected DrawerLayout drawerLayout;

    protected void inlcudeToolbar()
    {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        if (toolbar != null)
        {
            setSupportActionBar(toolbar);
        }
    }

    //Configuração do nav drawer
    protected void setupNavDrawer()
    {
        //Drawer layout
        final ActionBar actionBar = getSupportActionBar();
        //Icone do drawer
        actionBar.setHomeAsUpIndicator(R.drawable.ic_menu);
        actionBar.setDisplayHomeAsUpEnabled(true);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);

        if (navigationView != null && drawerLayout != null)
        {
            //Atualiza
            setNavViewValues(navigationView, R.string.nav_drawer_username, R.mipmap.ic_launcher);

            //Tratar o toque no menu
            navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    //seleciona a linha
                    item.setChecked(true);
                    //fecha o menu
                    drawerLayout.closeDrawers();
                    //Trata o evento do menu
                    onNavDrawerItemSelected(item);
                    return true;
                }
            });
        }
    }

    //Atualiza todos os dados do header
    static void setNavViewValues(NavigationView navView, int nome, int img)
    {
        View headerView = navView.getHeaderView(0);
        TextView txtNome = (TextView) headerView.findViewById(R.id.tNome);
        ImageView imgView = (ImageView) headerView.findViewById(R.id.img);

        txtNome.setText(nome);
        imgView.setImageResource(img);
    }

    //Trata o evento do menu lateral
    private void onNavDrawerItemSelected(MenuItem menuItem)
    {
        switch (menuItem.getItemId())
        {
            case R.id.nav_item_refrigerantes:
                replaceFragment(MenusFragment.newInstance(R.string.refrigerantes));
                break;
            case R.id.nav_item_cervejas:
                replaceFragment(MenusFragment.newInstance(R.string.cervejas));
                break;
            case R.id.nav_item_pizzas:
                replaceFragment(MenusFragment.newInstance(R.string.pizzas));
                break;
            case R.id.nav_item_massas:
                replaceFragment(MenusFragment.newInstance(R.string.massas));
                break;
            case R.id.nav_item_carnes:
                replaceFragment(MenusFragment.newInstance(R.string.carnes));
                break;
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId())
        {
            case android.R.id.home:
                //trata o clique no botao que abre o menu
                if (drawerLayout != null)
                {
                    openDrawer();
                    return true;
                }
        }

        return super.onOptionsItemSelected(item);
    }

    //Abre o menu lateral
    protected void openDrawer()
    {
        if (drawerLayout != null)
        {
            drawerLayout.openDrawer(GravityCompat.START);
        }
    }

    //fecha menu lateral
    protected void closeDrawer()
    {
        if (drawerLayout != null)
        {
            drawerLayout.closeDrawer(GravityCompat.START);
        }
    }

    private void mensagem(String msg)
    {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }

    //Adicionando o fragment no centro da tela
    protected void replaceFragment(Fragment frag)
    {
        getSupportFragmentManager().beginTransaction().replace(R.id.container, frag, "TAG").commit();
    }
}
