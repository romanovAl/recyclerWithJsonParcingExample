package jsonrecycler.romanoff.com.recyclerwithjsonparcingexample;

import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class CardRecyclerAdapter extends RecyclerView.Adapter<CardRecyclerAdapter.CardViewHolder> {

    private RecyclerView.ViewHolder holder;
    private ArrayList<User> users;

    public CardRecyclerAdapter(
        ArrayList<User> users) {
        this.users = users;
    }

    @NonNull
    @Override
    public CardRecyclerAdapter.CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent,
        int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_card,parent,false);
        return new CardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CardRecyclerAdapter.CardViewHolder holder, int position) {
        final User user = users.get(position);
        holder.bind(user.getUsername(),user.getName());
        holder.itemView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class CardViewHolder extends RecyclerView.ViewHolder{
        private TextView username, name;

        CardViewHolder(View view){
        super(view);
            username = view.findViewById(R.id.usernameText);
            name = view.findViewById(R.id.nameText);
        }

        private void bind (String username, String name){
            this.username.setText(username);
            this.name.setText(name);
        }
    }
}
