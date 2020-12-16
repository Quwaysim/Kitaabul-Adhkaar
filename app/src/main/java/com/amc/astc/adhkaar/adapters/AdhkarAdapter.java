package com.amc.astc.adhkaar.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.amc.astc.adhkaar.R;
import com.amc.astc.adhkaar.ui.AdhkarActivity;
import com.amc.astc.adhkaar.ui.NawawiActivity;
import com.amc.astc.adhkaar.utils.Constants;
import com.amc.astc.adhkaar.utils.MyResources;

public class AdhkarAdapter extends RecyclerView.Adapter<AdhkarAdapter.AdhkarViewHolder> {
    private Context mContext;
    private String[] mAdhkarTitleList;
    private int mLayout;
    private String mContentType;

    public AdhkarAdapter(Context context, String[] adhkarTitleList, int layout, String contentType) {
        mContext = context;
        mAdhkarTitleList = adhkarTitleList;
        mLayout = layout;
        mContentType = contentType;
    }

    @NonNull
    @Override
    public AdhkarViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(mLayout, parent, false);
        return new AdhkarViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdhkarViewHolder holder, final int position) {
        final MyResources myResources = new MyResources();
        String adhkarTitle = mAdhkarTitleList[position];
        holder.title.setText(adhkarTitle);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mContentType.equals(Constants.KEY_ADHKAR_INTENT)) {
                    if (myResources.getAdhkarStringArray(position, mContext) != null) {
                        String[] parseAdhkar = myResources.getAdhkarStringArray(position, mContext);
                        Intent intent = new Intent(mContext, AdhkarActivity.class).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        intent.putExtra(Constants.KEY_ADHKAR_INTENT, parseAdhkar);
                        mContext.startActivity(intent);
                    }
                } else if (mContentType.equals(Constants.KEY_SUWAR_INTENT)) {
                    if (myResources.getSuwarStringArray(position, mContext) != null) {
                        String[] parseSuwar = myResources.getSuwarStringArray(position, mContext);
                        Intent intent = new Intent(mContext, AdhkarActivity.class)
                                .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        intent.putExtra(Constants.KEY_SUWAR_INTENT, parseSuwar);
                        mContext.startActivity(intent);
                    }
                } else if (mContentType.equals(Constants.KEY_FORTY_HADITH_INTENT)){
                    Intent intent = new Intent(mContext, NawawiActivity.class)
                            .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    intent.putExtra(Constants.KEY_FORTY_HADITH_INTENT, position);
                    mContext.startActivity(intent);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mAdhkarTitleList.length;
    }

    public class AdhkarViewHolder extends RecyclerView.ViewHolder {
        public final TextView title;

        public AdhkarViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.adhkar_title);
        }
    }
}
