package com.example.fishapp.ui.payment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.fishapp.R;
import com.example.fishapp.ui.confirmation.confirmation;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class payment extends AppCompatActivity {
    private String phone_number;
    String [] destination = {"Kitengela", "Isinya", "Kajiado"};
    AutoCompleteTextView autoCompleteTxt;
    ArrayAdapter<String> adapterItems;
    private FirebaseFirestore db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_payment);
        db = FirebaseFirestore.getInstance();
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        final EditText phone = findViewById(R.id.phoneInput);
        //final EditText pin = findViewById(R.id.pinInput);
        final Button submit = findViewById(R.id.submitBtn);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //final String mpin = pin.getText().toString();
                final String mphone = phone.getText().toString();
                if(mphone.isEmpty()){
                    Toast.makeText(payment.this, "Enter your m-pesa number!", Toast.LENGTH_SHORT).show();
                }else{
                    Map<String, String> map = new HashMap<>();
                    map.put("phone", mphone);
                    db.collection("Phone").document().set(map).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if(task.isSuccessful()){
                                Intent i = new Intent(getApplicationContext(), confirmation.class);
                                startActivity(i);
                            }
                        }
                    });



                    /*addDataToFirestore(mphone);
                    Intent i = new Intent(getApplicationContext(), confirmation.class);
                    startActivity(i);
                    Toast.makeText(payment.this, "Information submitted Successfully!", Toast.LENGTH_SHORT).show();*/
                }
            }
            private void addDataToFirestore(String phone_number){
                CollectionReference dbNumbers = db.collection("Phone");

                dbNumbers.add(phone_number).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Toast.makeText(payment.this, "Your number has been added to Firebase Firestore", Toast.LENGTH_SHORT).show();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(payment.this, "Fail to add number \n" + e, Toast.LENGTH_SHORT).show();
                    }
                });

            }
        });
        autoCompleteTxt = findViewById(R.id.autoCompleteTextView);

        adapterItems = new ArrayAdapter<String>(this, R.layout.occupants_list,destination);
        autoCompleteTxt.setAdapter(adapterItems);

        autoCompleteTxt.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String occupant = adapterView.getItemAtPosition(i).toString();
                if (occupant.equals("Kitengela")){
                    /*Intent intent = new Intent(getApplicationContext(), Kitengela.class);
                    startActivity(intent);
                    finish();*/
                    Toast.makeText(getApplicationContext(), "Shipment rescheduled for address 400-200 Kitengela", Toast.LENGTH_SHORT).show();
                }else if (occupant.equals("Isinya")){
                    /*Intent intent = new Intent(getApplicationContext(), Isinya.class);
                    startActivity(intent);
                    finish();*/
                    Toast.makeText(getApplicationContext(), "Shipment rescheduled for address 400-400 Isinya", Toast.LENGTH_SHORT).show();
                }else if (occupant.equals("Kajiado")){
                    /*Intent intent = new Intent(getApplicationContext(), Kajiado.class);
                    startActivity(intent);
                    finish();*/
                    Toast.makeText(getApplicationContext(), "Shipment rescheduled for address 400-600 Kajiado", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getApplicationContext(), "Enter Occupation", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}