package com.softnopal.myfinalpet.adpater;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.softnopal.myfinalpet.pojo.Pet;
import com.softnopal.myfinalpet.R;

/**
 * Created by jarodrig00 on 07/05/17.
 */

public class DatosMascotaAdapter extends  BaseAdapter{
    private static Pet[] ITEMS = {
            new Pet("Buho", R.drawable.buho, 2),
            new Pet("Buho", R.drawable.buho, 4),
            new Pet("Buho", R.drawable.buho, 2),
            new Pet("Buho", R.drawable.buho, 1),
            new Pet("Buho", R.drawable.buho, 7),
            new Pet("Buho", R.drawable.buho, 3),
            new Pet("Buho", R.drawable.buho, 2),
            new Pet("Buho", R.drawable.buho, 8),
            new Pet("Buho", R.drawable.buho, 0)
    };

    private Context mContext;

    public DatosMascotaAdapter(Context c) {
        mContext = c;

    }


    @Override
    public int getCount() {
        return ITEMS.length;
    }

    @Override
    public Pet getItem(int position) {
        return ITEMS[position];
    }

    @Override
    public long getItemId(int position) {
        return getItem(position).getFoto();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.datos_mascota, parent, false);
        }
        ImageView imPetF1 = (ImageView) convertView.findViewById(R.id.imPetF1);
        TextView tvNameF1 = (TextView) convertView.findViewById(R.id.tvNameF1);
        TextView tvCountPetF1 = (TextView) convertView.findViewById(R.id.tvCountPetF1);

        final Pet item = getItem(position);
        imPetF1.setImageResource(item.getFoto());
        tvNameF1.setText(item.getNombre());
        tvCountPetF1.setText(Integer.toString(item.getCuenta()));

        return convertView;
    }
}
