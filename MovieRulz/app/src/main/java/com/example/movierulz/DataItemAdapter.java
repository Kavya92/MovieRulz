package com.example.movierulz;

/**
 * Created by devar on 28-03-2017.
 */

        import android.content.Context;
        import android.content.Intent;
        import android.graphics.drawable.Drawable;
        import android.support.v7.widget.RecyclerView;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.ImageView;
        import android.widget.TextView;
        import android.widget.Toast;

        import com.example.movierulz.model.DataItem;

        import java.io.IOException;
        import java.io.InputStream;
        import java.util.List;

public class DataItemAdapter extends RecyclerView.Adapter<DataItemAdapter.ViewHolder> {

    public static final String ITEM_ID_KEY = "item_id_key";
    public static final String ITEM_KEY = "item_key" ;
    private List<DataItem> mItems;
    private Context mContext;

    public DataItemAdapter(Context context, List<DataItem> items) {
        this.mContext = context;
        this.mItems = items;
    }

    @Override
    public DataItemAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View itemView = inflater.inflate(R.layout.new_layout, parent, false);
        ViewHolder viewHolder = new ViewHolder(itemView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(DataItemAdapter.ViewHolder holder, int position) {
        final DataItem item = mItems.get(position);

        try {
            holder.movieName.setText(item.getMovieName());
            holder.theatreName.setText(item.getTheatreName());
            holder.theatreTimings.setText(item.getMovieTime());
            String imageFile = item.getImage();
            InputStream inputStream = mContext.getAssets().open(imageFile);
            Drawable d = Drawable.createFromStream(inputStream, null);
            holder.imageView.setImageDrawable(d);
        } catch (IOException e) {
            e.printStackTrace();
        }

        holder.mView.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                //Toast.makeText(mContext,"You Selected " + item.getMovieName(),Toast.LENGTH_SHORT).show();
                //String itemId = item.getMovieId();
                Intent intent = new Intent(mContext,DetailActivity.class);
                intent.putExtra(ITEM_KEY,item);
                mContext.startActivity(intent);
            }
        });

        holder.mView.setOnLongClickListener(new View.OnLongClickListener()
        {
            @Override
            public boolean onLongClick(View v)
            {
                Toast.makeText(mContext,"You long Selected " + item.getMovieName(),Toast.LENGTH_SHORT).show();
                return false;
            }
        });
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView theatreName;
        public TextView theatreTimings;
        public ImageView imageView;
        public TextView movieName;
        public View mView;
        public ViewHolder(View itemView) {
            super(itemView);
            movieName = (TextView) itemView.findViewById(R.id.movieNameText);
            theatreName = (TextView) itemView.findViewById(R.id.theatreNameText);
            theatreTimings = (TextView) itemView.findViewById(R.id.timingsText);
            imageView = (ImageView) itemView.findViewById(R.id.imageView);
            mView = itemView;
        }
    }
}
