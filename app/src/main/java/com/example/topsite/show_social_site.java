package com.example.topsite;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;


import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import snakex.topsite.databinding.ShowSocialSiteBinding;

public class show_social_site extends AppCompatActivity {

ShowSocialSiteBinding binding;
DatabaseReference databaseReference;


ArrayList<SocialData> SocialDataList;

 SocialData socialDataClass;

String
    fireUrl = "https://firebasestorage.googleapis.com/v0/b/snakex-bookx.appspot.com/o/Class-1%20English%20For%20Today%20Final%20OPT.pdf?alt=media&token=56e4dd7d-39c6-4728-b781-567b7368729a"
    ,micUrl = "https://onedrive.live.com/embed?cid=7323908493D4E464&resid=7323908493D4E464%2118997&authkey=AD2b4huOQ44ACM4&em=2"
		,driveUrl ="https://drive.google.com/file/d/1CacCnLFHwERyazh9gyDYl7IiRLR_Hyml/view?usp=share_link"
		;

@Override
protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	binding = ShowSocialSiteBinding.inflate(getLayoutInflater());
	setContentView(binding.getRoot());

	 initialise();
	social_data();
  getDataIntoFireBase();


	setAdapter();


}

private void setAdapter() {


	 Adapter adapter = new Adapter(SocialDataList, show_social_site.this);

	 binding.showRecyclerView.setAdapter(adapter);

}

private void initialise() {

	 databaseReference = FirebaseDatabase.getInstance().getReference("TopSiteList");

}

private void getDataIntoFireBase() {

 databaseReference.addValueEventListener(new ValueEventListener() {
		@Override
		public void onDataChange(@NonNull DataSnapshot snapshot) {

			 for (DataSnapshot oneSnapshot : snapshot.getChildren()){

					socialDataClass = oneSnapshot.getValue(SocialData.class);

				  SocialDataList.add(socialDataClass);


			 }
       setAdapter();

		}

		@Override
		public void onCancelled(@NonNull DatabaseError error) {

		}
 });


}

