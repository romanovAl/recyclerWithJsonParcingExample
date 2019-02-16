package jsonrecycler.romanoff.com.recyclerwithjsonparcingexample;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AsyncResponse {
    UserTask userTask;
    ArrayList<User> usersList = new ArrayList<>();
    RecyclerView recyclerView ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userTask = new UserTask(this);
        userTask.delegate = this;
        userTask.execute();

        recyclerView = findViewById(R.id.mainRecycler);

    }

    @Override
    public void processFinish(ArrayList<User> output) {
        usersList = output;
        recyclerView.setLayoutManager(new GridLayoutManager(this,1));
        recyclerView.setAdapter(new CardRecyclerAdapter(usersList));
        System.err.println(output.toString());
    }
}
