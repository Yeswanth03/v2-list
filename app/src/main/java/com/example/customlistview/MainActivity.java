package com.example.customlistview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<ContactModel> arrcontacts = new ArrayList<>();
    RecyclerContactAdapter adapter;
    FloatingActionButton btnOpenDialog;
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView = findViewById(R.id.recyclerContact);
        btnOpenDialog = findViewById(R.id.btnOpenDialog);

        btnOpenDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Dialog dialog = new Dialog(MainActivity.this);
                dialog.setContentView(R.layout.add_update_lay);
                EditText edtname = dialog.findViewById(R.id.edtname);
                EditText edtnumber = dialog.findViewById(R.id.edtnumber);
                Button btnadd = dialog.findViewById(R.id.btnadd);

                btnadd.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String name = "",number = "";

                        if(!edtname.getText().toString().equals("")){
                             name = edtname.getText().toString();
                        } else {
                            Toast.makeText(MainActivity.this,"please enter contact name!",Toast.LENGTH_SHORT).show();
                        }
                        if (!edtnumber.getText().toString().equals("")){
                             number = edtnumber.getText().toString();
                        } else {
                            Toast.makeText(MainActivity.this,"please enter contact number!",Toast.LENGTH_SHORT).show();
                        }

                        arrcontacts.add(new ContactModel(R.drawable.ic_launcher_foreground,name,number));

                        adapter.notifyItemInserted(arrcontacts.size()-1);

                        recyclerView.scrollToPosition(arrcontacts.size()-1);

                        dialog.dismiss();
                    }

                });
                dialog.show();
            }
        });


        recyclerView.setLayoutManager(new LinearLayoutManager(this));



        arrcontacts.add(new ContactModel(R.drawable.ic_launcher_foreground, "A", "9012345678"));
        arrcontacts.add(new ContactModel(R.drawable.ic_launcher_foreground, "b", "9012345678"));
        arrcontacts.add(new ContactModel(R.drawable.ic_launcher_foreground, "c", "9012345678"));
        arrcontacts.add(new ContactModel(R.drawable.ic_launcher_foreground, "d", "9012345678"));
        arrcontacts.add(new ContactModel(R.drawable.ic_launcher_foreground, "e", "9012345678"));
        arrcontacts.add(new ContactModel(R.drawable.ic_launcher_foreground, "f", "9012345678"));
        arrcontacts.add(new ContactModel(R.drawable.ic_launcher_foreground, "g", "9012345678"));
        arrcontacts.add(new ContactModel(R.drawable.ic_launcher_foreground, "h", "9012345678"));
        arrcontacts.add(new ContactModel(R.drawable.ic_launcher_foreground, "i", "9012345678"));
        arrcontacts.add(new ContactModel(R.drawable.ic_launcher_foreground, "j", "9012345678"));

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter = new RecyclerContactAdapter(MainActivity.this,arrcontacts);
        recyclerView.setAdapter(adapter);

    }
}