package com.example.topsite;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import snakex.topsite.R;

public class view_holder extends RecyclerView.ViewHolder {


	ImageView photo;
	TextView Name;

public view_holder(@NonNull View itemView) {
	super(itemView);

	photo = itemView.findViewById(R.id.top_social_photo_show);
	Name = itemView.findViewById(R.id.top_social_name_show);

}
}
