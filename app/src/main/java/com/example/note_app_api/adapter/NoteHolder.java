package com.example.note_app_api.adapter;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.note_app_api.R;

public class NoteHolder extends RecyclerView.ViewHolder {

    TextView order,title,description,date;
    public NoteHolder(@NonNull View itemView) {
        super(itemView);
        order = itemView.findViewById(R.id.list_note_order_TextView);
        title = itemView.findViewById(R.id.list_note_title_TextView);
        description = itemView.findViewById(R.id.list_note_description_TextView);
        date = itemView.findViewById(R.id.list_note_date_TextView);
    }
}
