package com.example.JunSen;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class selleractivity extends AppCompatActivity {
    EditText name,pno,year,dept,sem,sub;
    Button save;
    DatabaseReference reff;
    Member mem;
    Long maxid= Long.valueOf(0);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selleractivity);
        name=(EditText)findViewById(R.id.editText5);
        pno=(EditText)findViewById(R.id.editText6);
        year=(EditText)findViewById(R.id.editText8);
        dept=(EditText)findViewById(R.id.editText10);
        sem=(EditText)findViewById(R.id.editText11);
        sub=(EditText)findViewById(R.id.editText12);
        save=(Button)findViewById(R.id.save);
        mem=new Member();
        reff= FirebaseDatabase.getInstance().getReference().child("Member");
        reff.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()) {
                    maxid = (dataSnapshot.getChildrenCount());
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nm=name.getText().toString().trim();
                String pn=pno.getText().toString().trim();
                String yr=year.getText().toString().trim();
                String dt=dept.getText().toString().trim();
                String sm=sem.getText().toString().trim();
                String sb=sub.getText().toString().trim();
                Long id=maxid+1;
                mem.setName(nm);
                mem.setPhone(pn);
                mem.setYear(yr);
                mem.setDept(dt);
                mem.setSem(sm);
                mem.setSub(sb);
                reff.child(String.valueOf(maxid+1)).setValue(mem);
               // reff.push().setValue(mem);
               // reff.child("mem1").setValue(mem);
                Toast.makeText(selleractivity.this,"SAVED!!! Your ID is:" + id,Toast.LENGTH_LONG).show();
            }
        });
    }
}
