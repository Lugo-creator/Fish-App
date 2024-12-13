package com.example.fishapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Sign_Up extends AppCompatActivity {
    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReferenceFromUrl("https://fish-candy-a4eb7-default-rtdb.firebaseio.com/");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sign_up);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        final TextView signin = (TextView) findViewById(R.id.sign_in);
        final EditText username = (EditText) findViewById(R.id.usernameInput);
        final EditText email = (EditText) findViewById(R.id.emailInput);
        final EditText phone = (EditText) findViewById(R.id.phoneInput);
        final EditText password = (EditText) findViewById(R.id.passwordInput);
        final EditText confirm_password = (EditText) findViewById(R.id.confirm_passwordInput);
        final ProgressBar progressBar = (ProgressBar) findViewById(R.id.progress_bar);
        final Button sign_up = (Button) findViewById(R.id.signup_btn);

        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent s = new Intent(getApplicationContext(), Login.class);
                startActivity(s);
            }
        });

        sign_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressBar.setVisibility(View.VISIBLE);
                final String phoneTxt = phone.getText().toString();
                final String usernameTxt = username.getText().toString();
                final String emailTxt = email.getText().toString();
                final String password1Txt = password.getText().toString();
                final String password2Txt = confirm_password.getText().toString();

                if(phoneTxt.isEmpty() || usernameTxt.isEmpty() || emailTxt.isEmpty() || password1Txt.isEmpty() || password2Txt.isEmpty()){
                    Toast.makeText(Sign_Up.this, "Fill in all the details!", Toast.LENGTH_SHORT).show();
                } else if (!password1Txt.equals(password2Txt)) {
                    Toast.makeText(Sign_Up.this, "Passwords do not match!", Toast.LENGTH_SHORT).show();
                }else{
                    databaseReference.child("users").addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            progressBar.setVisibility(View.GONE);
                            if(dataSnapshot.hasChild(phoneTxt)){
                                Toast.makeText(Sign_Up.this, "Phone number is already registered!", Toast.LENGTH_SHORT).show();
                            }else{
                                if(isValid(password1Txt)){
                                    databaseReference.child("users").child(phoneTxt).child("username").setValue(usernameTxt);
                                    databaseReference.child("users").child(phoneTxt).child("email").setValue(emailTxt);
                                    databaseReference.child("users").child(phoneTxt).child("password").setValue(password1Txt);

                                    Toast.makeText(Sign_Up.this, "Registration successful!", Toast.LENGTH_SHORT).show();

                                    Intent l = new Intent(getApplicationContext(), Login.class);
                                    l.putExtra("username",usernameTxt);
                                    startActivity(l);
                                    finish();
                                }
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });
                }
            }
        });
    }
    public static boolean isValid(String passworddhere){
        int f1=0,f2=0,f3=0;
        if(passworddhere.length() < 8){
            return false;
        }else{
            for(int p = 0; p < passworddhere.length(); p++){
                if(Character.isLetter(passworddhere.charAt(p))){
                    f1=1;
                }
            }
            for(int r = 0; r < passworddhere.length(); r++){
                if(Character.isDigit(passworddhere.charAt(r))){
                    f2=1;
                }
            }
            for(int s = 0; s < passworddhere.length(); s++){
                char c = passworddhere.charAt(s);
                if(c>=33&&c<=46 || c==64){
                    f3=1;
                }
            }
            if(f1==1 && f2==1 && f3==1)
                 return true;
            return false;

        }
    }
}