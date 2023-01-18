package com.example.topsite;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import snakex.topsite.R;

public class Adapter extends RecyclerView.Adapter<view_holder> {

	ArrayList<SocialData> SocialData;
	Context context;


public Adapter(ArrayList<SocialData> SocialData, Context context) {
	this.SocialData = SocialData;
	this.context = context;
}

@NonNull
@Override
public view_holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

	View view = LayoutInflater.from(context).inflate(R.layout.design,parent,false);


	return new view_holder(view);
}

@Override
public void onBindViewHolder(@NonNull view_holder holder, int position) {

	 SocialData  oneSocialData = SocialData.get(position);

	Picasso.get().load(oneSocialData.getSocial_photo_url()).placeholder(R.mipmap.social_media_photo).into(holder.photo);
	holder.Name.setText(oneSocialData.getSocial_name());


	holder.itemView.setOnClickListener(view -> {
		Intent intent = new Intent(context, ShowSite.class);
		intent.putExtra("site_url", oneSocialData.social_url);
		context.startActivity(intent);
	});

}

@Override
public int getItemCount() {

	 if (SocialData.size()==0){

			return 9;
	 }else {
			return SocialData.size();

	 }

}
}
