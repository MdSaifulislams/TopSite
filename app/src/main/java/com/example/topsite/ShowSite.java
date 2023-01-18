package com.example.topsite;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import snakex.topsite.R;
import snakex.topsite.databinding.SocialDetailsBinding;


public class ShowSite extends AppCompatActivity {

SocialDetailsBinding binding;
Context context = ShowSite.this;

String url;




@Override
protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	binding = SocialDetailsBinding.inflate(getLayoutInflater());
	setContentView(binding.getRoot());


url =	 getIntent().getStringExtra("site_url");



setWebViewSettings();
loadUrl();



}

private void loadUrl() {



	 binding.showWebView.loadUrl(url);


	 binding.showWebView.setWebViewClient(new WebViewClient(){

			@Override
			public void onPageStarted(WebView view, String url, Bitmap favicon) {
				 super.onPageStarted(view, url, favicon);

				 binding.progressBar.setVisibility(View.VISIBLE);
				 binding.progressBar1.setVisibility(View.VISIBLE);

			}

			@Override
			public void onPageFinished(WebView view, String url) {
				 super.onPageFinished(view, url);

				 binding.progressBar.setVisibility(View.INVISIBLE);
				 binding.progressBar1.setVisibility(View.INVISIBLE);
			}
	 });

	 binding.showWebView.setWebChromeClient( new WebChromeClient() {

			@Override
			public void onProgressChanged(WebView view, int newProgress) {
				 super.onProgressChanged(view, newProgress);
				 binding.progressBar1.setProgress(newProgress);}
	 });


}




private void setWebViewSettings() {

	 binding.showWebView.getSettings().setJavaScriptEnabled(true);
	 binding.showWebView.setWebChromeClient(new WebChromeClient());
	 binding.showWebView.getSettings().setPluginState(WebSettings.PluginState.ON);

}




@Override
public void onBackPressed() {

	if (binding.showWebView.canGoBack()){
		binding.showWebView.goBack();
	}else {
		alert_dialog();
	}
}



public void alert_dialog() {


	AlertDialog.Builder alert_dialog = new AlertDialog.Builder(context);

	alert_dialog.setTitle("Exit site");
	alert_dialog.setMessage("If you close this site press exit");
	alert_dialog.setIcon(R.drawable.home_icon);

	alert_dialog.setPositiveButton("Exit", (dialogInterface, i) -> finish());


	alert_dialog.setNegativeButton("No", (dialogInterface, i) -> {

	});


	 alert_dialog.show();


}



}