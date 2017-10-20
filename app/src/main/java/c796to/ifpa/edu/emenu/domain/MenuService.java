package c796to.ifpa.edu.emenu.domain;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;


public class MenuService {

    public static List<Menu> getMenus(Context context, int tipo)
    {
        String tipoString = context.getString(tipo);
        List<Menu> menus = new ArrayList<Menu>();

        for (int i = 0; i < 20; i++)
        {
            Menu m = new Menu();
            m.nome = "Menu " + tipoString + ": " + i; //Nome de acordo com o tipo
            m.descricao = "Descrição " + i;
            m.valor = "Valor: " + i;
           // m.urlFoto = "http://www.livroandroid.com.br/livro/carros/esportivos/Ferrari_FF.png";
            menus.add(m);
        }

        return menus;
    }
}