private void social_data() {

	SocialDataList = new ArrayList<>();

	SocialDataList.add(new SocialData("	Google Search	","https://www.google.com/", "https://firebasestorage.googleapis.com/v0/b/top-site-5b516.appspot.com/o/Site%20icon%2Fgoogle.png?alt=media&token=1b95a027-466a-4bf2-a6af-3560d8464254"));
	SocialDataList.add(new SocialData("	Bing	", "https://www.bing.com/", "https://firebasestorage.googleapis.com/v0/b/top-site-5b516.appspot.com/o/Site%20icon%2Fbing.png?alt=media&token=d5e7abb2-93c7-49fc-b10e-8fbd45aeabb3"));
	SocialDataList.add(new SocialData("	YouTube	","https://www.youtube.com/", "https://firebasestorage.googleapis.com/v0/b/top-site-5b516.appspot.com/o/Site%20icon%2Fyoutube.png?alt=media&token=8e66c768-a84a-44d6-b834-1ea1c3e4797f"));
	SocialDataList.add(new SocialData("	Facebook	", "https://m.facebook.com/", "https://firebasestorage.googleapis.com/v0/b/top-site-5b516.appspot.com/o/Site%20icon%2Ffacebook.png?alt=media&token=d296a972-d6ed-421d-ab3d-5515860cf9f7"));
	SocialDataList.add(new SocialData("	Twitter	", "	twitter.com", "https://firebasestorage.googleapis.com/v0/b/top-site-5b516.appspot.com/o/Site%20icon%2Ftwitter.png?alt=media&token=fdb500f2-3c25-4c6a-98cf-dba10a0e35d1"));
	SocialDataList.add(new SocialData("Instagram	", "instagram.com	", "https://firebasestorage.googleapis.com/v0/b/top-site-5b516.appspot.com/o/Site%20icon%2Finstagram.png?alt=media&token=ce6ee7d7-24ba-4c47-97c7-936703b761df"));
	SocialDataList.add(new SocialData("	TikTok	", "	tiktok.com", "https://firebasestorage.googleapis.com/v0/b/top-site-5b516.appspot.com/o/Site%20icon%2Ftiktok.png?alt=media&token=aa7bd471-896b-49d7-bce9-4d9edc38e04b"));
	SocialDataList.add(new SocialData("Translate	", "https://translate.google.com/","https://firebasestorage.googleapis.com/v0/b/top-site-5b516.appspot.com/o/Site%20icon%2Ftranslate.png?alt=media&token=e1d91233-fb17-41e9-85a5-578bcd4adbf0"));
	SocialDataList.add(new SocialData("Likee	", "https://likee.video/trending?lang=en&fromHome=1","https://firebasestorage.googleapis.com/v0/b/top-site-5b516.appspot.com/o/Site%20icon%2Flikee.jpeg?alt=media&token=0a524d29-695c-49bf-9a24-7872264ee591"));
	SocialDataList.add(new SocialData("Snapchat	", "https://story.snapchat.com/spotlight","https://firebasestorage.googleapis.com/v0/b/top-site-5b516.appspot.com/o/Site%20icon%2Fsnapchat.png?alt=media&token=6535f635-9d61-4ffd-9eb0-c47e6d3e287f"));
	SocialDataList.add(new SocialData("Telegram	", "https://oauth.telegram.org/auth?bot_id=531675494&origin=https%3A%2F%2Ftelegram.org&embed=1&request_access=write&return_to=https%3A%2F%2Ftelegram.org%2Fblog%2Flogin","https://firebasestorage.googleapis.com/v0/b/top-site-5b516.appspot.com/o/Site%20icon%2Ftelegram.png?alt=media&token=42042317-aa26-4459-b60d-a308b33c7bf1"));
	SocialDataList.add(new SocialData(" Pinterest	", "https://www.pinterest.com/","https://firebasestorage.googleapis.com/v0/b/top-site-5b516.appspot.com/o/Site%20icon%2Fpinterest.png?alt=media&token=c9f758a3-1fb7-4966-a09c-e2d78354bfb5"));
	SocialDataList.add(new SocialData("	Baidu	", "https://www.baidu.com/","https://firebasestorage.googleapis.com/v0/b/top-site-5b516.appspot.com/o/Site%20icon%2Fbaidu.png?alt=media&token=9cb07fd6-3d0a-499e-9761-0857947d0704"));
	SocialDataList.add(new SocialData("	Wikipedia	", "	wikipedia.org	","https://firebasestorage.googleapis.com/v0/b/top-site-5b516.appspot.com/o/Site%20icon%2Fwikipedia_icon.png?alt=media&token=7c4c4272-dd8b-43e2-93a2-1c6271dd81e2"));
	SocialDataList.add(new SocialData("	Amazon	", "https://www.amazon.com/", "https://firebasestorage.googleapis.com/v0/b/top-site-5b516.appspot.com/o/Site%20icon%2FAmazon-Logo-PNG-Isolated-HD.png?alt=media&token=e64467fe-b606-4981-ab81-7459c1f8027b"));
	SocialDataList.add(new SocialData("	Alibaba	", "https://www.alibaba.com/","https://firebasestorage.googleapis.com/v0/b/top-site-5b516.appspot.com/o/Site%20icon%2Falibaba.png?alt=media&token=dda80881-c9d1-4625-87be-032e2a0e228c"));
	SocialDataList.add(new SocialData("Icloud", "https://www.icloud.com/","https://firebasestorage.googleapis.com/v0/b/top-site-5b516.appspot.com/o/Site%20icon%2Fapple-logo.png?alt=media&token=65cd7b94-32a1-4b10-af27-8bc30cb6fd2a"));
	SocialDataList.add(new SocialData("	Mail", "https://mail.google.com/", "https://firebasestorage.googleapis.com/v0/b/top-site-5b516.appspot.com/o/Site%20icon%2Fmail.png?alt=media&token=0bbf8e9e-b011-4938-8286-835dd41b207d"));
	SocialDataList.add(new SocialData("	Quora", "https://www.quora.com/","https://firebasestorage.googleapis.com/v0/b/top-site-5b516.appspot.com/o/Site%20icon%2Fquora.png?alt=media&token=681a80a4-88ef-4f36-9635-3c2aaf570575"));
	SocialDataList.add(new SocialData("	Maps", "https://www.google.com/maps","https://firebasestorage.googleapis.com/v0/b/top-site-5b516.appspot.com/o/Site%20icon%2Fgoogle-maps.png?alt=media&token=102470a9-ace0-4264-ae40-d41758f1b914"));
	SocialDataList.add(new SocialData("	Yandex	", "https://yandex.eu/", "https://firebasestorage.googleapis.com/v0/b/top-site-5b516.appspot.com/o/Site%20icon%2Fyandex.png?alt=media&token=107d7721-243a-48a3-a00f-923bf265d33a"));
	SocialDataList.add(new SocialData("	Yahoo	", "https://mail.yahoo.com/", "https://firebasestorage.googleapis.com/v0/b/top-site-5b516.appspot.com/o/Site%20icon%2Fyahoo.png?alt=media&token=fa68d575-078c-43db-ae15-af3cce5819e1"));
	SocialDataList.add(new SocialData("	Netflix	", "https://www.netflix.com/bd/", "https://firebasestorage.googleapis.com/v0/b/top-site-5b516.appspot.com/o/Site%20icon%2Fnetflix.png?alt=media&token=00064b27-5831-4e32-b511-75fbcdab1036"));
	SocialDataList.add(new SocialData("	Spotify	", "https://open.spotify.com/","https://firebasestorage.googleapis.com/v0/b/top-site-5b516.appspot.com/o/Site%20icon%2Fspotify.png?alt=media&token=f9e0d4eb-298d-42ea-b59e-8bc7335ef99e"));
	SocialDataList.add(new SocialData("	Reddit	", "https://www.reddit.com/","https://firebasestorage.googleapis.com/v0/b/top-site-5b516.appspot.com/o/Site%20icon%2Freddit.png?alt=media&token=4d5a43a0-b27a-4187-b8b8-7e83abf1ff64"));
	SocialDataList.add(new SocialData("	LinkedIn	", "https://www.linkedin.com/","https://firebasestorage.googleapis.com/v0/b/top-site-5b516.appspot.com/o/Site%20icon%2Flinkedin.png?alt=media&token=68808285-b6a5-4d7e-b8ee-5337d6f8da6e"));
	SocialDataList.add(new SocialData("	Blogger	", "https://www.blogger.com/","https://firebasestorage.googleapis.com/v0/b/top-site-5b516.appspot.com/o/Site%20icon%2Fblogger.png?alt=media&token=82f8f2a1-854b-4c29-9193-4d9a69ee9017"));
	SocialDataList.add(new SocialData("	Icc Cricket	", "https://www.icc-cricket.com/live-cricket/live","https://firebasestorage.googleapis.com/v0/b/top-site-5b516.appspot.com/o/Site%20icon%2Ficc.png?alt=media&token=8a2362ca-5aee-4f61-b867-9d0a8387eab0"));
	SocialDataList.add(new SocialData("fifa Football", "https://www.fifa.com/", "https://firebasestorage.googleapis.com/v0/b/top-site-5b516.appspot.com/o/Site%20icon%2Ffootball.png?alt=media&token=d5e4463e-47c5-4f8d-b41b-b06890a124f7"));
//	 SocialData.add(new SocialData("	WeChat	", "	WeChat.com	", ""));
	SocialDataList.add(new SocialData("QQ", "	https://im.qq.com/index	","https://firebasestorage.googleapis.com/v0/b/top-site-5b516.appspot.com/o/Site%20icon%2FQQ.png?alt=media&token=677f8224-37e8-422a-a5c2-1d8562b1da48"));
	SocialDataList.add(new SocialData("Zoom", "	https://zoom.us/signin#/login	","https://firebasestorage.googleapis.com/v0/b/top-site-5b516.appspot.com/o/Site%20icon%2Fzoom.png?alt=media&token=c72f9003-bdb3-4ffb-9e7d-f9bb91749b7f"));
	SocialDataList.add(new SocialData("Meet", "https://meet.google.com/","https://firebasestorage.googleapis.com/v0/b/top-site-5b516.appspot.com/o/Site%20icon%2Fmeet.png?alt=media&token=58c42813-def1-41ec-93de-a31243f282db"));
}



}