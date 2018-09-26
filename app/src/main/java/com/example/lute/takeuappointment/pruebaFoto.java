package com.example.lute.takeuappointment;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

public class pruebaFoto extends AppCompatActivity {

    Button btnFoto, btnSubirFoto;
    ImageView photoViewer;
    TextView tvFoto, tvUsuario;
    //static final int REQUEST_IMAGE_CAPTURE = 1;
    StorageReference mStorage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prueba_foto);

        mStorage = FirebaseStorage.getInstance().getReference();

        photoViewer = (ImageView)findViewById(R.id.photoViewer);
        tvFoto = (TextView)findViewById(R.id.tvFoto);
        tvUsuario = (TextView)findViewById(R.id.tvUsuario);

        btnSubirFoto = (Button)findViewById(R.id.btnSubirFoto);
        btnFoto = (Button)findViewById(R.id.btnFoto);
        btnFoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                llamarIntent();
            }
        });


    }

    private void llamarIntent()
    {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if(takePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, 0);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        /*if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            photoViewer.setImageBitmap(imageBitmap);

            }*/
        super.onActivityResult(requestCode,resultCode,data);
        Bitmap bitmap = (Bitmap)data.getExtras().get("data");
        photoViewer.setImageBitmap(bitmap);
        //PROTOCOLO FECHA
        Date d=new Date();
        SimpleDateFormat fecc=new SimpleDateFormat("dMMMMyyyy");
        String fechacComplString = fecc.format(d);
        tvFoto.setText(tvUsuario.getText().toString()+fechacComplString+".jpg");
    }

    public void subirFoto (View view){
        StorageReference storageRef = mStorage.child("images/"+tvFoto.getText().toString());
        photoViewer.setDrawingCacheEnabled(true);
        photoViewer.buildDrawingCache();
        Bitmap bitmap = ((BitmapDrawable) photoViewer.getDrawable()).getBitmap();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos);
        byte[] data = baos.toByteArray();

        UploadTask uploadTask = storageRef.putBytes(data);
        uploadTask.addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception exception) {
                Toast.makeText(getApplicationContext(),"No se subio la imagen",Toast.LENGTH_LONG).show();
            }
        }).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                Toast.makeText(getApplicationContext(),"Se subio la imagen con éxito",Toast.LENGTH_LONG).show();
            }
        });


    }



}
