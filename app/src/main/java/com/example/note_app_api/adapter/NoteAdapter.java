package com.example.note_app_api.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.note_app_api.R;
import com.example.note_app_api.model.Note;

import java.util.List;

public class NoteAdapter extends RecyclerView.Adapter<NoteHolder>{
    private List<Note> noteList;

    public NoteAdapter(List<Note> noteList) {
        this.noteList = noteList;
    }

    @NonNull
    @Override
    public NoteHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.note_row, parent, false);
        return new NoteHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NoteHolder holder, int position) {
        Note note = noteList.get(position);
        holder.title.setText(note.getTitle());
        holder.description.setText(note.getDescription());
        holder.date.setText(note.getDate().subSequence(0,note.getDate().lastIndexOf("T")));//cannot use "note.getDate()", because the date contains miliseconds
        holder.order.setText(String.valueOf(position)+".");
    }

    @Override
    public int getItemCount() {
        return noteList.size();
    }
}
