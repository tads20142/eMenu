package c796to.ifpa.edu.emenu.domain;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;


public class Menu implements Parcelable {

    private static final long serialVersionUID = 6601006766832473959L;
    public long id;
    public String tipo;
    public String nome;
    public String valor;
    public String descricao;
    public String urlFoto;


    @Override
    public String toString() {
        return "Menu{" +
                "nome='" + nome + '\'' +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(id);
        dest.writeString(tipo);
        dest.writeString(nome);
        dest.writeString(valor);
        dest.writeString(descricao);
        dest.writeString(urlFoto);
    }

    public void readFromParcel(Parcel parcel) {
        this.id = parcel.readLong();
        this.tipo = parcel.readString();
        this.nome = parcel.readString();
        this.valor = parcel.readString();
        this.descricao = parcel.readString();
        this.urlFoto = parcel.readString();

    }

    public static final Parcelable.Creator<Menu> CREATOR = new Creator<Menu>() {
        @Override
        public Menu createFromParcel(Parcel source) {
            Menu m = new Menu();
            m.readFromParcel(source);
            return m;
        }

        @Override
        public Menu[] newArray(int size) {
            return new Menu[0];
        }
    };
}
