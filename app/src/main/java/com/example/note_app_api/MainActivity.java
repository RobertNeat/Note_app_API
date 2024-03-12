package com.example.note_app_api;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.note_app_api.adapter.NoteAdapter;
import com.example.note_app_api.model.Note;
import com.example.note_app_api.retrofit.NoteApi;
import com.example.note_app_api.retrofit.RetrofitService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/*
* Tutorial (time-marked): https://youtu.be/yxMQPmmb-EQ?list=PLhs1urmduZ2_jNSEfOMTDojkvxMjgWzmd
*
* Podobny mój projekt w przypadku trudności: https://github.com/RobertNeat/Note_app/blob/main/app/src/main/java/com/example/note_app/MainActivity.java
*
* ESET potrafi blokowac dostęp do REST API, ponieważ blokuje ruch z internetu.
* Należy wyłączyć w tym przypadku opcję (najprawdopodobniej blokuje):
*  ochrona komputera --> System zapobiegania włamanion działający na hoście (HIPS)
*
* */

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        /*
            //wywołanie edit_activity, żeby przetestować
            Intent intent = new Intent(MainActivity.this, NoteEditorActivity.class);
            startActivity(intent);
         */

        recyclerView = findViewById(R.id.note_list_recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        loadNotes();

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void loadNotes() {
        RetrofitService retrofitService = new RetrofitService();
        NoteApi noteApi = retrofitService.getRetrofit().create(NoteApi.class);
        noteApi.getAllNotes()
                .enqueue(new Callback<List<Note>>() {
                    @Override
                    public void onResponse(Call<List<Note>> call, Response<List<Note>> response) {
                        populateListView(response.body());
                    }

                    @Override
                    public void onFailure(Call<List<Note>> call, Throwable t) {
                        Toast.makeText(MainActivity.this,"Failed loading Notes",Toast.LENGTH_SHORT).show();
                    }
                });
    }

    private void populateListView(List<Note> noteList) {
        NoteAdapter noteAdapter = new NoteAdapter(noteList);
        recyclerView.setAdapter(noteAdapter);
    }
}