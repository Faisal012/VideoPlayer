package com.example.videoplayer;

import android.content.Context;
import android.graphics.Bitmap;
import android.media.ThumbnailUtils;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.io.File;
import java.util.List;

public class customAdapter extends RecyclerView.Adapter<VideoViiewHolder> {
    private Context context;
    private List<File> files;
    private SelectListener listener;

    public customAdapter(Context context, List<File> files,SelectListener listener) {
        this.context = context;
        this.files = files;
        this.listener=listener;

    }

    @NonNull
    @Override
    public VideoViiewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new VideoViiewHolder(LayoutInflater.from(context).inflate(R.layout.custom_list,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull VideoViiewHolder holder, int position) {
        holder.textName.setText(files.get(position).getName());
        holder.textName.setSelected(true);
        Bitmap thumb= ThumbnailUtils.createVideoThumbnail(files.get(position).getAbsolutePath(),
                MediaStore.Images.Thumbnails.MINI_KIND);
        holder.imgThumbnail.setImageBitmap(thumb);
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onFileClicked(files.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return files.size();
    }
}
