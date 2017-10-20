package c796to.ifpa.edu.emenu.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import c796to.ifpa.edu.emenu.R;
import c796to.ifpa.edu.emenu.domain.Menu;


public class MenuFragment extends BaseFragment{
    private int tipo;


    //Método para instanciar o fragmento pelo tipo de opção

    public static MenuFragment newInstance(int tipo)
    {
        Bundle bundle = new Bundle();
        bundle.putInt("tipo", tipo);
        MenuFragment menuFragment = new MenuFragment();
        menuFragment.setArguments(bundle);
        return menuFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        if (getArguments() != null)
        {
            this.tipo = getArguments().getInt("tipo"); //lê o tipo dos argumentos
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_menu, container, false);
       TextView text = (TextView) view.findViewById(R.id.text);
       text.setText("Menu " + getString(tipo));

        return view;
    }



}
