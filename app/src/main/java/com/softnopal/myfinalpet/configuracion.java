package com.softnopal.myfinalpet;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.softnopal.myfinalpet.pojo.UserInstagram;
import com.softnopal.myfinalpet.pojo.UserPersistente;
import com.softnopal.myfinalpet.restApi.EndPointApi;
import com.softnopal.myfinalpet.restApi.RestApiConstant;
import com.softnopal.myfinalpet.restApi.adapter.RestApiAdapter;
import com.softnopal.myfinalpet.restApi.model.UserResponse;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class configuracion extends AppCompatActivity {
    private EditText etUser;
    private TextView tvMensaje;
    private ArrayList<UserInstagram> userInstagram;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuracion);

        etUser = (EditText) findViewById(R.id.etUser);
        tvMensaje = (TextView) findViewById(R.id.tvMensaje);
        Button btnUser = (Button) findViewById(R.id.btnUser);

        btnUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!validaUser()){
                    tvMensaje.setText(getString(R.string.usuario_instagram_no_valido));
                }else{
                    tvMensaje.setText("");
                    Intent data = new Intent();
                    data.setData(Uri.parse(etUser.getText().toString()));
                    setResult(RESULT_OK, data);
                    finish();
                }

            }
        });
    }

    public boolean validaUser(){
        if (etUser.getText().toString() == ""){
            tvMensaje.setText("Debes capturar un nombre de usuario");
            return false;
        }else{
            String user = etUser.getText().toString();
            obtenerUsuario(user);
            if(userInstagram == null){
                tvMensaje.setText("El usuario seleccionado no existe");
                return false;
            }else{
                UserPersistente userPersistente = new UserPersistente(getApplicationContext());
                userPersistente.saveToFile(userInstagram.get(0));
            }
        }
        return true;
    }

    public void obtenerUsuario(String user){
        RestApiAdapter restApiAdapter = new RestApiAdapter();
        Gson gsonUser =  restApiAdapter.construyeGsonDeserializadorUserInstagram();
        EndPointApi endPointApi = restApiAdapter.establecerConexionRestApiInstagram(gsonUser);
        Map <String, String> params = new HashMap<String, String>();
        params.put(RestApiConstant.KEY_USER_SEARCH, user);
        params.put(RestApiConstant.KEY_ACCESS_TOKEN, RestApiConstant.ACCESS_TOKEN);
        Call<UserResponse> userResponseCall =  endPointApi.getUser(params);


        userResponseCall.enqueue(new Callback<UserResponse>() {
            @Override
            public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
                UserResponse userResponse = response.body();
                userInstagram = userResponse.getUsers();
            }

            @Override
            public void onFailure(Call<UserResponse> call, Throwable t) {
                Toast.makeText(configuracion.this, "Algo paso, intenta de nuevo", Toast.LENGTH_LONG).show();
                Log.e("Fallo la conexion", t.toString());
            }
        });

    }

}
