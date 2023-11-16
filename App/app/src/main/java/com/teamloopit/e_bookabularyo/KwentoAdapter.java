package com.teamloopit.e_bookabularyo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class KwentoAdapter extends RecyclerView.Adapter<KwentoAdapter.ViewHolder> {

    private List<KwentoModel> dataList;
    private OnItemClickListener onItemClickListener;
    public KwentoAdapter(List<KwentoModel> dataList) {
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public KwentoAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.kwentolayoutmodel, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull KwentoAdapter.ViewHolder holder, int position) {
        KwentoModel currentItem = dataList.get(position);
        holder.imageView.setImageResource(currentItem.getImageResourceId());

    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public interface OnItemClickListener {
        void onItemClick(KwentoModel kwentoModel);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.kwentoBg);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION && onItemClickListener != null) {
                        onItemClickListener.onItemClick(dataList.get(position));
                    }
                }
            });

        }
    }
}
