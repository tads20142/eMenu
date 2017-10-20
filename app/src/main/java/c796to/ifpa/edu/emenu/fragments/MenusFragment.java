package c796to.ifpa.edu.emenu.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.List;

import c796to.ifpa.edu.emenu.R;
import c796to.ifpa.edu.emenu.activity.MenuActivity;
import c796to.ifpa.edu.emenu.adapter.MenuAdapter;
import c796to.ifpa.edu.emenu.domain.Menu;
import c796to.ifpa.edu.emenu.domain.MenuService;


public class MenusFragment extends BaseFragment {

    private int tipo;
    protected RecyclerView recyclerView;
    private List<Menu> menus;

    //instanciar o fragmento pelo tipo
    public static MenusFragment newInstance(int tipo)
    {
        Bundle bundle = new Bundle();
        bundle.putInt("tipo", tipo);
        MenusFragment menusFragment = new MenusFragment();
        menusFragment.setArguments(bundle);

        return menusFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        if (getArguments() != null)
        {
            this.tipo = getArguments().getInt("tipo");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_menus, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setHasFixedSize(true);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstaceState)
    {
        super.onActivityCreated(savedInstaceState);
        taskMenus();
    }

    private void taskMenus()
    {
        //Busca os itens do menu pelo tipo
        this.menus = MenuService.getMenus(getContext(), tipo);
        //Atualiza a lista
        recyclerView.setAdapter(new MenuAdapter(getContext(), menus, onClickMenu()));
    }

    private MenuAdapter.MenuOnClickListener onClickMenu()
    {
        return new MenuAdapter.MenuOnClickListener()
        {
            @Override
            public void onClickMenu(View view, int idx) {
               Menu menu = menus.get(idx);
               mensagem("Menu " + menu.nome);

            }
        };
    }

    private void mensagem(String msg)
    {
        Toast.makeText(getContext(), msg, Toast.LENGTH_LONG).show();
    }

}
