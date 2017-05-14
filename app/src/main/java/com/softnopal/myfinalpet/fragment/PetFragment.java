package com.softnopal.myfinalpet.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.softnopal.myfinalpet.adpater.DatosMascotaAdapter;
import com.softnopal.myfinalpet.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class PetFragment extends Fragment {
    DatosMascotaAdapter datosMascotaAdapter;
    GridView gvMascota;

    public PetFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_pet, container, false);

        gvMascota = (GridView) v.findViewById(R.id.gvMascota);
        gvMascota.setDrawSelectorOnTop(true);

        datosMascotaAdapter = new DatosMascotaAdapter(getActivity().getApplicationContext());
        gvMascota.setAdapter(datosMascotaAdapter);

        return v;

    }

}
