package jsonrecycler.romanoff.com.recyclerwithjsonparcingexample;

import android.os.AsyncTask;
import java.io.IOException;
import java.util.ArrayList;
import org.json.JSONException;

public class UserTask extends AsyncTask<Void, Void, ArrayList<User>> {
    public AsyncResponse delegate = null;

    public UserTask(AsyncResponse delegate){
        this.delegate = delegate;
    }

    @Override
    protected ArrayList<User> doInBackground(Void... voids) {
        JsonPlaceholderApi api = new JsonPlaceholderApi("https://jsonplaceholder.typicode.com/users");
        ArrayList<User> users = new ArrayList<>();
        try {
            users = api.getUserList();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    protected void onPostExecute(ArrayList<User> users) {
        super.onPostExecute(users);
        delegate.processFinish(users);
    }

}
