package c796to.ifpa.edu.emenu.adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.io.File;
import java.util.List;

import c796to.ifpa.edu.emenu.R;
import c796to.ifpa.edu.emenu.domain.Menu;


public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.MenusViewHolder> {

    private final List<Menu> menus;
    private final Context context;
    private MenuOnClickListener menuOnClickListener;

    public MenuAdapter(Context context, List<Menu> menus, MenuOnClickListener menuOnClickListener) {
        this.context = context;
        this.menus = menus;
        this.menuOnClickListener = menuOnClickListener;
    }

    @Override
    public int getItemCount() {
        return this.menus != null ? this.menus.size() : 0;
    }

    @Override
    public MenusViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType)
    {
        View view = LayoutInflater.from(context).inflate(R.layout.adapter_menu, viewGroup, false);
        MenusViewHolder holder = new MenusViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(final MenusViewHolder holder, final int position) {
        //Atualiza a view

        Menu m = menus.get(position);
        holder.txtNome.setText(m.nome);
        holder.txtDescricao.setText(m.descricao);
        holder.txtValor.setText(m.valor);
        holder.progress.setVisibility(View.VISIBLE);
        //Fazendo o download da imagem

        //  Picasso.with(context).load(m.urlFoto).fit().into(holder.img, new com.squareup.picasso.Callback()

        //clicou?
        if (menuOnClickListener != null)
        {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    menuOnClickListener.onClickMenu(holder.itemView, position);
                }
            });
        }

}

    public interface MenuOnClickListener
    {
         void onClickMenu(View view, int idx);
    }

    //viewHolder com as viewa
    public static class MenusViewHolder extends RecyclerView.ViewHolder
    {
        public TextView txtNome;
        public TextView txtDescricao;
        public TextView txtValor;
        ImageView img;
        ProgressBar progress;
        CardView cardView;

        public MenusViewHolder(View itemView) {
            super(itemView);
            txtNome = (TextView) itemView.findViewById(R.id.tNome);
            txtDescricao = (TextView) itemView.findViewById(R.id.tDescricao);
            txtValor = (TextView) itemView.findViewById(R.id.tValor);
            img = (ImageView) itemView.findViewById(R.id.img);
            progress = (ProgressBar) itemView.findViewById(R.id.progressImg);
            cardView = (CardView) itemView.findViewById(R.id.card_view);
        }
    }
}
