package com.example.note_app_api;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;


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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        //wywołanie edit_activity, żeby przetestować
        Intent intent = new Intent(MainActivity.this, NoteEditorActivity.class);
        startActivity(intent);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}