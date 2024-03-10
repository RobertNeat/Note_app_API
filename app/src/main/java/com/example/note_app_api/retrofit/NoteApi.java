package com.example.note_app_api.retrofit;

import com.example.note_app_api.model.Note;

import java.util.List;
import java.util.Optional;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface NoteApi {
    @GET("/note/get-all")
    Call<List<Note>> getAllNotes();
    @GET("/note/{note_id}")
    Call<Optional<Note>> getNoteById(@Path("note_id") String note_id);

    @POST("/note")
    Call<Note> createNote(@Body Note note);

    @PUT("/note/update")
    Call<Note> updateNote(@Body Note note);

    @DELETE("/note/{note_id}")
    Call<?> deleteNoteById(@Path("note_id") String note_id);

    @DELETE("/note/delete-all")
    Call<?> deleteAll();
}
