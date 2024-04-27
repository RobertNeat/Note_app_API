# Note App - Android Client

![Android](https://img.shields.io/badge/Android-12-orange)
![API](https://img.shields.io/badge/API-31-yellow)

This Android application serves as a client for interacting with the Note API backend. It allows users to view a list of notes and add new notes through the app interface. The app communicates with the backend server to retrieve existing notes and save new ones.

## Configuration

Application is set for the following configuration:

- Android: API 31 ("S";Android 12),

## Features

- Two activities that supports user interaction (viewing list of notes and adding new note),
- View Notes: Display a list of notes with creation dates in a RecyclerView.
- Add Note: Add a new note through the app interface.
- Communicate with API: The app communicates with the Note API backend to retrieve and save notes (if the communication is not working the toast popup shows up).
- Permissions for the internet communication issued by app to manipulate data on server,

## Retrofit Service Configuration

Ensure to update the RetrofitService IP address to match the computer running the REST API server:

java
Copy code
private void initializeRetrofit() {
retrofit = new Retrofit.Builder()
.baseUrl("http://192.168.104.90:9000") // Set the IP of the computer running the REST API server
.addConverterFactory(GsonConverterFactory.create(new Gson()))
.build();
}

## Antivirus Interference

Note that some antivirus software may interfere with communication, for example, ESET:

ESET: ESET may block access to the REST API by blocking internet traffic. In such cases, consider disabling the following option:

```
Computer protection --> Host-based intrusion prevention system (HIPS)
```

## Contributing

Contributions to this Android client are welcome. If you encounter any issues or have suggestions for improvements, please open an issue or submit a pull request.

## License

This Android client for the Note API is open-source software licensed under the MIT License. See the LICENSE file for more details.

## Future improvements

The project is not in the final stage and not most of the routes are used. The plan is to implement features in the next project phase:

- app refresh when the main activity is resumed (so the added elements will show up immediately,
- pulpet menu with button to delete all notes,
- intent from recycler view to edit existing note (without editing the date of the note),
- item touch helper on the recycler view element to delete specific note by swiping.

## App screenshots
<table>
    <tr>
        <td>    
            <img src="https://github.com/RobertNeat/Note_app_API/blob/master/screenshots/apps_tray.png" width="200"/>
        </td>  
        <td>    
            <img src="https://github.com/RobertNeat/Note_app_API/blob/master/screenshots/launching_screen.png" width="200"/>
        </td>  
        <td>    
          <p>When rest api is not available the app shows info about that</p>
            <img src="https://github.com/RobertNeat/Note_app_API/blob/master/screenshots/connection_error.png" width="200"/>
        </td>  
    </tr>
</table>
- Adding new note (app restart needed to refresh note list)
<table>
  <tr>
    <td>
       <img src="https://github.com/RobertNeat/Note_app_API/blob/master/screenshots/note_list_initial.png" width="200"/>
    </td>
    <td>
       <img src="https://github.com/RobertNeat/Note_app_API/blob/master/screenshots/add_note_activity.png" width="200"/>
    </td>
    <td>
       <img src="https://github.com/RobertNeat/Note_app_API/blob/master/screenshots/paused_app.png" width="200"/>
    </td>
    <td>
       <img src="https://github.com/RobertNeat/Note_app_API/blob/master/screenshots/note_list_added.png" width="200"/>
    </td>
  </tr>
</table>
