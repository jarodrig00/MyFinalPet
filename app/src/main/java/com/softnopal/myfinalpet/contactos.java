package com.softnopal.myfinalpet;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.softnopal.myfinalpet.R;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class contactos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contactos);
        final EditText etNombre = (EditText) findViewById(R.id.etNombre);
        final EditText etCorreo = (EditText) findViewById(R.id.etCorreo);
        final EditText etDescripcion = (EditText) findViewById(R.id.etDescripcion);

        Button btnComentario = (Button) findViewById(R.id.btnComentario);
        btnComentario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    //Propiedades de la conexión
                    Properties props = new Properties();
                    props.setProperty("mail.smtp.host", "smtp.gmail.com");
                    props.setProperty("mail.smtp.starttls.enable", "true");
                    props.setProperty("mail.smtp.port", "587");
                    props.setProperty("mail.smtp.user", "jarodrig00@gmail.com");
                    props.setProperty("mail.smtp.auth", "true");

                    // Preparamos la sesion
                    Session session = Session.getDefaultInstance(props);

                    // Construimos el mensaje

                    MimeMessage message = new MimeMessage(session);
                    message.setFrom(new InternetAddress("jarodrig00@gmail.com"));
                    message.addRecipient(
                            Message.RecipientType.TO,
                            new InternetAddress(etCorreo.toString()));
                    message.setSubject(etNombre.toString());
                    message.setText(etDescripcion.toString());

                    // Lo enviamos.
                    Transport t = session.getTransport("smtp");
                    t.connect("jarodrig00@gmail.com", "la clave");
                    t.sendMessage(message, message.getAllRecipients());

                    // Cierre.
                    t.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                finish();
            }
        });
    }
}
