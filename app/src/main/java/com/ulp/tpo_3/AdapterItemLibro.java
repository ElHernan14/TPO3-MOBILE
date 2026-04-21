package com.ulp.tpo_3;

import static android.content.Intent.FLAG_ACTIVITY_NEW_TASK;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ulp.tpo_3.modelo.OpenLibraryResponse;

import java.util.ArrayList;

public class AdapterItemLibro extends RecyclerView.Adapter<AdapterItemLibro.ViewHolderItemLibro>{

    private LayoutInflater inflater;
    private ArrayList<OpenLibraryResponse.Doc> list;

    public AdapterItemLibro(ArrayList<OpenLibraryResponse.Doc> list, LayoutInflater inflater) {
        this.list = list;
        this.inflater = inflater;
    }

    @NonNull
    @Override
    public ViewHolderItemLibro onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = inflater.inflate(R.layout.item, parent, false);
        return new ViewHolderItemLibro(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderItemLibro holder, int position) {
        OpenLibraryResponse.Doc i = list.get(position);

        holder.title.setText(i.title);
        holder.autor.setText(i.getAutores());
        holder.anioPub.setText(i.getStringFirstPublishYear());

        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(v.getContext(), TerceraActivity.class);
            intent.setFlags(FLAG_ACTIVITY_NEW_TASK);
            intent.putExtra("libro", i);
            v.getContext().startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolderItemLibro extends RecyclerView.ViewHolder {

        private TextView title, autor, anioPub;
        public ViewHolderItemLibro(@NonNull View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.tvItemTitle);
            autor = itemView.findViewById(R.id.tvItemAutor);
            anioPub = itemView.findViewById(R.id.tvItemAnioPug);
        }
    }
}
