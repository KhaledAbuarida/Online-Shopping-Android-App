package com.example.e_commerce.Activity;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import com.example.e_commerce.Database.Database;
import com.example.e_commerce.Model.User;
import com.example.e_commerce.R;

public class EditProfileActivity extends AppCompatActivity {
    EditText et_username, et_email, et_password, et_job, et_birthday;
    Spinner spinner_gender;
    Button btn_edit_profile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        getSupportActionBar().hide();

        et_username = findViewById(R.id.edit_profile_txt_username);
        et_email = findViewById(R.id.edit_profile_txt_email);
        et_password = findViewById(R.id.edit_profile_txt_password);
        et_job = findViewById(R.id.edit_profile_txt_job);
        et_birthday = findViewById(R.id.edit_profile_txt_birthday);
        spinner_gender = findViewById(R.id.edit_spinner_gender);
        btn_edit_profile = findViewById(R.id.edit_product_btn_edit);

        Database db = new Database(this);

        Intent intent = getIntent();
        int user_id = intent.getExtras().getInt("id");
        String username = intent.getExtras().getString("username");
        String email = intent.getExtras().getString("email");
        String password = intent.getExtras().getString("password");
        String birthdate = intent.getExtras().getString("birthdate");
        String job = intent.getExtras().getString("job");
        String gender = intent.getExtras().getString("gender");

        et_username.setText(username);
        et_email.setText(email);
        et_password.setText(password);
        et_birthday.setText(birthdate);
        et_job.setText(job);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                R.array.gender_array,
                android.R.layout.simple_spinner_item
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_gender.setAdapter(adapter);

        if (gender.equals("Male")) {
            spinner_gender.setSelection(0);
        } else {
            spinner_gender.setSelection(1);
        }


        btn_edit_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String updatedUsername = et_username.getText().toString();
                String updatedEmail = et_email.getText().toString();
                String updatedPassword = et_password.getText().toString();
                String updatedBirthday = et_birthday.getText().toString();
                String updatedJob = et_job.getText().toString();
                String updatedGender = spinner_gender.getSelectedItem().toString();

                User.getInstance().initialize(user_id, updatedUsername, updatedEmail, updatedPassword, updatedBirthday, updatedJob, updatedGender);
                User userInstance = User.getInstance();
                userInstance.initialize(user_id, updatedUsername, updatedEmail, updatedPassword, updatedBirthday, updatedJob, updatedGender);

                db.editUser(userInstance);

                Toast.makeText(EditProfileActivity.this, "Profile updated successfully", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
