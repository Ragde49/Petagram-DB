package com.softcame.petagram.correo;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class SendMail extends AsyncTask<Void,Void,Void> {

    // Variables
    private Context context;
    private Session session;

    //Informacion
    private String email;
    private String subject;
    private String message;

    //Ventana de progreso
    private ProgressDialog progressDialog;

    //Clase
    public SendMail(Context context, String email, String subject, String message){
        //inicializacion
        this.context = context;
        this.email = email;
        this.subject = subject;
        this.message = message;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        //Muestra progreso
        progressDialog = ProgressDialog.show(context,"Enviando Mensaje","...",false,false);
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        //cierra el progreso
        progressDialog.dismiss();
        //Toast para aviso
        Toast.makeText(context,"Mensaje Enviado",Toast.LENGTH_LONG).show();
    }

    @Override
    protected Void doInBackground(Void... params) {
        //Propiedades de envio
        Properties props = new Properties();

        //propiedades de gmail
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");

        //Crea la sesion
        session = Session.getDefaultInstance(props,
                new javax.mail.Authenticator() {
                    //Autenticacion
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(Config.EMAIL, Config.PASSWORD);
                    }
                });

        try {
            //crea mensaje
            MimeMessage mm = new MimeMessage(session);

            //quien manda
            mm.setFrom(new InternetAddress(Config.EMAIL));
            //quien recive
            mm.addRecipient(Message.RecipientType.TO, new InternetAddress(email));
            //asunto
            mm.setSubject(subject);
            //mensaje
            mm.setText(message);

            //manda correo
            Transport.send(mm);

        } catch (MessagingException e) {
            e.printStackTrace();
        }
        return null;
    }
}
