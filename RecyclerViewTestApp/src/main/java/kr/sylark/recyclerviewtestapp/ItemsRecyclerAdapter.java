package kr.sylark.recyclerviewtestapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ItemsRecyclerAdapter extends RecyclerView.Adapter<ItemsRecyclerAdapter.ItemViewHolder> {

    private Context mContext;

    private List<Item> mItems;

    public ItemsRecyclerAdapter(Context context, List<Item> items) {
        mContext = context;
        mItems = items;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(kr.pe.sylark.recyclerviewtestapp.R.layout.item_view, null);

        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {

        Item item = mItems.get(position);

        holder.name.setText(item.name);

        if(item.icon != null) {
            holder.icon.setImageDrawable(item.icon);
        }
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    static class ItemViewHolder extends RecyclerView.ViewHolder {

        private TextView name;
        private ImageView icon;

        public ItemViewHolder(View itemView) {
            super(itemView);

            name = itemView.findViewById(kr.pe.sylark.recyclerviewtestapp.R.id.name);
            icon = itemView.findViewById(kr.pe.sylark.recyclerviewtestapp.R.id.icon);
        }
    }
}
