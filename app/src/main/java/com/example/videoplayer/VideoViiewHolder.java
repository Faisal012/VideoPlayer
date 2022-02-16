package com.example.videoplayer;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class VideoViiewHolder extends RecyclerView.ViewHolder {
    public ImageView imgThumbnail;
    public TextView textName;
    public CardView cardView;
    public VideoViiewHolder(@NonNull View itemView) {
        super(itemView);
        imgThumbnail=itemView.findViewById(R.id.imgThumbnail);
        textName=itemView.findViewById(R.id.textName);
        cardView=itemView.findViewById(R.id.card_view);
    }
}
