package com.softnopal.myfinalpet.adpater;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.softnopal.myfinalpet.pojo.Pet;
import com.softnopal.myfinalpet.R;
import com.softnopal.myfinalpet.restApi.EndPointApi;
import com.softnopal.myfinalpet.restApi.adapter.RestApiAdapter;
import com.softnopal.myfinalpet.restApi.model.MediaResponse;
import com.softnopal.myfinalpet.restApi.model.UserResponse;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by jarodrig00 on 07/05/17.
 */

public class DatosMascotaAdapter extends  BaseAdapter{
    private ArrayList<Pet> ITEMS;
    /*
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
    };*/

    private Context mContext;

    public DatosMascotaAdapter(Context c) {
        mContext = c;
        ITEMS = new ArrayList<>();
        RestApiAdapter restApiAdapter = new RestApiAdapter();
        Gson gsonMedia = restApiAdapter.construyeGsonDeserializadorMediaInstagram();
        EndPointApi endPointApi = restApiAdapter.establecerConexionRestApiInstagram(gsonMedia);
        Call<MediaResponse> mediaResponseCall = endPointApi.getMedia();

        mediaResponseCall.enqueue(new Callback<MediaResponse>() {
            @Override
            public void onResponse(Call<MediaResponse> call, Response<MediaResponse> response) {


                Log.e("Media","OnResponse response  " + response.isSuccessful());

                //Log.e("Media", "OnResponse" + response.body().toString());

                if(response.isSuccessful()) {
                    MediaResponse mediaResponse = response.body();
                    ITEMS = mediaResponse.getPets();
                }
            }

            @Override
            public void onFailure(Call<MediaResponse> call, Throwable t) {
                Toast.makeText(mContext, "Algo paso, intenta de nuevo", Toast.LENGTH_LONG).show();
                Log.e("Fallo la conexion", t.toString());

            }
        });

    }


    @Override
    public int getCount() {
        return ITEMS.size();
    }

    @Override
    public Pet getItem(int position) {
        return ITEMS.get(position);
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
