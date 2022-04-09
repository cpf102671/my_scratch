package com.example.myapplication;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.Spinner;

import androidx.annotation.NonNull;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;

public class TaiwanScratch extends Activity {
    WebView mWebView = null;
    Spinner mTaiwan;
    ImageButton back_iv;
    String urlstation=("https://sites.google.com/view/happyscratch2022/%E9%A6%96%E9%A0%81");
    String nowurlstation=("https://sites.google.com/view/happyscratch2022/%E9%A6%96%E9%A0%81");
    private InterstitialAd mInterstitialAd;
    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_taiwan_scratch);

        MobileAds.initialize(this, initializationStatus -> {
        });

        setAds();

        mWebView =findViewById(R.id.webview);
        mTaiwan=findViewById(R.id.mauntaiwan);
        back_iv=findViewById(R.id.back_iv);

        mWebView.setWebViewClient(mWebViewClient);
        convertWedPages(0);

        back_iv.setOnClickListener(view -> {
            if (urlstation.equals("https://sites.google.com/view/happyscratch2022/%E9%A6%96%E9%A0%81") && nowurlstation.equals("https://sites.google.com/view/happyscratch2022/%E9%A6%96%E9%A0%81")) {
                Intent intent = new Intent(TaiwanScratch.this, MainActivity.class);
                startActivity(intent);
            } else if (urlstation.equals(nowurlstation)) {
                convertWedPages(0);
            }else {
                mWebView.loadUrl(urlstation);
                nowurlstation=(urlstation);
            }
        });

        mTaiwan.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1,
                                       int arg2, long arg3) {
                // TODO Auto-generated method stub
                convertWedPages(arg2);
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub

            }
        });
    }

    public void convertWedPages(int a){
        switch (a){
            case 0:
                mWebView.loadUrl("https://sites.google.com/view/happyscratch2022/%E9%A6%96%E9%A0%81");
                urlstation=("https://sites.google.com/view/happyscratch2022/%E9%A6%96%E9%A0%81");
                break;
            case 1:
                mWebView.loadUrl("https://sites.google.com/view/happyscratch2022/nt100");
                urlstation=("https://sites.google.com/view/happyscratch2022/nt100");
                nowurlstation=("https://sites.google.com/view/happyscratch2022/nt100");
                break;
            case 2:
                mWebView.loadUrl("https://sites.google.com/view/happyscratch2022/nt200");
                urlstation=("https://sites.google.com/view/happyscratch2022/nt200");
                nowurlstation=("https://sites.google.com/view/happyscratch2022/nt200");
                break;
            case 3:
                mWebView.loadUrl("https://sites.google.com/view/happyscratch2022/nt300");
                urlstation=("https://sites.google.com/view/happyscratch2022/nt300");
                nowurlstation=("https://sites.google.com/view/happyscratch2022/nt300");
                break;
            case 4:
                mWebView.loadUrl("https://sites.google.com/view/happyscratch2022/nt500");
                urlstation=("https://sites.google.com/view/happyscratch2022/nt500");
                nowurlstation=("https://sites.google.com/view/happyscratch2022/nt500");
                break;
            case 5:
                mWebView.loadUrl("https://sites.google.com/view/happyscratch2022/nt1000");
                urlstation=("https://sites.google.com/view/happyscratch2022/nt1000");
                nowurlstation=("https://sites.google.com/view/happyscratch2022/nt1000");
                break;
            case 6:
                mWebView.loadUrl("https://sites.google.com/view/happyscratch2022/nt2000");
                urlstation=("https://sites.google.com/view/happyscratch2022/nt2000");
                nowurlstation=("https://sites.google.com/view/happyscratch2022/nt2000");
                break;
            case 7:
                mWebView.loadUrl("https://sites.google.com/view/happyscratch2022/%E5%AF%A6%E9%9A%9B%E6%A9%9F%E7%8E%87%E6%8E%92%E8%A1%8C");
                urlstation=("https://sites.google.com/view/happyscratch2022/%E5%AF%A6%E9%9A%9B%E6%A9%9F%E7%8E%87%E6%8E%92%E8%A1%8C");
                nowurlstation=("https://sites.google.com/view/happyscratch2022/%E5%AF%A6%E9%9A%9B%E6%A9%9F%E7%8E%87%E6%8E%92%E8%A1%8C");
                break;
            case 8:
                mWebView.loadUrl("https://sites.google.com/view/happyscratch2022/%E9%A0%AD%E7%8D%8E%E7%8D%8E%E9%87%91%E6%9C%80%E9%AB%98");
                urlstation=("https://sites.google.com/view/happyscratch2022/%E9%A0%AD%E7%8D%8E%E7%8D%8E%E9%87%91%E6%9C%80%E9%AB%98");
                nowurlstation=("https://sites.google.com/view/happyscratch2022/%E9%A0%AD%E7%8D%8E%E7%8D%8E%E9%87%91%E6%9C%80%E9%AB%98");
                break;
            case 9:
                mWebView.loadUrl("https://sites.google.com/view/happyscratch2022/%E9%A0%AD%E7%8D%8E%E4%B8%AD%E7%8D%8E%E7%8E%87%E6%9C%80%E9%AB%98");
                urlstation=("https://sites.google.com/view/happyscratch2022/%E9%A0%AD%E7%8D%8E%E4%B8%AD%E7%8D%8E%E7%8E%87%E6%9C%80%E9%AB%98");
                nowurlstation=("https://sites.google.com/view/happyscratch2022/%E9%A0%AD%E7%8D%8E%E4%B8%AD%E7%8D%8E%E7%8E%87%E6%9C%80%E9%AB%98");
                break;
            case 10:
                toAdmob();
                break;
        }

    }
    private void setAds() {
        AdRequest adRequest = new AdRequest.Builder().build();

        InterstitialAd.load(this, "ca-app-pub-7423243150220011/2615075965", adRequest, new InterstitialAdLoadCallback() {
            @Override
            public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {
                // The mInterstitialAd reference will be null until
                // an ad is loaded.
                mInterstitialAd = interstitialAd;
                Log.d("---AdMob", "onAdLoaded");
            }

            @Override
            public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                // Handle the error
                Log.d("---AdMob", loadAdError.getMessage());
                mInterstitialAd = null;
            }
        });
    }

    public void toAdmob() {
        if (mInterstitialAd != null) {
            mInterstitialAd.show(TaiwanScratch.this);
            mInterstitialAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                @Override
                public void onAdDismissedFullScreenContent() {
                    // Called when fullscreen content is dismissed.
                    super.onAdDismissedFullScreenContent();
                    mWebView.loadUrl("https://sites.google.com/view/happyscratch2022/%E6%8E%A8%E8%96%A6");
                    urlstation=("https://sites.google.com/view/happyscratch2022/%E6%8E%A8%E8%96%A6");
                    nowurlstation=("https://sites.google.com/view/happyscratch2022/%E6%8E%A8%E8%96%A6");
                    mInterstitialAd = null;
                    setAds();
                }
            });
        } else {
            Log.d("---AdMob", "The interstitial ad wasn't ready yet.");
            mWebView.loadUrl("https://sites.google.com/view/happyscratch2022/%E6%8E%A8%E8%96%A6");
            urlstation=("https://sites.google.com/view/happyscratch2022/%E6%8E%A8%E8%96%A6");
            nowurlstation=("https://sites.google.com/view/happyscratch2022/%E6%8E%A8%E8%96%A6");
        }
    }

    WebViewClient mWebViewClient = new WebViewClient() {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            nowurlstation=(url);
            return true;
        }
    };

}