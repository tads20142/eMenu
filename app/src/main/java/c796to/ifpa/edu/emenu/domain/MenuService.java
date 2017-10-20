package c796to.ifpa.edu.emenu.domain;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;


public class MenuService {

    public static List<Menu> getMenus(Context context, int tipo)
    {
        String tipoString = context.getString(tipo);
        List<Menu> menus = new ArrayList<Menu>();


        /*Menu menuRefri = new Menu();
        menuRefri.nome = "Nome: " + tipoString;
        menuRefri.descricao = "1L";
        menuRefri.valor = "R$ 5,00";
        menus.add(menuRefri);

        Menu menuPizza = new Menu();
        menuPizza.nome = "Nome: " + tipoString;
        menuPizza.descricao = "Tamanho família, 4 Queijos";
        menuPizza.valor = "R$ 35,00";
       menus.add(menuPizza);*/

        for (int i = 0; i < 20; i++)
        {
            Menu m = new Menu();
            m.nome = "Menu " + tipoString + ": " + i; //Nome de acordo com o tipo
            m.descricao = "Descrição " + i;
            m.valor = "Valor: R$ " + i +",00";
            menus.add(m);
        }

        return menus;
    }
}
