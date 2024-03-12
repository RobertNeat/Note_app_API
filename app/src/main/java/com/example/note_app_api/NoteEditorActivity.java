package com.example.note_app_api;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.note_app_api.model.Note;
import com.example.note_app_api.retrofit.NoteApi;
import com.example.note_app_api.retrofit.RetrofitService;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NoteEditorActivity extends AppCompatActivity {


    EditText note_title_EditText;
    EditText note_description_EditText;
    Button save_btn;
    Button cancel_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_note_editor);

        initializeComponents();

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

    }

    private void initializeComponents(){
        note_title_EditText = findViewById(R.id.note_title_EditText);
        note_description_EditText = findViewById(R.id.note_description_EditText);
        save_btn = findViewById(R.id.SaveBTN);
        cancel_btn = findViewById(R.id.CancelBTN);

        RetrofitService retrofitService = new RetrofitService();
        NoteApi noteApi = retrofitService.getRetrofit().create(NoteApi.class);

        save_btn.setOnClickListener(view->{
            Toast.makeText(NoteEditorActivity.this,"TEST",Toast.LENGTH_SHORT).show();
            String title = String.valueOf(note_title_EditText.getText());
            String description = String.valueOf(note_description_EditText.getText());

            Note note = new Note();
            note.setTitle(title);
            note.setDescription(description);
            // Format the date
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSX", Locale.getDefault());
            String formattedDate = dateFormat.format(new Date());
            note.setDate(formattedDate);

            noteApi.createNote(note)
                    .enqueue(new Callback<Note>() {//enque so the main process wont be paused
                        @Override
                        public void onResponse(Call<Note> call, Response<Note> response) {
                            Toast.makeText(NoteEditorActivity.this,"Note created! 🥳",Toast.LENGTH_SHORT).show();
                        }
                        @Override
                        public void onFailure(Call<Note> call, Throwable t) {
                            Toast.makeText(NoteEditorActivity.this,"Save failed 😒",Toast.LENGTH_SHORT).show();
                            Logger.getLogger(NoteEditorActivity.class.getName()).log(Level.SEVERE,"Error occured",t);
                        }
                    });
        });

        cancel_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

}