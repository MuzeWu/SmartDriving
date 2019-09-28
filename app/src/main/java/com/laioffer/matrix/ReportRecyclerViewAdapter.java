package com.laioffer.matrix;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ReportRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<Item> items;
    private LayoutInflater mInflater;
    private OnClickListener mClickListener;

    public ReportRecyclerViewAdapter(Context context, List<Item> items) {
        this.items = items;
        this.mInflater = LayoutInflater.from(context);

    }

    public interface OnClickListener{
        public void setItem(String item);
    }

    public void setClickListener(ReportRecyclerViewAdapter.OnClickListener callback) {
        mClickListener = callback;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.recyclerview_item, parent, false);
        RecyclerView.ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder viewHolder = (ViewHolder) holder;
        final Item item = items.get(position);
        viewHolder.imageView.setImageResource(item.getDrawable_id());
        viewHolder.textView.setText(item.getDrawable_label());
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mClickListener != null) {
                    mClickListener.setItem(item.getDrawable_label());
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    @Override
    public int getItemViewType(int position) {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        ImageView imageView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.info_text);
            imageView = itemView.findViewById(R.id.info_img);
        }
    }
}
