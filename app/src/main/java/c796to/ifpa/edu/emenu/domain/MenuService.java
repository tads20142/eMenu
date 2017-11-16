package c796to.ifpa.edu.emenu.domain;

import android.content.Context;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import c796to.ifpa.edu.emenu.R;
import livroandroid.lib.utils.FileUtils;


public class MenuService {

    public static List<Menu> getMenus(Context context, int tipo) throws IOException
    {
       String json = readFile(context, tipo);
        List<Menu> menus = parserJSON(context, json);

        return menus;
    }

    private static String readFile(Context context, int tipo) throws IOException
    {
        if (tipo == R.string.refrigerantes)
        {
            return FileUtils.readRawFileString(context, R.raw.refrigerantes, "UTF-8");
        }
        else
            return FileUtils.readRawFileString(context, R.raw.cervejas, "UTF-8");
    }

    private static List<Menu> parserJSON(Context context, String json) throws IOException
    {
        List<Menu> menus = new ArrayList<Menu>();
        try
        {
            JSONObject root = new JSONObject(json);
            JSONObject obj = root.getJSONObject("menus");
            JSONArray jsonMenus = obj.getJSONArray("menu");

            //insere cada item na lista
            for (int i = 0; i < jsonMenus.length(); i++)
            {
                JSONObject jsonMenu = jsonMenus.getJSONObject(i);
                Menu m = new Menu();
                m.nome = jsonMenu.optString("nome");
                m.valor = jsonMenu.optString("valor");
                m.descricao = jsonMenu.optString("descricao");

                menus.add(m);
            }
        }
        catch (JSONException e)
        {
            throw new IOException(e.getMessage(), e);
        }

        return menus;
    }
}
