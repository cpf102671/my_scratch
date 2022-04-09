package com.example.myapplication;

import androidx.annotation.NonNull;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageButton;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;

public class MainActivity extends Activity {
    ImageButton totaiwan ;
    private InterstitialAd mInterstitialAd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MobileAds.initialize(this, initializationStatus -> {
        });
        setAds();
        totaiwan = findViewById(R.id.totaiwan);
        totaiwan.setOnClickListener(view -> onAdmob());
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

    public void onAdmob() {
        if (mInterstitialAd != null) {
            mInterstitialAd.show(MainActivity.this);
            mInterstitialAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                @Override
                public void onAdDismissedFullScreenContent() {
                    // Called when fullscreen content is dismissed.
                    super.onAdDismissedFullScreenContent();

                    Intent intent = new Intent(MainActivity.this, TaiwanScratch.class);
                    startActivity(intent);
                    setAds();
                }
                });

        } else {
            Log.d("---AdMob", "The interstitial ad wasn't ready yet.");
            Intent intent = new Intent(MainActivity.this,TaiwanScratch.class);
            startActivity(intent);
        }
    }
}