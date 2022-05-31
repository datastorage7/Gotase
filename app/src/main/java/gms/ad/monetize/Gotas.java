package gms.ad.monetize;

import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.vectordrawable.graphics.drawable.ArgbEvaluator;

import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdLoader;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.OnUserEarnedRewardListener;
import com.google.android.gms.ads.appopen.AppOpenAd;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.ads.nativead.NativeAd;
import com.google.android.gms.ads.nativead.NativeAdOptions;
import com.google.android.gms.ads.rewarded.RewardItem;
import com.google.android.gms.ads.rewarded.RewardedAd;
import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback;
import com.google.android.gms.ads.rewardedinterstitial.RewardedInterstitialAd;
import com.google.android.gms.ads.rewardedinterstitial.RewardedInterstitialAdLoadCallback;
import com.startapp.sdk.ads.banner.Banner;
import com.startapp.sdk.ads.banner.BannerListener;
import com.startapp.sdk.ads.banner.Mrec;
import com.startapp.sdk.ads.nativead.StartAppNativeAd;
import com.startapp.sdk.adsbase.Ad;
import com.startapp.sdk.adsbase.StartAppAd;
import com.startapp.sdk.adsbase.StartAppSDK;
import com.startapp.sdk.adsbase.adlisteners.AdEventListener;
import com.tappx.sdk.android.TappxAdError;
import com.tappx.sdk.android.TappxBanner;
import com.tappx.sdk.android.TappxBannerListener;
import com.tappx.sdk.android.TappxInterstitial;
import com.tappx.sdk.android.TappxInterstitialListener;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class Gotas {

    public static int Server_Yes_No = 1000;
    public static int Exit_Menu_Decided = 0, Setup_Main = 0;
    private static boolean isShowingAd = false;
    private static boolean isShowingAd1 = false;
    private static boolean isShowingAd2 = false;
    private static boolean isShowingAd3 = false;
    public InterstitialAd Splash_InterstialAd, InterstialAd, InterstialAd1;
    public InterstitialAd InterstialAd_Setup3, InterstialAd_Setup2, InterstialAd_Setup1;
    public RewardedAd mRewardedAd;
    public RewardedInterstitialAd rewardedInterstitialAd;
    public AppOpenAd.AppOpenAdLoadCallback loadCallback;
    public AppOpenAd.AppOpenAdLoadCallback loadCallback1;

    //String Native_ID;
    public AppOpenAd.AppOpenAdLoadCallback loadCallback2;
    public AppOpenAd.AppOpenAdLoadCallback loadCallback3;
    public int Which_Banner;
    public int Which_Native;
    Context Contextt;
    AdView mAdView, mAdView_exit;
    int Inter_Setup, App_Open_Setup;
    RewardedInterstitialAd mrewardedInterstitialAd;
    RelativeLayout relative;
    String Tx_ID;
    String Interstial, Interstial1, Interstial2;
    String Banner, Banner1, Banner2;
    String Native_ID, Native_ID1, Native_ID2;
    String APP_ID, APP_OPEN, REWARD, INTER_REWARD, EXTRA1, EXTRA2;
    TappxBanner Tappxbanner;
    TappxInterstitial Splash_tappxInterstitial_preload, tappxInterstitial,
            tappxInterstitial_preload;
    StartAppAd startAppAd_rewarded;
    StartAppAd.AdMode SO;
    StartAppAd.AdMode SO_AUTOMATIC = StartAppAd.AdMode.AUTOMATIC;
    StartAppAd.AdMode SO_FULLPAGE = StartAppAd.AdMode.FULLPAGE;
    StartAppAd.AdMode SO_OFFERWALL = StartAppAd.AdMode.OFFERWALL;
    StartAppAd.AdMode SO_VIDEO = StartAppAd.AdMode.VIDEO;
    StartAppAd.AdMode SO_REWARDED_VIDEO = StartAppAd.AdMode.REWARDED_VIDEO;
    int Native_Load = 1000;
    NativeTemplateView nativeTemplateView_Pre_Load = null;
    String Server = "";
    String TX = "", BR1 = "", BR2 = "", IN1 = "", IN2 = "";
    String NA1 = "", NA2 = "", AID = "", AO = "", RD = "", IRD = "", EX1 = "", EX2 = "";
    String B11 = "", B111 = "", B22 = "", B222 = "", B33 = "", B333 = "", I11 = "", I111 = "", I22 = "", I222 = "", I33 = "", I333 = "", N11 = "", N111 = "", N22 = "", N222 = "", N33 = "", N333 = "", AO11 = "", AO111 = "", AO22 = "", AO222 = "", AO33 = "", AO333 = "", RD11 = "", RD111 = "", RD22 = "", RD222 = "", RD33 = "", RD333 = "", IRD11 = "", IRD111 = "", IRD22 = "", IRD222 = "", IRD33 = "", IRD333 = "";
    String Setup = "";
    String B11_ID = "", B111_ID = "", B22_ID = "", B222_ID = "", B33_ID = "", B333_ID = "", I11_ID = "", I111_ID = "", I22_ID = "", I222_ID = "", I33_ID = "", I333_ID = "", N11_ID = "", N111_ID = "", N22_ID = "", N222_ID = "", N33_ID = "", N333_ID = "", AO11_ID = "", AO111_ID = "", AO22_ID = "", AO222_ID = "", AO33_ID = "", AO333_ID = "", RD11_ID = "", RD111_ID = "", RD22_ID = "", RD222_ID = "", RD33_ID = "", RD333_ID = "", IRD11_ID = "", IRD111_ID = "", IRD22_ID = "", IRD222_ID = "", IRD33_ID = "", IRD333_ID = "";
    String Setup_ID = "";
    int Inter_Failed;
    AdView Pre_Load_mAdView;
    int Banner_Load_Not = 5;
    TappxBanner Pre_Tappxbanner;
    NativeTemplateView pre_Load_Native_Native_templateView;
    int Native_Load_Not = 5;
    ConnectivityManager connec;
    String Packages;
    String Name;
    boolean ads_exit_Preferense, ads_enter_Preferense;
    String Enter_Ads_Popup_Or_Not = "", Exit_Top_Ads_Popup_Or_Not = "";
    LinearLayout LL;
    HorizontalScrollView HH;
    ProgressDialog Ad_ProgressDialog;
    ArrayList<HashMap<String, String>> contactList;
    Boolean doubleBackToExitPressedOnce = false;
    private StartAppAd startAppAd;
    private StartAppNativeAd startAppNativeAd;
    private AppOpenAd appOpenAd = null;
    private AppOpenAd appOpenAd1 = null;
    private AppOpenAd appOpenAd2 = null;
    private AppOpenAd appOpenAd3 = null;

    @SuppressWarnings("static-access")
    public Gotas(Context context, String Package, String name,
                 final String Tx_id, final String Interstial_ID,
                 final String Interstial_ID1, final String Banner_ID,
                 final String Banner_ID1, final String NativeID1, final String NativeID2,
                 final String App_id, final String App_Open, final String Reward,
                 final String Inter_Reward, final String Extra1, final String SO,
                 String server, final String Setup_Id, final String B11_Id, final String B111_Id,
                 final String B22_Id, final String B222_Id, final String B33_Id, final String B333_Id,
                 final String I11_Id, final String I111_Id, final String I22_Id, final String I222_Id,
                 final String I33_Id, final String I333_Id, final String N11_Id,
                 final String N111_Id, final String N22_Id, final String N222_Id,
                 final String N33_Id, final String N333_Id, final String AO11_Id,
                 final String AO111_Id, final String AO22_Id, final String AO222_Id,
                 final String AO33_Id, final String AO333_Id, final String RD11_Id,
                 final String RD111_Id, final String RD22_Id, final String RD222_Id,
                 final String RD33_Id, final String RD333_Id, final String IRD11_Id,
                 final String IRD111_Id, final String IRD22_Id, final String IRD222_Id,
                 final String IRD33_Id, final String IRD333_Id) {

        Contextt = context;
        Packages = Package;
        Name = name;

        Server = server;


        MobileAds.initialize(Contextt, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus
                                                         initializationStatus) {
            }
        });

        StartAppSDK.init(context, "" + SO, false);

        startAppAd = new StartAppAd(context.getApplicationContext());


        StartAppAd.disableSplash();

        connec = (ConnectivityManager) Contextt
                .getSystemService(Contextt.CONNECTIVITY_SERVICE);
        contactList = new ArrayList<HashMap<String, String>>();

        if (isNetworkConnected(Contextt) == true) {

            new GetData().execute();

        } else if (isNetworkConnected(Contextt) == false) {

            Exit_Menu_Decided = 0;
        }


        Tx_ID = Tx_id;

        Interstial1 = Interstial_ID;
        Interstial2 = Interstial_ID1;

        Banner1 = Banner_ID;
        Banner2 = Banner_ID1;

        Native_ID1 = NativeID1;
        Native_ID2 = NativeID2;

        APP_ID = App_id;
        APP_OPEN = App_Open;
        REWARD = Reward;
        INTER_REWARD = Inter_Reward;
        EXTRA1 = Extra1;
        EXTRA2 = SO;

        Setup_ID = Setup_Id;
        B11_ID = B11_Id;
        B111_ID = B111_Id;
        B22_ID = B22_Id;
        B222_ID = B222_Id;
        B33_ID = B33_Id;
        B333_ID = B333_Id;
        I11_ID = I11_Id;
        I111_ID = I111_Id;
        I22_ID = I22_Id;
        I222_ID = I222_Id;
        I33_ID = I33_Id;
        I333_ID = I333_Id;
        N11_ID = N11_Id;
        N111_ID = N111_Id;
        N22_ID = N22_Id;
        N222_ID = N222_Id;
        N33_ID = N33_Id;
        N333_ID = N333_Id;
        AO11_ID = AO11_Id;
        AO111_ID = AO111_Id;
        AO22_ID = AO22_Id;
        AO222_ID = AO222_Id;
        AO33_ID = AO33_Id;
        AO333_ID = AO333_Id;
        RD11_ID = RD11_Id;
        RD111_ID = RD111_Id;
        RD22_ID = RD22_Id;
        RD222_ID = RD222_Id;
        RD33_ID = RD33_Id;
        RD333_ID = RD333_Id;
        IRD11_ID = IRD11_Id;
        IRD111_ID = IRD111_Id;
        IRD22_ID = IRD22_Id;
        IRD222_ID = IRD222_Id;
        IRD33_ID = IRD33_Id;
        IRD333_ID = IRD333_Id;


    }

    public void Pre_Banner_Load_Decided(final int Which_Banner_Load) {

        if (SharedPreferences.getbanner(Contextt) == 0) {

            Banner = SharedPreferences.getbanner1(Contextt);

            SharedPreferences.setbanner(Contextt, 1);

        } else {

            Banner = SharedPreferences.getbanner2(Contextt);

            SharedPreferences.setbanner(Contextt, 0);

        }

        Pre_Load_mAdView = new AdView(Contextt);

        if (Which_Banner_Load == 4) {

            Pre_Load_mAdView.setAdSize(AdSize.MEDIUM_RECTANGLE);

        } else if (Which_Banner_Load == 3) {

            Pre_Load_mAdView.setAdSize(AdSize.LARGE_BANNER);

        } else if (Which_Banner_Load == 2) {

            Pre_Load_mAdView.setAdSize(AdSize.LARGE_BANNER);

        } else if (Which_Banner_Load == 1) {

            Pre_Load_mAdView.setAdSize(AdSize.BANNER);

        } else {

            Pre_Load_mAdView.setAdSize(AdSize.BANNER);

        }

        Pre_Load_mAdView.setAdUnitId(Banner);
        AdRequest adore = new AdRequest.Builder().build();
        Pre_Load_mAdView.loadAd(adore);
        Pre_Load_mAdView.setAdListener(new AdListener() {

            @Override
            public void onAdLoaded() {
                // TODO Auto-generated method stub
                super.onAdLoaded();

                SharedPreferences.setsplashcount(Contextt, 0);

                Banner_Load_Not = 1;

            }

            @Override
            public void onAdFailedToLoad(int errorCode) {
                // TODO Auto-generated method stub
                super.onAdFailedToLoad(errorCode);

                Banner_Load_Not = 0;

                Pre_Banner_Load_Tappx_Decided(Which_Banner_Load);

            }

        });

    }

    public void Pre_Banner_Load_Tappx_Decided(int Which_Banner_Load) {

        Pre_Tappxbanner = new TappxBanner(Contextt, SharedPreferences.gettx(Contextt));

        if (Which_Banner_Load == 4) {

            Pre_Tappxbanner
                    .setAdSize(TappxBanner.AdSize.BANNER_300x250);

        } else if (Which_Banner_Load == 3) {

            Pre_Tappxbanner
                    .setAdSize(TappxBanner.AdSize.BANNER_300x250);

        } else if (Which_Banner_Load == 2) {

            Pre_Tappxbanner
                    .setAdSize(TappxBanner.AdSize.BANNER_300x250);

        } else if (Which_Banner_Load == 1) {

            Pre_Tappxbanner
                    .setAdSize(TappxBanner.AdSize.SMART_BANNER);

        } else {

            Pre_Tappxbanner
                    .setAdSize(TappxBanner.AdSize.SMART_BANNER);

        }

        Pre_Tappxbanner.loadAd();
        Pre_Tappxbanner.setRefreshTimeSeconds(45);

        Pre_Tappxbanner.setListener(new TappxBannerListener() {
            @Override
            public void onBannerLoaded(TappxBanner tappxBanner) {

                SharedPreferences.setsplashcount(Contextt,
                        (SharedPreferences.getsplashcount(Contextt) + 1));

            }

            @Override
            public void onBannerLoadFailed(TappxBanner tappxBanner,
                                           TappxAdError tappxAdError) {

            }

            @Override
            public void onBannerClicked(TappxBanner tappxBanner) {

            }

            @Override
            public void onBannerExpanded(TappxBanner tappxBanner) {

            }

            @Override
            public void onBannerCollapsed(TappxBanner tappxBanner) {

            }
        });

    }

    public void Pre_Banner_Show_Decided(final RelativeLayout Ad_Layout,
                                        final int Banner_Type) {

        if (Banner_Load_Not == 1) {

            try {

                Ad_Layout.addView(Pre_Load_mAdView);

                RelativeLayout.LayoutParams relativeParams = (RelativeLayout.LayoutParams) Ad_Layout
                        .getLayoutParams();
                relativeParams.setMargins(0, 10, 0, 0);
                Ad_Layout.setLayoutParams(relativeParams);

            } catch (Exception e) {
                // TODO: handle exception
            }

        }

        if (Banner_Load_Not == 0) {

            try {

                Ad_Layout.addView(Pre_Tappxbanner);

                RelativeLayout.LayoutParams relativeParams = (RelativeLayout.LayoutParams) Ad_Layout
                        .getLayoutParams();
                relativeParams.setMargins(0, 10, 0, 0);
                Ad_Layout.setLayoutParams(relativeParams);

            } catch (Exception e) {
                // TODO: handle exception
            }

        }

    }

    public void Banner_Pre_Load(final int Which_Banner_Load) {

        if (Exit_Menu_Decided == 100) {

            return;
        }

        if (isNetworkConnected(Contextt) == true) {

            final Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {

                    if (Server_Yes_No == 1 || Server_Yes_No == 0) {


                        if ((SharedPreferences.getSetup(Contextt)).equals("1")) {

                            Banner_Pre_Load_Setup1(Which_Banner_Load);

                        } else if ((SharedPreferences.getSetup(Contextt)).equals("0")) {

                            Banner_Pre_Load_Normal(Which_Banner_Load);

                        }


                    } else {

                        handler.postDelayed(this, 1000);

                    }

                }

            }, 1000);

        }


    }

    public void Banner_Show(final RelativeLayout Ad_Layout) {

        if (Exit_Menu_Decided == 100) {

            return;
        }

        if ((SharedPreferences.getSetup(Contextt)).equals("1")) {

            Banner_Show_Setup(Ad_Layout);

        } else if ((SharedPreferences.getSetup(Contextt)).equals("0")) {

            Banner_Show_Normal(Ad_Layout);

        }

    }

    public void Banner_Pre_Load_Normal(final int Which_Banner_Load) {

        Which_Banner = Which_Banner_Load;

        if (SharedPreferences.getbanner(Contextt) == 0) {

            Banner = SharedPreferences.getbanner1(Contextt);

            SharedPreferences.setbanner(Contextt, 1);

        } else {

            Banner = SharedPreferences.getbanner2(Contextt);

            SharedPreferences.setbanner(Contextt, 0);

        }

        Pre_Load_mAdView = new AdView(Contextt);

        if (Which_Banner_Load == 4) {

            Pre_Load_mAdView.setAdSize(AdSize.MEDIUM_RECTANGLE);

        } else if (Which_Banner_Load == 3) {

            Pre_Load_mAdView.setAdSize(AdSize.LARGE_BANNER);

        } else if (Which_Banner_Load == 2) {

            Pre_Load_mAdView.setAdSize(AdSize.LARGE_BANNER);

        } else if (Which_Banner_Load == 1) {

            Pre_Load_mAdView.setAdSize(AdSize.BANNER);

        } else {

            Pre_Load_mAdView.setAdSize(AdSize.BANNER);

        }

        Pre_Load_mAdView.setAdUnitId(Banner);
        AdRequest adore = new AdRequest.Builder().build();
        Pre_Load_mAdView.loadAd(adore);
        Pre_Load_mAdView.setAdListener(new AdListener() {

            @Override
            public void onAdLoaded() {
                // TODO Auto-generated method stub
                super.onAdLoaded();

                SharedPreferences.setsplashcount(Contextt, 0);

                Banner_Load_Not = 1;

            }

            @Override
            public void onAdFailedToLoad(int errorCode) {
                // TODO Auto-generated method stub
                super.onAdFailedToLoad(errorCode);


                Pre_Banner_Load_Tappx_Normal(Which_Banner_Load);

            }

        });

    }

    public void Pre_Banner_Load_Tappx_Normal(int Which_Banner_Load) {

        Pre_Tappxbanner = new TappxBanner(Contextt, SharedPreferences.gettx(Contextt));

        if (Which_Banner_Load == 4) {

            Pre_Tappxbanner
                    .setAdSize(TappxBanner.AdSize.BANNER_300x250);

        } else if (Which_Banner_Load == 3) {

            Pre_Tappxbanner
                    .setAdSize(TappxBanner.AdSize.BANNER_300x250);

        } else if (Which_Banner_Load == 2) {

            Pre_Tappxbanner
                    .setAdSize(TappxBanner.AdSize.BANNER_300x250);

        } else if (Which_Banner_Load == 1) {

            Pre_Tappxbanner
                    .setAdSize(TappxBanner.AdSize.SMART_BANNER);

        } else {

            Pre_Tappxbanner
                    .setAdSize(TappxBanner.AdSize.SMART_BANNER);

        }

        Pre_Tappxbanner.loadAd();
        Pre_Tappxbanner.setRefreshTimeSeconds(45);

        Pre_Tappxbanner.setListener(new TappxBannerListener() {
            @Override
            public void onBannerLoaded(TappxBanner tappxBanner) {

                SharedPreferences.setsplashcount(Contextt,
                        (SharedPreferences.getsplashcount(Contextt) + 1));

                Banner_Load_Not = 0;

            }

            @Override
            public void onBannerLoadFailed(TappxBanner tappxBanner,
                                           TappxAdError tappxAdError) {


            }

            @Override
            public void onBannerClicked(TappxBanner tappxBanner) {

            }

            @Override
            public void onBannerExpanded(TappxBanner tappxBanner) {

            }

            @Override
            public void onBannerCollapsed(TappxBanner tappxBanner) {

            }
        });

    }

    public void Banner_Show_Normal(final RelativeLayout Ad_Layout) {


        if (Banner_Load_Not == 1) {

            try {

                if (Pre_Load_mAdView != null) {
                    Ad_Layout.removeAllViews();
                    Ad_Layout.addView(Pre_Load_mAdView);

                }


            } catch (Exception e) {
                // TODO: handle exception
            }

        }

        if (Banner_Load_Not == 0) {

            try {

                if (Pre_Tappxbanner != null) {
                    Ad_Layout.removeAllViews();
                    Ad_Layout.addView(Pre_Tappxbanner);

                }


            } catch (Exception e) {
                // TODO: handle exception
            }

        }

        Banner_Pre_Load_Normal(Which_Banner);


    }

    public void Banner_Pre_Load_Setup1(final int Which_Banner_Load) {

        Which_Banner = Which_Banner_Load;

        if (SharedPreferences.getBB1(Contextt) == 0) {

            Banner = SharedPreferences.getB11(Contextt);

            SharedPreferences.setBB1(Contextt, 1);

        } else {

            Banner = SharedPreferences.getB111(Contextt);

            SharedPreferences.setBB1(Contextt, 0);

        }

        Pre_Load_mAdView = new AdView(Contextt);

        if (Which_Banner_Load == 4) {

            Pre_Load_mAdView.setAdSize(AdSize.MEDIUM_RECTANGLE);

        } else if (Which_Banner_Load == 3) {

            Pre_Load_mAdView.setAdSize(AdSize.LARGE_BANNER);

        } else if (Which_Banner_Load == 2) {

            Pre_Load_mAdView.setAdSize(AdSize.LARGE_BANNER);

        } else if (Which_Banner_Load == 1) {

            Pre_Load_mAdView.setAdSize(AdSize.BANNER);

        } else {

            Pre_Load_mAdView.setAdSize(AdSize.BANNER);

        }

        Pre_Load_mAdView.setAdUnitId(Banner);
        AdRequest adore = new AdRequest.Builder().build();
        Pre_Load_mAdView.loadAd(adore);
        Pre_Load_mAdView.setAdListener(new AdListener() {

            @Override
            public void onAdLoaded() {
                // TODO Auto-generated method stub
                super.onAdLoaded();

                SharedPreferences.setsplashcount(Contextt, 0);

                Banner_Load_Not = 1;

            }

            @Override
            public void onAdFailedToLoad(int errorCode) {
                // TODO Auto-generated method stub
                super.onAdFailedToLoad(errorCode);

                Banner_Pre_Load_Setup2(Which_Banner);


            }

        });

    }

    public void Banner_Pre_Load_Setup2(final int Which_Banner_Load) {

        Which_Banner = Which_Banner_Load;

        if (SharedPreferences.getBB2(Contextt) == 0) {

            Banner = SharedPreferences.getB22(Contextt);

            SharedPreferences.setBB2(Contextt, 1);

        } else {

            Banner = SharedPreferences.getB222(Contextt);

            SharedPreferences.setBB2(Contextt, 0);

        }

        Pre_Load_mAdView = new AdView(Contextt);

        if (Which_Banner_Load == 4) {

            Pre_Load_mAdView.setAdSize(AdSize.MEDIUM_RECTANGLE);

        } else if (Which_Banner_Load == 3) {

            Pre_Load_mAdView.setAdSize(AdSize.LARGE_BANNER);

        } else if (Which_Banner_Load == 2) {

            Pre_Load_mAdView.setAdSize(AdSize.LARGE_BANNER);

        } else if (Which_Banner_Load == 1) {

            Pre_Load_mAdView.setAdSize(AdSize.BANNER);

        } else {

            Pre_Load_mAdView.setAdSize(AdSize.BANNER);

        }

        Pre_Load_mAdView.setAdUnitId(Banner);
        AdRequest adore = new AdRequest.Builder().build();
        Pre_Load_mAdView.loadAd(adore);
        Pre_Load_mAdView.setAdListener(new AdListener() {

            @Override
            public void onAdLoaded() {
                // TODO Auto-generated method stub
                super.onAdLoaded();

                SharedPreferences.setsplashcount(Contextt, 0);

                Banner_Load_Not = 2;

            }

            @Override
            public void onAdFailedToLoad(int errorCode) {
                // TODO Auto-generated method stub
                super.onAdFailedToLoad(errorCode);

                Banner_Pre_Load_Setup3(Which_Banner);


            }

        });

    }

    public void Banner_Pre_Load_Setup3(final int Which_Banner_Load) {

        Which_Banner = Which_Banner_Load;

        if (SharedPreferences.getBB3(Contextt) == 0) {

            Banner = SharedPreferences.getB33(Contextt);

            SharedPreferences.setBB3(Contextt, 1);

        } else {

            Banner = SharedPreferences.getB333(Contextt);

            SharedPreferences.setBB3(Contextt, 0);

        }

        Pre_Load_mAdView = new AdView(Contextt);

        if (Which_Banner_Load == 4) {

            Pre_Load_mAdView.setAdSize(AdSize.MEDIUM_RECTANGLE);

        } else if (Which_Banner_Load == 3) {

            Pre_Load_mAdView.setAdSize(AdSize.LARGE_BANNER);

        } else if (Which_Banner_Load == 2) {

            Pre_Load_mAdView.setAdSize(AdSize.LARGE_BANNER);

        } else if (Which_Banner_Load == 1) {

            Pre_Load_mAdView.setAdSize(AdSize.BANNER);

        } else {

            Pre_Load_mAdView.setAdSize(AdSize.BANNER);

        }

        Pre_Load_mAdView.setAdUnitId(Banner);
        AdRequest adore = new AdRequest.Builder().build();
        Pre_Load_mAdView.loadAd(adore);
        Pre_Load_mAdView.setAdListener(new AdListener() {

            @Override
            public void onAdLoaded() {
                // TODO Auto-generated method stub
                super.onAdLoaded();

                SharedPreferences.setsplashcount(Contextt, 0);

                Banner_Load_Not = 3;

            }

            @Override
            public void onAdFailedToLoad(int errorCode) {
                // TODO Auto-generated method stub
                super.onAdFailedToLoad(errorCode);

                Pre_Banner_Load_Tappx_Normal(Which_Banner_Load);


            }

        });

    }

    public void Banner_Show_Setup(final RelativeLayout Ad_Layout) {


        if (Banner_Load_Not == 1) {

            try {

                if (Pre_Load_mAdView != null) {

                    Ad_Layout.removeAllViews();
                    Ad_Layout.addView(Pre_Load_mAdView);

                }


            } catch (Exception e) {
                // TODO: handle exception
            }

        }

        if (Banner_Load_Not == 2) {

            try {

                if (Pre_Load_mAdView != null) {

                    Ad_Layout.removeAllViews();
                    Ad_Layout.addView(Pre_Load_mAdView);

                }


            } catch (Exception e) {
                // TODO: handle exception
            }

        }

        if (Banner_Load_Not == 3) {

            try {

                if (Pre_Load_mAdView != null) {

                    Ad_Layout.removeAllViews();
                    Ad_Layout.addView(Pre_Load_mAdView);

                }


            } catch (Exception e) {
                // TODO: handle exception
            }

        }

        if (Banner_Load_Not == 0) {

            try {

                if (Pre_Tappxbanner != null) {

                    Ad_Layout.removeAllViews();
                    Ad_Layout.addView(Pre_Tappxbanner);

                }


            } catch (Exception e) {
                // TODO: handle exception
            }

        }

        Banner_Pre_Load_Setup1(Which_Banner);


    }

    public void Native_Pre_Load(final int Which_Native_Load) {

        if (Exit_Menu_Decided == 100) {

            return;
        }

        if (isNetworkConnected(Contextt) == true) {

            final Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {

                    if (Server_Yes_No == 1 || Server_Yes_No == 0) {

                        if ((SharedPreferences.getSetup(Contextt)).equals("1")) {

                            Native_Pre_Load_Setup1(Which_Native_Load);

                        } else if ((SharedPreferences.getSetup(Contextt)).equals("0")) {

                            Native_Pre_Load_Normal(Which_Native_Load);

                        }


                    } else {

                        handler.postDelayed(this, 500);

                    }

                }

            }, 500);

        }
    }

    public void Native_Pre_Load_Normal(final int Which_Native_Load) {

        Which_Native = Which_Native_Load;

        if (SharedPreferences.getnative(Contextt) == 0) {

            Native_ID = SharedPreferences.getnative1(Contextt);

            SharedPreferences.setnative(Contextt, 1);


        } else {

            Native_ID = SharedPreferences.getnative2(Contextt);

            SharedPreferences.setnative(Contextt, 0);


        }

        AdLoader adLoader = new AdLoader.Builder(Contextt, Native_ID)
                .forNativeAd(new NativeAd.OnNativeAdLoadedListener() {
                    private ColorDrawable background;

                    @Override
                    public void onNativeAdLoaded(NativeAd nativeAd) {
                        NativeStyle styles = new
                                NativeStyle.Builder().withMainBackgroundColor(background).build();


                        pre_Load_Native_Native_templateView = new NativeTemplateView(Contextt, Which_Native_Load);

                        pre_Load_Native_Native_templateView.setStyles(styles);
                        pre_Load_Native_Native_templateView.setNativeAd(nativeAd);
                        pre_Load_Native_Native_templateView.setVisibility(View.VISIBLE);

                        Native_Load_Not = 1;


                    }

                })
                .withAdListener(new AdListener() {
                    @Override
                    public void onAdFailedToLoad(LoadAdError adError) {

                        Pre_Banner_Load_Tappx_Normal_For_Native(Which_Native_Load);

                    }
                })
                .withNativeAdOptions(new NativeAdOptions.Builder()

                        .build())
                .build();

        adLoader.loadAd(new AdRequest.Builder().build());

    }

    public void Native_Pre_Load_Setup1(final int Which_Native_Load) {

        Which_Native = Which_Native_Load;

        if (SharedPreferences.getNN1(Contextt) == 0) {

            Native_ID = SharedPreferences.getN11(Contextt);

            SharedPreferences.setNN1(Contextt, 1);


        } else {

            Native_ID = SharedPreferences.getN111(Contextt);

            SharedPreferences.setNN1(Contextt, 0);


        }

        AdLoader adLoader = new AdLoader.Builder(Contextt, Native_ID)
                .forNativeAd(new NativeAd.OnNativeAdLoadedListener() {
                    private ColorDrawable background;

                    @Override
                    public void onNativeAdLoaded(NativeAd nativeAd) {
                        NativeStyle styles = new
                                NativeStyle.Builder().withMainBackgroundColor(background).build();


                        pre_Load_Native_Native_templateView = new NativeTemplateView(Contextt, Which_Native_Load);

                        pre_Load_Native_Native_templateView.setStyles(styles);
                        pre_Load_Native_Native_templateView.setNativeAd(nativeAd);
                        pre_Load_Native_Native_templateView.setVisibility(View.VISIBLE);

                        Native_Load_Not = 1;


                    }

                })
                .withAdListener(new AdListener() {
                    @Override
                    public void onAdFailedToLoad(LoadAdError adError) {

                        Native_Pre_Load_Setup2(Which_Native_Load);

                    }
                })
                .withNativeAdOptions(new NativeAdOptions.Builder()

                        .build())
                .build();

        adLoader.loadAd(new AdRequest.Builder().build());

    }

    public void Native_Pre_Load_Setup2(final int Which_Native_Load) {

        Which_Native = Which_Native_Load;

        if (SharedPreferences.getNN2(Contextt) == 0) {

            Native_ID = SharedPreferences.getN22(Contextt);

            SharedPreferences.setNN2(Contextt, 1);


        } else {

            Native_ID = SharedPreferences.getN222(Contextt);

            SharedPreferences.setNN2(Contextt, 0);


        }

        AdLoader adLoader = new AdLoader.Builder(Contextt, Native_ID)
                .forNativeAd(new NativeAd.OnNativeAdLoadedListener() {
                    private ColorDrawable background;

                    @Override
                    public void onNativeAdLoaded(NativeAd nativeAd) {
                        NativeStyle styles = new
                                NativeStyle.Builder().withMainBackgroundColor(background).build();


                        pre_Load_Native_Native_templateView = new NativeTemplateView(Contextt, Which_Native_Load);

                        pre_Load_Native_Native_templateView.setStyles(styles);
                        pre_Load_Native_Native_templateView.setNativeAd(nativeAd);
                        pre_Load_Native_Native_templateView.setVisibility(View.VISIBLE);

                        Native_Load_Not = 2;


                    }

                })
                .withAdListener(new AdListener() {
                    @Override
                    public void onAdFailedToLoad(LoadAdError adError) {

                        Native_Pre_Load_Setup3(Which_Native_Load);

                    }
                })
                .withNativeAdOptions(new NativeAdOptions.Builder()

                        .build())
                .build();

        adLoader.loadAd(new AdRequest.Builder().build());

    }

    public void Native_Pre_Load_Setup3(final int Which_Native_Load) {

        Which_Native = Which_Native_Load;

        if (SharedPreferences.getNN3(Contextt) == 0) {

            Native_ID = SharedPreferences.getN33(Contextt);

            SharedPreferences.setNN3(Contextt, 1);


        } else {

            Native_ID = SharedPreferences.getN333(Contextt);

            SharedPreferences.setNN3(Contextt, 0);


        }

        AdLoader adLoader = new AdLoader.Builder(Contextt, Native_ID)
                .forNativeAd(new NativeAd.OnNativeAdLoadedListener() {
                    private ColorDrawable background;

                    @Override
                    public void onNativeAdLoaded(NativeAd nativeAd) {
                        NativeStyle styles = new
                                NativeStyle.Builder().withMainBackgroundColor(background).build();


                        pre_Load_Native_Native_templateView = new NativeTemplateView(Contextt, Which_Native_Load);

                        pre_Load_Native_Native_templateView.setStyles(styles);
                        pre_Load_Native_Native_templateView.setNativeAd(nativeAd);
                        pre_Load_Native_Native_templateView.setVisibility(View.VISIBLE);

                        Native_Load_Not = 3;


                    }

                })
                .withAdListener(new AdListener() {
                    @Override
                    public void onAdFailedToLoad(LoadAdError adError) {

                        Pre_Banner_Load_Tappx_Normal_For_Native(Which_Native_Load);

                    }
                })
                .withNativeAdOptions(new NativeAdOptions.Builder()

                        .build())
                .build();

        adLoader.loadAd(new AdRequest.Builder().build());

    }

    public void Pre_Banner_Load_Tappx_Normal_For_Native(int Which_Native_Load) {

        Pre_Tappxbanner = new TappxBanner(Contextt, SharedPreferences.gettx(Contextt));


        Pre_Tappxbanner
                .setAdSize(TappxBanner.AdSize.BANNER_300x250);


        Pre_Tappxbanner.loadAd();
        Pre_Tappxbanner.setRefreshTimeSeconds(30);

        Pre_Tappxbanner.setListener(new TappxBannerListener() {
            @Override
            public void onBannerLoaded(TappxBanner tappxBanner) {

                SharedPreferences.setsplashcount(Contextt,
                        (SharedPreferences.getsplashcount(Contextt) + 1));

                Native_Load_Not = 0;

            }

            @Override
            public void onBannerLoadFailed(TappxBanner tappxBanner,
                                           TappxAdError tappxAdError) {


            }

            @Override
            public void onBannerClicked(TappxBanner tappxBanner) {

            }

            @Override
            public void onBannerExpanded(TappxBanner tappxBanner) {

            }

            @Override
            public void onBannerCollapsed(TappxBanner tappxBanner) {

            }
        });

    }

    public void Native_Show_Normal(final RelativeLayout Ad_Layout) {

        if (Native_Load_Not == 1) {

            if (pre_Load_Native_Native_templateView != null) {


                try {

                    Ad_Layout.removeAllViews();
                    Ad_Layout.setVisibility(View.VISIBLE);
                    Ad_Layout.addView(pre_Load_Native_Native_templateView);
                    Native_Pre_Load_Normal(Which_Native);

                } catch (Exception e) {
                    // TODO: handle exception
                }


            }
        }

        if (Native_Load_Not == 0) {

            if (Pre_Tappxbanner != null) {


                try {

                    Ad_Layout.removeAllViews();
                    Ad_Layout.setVisibility(View.VISIBLE);
                    Ad_Layout.addView(Pre_Tappxbanner);
                    Native_Pre_Load_Normal(Which_Native);

                } catch (Exception e) {
                    // TODO: handle exception
                }


            }
        }

    }

    public void Native_Show_Setup(final RelativeLayout Ad_Layout) {

        if (Native_Load_Not == 1) {

            if (pre_Load_Native_Native_templateView != null) {


                try {

                    Ad_Layout.removeAllViews();
                    Ad_Layout.setVisibility(View.VISIBLE);
                    Ad_Layout.addView(pre_Load_Native_Native_templateView);
                    Native_Pre_Load_Setup1(Which_Native);

                } catch (Exception e) {
                    // TODO: handle exception
                }


            }
        }

        if (Native_Load_Not == 2) {

            if (pre_Load_Native_Native_templateView != null) {


                try {

                    Ad_Layout.removeAllViews();
                    Ad_Layout.setVisibility(View.VISIBLE);
                    Ad_Layout.addView(pre_Load_Native_Native_templateView);
                    Native_Pre_Load_Setup1(Which_Native);

                } catch (Exception e) {
                    // TODO: handle exception
                }


            }
        }

        if (Native_Load_Not == 3) {

            if (pre_Load_Native_Native_templateView != null) {


                try {

                    Ad_Layout.removeAllViews();
                    Ad_Layout.setVisibility(View.VISIBLE);
                    Ad_Layout.addView(pre_Load_Native_Native_templateView);
                    Native_Pre_Load_Setup1(Which_Native);

                } catch (Exception e) {
                    // TODO: handle exception
                }


            }
        }

        if (Native_Load_Not == 0) {

            if (Pre_Tappxbanner != null) {


                try {

                    Ad_Layout.removeAllViews();
                    Ad_Layout.setVisibility(View.VISIBLE);
                    Ad_Layout.addView(Pre_Tappxbanner);
                    Native_Pre_Load_Setup1(Which_Native);

                } catch (Exception e) {
                    // TODO: handle exception
                }


            }
        }

    }

    public void Native_Show(final RelativeLayout Ad_Layout) {

        if (Exit_Menu_Decided == 100) {

            return;
        }

        if ((SharedPreferences.getSetup(Contextt)).equals("1")) {

            Native_Show_Setup(Ad_Layout);

        } else if ((SharedPreferences.getSetup(Contextt)).equals("0")) {

            Native_Show_Normal(Ad_Layout);

        }


    }

    @SuppressLint({"NewApi", "SetJavaScriptEnabled"})
    public void Splash_Icon(String App_Name, int Text_Color, int icLauncher,
                            final Context ads_context, final int animation_type) {

        if (isNetworkConnected(Contextt) == true) {


            int width = 480, Height = 800;

            final android.app.Dialog builder = new android.app.Dialog(ads_context);
            builder.requestWindowFeature(Window.FEATURE_NO_TITLE);
            builder.getWindow().setBackgroundDrawable(
                    new ColorDrawable(Color.BLACK));
            builder.getWindow().setFlags(
                    WindowManager.LayoutParams.FLAG_FULLSCREEN,
                    WindowManager.LayoutParams.FLAG_FULLSCREEN);

            WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
            lp.copyFrom(builder.getWindow().getAttributes());
            lp.width = WindowManager.LayoutParams.MATCH_PARENT;
            lp.height = WindowManager.LayoutParams.MATCH_PARENT;

            builder.setOnDismissListener(new DialogInterface.OnDismissListener() {
                @Override
                public void onDismiss(DialogInterface dialogInterface) {
                    // nothing;
                }
            });

            DisplayMetrics displayMetrics = new DisplayMetrics();
            builder.getWindow().getWindowManager().getDefaultDisplay()
                    .getMetrics(displayMetrics);

            width = displayMetrics.widthPixels;
            Height = displayMetrics.heightPixels;

            float[] hsv = new float[3];
            int color = Text_Color;
            Color.colorToHSV(color, hsv);
            hsv[2] *= 0.175f; // value component
            color = Color.HSVToColor(hsv);


            final RelativeLayout RL = new RelativeLayout(ads_context);
            //RL.setBackgroundColor(color);

            int colorFrom = ads_context.getResources().getColor(R.color.black);
            int colorTo = color;
            @SuppressLint("RestrictedApi") ValueAnimator colorAnimation = ValueAnimator.ofObject(new ArgbEvaluator(), colorFrom, colorTo);
            colorAnimation.setDuration(2000);
            colorAnimation.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {

                @Override
                public void onAnimationUpdate(ValueAnimator animator) {
                    RL.setBackgroundColor((int) animator.getAnimatedValue());
                }

            });
            colorAnimation.start();

            RL.setGravity(Gravity.CENTER_HORIZONTAL | Gravity.BOTTOM);
            builder.addContentView(RL, new RelativeLayout.LayoutParams(
                    WindowManager.LayoutParams.MATCH_PARENT,
                    WindowManager.LayoutParams.MATCH_PARENT));


            if (animation_type != 100) {

                WebView back = new WebView(ads_context);
                back.getSettings().setJavaScriptEnabled(true);
                back.setScrollContainer(false);
                back.setVerticalScrollBarEnabled(false);
                back.setHorizontalScrollBarEnabled(false);

                if (animation_type == 0) { // Random Animation

                    int animation_type_Ggenrate = (new Random().nextInt((20 - 1) + 1) + 1);

                    back.loadUrl("file:///android_asset/background/a" + animation_type_Ggenrate + "/index.html");

                    if (animation_type_Ggenrate == 1) {

                        Text_Color = Color.parseColor("#4EC0E9");

                    } else if (animation_type_Ggenrate == 2) {

                        Text_Color = Color.parseColor("#386d1b");

                    } else if (animation_type_Ggenrate == 3) {

                        Text_Color = Color.parseColor("#76B7F7");

                    } else if (animation_type_Ggenrate == 4) {

                        Text_Color = Color.parseColor("#76B7F7");

                    } else if (animation_type_Ggenrate == 5) {

                        Text_Color = Color.parseColor("#76B7F7");

                    } else if (animation_type_Ggenrate == 6) {

                        Text_Color = Color.parseColor("#76B7F7");

                    } else if (animation_type_Ggenrate == 7) {

                        Text_Color = Color.parseColor("#ff56b6");

                    } else if (animation_type_Ggenrate == 8) {

                        Text_Color = Color.parseColor("#8fc800");

                    } else if (animation_type_Ggenrate == 9) {

                        Text_Color = Color.parseColor("#00b7ea");

                    } else if (animation_type_Ggenrate == 10) {

                        Text_Color = Color.parseColor("#5aa1ed");

                    } else if (animation_type_Ggenrate == 11) {

                        Text_Color = Color.parseColor("#e8eded");

                    } else if (animation_type_Ggenrate == 12) {

                        Text_Color = Color.parseColor("#24f4ff");

                    } else if (animation_type_Ggenrate == 13) {

                        Text_Color = Color.parseColor("#FFFFFF");

                    } else if (animation_type_Ggenrate == 14) {

                        Text_Color = Color.parseColor("#FFFFFF");

                    } else if (animation_type_Ggenrate == 15) {

                        Text_Color = Color.parseColor("#eaeaea");

                    } else if (animation_type_Ggenrate == 16) {

                        Text_Color = Color.parseColor("#FFFFFF");

                    } else if (animation_type_Ggenrate == 17) {

                        Text_Color = Color.parseColor("#ffff88");

                    } else if (animation_type_Ggenrate == 18) {

                        Text_Color = Color.parseColor("#cdf1f7");

                    } else if (animation_type_Ggenrate == 19) {

                        Text_Color = Color.parseColor("#FFFFFF");

                    } else if (animation_type_Ggenrate == 20) {

                        Text_Color = Color.parseColor("#000000");

                    }

                } else { // Selected Animation 1 to 10
                    back.loadUrl("file:///android_asset/background/a" + animation_type + "/index.html");

                    if (animation_type == 1) {

                        Text_Color = Color.parseColor("#4EC0E9");

                    } else if (animation_type == 2) {

                        Text_Color = Color.parseColor("#386d1b");

                    } else if (animation_type == 3) {

                        Text_Color = Color.parseColor("#76B7F7");

                    } else if (animation_type == 4) {

                        Text_Color = Color.parseColor("#76B7F7");

                    } else if (animation_type == 5) {

                        Text_Color = Color.parseColor("#76B7F7");

                    } else if (animation_type == 6) {

                        Text_Color = Color.parseColor("#76B7F7");

                    } else if (animation_type == 7) {

                        Text_Color = Color.parseColor("#ff56b6");

                    } else if (animation_type == 8) {

                        Text_Color = Color.parseColor("#8fc800");

                    } else if (animation_type == 9) {

                        Text_Color = Color.parseColor("#00b7ea");

                    } else if (animation_type == 10) {

                        Text_Color = Color.parseColor("#5aa1ed");

                    } else if (animation_type == 11) {

                        Text_Color = Color.parseColor("#e8eded");

                    } else if (animation_type == 12) {

                        Text_Color = Color.parseColor("#24f4ff");

                    } else if (animation_type == 13) {

                        Text_Color = Color.parseColor("#FFFFFF");

                    } else if (animation_type == 14) {

                        Text_Color = Color.parseColor("#FFFFFF");

                    } else if (animation_type == 15) {

                        Text_Color = Color.parseColor("#eaeaea");

                    } else if (animation_type == 16) {

                        Text_Color = Color.parseColor("#FFFFFF");

                    } else if (animation_type == 17) {

                        Text_Color = Color.parseColor("#ffff88");

                    } else if (animation_type == 18) {

                        Text_Color = Color.parseColor("#cdf1f7");

                    } else if (animation_type == 19) {

                        Text_Color = Color.parseColor("#FFFFFF");

                    } else if (animation_type == 20) {

                        Text_Color = Color.parseColor("#000000");

                    }

                }
                builder.addContentView(back, new RelativeLayout.LayoutParams(
                        WindowManager.LayoutParams.MATCH_PARENT,
                        WindowManager.LayoutParams.MATCH_PARENT));
            }

            ImageView imageView = new ImageView(ads_context);
            imageView.setImageResource(icLauncher);
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            int image_paadding = ((int) (width / 5));
            imageView.setPadding(image_paadding, image_paadding,
                    image_paadding, image_paadding);
            imageView.setTranslationY(-(int) (Height / 7));
            builder.addContentView(imageView, new RelativeLayout.LayoutParams(
                    WindowManager.LayoutParams.MATCH_PARENT,
                    WindowManager.LayoutParams.MATCH_PARENT));


            TextView theText = new TextView(ads_context);
            theText.setText("" + App_Name);
            theText.setTextColor(Text_Color);
            theText.setTypeface(null, Typeface.BOLD);
            theText.setTextSize((int) (Height / (width / 11)));
            theText.setTranslationY(-(int) (Height / 5.5));

            theText.setGravity(Gravity.CENTER_HORIZONTAL | Gravity.BOTTOM);
            builder.addContentView(theText, new RelativeLayout.LayoutParams(
                    WindowManager.LayoutParams.MATCH_PARENT,
                    WindowManager.LayoutParams.MATCH_PARENT));


            ProgressBar progressBar = new ProgressBar(ads_context);


            progressBar.getIndeterminateDrawable().setColorFilter(Text_Color,
                    android.graphics.PorterDuff.Mode.MULTIPLY);

            int progressBar_padding = ((int) (width / 2.5));
            progressBar.setPadding(progressBar_padding, progressBar_padding,
                    progressBar_padding, progressBar_padding);
            progressBar.setTranslationY((float) ((Height) / 2.5));
            builder.addContentView(progressBar,
                    new RelativeLayout.LayoutParams(
                            WindowManager.LayoutParams.MATCH_PARENT,
                            WindowManager.LayoutParams.MATCH_PARENT));


            int[] Progreesssss = new int[]{R.drawable.roating_loading1, R.drawable.roating_loading2, R.drawable.roating_loading3, R.drawable.roating_loading4
                    , R.drawable.roating_loading5, R.drawable.roating_loading6, R.drawable.roating_loading7, R.drawable.roating_loading8, R.drawable.roating_loading9
                    , R.drawable.roating_loading10, R.drawable.roating_loading11, R.drawable.roating_loading12, R.drawable.roating_loading13, R.drawable.roating_loading14};


            progressBar.setIndeterminateDrawable(ads_context.getResources().getDrawable(Progreesssss[new Random().nextInt((13 - 0) + 1) + 0]));
            progressBar.getIndeterminateDrawable().setColorFilter(Text_Color,
                    android.graphics.PorterDuff.Mode.MULTIPLY);


            builder.show();
            builder.getWindow().setAttributes(lp);
            builder.setCancelable(false);

            final Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {


                    if (Server_Yes_No == 1 || Server_Yes_No == 0) {

                        if ((SharedPreferences.getSetup(ads_context)).equals("1")) {

                            Splash_Interstial_Setup1(builder, ads_context);

                        } else if ((SharedPreferences.getSetup(ads_context)).equals("0")) {

                            Splash_Interstial(builder, ads_context);

                        }


                    } else {

                        handler.postDelayed(this, 1000);

                    }

                }

            }, 1000);
        }


    }

    private void Splash_Popup_Dissmiss(final android.app.Dialog builder) {
        // TODO Auto-generated method stub

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {

                builder.dismiss();

            }

        }, 200);

    }

    public void Splash_Interstial(final android.app.Dialog builder, final Context mContext) {


        if (Exit_Menu_Decided == 100) {

            Splash_Popup_Dissmiss(builder);
            return;
        }


        if (SharedPreferences.getinter(mContext) == 0) {

            Interstial = SharedPreferences.getinter1(mContext);

            SharedPreferences.setinter(mContext, 1);

        } else {

            Interstial = SharedPreferences.getinter2(mContext);

            SharedPreferences.setinter(mContext, 0);

        }

        try {

            AdRequest adRequest = new AdRequest.Builder().build();
            Splash_InterstialAd = new InterstitialAd(mContext);
            Splash_InterstialAd.setAdUnitId(Interstial);

            Splash_InterstialAd.loadAd(adRequest);

            Splash_InterstialAd.setAdListener(new AdListener() {
                @Override
                public void onAdLoaded() {
                    super.onAdLoaded();


                    Splash_InterstialAd.show();

                    SharedPreferences.setsplashcount(mContext, 0);

                    Splash_Popup_Dissmiss(builder);

                }

                @Override
                public void onAdFailedToLoad(int errorCode) {
                    super.onAdFailedToLoad(errorCode);

                    Splash_InterstialAd = null;

                    Splash_Tappx_Inter(builder, mContext);

                }

            });
        } catch (Exception e) {

        }

    }

    public void Splash_Interstial_Setup1(final android.app.Dialog builder, final Context mContext) {


        if (Exit_Menu_Decided == 100) {

            Splash_Popup_Dissmiss(builder);
            return;
        }


        if (SharedPreferences.getII1(mContext) == 0) {

            Interstial = SharedPreferences.getI11(mContext);

            SharedPreferences.setII1(mContext, 1);

        } else {

            Interstial = SharedPreferences.getI111(mContext);

            SharedPreferences.setII1(mContext, 0);

        }

        try {

            AdRequest adRequest = new AdRequest.Builder().build();
            Splash_InterstialAd = new InterstitialAd(mContext);
            Splash_InterstialAd.setAdUnitId(Interstial);

            Splash_InterstialAd.loadAd(adRequest);

            Splash_InterstialAd.setAdListener(new AdListener() {
                @Override
                public void onAdLoaded() {
                    super.onAdLoaded();

                    Splash_InterstialAd.show();

                    SharedPreferences.setsplashcount(mContext, 0);

                    Splash_Popup_Dissmiss(builder);

                }

                @Override
                public void onAdFailedToLoad(int errorCode) {
                    super.onAdFailedToLoad(errorCode);

                    Splash_InterstialAd = null;

                    Splash_Interstial_Setup2(builder, mContext);


                }

            });
        } catch (Exception e) {

        }

    }

    public void Splash_Interstial_Setup2(final android.app.Dialog builder, final Context mContext) {


        if (SharedPreferences.getII2(mContext) == 0) {

            Interstial = SharedPreferences.getI22(mContext);

            SharedPreferences.setII2(mContext, 1);

        } else {

            Interstial = SharedPreferences.getI222(mContext);

            SharedPreferences.setII2(mContext, 0);

        }

        try {

            AdRequest adRequest = new AdRequest.Builder().build();
            Splash_InterstialAd = new InterstitialAd(mContext);
            Splash_InterstialAd.setAdUnitId(Interstial);

            Splash_InterstialAd.loadAd(adRequest);

            Splash_InterstialAd.setAdListener(new AdListener() {
                @Override
                public void onAdLoaded() {
                    super.onAdLoaded();

                    Splash_InterstialAd.show();

                    SharedPreferences.setsplashcount(mContext, 0);

                    Splash_Popup_Dissmiss(builder);

                }

                @Override
                public void onAdFailedToLoad(int errorCode) {
                    super.onAdFailedToLoad(errorCode);

                    Splash_InterstialAd = null;

                    Splash_Interstial_Setup3(builder, mContext);


                }

            });
        } catch (Exception e) {

        }

    }

    public void Splash_Interstial_Setup3(final android.app.Dialog builder, final Context mContext) {


        if (SharedPreferences.getII3(mContext) == 0) {

            Interstial = SharedPreferences.getI33(mContext);

            SharedPreferences.setII3(mContext, 1);

        } else {

            Interstial = SharedPreferences.getI333(mContext);

            SharedPreferences.setII3(mContext, 0);

        }

        try {

            AdRequest adRequest = new AdRequest.Builder().build();
            Splash_InterstialAd = new InterstitialAd(mContext);
            Splash_InterstialAd.setAdUnitId(Interstial);

            Splash_InterstialAd.loadAd(adRequest);

            Splash_InterstialAd.setAdListener(new AdListener() {
                @Override
                public void onAdLoaded() {
                    super.onAdLoaded();

                    Splash_InterstialAd.show();

                    SharedPreferences.setsplashcount(mContext, 0);

                    Splash_Popup_Dissmiss(builder);

                }

                @Override
                public void onAdFailedToLoad(int errorCode) {
                    super.onAdFailedToLoad(errorCode);

                    Splash_InterstialAd = null;

                    Splash_Interstial(builder, mContext);


                }

            });
        } catch (Exception e) {

        }

    }

    public void Splash_Tappx_Inter(final android.app.Dialog builder, final Context context) {

        Splash_tappxInterstitial_preload = new TappxInterstitial(context,
                SharedPreferences.gettx(context));
        Splash_tappxInterstitial_preload.loadAd();
        Splash_tappxInterstitial_preload
                .setListener(new TappxInterstitialListener() {
                    @Override
                    public void onInterstitialLoaded(
                            TappxInterstitial tappxInterstitial) {

                        tappxInterstitial.show();

                        Splash_Popup_Dissmiss(builder);

                        SharedPreferences.setsplashcount(context,
                                (SharedPreferences.getsplashcount(context) + 1));
                    }

                    @Override
                    public void onInterstitialLoadFailed(
                            TappxInterstitial tappxInterstitial,
                            TappxAdError tappxAdError) {


                        if ((new Random().nextInt((2 - 1) + 1) + 1) == 1) {
                            SO = SO_FULLPAGE;
                        } else {
                            SO = SO_OFFERWALL;
                        }

                        startAppAd.loadAd(SO, new AdEventListener() {
                            @Override
                            public void onReceiveAd(Ad ad) {

                                startAppAd.showAd();
                                Splash_Popup_Dissmiss(builder);

                            }

                            @Override
                            public void onFailedToReceiveAd(Ad ad) {
                                Splash_Popup_Dissmiss(builder);
                            }

                        });

                    }

                    @Override
                    public void onInterstitialClicked(TappxInterstitial arg0) {
                        // TODO Auto-generated method stub

                    }

                    @Override
                    public void onInterstitialDismissed(TappxInterstitial arg0) {
                        // TODO Auto-generated method stub

                    }

                    @Override
                    public void onInterstitialShown(TappxInterstitial arg0) {
                        // TODO Auto-generated method stub

                    }

                });

    }

    public void Banner(final RelativeLayout Ad_Layout, final int Banner_Type) {

        if (Exit_Menu_Decided == 100) {

            return;
        }

        if (isNetworkConnected(Contextt) == true) {

            final Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {

                    if (Server_Yes_No == 1 || Server_Yes_No == 0) {


                        if ((SharedPreferences.getSetup(Contextt)).equals("1")) {

                            Banner_Auto_Setup(Ad_Layout, Banner_Type);

                        } else if ((SharedPreferences.getSetup(Contextt)).equals("0")) {

                            Banner_Normal(Ad_Layout, Banner_Type);

                        }


                    } else {

                        handler.postDelayed(this, 500);

                    }

                }

            }, 500);

        } else {

            Ad_Layout.setVisibility(View.GONE);

        }


    }

    public void Banner_Main_Linear(final RelativeLayout Ad_Layout, final int Banner_Type) {

        if (isNetworkConnected(Contextt) == true) {

            final Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {

                    if (Server_Yes_No == 1 || Server_Yes_No == 0) {


                        if (Exit_Menu_Decided == 100) {

                            return;
                        }

                        if ((SharedPreferences.getSetup(Contextt)).equals("1")) {

                            Banner_Auto_Setup_Main_Linear(Ad_Layout, Banner_Type);

                        } else if ((SharedPreferences.getSetup(Contextt)).equals("0")) {

                            Banner_Main_Linear_Normal(Ad_Layout, Banner_Type);

                        }

                    } else {

                        handler.postDelayed(this, 500);

                    }

                }

            }, 500);

        } else {

            Ad_Layout.setVisibility(View.GONE);

        }


    }

    public void Banner_Normal(final RelativeLayout Ad_Layout, final int Banner_Type) {

        if (Exit_Menu_Decided == 100) {

            return;
        }

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                if (Server_Yes_No == 1 || Server_Yes_No == 0) {

                    AdSize Banner_Type_Size = null;

                    if (Banner_Type == 1) {

                        Banner_Type_Size = AdSize.BANNER;

                    } else if (Banner_Type == 2) {

                        Banner_Type_Size = AdSize.LARGE_BANNER;

                    } else if (Banner_Type == 3) {

                        Banner_Type_Size = AdSize.LARGE_BANNER;

                    } else if (Banner_Type == 4) {

                        Banner_Type_Size = AdSize.MEDIUM_RECTANGLE;

                    } else {

                        Banner_Type_Size = AdSize.BANNER;

                    }

                    if (SharedPreferences.getbanner(Contextt) == 0) {

                        Banner = SharedPreferences.getbanner1(Contextt);

                        SharedPreferences.setbanner(Contextt, 1);

                    } else {

                        Banner = SharedPreferences.getbanner2(Contextt);

                        SharedPreferences.setbanner(Contextt, 0);

                    }

                    mAdView = new AdView(Contextt);
                    mAdView.setAdSize(Banner_Type_Size);
                    mAdView.setAdUnitId(Banner);
                    AdRequest adore = new AdRequest.Builder().build();
                    mAdView.loadAd(adore);
                    Ad_Layout.addView(mAdView);

                    RelativeLayout.LayoutParams relativeParams = (RelativeLayout.LayoutParams) Ad_Layout
                            .getLayoutParams();
                    relativeParams.setMargins(0, 10, 0, 0);
                    Ad_Layout.setLayoutParams(relativeParams);

                    mAdView.setAdListener(new AdListener() {

                        @Override
                        public void onAdLoaded() {
                            // TODO Auto-generated method stub

                            Ad_Layout.setVisibility(View.VISIBLE);
                            SharedPreferences.setsplashcount(Contextt, 0);

                            super.onAdLoaded();

                        }

                        @Override
                        public void onAdFailedToLoad(int errorCode) {
                            // TODO Auto-generated method stub
                            super.onAdFailedToLoad(errorCode);

                            mAdView.destroy();

                            TappxBanner.AdSize Banner_Type_Size_Tappx = null;

                            if (Banner_Type == 1) {

                                Banner_Type_Size_Tappx = TappxBanner.AdSize.SMART_BANNER;

                            } else if (Banner_Type == 2) {

                                Banner_Type_Size_Tappx = TappxBanner.AdSize.BANNER_300x250;

                            } else if (Banner_Type == 3) {

                                Banner_Type_Size_Tappx = TappxBanner.AdSize.BANNER_300x250;

                            } else if (Banner_Type == 4) {

                                Banner_Type_Size_Tappx = TappxBanner.AdSize.BANNER_300x250;

                            } else {

                                Banner_Type_Size_Tappx = TappxBanner.AdSize.SMART_BANNER;

                            }

                            Tappxbanner = new TappxBanner(Contextt, SharedPreferences
                                    .gettx(Contextt));
                            Tappxbanner.setAdSize(Banner_Type_Size_Tappx);
                            Ad_Layout.addView(Tappxbanner);
                            Tappxbanner.loadAd();
                            Tappxbanner.setRefreshTimeSeconds(45);

                            Tappxbanner.setListener(new TappxBannerListener() {
                                @Override
                                public void onBannerLoaded(
                                        TappxBanner tappxBanner) {
                                    Ad_Layout.setVisibility(View.VISIBLE);

                                    SharedPreferences.setsplashcount(
                                            Contextt,
                                            (SharedPreferences.getsplashcount(Contextt) + 1));

                                }

                                @Override
                                public void onBannerLoadFailed(
                                        TappxBanner tappxBanner,
                                        TappxAdError tappxAdError) {

                                    Ad_Layout.setVisibility(View.GONE);
                                    SO_Banner(Ad_Layout, Banner_Type);


                                }

                                @Override
                                public void onBannerClicked(
                                        TappxBanner tappxBanner) {
                                    Ad_Layout.setVisibility(View.GONE);
                                }

                                @Override
                                public void onBannerExpanded(
                                        TappxBanner tappxBanner) {
                                }

                                @Override
                                public void onBannerCollapsed(
                                        TappxBanner tappxBanner) {
                                }
                            });

                        }
                    });

                } else {

                    handler.postDelayed(this, 500);

                }

            }

        }, 500);

    }

    public void Banner_Main_Linear_Normal(final RelativeLayout Ad_Layout, final int Banner_Type) {

        if (Exit_Menu_Decided == 100) {

            return;
        }

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                if (Server_Yes_No == 1 || Server_Yes_No == 0) {

                    AdSize Banner_Type_Size = null;

                    if (Banner_Type == 1) {

                        Banner_Type_Size = AdSize.BANNER;

                    } else if (Banner_Type == 2) {

                        Banner_Type_Size = AdSize.LARGE_BANNER;

                    } else if (Banner_Type == 3) {

                        Banner_Type_Size = AdSize.LARGE_BANNER;

                    } else if (Banner_Type == 4) {

                        Banner_Type_Size = AdSize.MEDIUM_RECTANGLE;

                    } else {

                        Banner_Type_Size = AdSize.BANNER;

                    }

                    if (SharedPreferences.getbanner(Contextt) == 0) {

                        Banner = SharedPreferences.getbanner1(Contextt);

                        SharedPreferences.setbanner(Contextt, 1);

                    } else {

                        Banner = SharedPreferences.getbanner2(Contextt);

                        SharedPreferences.setbanner(Contextt, 0);

                    }

                    mAdView = new AdView(Contextt);
                    mAdView.setAdSize(Banner_Type_Size);
                    mAdView.setAdUnitId(Banner);
                    AdRequest adore = new AdRequest.Builder().build();
                    mAdView.loadAd(adore);
                    Ad_Layout.addView(mAdView);

                    LinearLayout.LayoutParams relativeParams = (LinearLayout.LayoutParams) Ad_Layout
                            .getLayoutParams();
                    relativeParams.setMargins(0, 10, 0, 0);

                    Ad_Layout.setLayoutParams(relativeParams);

                    mAdView.setAdListener(new AdListener() {

                        @Override
                        public void onAdLoaded() {
                            // TODO Auto-generated method stub

                            Ad_Layout.setVisibility(View.VISIBLE);
                            SharedPreferences.setsplashcount(Contextt, 0);

                            super.onAdLoaded();

                        }

                        @Override
                        public void onAdFailedToLoad(int errorCode) {
                            // TODO Auto-generated method stub
                            super.onAdFailedToLoad(errorCode);

                            mAdView.destroy();

                            TappxBanner.AdSize Banner_Type_Size_Tappx = null;

                            if (Banner_Type == 1) {

                                Banner_Type_Size_Tappx = TappxBanner.AdSize.SMART_BANNER;

                            } else if (Banner_Type == 2) {

                                Banner_Type_Size_Tappx = TappxBanner.AdSize.BANNER_300x250;

                            } else if (Banner_Type == 3) {

                                Banner_Type_Size_Tappx = TappxBanner.AdSize.BANNER_300x250;

                            } else if (Banner_Type == 4) {

                                Banner_Type_Size_Tappx = TappxBanner.AdSize.BANNER_300x250;

                            } else {

                                Banner_Type_Size_Tappx = TappxBanner.AdSize.SMART_BANNER;

                            }

                            Tappxbanner = new TappxBanner(Contextt, SharedPreferences
                                    .gettx(Contextt));
                            Tappxbanner.setAdSize(Banner_Type_Size_Tappx);
                            Ad_Layout.addView(Tappxbanner);
                            Tappxbanner.loadAd();
                            Tappxbanner.setRefreshTimeSeconds(45);

                            Tappxbanner.setListener(new TappxBannerListener() {
                                @Override
                                public void onBannerLoaded(
                                        TappxBanner tappxBanner) {
                                    Ad_Layout.setVisibility(View.VISIBLE);

                                    SharedPreferences.setsplashcount(
                                            Contextt,
                                            (SharedPreferences.getsplashcount(Contextt) + 1));

                                }

                                @Override
                                public void onBannerLoadFailed(
                                        TappxBanner tappxBanner,
                                        TappxAdError tappxAdError) {

                                    Ad_Layout.setVisibility(View.GONE);
                                    SO_Banner(Ad_Layout, Banner_Type);

                                }

                                @Override
                                public void onBannerClicked(
                                        TappxBanner tappxBanner) {
                                    Ad_Layout.setVisibility(View.GONE);
                                }

                                @Override
                                public void onBannerExpanded(
                                        TappxBanner tappxBanner) {
                                }

                                @Override
                                public void onBannerCollapsed(
                                        TappxBanner tappxBanner) {
                                }
                            });

                        }
                    });

                } else {

                    handler.postDelayed(this, 500);

                }

            }

        }, 500);

    }

    public void Banner_Auto_Setup(final RelativeLayout Ad_Layout, final int Banner_Type) {

        if (Exit_Menu_Decided == 100) {

            return;
        }

        if (isNetworkConnected(Contextt) == true) {

            final Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {

                    if (Server_Yes_No == 1 || Server_Yes_No == 0) {

                        Banner_Auto_Setup1(Ad_Layout, Banner_Type);

                    } else {

                        handler.postDelayed(this, 500);

                    }

                }

            }, 500);

        } else {

            Ad_Layout.setVisibility(View.GONE);

        }


    }

    public void Banner_Auto_Setup1(final RelativeLayout Ad_Layout, final int Banner_Type) {

        if (Exit_Menu_Decided == 100) {

            return;
        }

        AdSize Banner_Type_Size = null;

        if (Banner_Type == 1) {

            Banner_Type_Size = AdSize.BANNER;

        } else if (Banner_Type == 2) {

            Banner_Type_Size = AdSize.LARGE_BANNER;

        } else if (Banner_Type == 3) {

            Banner_Type_Size = AdSize.LARGE_BANNER;

        } else if (Banner_Type == 4) {

            Banner_Type_Size = AdSize.MEDIUM_RECTANGLE;

        } else {

            Banner_Type_Size = AdSize.BANNER;

        }

        if (SharedPreferences.getBB1(Contextt) == 0) {

            Banner = SharedPreferences.getB11(Contextt);

            SharedPreferences.setBB1(Contextt, 1);

        } else {

            Banner = SharedPreferences.getB111(Contextt);

            SharedPreferences.setBB1(Contextt, 0);

        }

        AdView mAdView_Setup = new AdView(Contextt);
        mAdView_Setup.setAdSize(Banner_Type_Size);
        mAdView_Setup.setAdUnitId(Banner);
        AdRequest adore = new AdRequest.Builder().build();
        mAdView_Setup.loadAd(adore);
        Ad_Layout.addView(mAdView_Setup);

        RelativeLayout.LayoutParams relativeParams = (RelativeLayout.LayoutParams) Ad_Layout
                .getLayoutParams();
        relativeParams.setMargins(0, 10, 0, 0);
        Ad_Layout.setLayoutParams(relativeParams);

        mAdView_Setup.setAdListener(new AdListener() {

            @Override
            public void onAdLoaded() {
                // TODO Auto-generated method stub

                Ad_Layout.setVisibility(View.VISIBLE);

                super.onAdLoaded();

            }

            @Override
            public void onAdFailedToLoad(int errorCode) {
                // TODO Auto-generated method stub
                super.onAdFailedToLoad(errorCode);

                mAdView_Setup.destroy();

                Banner_Auto_Setup2(Ad_Layout, Banner_Type);

            }
        });
    }

    public void Banner_Auto_Setup2(final RelativeLayout Ad_Layout, final int Banner_Type) {

        if (Exit_Menu_Decided == 100) {

            return;
        }

        AdSize Banner_Type_Size = null;

        if (Banner_Type == 1) {

            Banner_Type_Size = AdSize.BANNER;

        } else if (Banner_Type == 2) {

            Banner_Type_Size = AdSize.LARGE_BANNER;

        } else if (Banner_Type == 3) {

            Banner_Type_Size = AdSize.LARGE_BANNER;

        } else if (Banner_Type == 4) {

            Banner_Type_Size = AdSize.MEDIUM_RECTANGLE;

        } else {

            Banner_Type_Size = AdSize.BANNER;

        }

        if (SharedPreferences.getBB2(Contextt) == 0) {

            Banner = SharedPreferences.getB22(Contextt);

            SharedPreferences.setBB2(Contextt, 1);

        } else {

            Banner = SharedPreferences.getB222(Contextt);

            SharedPreferences.setBB2(Contextt, 0);

        }

        AdView mAdView_Setup = new AdView(Contextt);
        mAdView_Setup.setAdSize(Banner_Type_Size);
        mAdView_Setup.setAdUnitId(Banner);
        AdRequest adore = new AdRequest.Builder().build();
        mAdView_Setup.loadAd(adore);
        Ad_Layout.addView(mAdView_Setup);

        RelativeLayout.LayoutParams relativeParams = (RelativeLayout.LayoutParams) Ad_Layout
                .getLayoutParams();
        relativeParams.setMargins(0, 10, 0, 0);
        Ad_Layout.setLayoutParams(relativeParams);

        mAdView_Setup.setAdListener(new AdListener() {

            @Override
            public void onAdLoaded() {
                // TODO Auto-generated method stub

                Ad_Layout.setVisibility(View.VISIBLE);

                super.onAdLoaded();

            }

            @Override
            public void onAdFailedToLoad(int errorCode) {
                // TODO Auto-generated method stub
                super.onAdFailedToLoad(errorCode);

                mAdView_Setup.destroy();

                Banner_Auto_Setup3(Ad_Layout, Banner_Type);

            }
        });
    }

    public void Banner_Auto_Setup3(final RelativeLayout Ad_Layout, final int Banner_Type) {

        if (Exit_Menu_Decided == 100) {

            return;
        }

        AdSize Banner_Type_Size = null;

        if (Banner_Type == 1) {

            Banner_Type_Size = AdSize.BANNER;

        } else if (Banner_Type == 2) {

            Banner_Type_Size = AdSize.LARGE_BANNER;

        } else if (Banner_Type == 3) {

            Banner_Type_Size = AdSize.LARGE_BANNER;

        } else if (Banner_Type == 4) {

            Banner_Type_Size = AdSize.MEDIUM_RECTANGLE;

        } else {

            Banner_Type_Size = AdSize.BANNER;

        }

        if (SharedPreferences.getBB3(Contextt) == 0) {

            Banner = SharedPreferences.getB33(Contextt);

            SharedPreferences.setBB3(Contextt, 1);

        } else {

            Banner = SharedPreferences.getB333(Contextt);

            SharedPreferences.setBB3(Contextt, 0);

        }

        AdView mAdView_Setup = new AdView(Contextt);
        mAdView_Setup.setAdSize(Banner_Type_Size);
        mAdView_Setup.setAdUnitId(Banner);
        AdRequest adore = new AdRequest.Builder().build();
        mAdView_Setup.loadAd(adore);
        Ad_Layout.addView(mAdView_Setup);

        RelativeLayout.LayoutParams relativeParams = (RelativeLayout.LayoutParams) Ad_Layout
                .getLayoutParams();
        relativeParams.setMargins(0, 10, 0, 0);
        Ad_Layout.setLayoutParams(relativeParams);

        mAdView_Setup.setAdListener(new AdListener() {

            @Override
            public void onAdLoaded() {
                // TODO Auto-generated method stub

                Ad_Layout.setVisibility(View.VISIBLE);

                super.onAdLoaded();

            }


            @Override
            public void onAdFailedToLoad(int errorCode) {
                // TODO Auto-generated method stub
                super.onAdFailedToLoad(errorCode);

                mAdView_Setup.destroy();

                TappxBanner.AdSize Banner_Type_Size_Tappx = null;

                if (Banner_Type == 1) {

                    Banner_Type_Size_Tappx = TappxBanner.AdSize.SMART_BANNER;

                } else if (Banner_Type == 2) {

                    Banner_Type_Size_Tappx = TappxBanner.AdSize.BANNER_300x250;

                } else if (Banner_Type == 3) {

                    Banner_Type_Size_Tappx = TappxBanner.AdSize.BANNER_300x250;

                } else if (Banner_Type == 4) {

                    Banner_Type_Size_Tappx = TappxBanner.AdSize.BANNER_300x250;

                } else {

                    Banner_Type_Size_Tappx = TappxBanner.AdSize.SMART_BANNER;

                }

                Tappxbanner = new TappxBanner(Contextt, SharedPreferences
                        .gettx(Contextt));
                Tappxbanner.setAdSize(Banner_Type_Size_Tappx);
                Ad_Layout.addView(Tappxbanner);
                Tappxbanner.loadAd();
                Tappxbanner.setRefreshTimeSeconds(45);

                Tappxbanner.setListener(new TappxBannerListener() {
                    @Override
                    public void onBannerLoaded(
                            TappxBanner tappxBanner) {
                        Ad_Layout.setVisibility(View.VISIBLE);

                        SharedPreferences.setsplashcount(
                                Contextt,
                                (SharedPreferences.getsplashcount(Contextt) + 1));

                    }

                    @Override
                    public void onBannerLoadFailed(
                            TappxBanner tappxBanner,
                            TappxAdError tappxAdError) {

                        Ad_Layout.setVisibility(View.GONE);
                        SO_Banner(Ad_Layout, Banner_Type);

                    }

                    @Override
                    public void onBannerClicked(
                            TappxBanner tappxBanner) {
                        Ad_Layout.setVisibility(View.GONE);
                    }

                    @Override
                    public void onBannerExpanded(
                            TappxBanner tappxBanner) {
                    }

                    @Override
                    public void onBannerCollapsed(
                            TappxBanner tappxBanner) {
                    }
                });

            }
        });
    }

    public void Banner_Auto_Setup_Main_Linear(final RelativeLayout Ad_Layout, final int Banner_Type) {

        if (Exit_Menu_Decided == 100) {

            return;
        }

        if (isNetworkConnected(Contextt) == true) {

            final Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {

                    if (Server_Yes_No == 1 || Server_Yes_No == 0) {

                        Banner_Auto_Setup_Linear1(Ad_Layout, Banner_Type);

                    } else {

                        handler.postDelayed(this, 500);

                    }

                }

            }, 500);

        } else {

            Ad_Layout.setVisibility(View.GONE);

        }

    }

    public void Banner_Auto_Setup_Linear1(final RelativeLayout Ad_Layout, final int Banner_Type) {

        if (Exit_Menu_Decided == 100) {

            return;
        }

        AdSize Banner_Type_Size = null;

        if (Banner_Type == 1) {

            Banner_Type_Size = AdSize.BANNER;

        } else if (Banner_Type == 2) {

            Banner_Type_Size = AdSize.LARGE_BANNER;

        } else if (Banner_Type == 3) {

            Banner_Type_Size = AdSize.LARGE_BANNER;

        } else if (Banner_Type == 4) {

            Banner_Type_Size = AdSize.MEDIUM_RECTANGLE;

        } else {

            Banner_Type_Size = AdSize.BANNER;

        }

        if (SharedPreferences.getBB1(Contextt) == 0) {

            Banner = SharedPreferences.getB11(Contextt);

            SharedPreferences.setBB1(Contextt, 1);

        } else {

            Banner = SharedPreferences.getB111(Contextt);

            SharedPreferences.setBB1(Contextt, 0);

        }

        AdView mAdView_Setup = new AdView(Contextt);
        mAdView_Setup.setAdSize(Banner_Type_Size);
        mAdView_Setup.setAdUnitId(Banner);
        AdRequest adore = new AdRequest.Builder().build();
        mAdView_Setup.loadAd(adore);
        Ad_Layout.addView(mAdView_Setup);

        LinearLayout.LayoutParams relativeParams = (LinearLayout.LayoutParams) Ad_Layout
                .getLayoutParams();
        relativeParams.setMargins(0, 10, 0, 0);
        Ad_Layout.setLayoutParams(relativeParams);

        mAdView_Setup.setAdListener(new AdListener() {

            @Override
            public void onAdLoaded() {
                // TODO Auto-generated method stub

                Ad_Layout.setVisibility(View.VISIBLE);

                super.onAdLoaded();

            }

            @Override
            public void onAdFailedToLoad(int errorCode) {
                // TODO Auto-generated method stub
                super.onAdFailedToLoad(errorCode);

                mAdView_Setup.destroy();

                Banner_Auto_Setup_Linear2(Ad_Layout, Banner_Type);

            }
        });
    }

    public void Banner_Auto_Setup_Linear2(final RelativeLayout Ad_Layout, final int Banner_Type) {

        if (Exit_Menu_Decided == 100) {

            return;
        }

        AdSize Banner_Type_Size = null;

        if (Banner_Type == 1) {

            Banner_Type_Size = AdSize.BANNER;

        } else if (Banner_Type == 2) {

            Banner_Type_Size = AdSize.LARGE_BANNER;

        } else if (Banner_Type == 3) {

            Banner_Type_Size = AdSize.LARGE_BANNER;

        } else if (Banner_Type == 4) {

            Banner_Type_Size = AdSize.MEDIUM_RECTANGLE;

        } else {

            Banner_Type_Size = AdSize.BANNER;

        }

        if (SharedPreferences.getBB2(Contextt) == 0) {

            Banner = SharedPreferences.getB22(Contextt);

            SharedPreferences.setBB2(Contextt, 1);

        } else {

            Banner = SharedPreferences.getB222(Contextt);

            SharedPreferences.setBB2(Contextt, 0);

        }

        AdView mAdView_Setup = new AdView(Contextt);
        mAdView_Setup.setAdSize(Banner_Type_Size);
        mAdView_Setup.setAdUnitId(Banner);
        AdRequest adore = new AdRequest.Builder().build();
        mAdView_Setup.loadAd(adore);
        Ad_Layout.addView(mAdView_Setup);

        LinearLayout.LayoutParams relativeParams = (LinearLayout.LayoutParams) Ad_Layout
                .getLayoutParams();
        relativeParams.setMargins(0, 10, 0, 0);
        Ad_Layout.setLayoutParams(relativeParams);

        mAdView_Setup.setAdListener(new AdListener() {

            @Override
            public void onAdLoaded() {
                // TODO Auto-generated method stub

                Ad_Layout.setVisibility(View.VISIBLE);

                super.onAdLoaded();

            }

            @Override
            public void onAdFailedToLoad(int errorCode) {
                // TODO Auto-generated method stub
                super.onAdFailedToLoad(errorCode);

                mAdView_Setup.destroy();

                Banner_Auto_Setup_Linear3(Ad_Layout, Banner_Type);

            }
        });
    }

    public void Banner_Auto_Setup_Linear3(final RelativeLayout Ad_Layout, final int Banner_Type) {

        if (Exit_Menu_Decided == 100) {

            return;
        }

        AdSize Banner_Type_Size = null;

        if (Banner_Type == 1) {

            Banner_Type_Size = AdSize.BANNER;

        } else if (Banner_Type == 2) {

            Banner_Type_Size = AdSize.LARGE_BANNER;

        } else if (Banner_Type == 3) {

            Banner_Type_Size = AdSize.LARGE_BANNER;

        } else if (Banner_Type == 4) {

            Banner_Type_Size = AdSize.MEDIUM_RECTANGLE;

        } else {

            Banner_Type_Size = AdSize.BANNER;

        }

        if (SharedPreferences.getBB3(Contextt) == 0) {

            Banner = SharedPreferences.getB33(Contextt);

            SharedPreferences.setBB3(Contextt, 1);

        } else {

            Banner = SharedPreferences.getB333(Contextt);

            SharedPreferences.setBB3(Contextt, 0);

        }

        AdView mAdView_Setup = new AdView(Contextt);
        mAdView_Setup.setAdSize(Banner_Type_Size);
        mAdView_Setup.setAdUnitId(Banner);
        AdRequest adore = new AdRequest.Builder().build();
        mAdView_Setup.loadAd(adore);
        Ad_Layout.addView(mAdView_Setup);

        LinearLayout.LayoutParams relativeParams = (LinearLayout.LayoutParams) Ad_Layout
                .getLayoutParams();
        relativeParams.setMargins(0, 10, 0, 0);
        Ad_Layout.setLayoutParams(relativeParams);

        mAdView_Setup.setAdListener(new AdListener() {

            @Override
            public void onAdLoaded() {
                // TODO Auto-generated method stub

                Ad_Layout.setVisibility(View.VISIBLE);

                super.onAdLoaded();

            }


            @Override
            public void onAdFailedToLoad(int errorCode) {
                // TODO Auto-generated method stub
                super.onAdFailedToLoad(errorCode);

                mAdView_Setup.destroy();

                TappxBanner.AdSize Banner_Type_Size_Tappx = null;

                if (Banner_Type == 1) {

                    Banner_Type_Size_Tappx = TappxBanner.AdSize.SMART_BANNER;

                } else if (Banner_Type == 2) {

                    Banner_Type_Size_Tappx = TappxBanner.AdSize.BANNER_300x250;

                } else if (Banner_Type == 3) {

                    Banner_Type_Size_Tappx = TappxBanner.AdSize.BANNER_300x250;

                } else if (Banner_Type == 4) {

                    Banner_Type_Size_Tappx = TappxBanner.AdSize.BANNER_300x250;

                } else {

                    Banner_Type_Size_Tappx = TappxBanner.AdSize.SMART_BANNER;

                }

                Tappxbanner = new TappxBanner(Contextt, SharedPreferences
                        .gettx(Contextt));
                Tappxbanner.setAdSize(Banner_Type_Size_Tappx);
                Ad_Layout.addView(Tappxbanner);
                Tappxbanner.loadAd();
                Tappxbanner.setRefreshTimeSeconds(45);

                Tappxbanner.setListener(new TappxBannerListener() {
                    @Override
                    public void onBannerLoaded(
                            TappxBanner tappxBanner) {
                        Ad_Layout.setVisibility(View.VISIBLE);

                        SharedPreferences.setsplashcount(
                                Contextt,
                                (SharedPreferences.getsplashcount(Contextt) + 1));

                    }

                    @Override
                    public void onBannerLoadFailed(
                            TappxBanner tappxBanner,
                            TappxAdError tappxAdError) {

                        Ad_Layout.setVisibility(View.GONE);
                        SO_Banner(Ad_Layout, Banner_Type);

                    }

                    @Override
                    public void onBannerClicked(
                            TappxBanner tappxBanner) {
                        Ad_Layout.setVisibility(View.GONE);
                    }

                    @Override
                    public void onBannerExpanded(
                            TappxBanner tappxBanner) {
                    }

                    @Override
                    public void onBannerCollapsed(
                            TappxBanner tappxBanner) {
                    }
                });

            }
        });
    }

    public void Splash_Screen(final Context mContext, boolean bool,
                              final int When_App_Open_How_Much_Time_After) {


        if (Exit_Menu_Decided == 100) {

            return;
        }

        if (SharedPreferences.getsplashcount(mContext) >= 10) {

            Load_Splash_Goog(mContext, When_App_Open_How_Much_Time_After);

        } else {

            if (bool == true) {

                new Handler().postDelayed(new Runnable() {

                    @Override
                    public void run() {

                        Load_Splash_Goog(mContext,
                                When_App_Open_How_Much_Time_After);


                    }

                }, When_App_Open_How_Much_Time_After);

            } else {

            }

        }

    }

    private void Load_Splash_Goog(final Context mContext, int splash_Screen_Time) {
        // TODO Auto-generated method stub

        if (Exit_Menu_Decided == 100) {

            return;
        }

        Ad_Popup(mContext, "Splash Ad . . .");

        if (SharedPreferences.getinter(mContext) == 0) {

            Interstial = SharedPreferences.getinter1(mContext);

            SharedPreferences.setinter(mContext, 1);

        } else {

            Interstial = SharedPreferences.getinter2(mContext);

            SharedPreferences.setinter(mContext, 0);

        }

        try {

            AdRequest adRequest = new AdRequest.Builder().build();
            InterstialAd = new InterstitialAd(mContext);
            InterstialAd.setAdUnitId(Interstial);

            InterstialAd.loadAd(adRequest);

            InterstialAd.setAdListener(new AdListener() {

                @Override
                public void onAdLoaded() {

                    InterstialAd.show();
                    SharedPreferences.setsplashcount(mContext, 0);
                    Ad_ProgressDialog.dismiss();

                    super.onAdLoaded();

                }

                @Override
                public void onAdFailedToLoad(int errorCode) {

                    SharedPreferences.setsplashcount(mContext,
                            (SharedPreferences.getsplashcount(mContext) + 1));
                    Tappx_Inter(mContext);

                    super.onAdFailedToLoad(errorCode);

                }

            });
        } catch (Exception e) {

        }

    }

    public void Interstial(final Context mContext,
                           final int How_Much_Time_After_Interstial_Milisecond) {
        // TODO Auto-generated method stub

        if (Exit_Menu_Decided == 100) {

            return;
        }

        if (isNetworkConnected(Contextt) == true) {

            new Handler().postDelayed(new Runnable() {

                @Override
                public void run() {


                    Pre_Interstial_Show(mContext);

                }

            }, How_Much_Time_After_Interstial_Milisecond);

        }

    }

    public void Interstial(final Context mContext) {

        if ((SharedPreferences.getSetup(mContext)).equals("1")) {

            Interstial_When_Load_Setup1(mContext);


        } else if ((SharedPreferences.getSetup(mContext)).equals("0")) {

            Interstial_When_Load_Normal(mContext);

        }


    }

    public void Interstial_When_Load_Normal(final Context mContext) {


        if (Exit_Menu_Decided == 100) {

            return;
        }

        if (SharedPreferences.getinter(mContext) == 0) {

            Interstial = SharedPreferences.getinter1(mContext);

            SharedPreferences.setinter(mContext, 1);

        } else {

            Interstial = SharedPreferences.getinter2(mContext);

            SharedPreferences.setinter(mContext, 0);

        }

        Ad_Popup(mContext, "Ad Loading . . .");

        try {

            AdRequest adRequest = new AdRequest.Builder().build();
            InterstialAd = new InterstitialAd(mContext);
            InterstialAd.setAdUnitId(Interstial);

            InterstialAd.loadAd(adRequest);

            InterstialAd.setAdListener(new AdListener() {
                @Override
                public void onAdLoaded() {

                    InterstialAd.show();
                    SharedPreferences.setsplashcount(mContext, 0);
                    Ad_ProgressDialog.dismiss();

                    super.onAdLoaded();

                }

                @Override
                public void onAdFailedToLoad(int errorCode) {
                    super.onAdFailedToLoad(errorCode);

                    Tappx_Inter(mContext);

                    super.onAdFailedToLoad(errorCode);

                }

            });
        } catch (Exception e) {

        }

    }

    public void Interstial_When_Load_Setup1(final Context mContext) {


        if (Exit_Menu_Decided == 100) {

            return;
        }

        if (SharedPreferences.getII1(mContext) == 0) {

            Interstial = SharedPreferences.getI11(mContext);

            SharedPreferences.setII1(mContext, 1);

        } else {

            Interstial = SharedPreferences.getI111(mContext);

            SharedPreferences.setII1(mContext, 0);

        }

        Ad_Popup(mContext, "Ad Loading . . .");

        try {

            AdRequest adRequest = new AdRequest.Builder().build();
            InterstialAd = new InterstitialAd(mContext);
            InterstialAd.setAdUnitId(Interstial);

            InterstialAd.loadAd(adRequest);

            InterstialAd.setAdListener(new AdListener() {
                @Override
                public void onAdLoaded() {

                    InterstialAd.show();
                    SharedPreferences.setsplashcount(mContext, 0);
                    Ad_ProgressDialog.dismiss();

                    super.onAdLoaded();

                }

                @Override
                public void onAdFailedToLoad(int errorCode) {
                    super.onAdFailedToLoad(errorCode);

                    Interstial_When_Load_Setup2(mContext);

                    super.onAdFailedToLoad(errorCode);

                }

            });
        } catch (Exception e) {

        }

    }

    public void Interstial_When_Load_Setup2(final Context mContext) {


        if (SharedPreferences.getII2(mContext) == 0) {

            Interstial = SharedPreferences.getI22(mContext);

            SharedPreferences.setII2(mContext, 1);

        } else {

            Interstial = SharedPreferences.getI222(mContext);

            SharedPreferences.setII2(mContext, 0);

        }


        try {

            AdRequest adRequest = new AdRequest.Builder().build();
            InterstialAd = new InterstitialAd(mContext);
            InterstialAd.setAdUnitId(Interstial);

            InterstialAd.loadAd(adRequest);

            InterstialAd.setAdListener(new AdListener() {
                @Override
                public void onAdLoaded() {

                    InterstialAd.show();
                    SharedPreferences.setsplashcount(mContext, 0);
                    Ad_ProgressDialog.dismiss();

                    super.onAdLoaded();

                }

                @Override
                public void onAdFailedToLoad(int errorCode) {
                    super.onAdFailedToLoad(errorCode);

                    Interstial_When_Load_Setup3(mContext);

                    super.onAdFailedToLoad(errorCode);

                }

            });
        } catch (Exception e) {

        }

    }

    public void Interstial_When_Load_Setup3(final Context mContext) {


        if (Exit_Menu_Decided == 100) {

            return;
        }

        if (SharedPreferences.getII3(mContext) == 0) {

            Interstial = SharedPreferences.getI33(mContext);

            SharedPreferences.setII3(mContext, 1);

        } else {

            Interstial = SharedPreferences.getI333(mContext);

            SharedPreferences.setII3(mContext, 0);

        }


        try {

            AdRequest adRequest = new AdRequest.Builder().build();
            InterstialAd = new InterstitialAd(mContext);
            InterstialAd.setAdUnitId(Interstial);

            InterstialAd.loadAd(adRequest);

            InterstialAd.setAdListener(new AdListener() {
                @Override
                public void onAdLoaded() {

                    InterstialAd.show();
                    SharedPreferences.setsplashcount(mContext, 0);
                    Ad_ProgressDialog.dismiss();

                    super.onAdLoaded();

                }

                @Override
                public void onAdFailedToLoad(int errorCode) {
                    super.onAdFailedToLoad(errorCode);

                    Ad_ProgressDialog.dismiss();

                    Interstial_When_Load_Normal(mContext);

                    super.onAdFailedToLoad(errorCode);

                }

            });
        } catch (Exception e) {

        }

    }

    public void Pre_Interstial_Show(final Context mContext) {

        if (Exit_Menu_Decided == 100) {

            return;
        }


        if ((SharedPreferences.getextra1(mContext)).equals("1")) {

            if ((SharedPreferences.getSetup(mContext)).equals("1")) {

                Show_Inter_Setup_Show(mContext);

            } else if ((SharedPreferences.getSetup(mContext)).equals("0")) {

                Pre_Interstial_Show_Normal(mContext);

            }

        } else if ((SharedPreferences.getextra1(mContext)).equals("2")) {

            Pre_App_Open_Show((Activity) mContext);

        } else {

            if ((SharedPreferences.getSetup(mContext)).equals("1")) {

                Show_Inter_Setup_Show(mContext);

            } else if ((SharedPreferences.getSetup(mContext)).equals("0")) {

                Pre_Interstial_Show_Normal(mContext);

            }

        }


    }

    public void Pre_Interstial_Show_End(final Context mContext) {

        if (Exit_Menu_Decided == 100) {

            return;
        }


        if ((SharedPreferences.getextra1(mContext)).equals("1")) {

            //Inter
            if ((SharedPreferences.getSetup(mContext)).equals("1")) {

                Show_Inter_Setup_Show_End(mContext);

            } else if ((SharedPreferences.getSetup(mContext)).equals("0")) {

                Pre_Interstial_Show_End_Normal(mContext);

            }

        } else if ((SharedPreferences.getextra1(mContext)).equals("2")) {

            Pre_App_Open_Show((Activity) mContext);

        } else {

            if ((SharedPreferences.getSetup(mContext)).equals("1")) {

                Show_Inter_Setup_Show_End(mContext);

            } else if ((SharedPreferences.getSetup(mContext)).equals("0")) {

                Pre_Interstial_Show_End_Normal(mContext);

            }

        }

    }

    public void Pre_Interstial_Load_Normal(final Context mContext) {

        if (Exit_Menu_Decided == 100) {

            return;
        }

        if (SharedPreferences.getinter(mContext) == 0) {

            Interstial = SharedPreferences.getinter1(mContext);

            SharedPreferences.setinter(mContext, 1);


        } else {

            Interstial = SharedPreferences.getinter2(mContext);

            SharedPreferences.setinter(mContext, 0);


        }

        try {

            AdRequest adRequest = new AdRequest.Builder().build();
            InterstialAd1 = new InterstitialAd(mContext);
            InterstialAd1.setAdUnitId(Interstial);

            InterstialAd1.loadAd(adRequest);

            InterstialAd1.setAdListener(new AdListener() {
                @Override
                public void onAdLoaded() {

                    Inter_Failed = 0;
                    super.onAdLoaded();


                }

                @Override
                public void onAdFailedToLoad(int errorCode) {

                    super.onAdFailedToLoad(errorCode);

                    InterstialAd1 = null;

                    tappxInterstitial_preload = new TappxInterstitial(mContext,
                            SharedPreferences.gettx(Contextt));
                    tappxInterstitial_preload.loadAd();
                    tappxInterstitial_preload
                            .setListener(new TappxInterstitialListener() {
                                @Override
                                public void onInterstitialLoaded(
                                        TappxInterstitial tappxInterstitial) {

                                    Inter_Failed = 1;

                                }

                                @Override
                                public void onInterstitialLoadFailed(
                                        TappxInterstitial tappxInterstitial,
                                        TappxAdError tappxAdError) {

                                    Inter_Failed = 50;

                                    if ((new Random().nextInt((2 - 1) + 1) + 1) == 1) {
                                        SO = SO_FULLPAGE;
                                    } else {
                                        SO = SO_OFFERWALL;
                                    }

                                    startAppAd.loadAd(SO, new AdEventListener() {
                                        @Override
                                        public void onReceiveAd(Ad ad) {


                                        }

                                        @Override
                                        public void onFailedToReceiveAd(Ad ad) {

                                        }

                                    });

                                }

                                @Override
                                public void onInterstitialClicked(
                                        TappxInterstitial arg0) {
                                    // TODO Auto-generated method stub

                                }

                                @Override
                                public void onInterstitialDismissed(
                                        TappxInterstitial arg0) {
                                    // TODO Auto-generated method stub

                                }

                                @Override
                                public void onInterstitialShown(
                                        TappxInterstitial arg0) {
                                    // TODO Auto-generated method stub

                                }

                            });

                }

            });
        } catch (Exception e) {

        }

    }

    public void Pre_Interstial_Show_Normal(final Context mContext) {

        if (Exit_Menu_Decided == 100) {

            return;
        }

        if (isNetworkConnected(Contextt) == true) {

            if (Inter_Failed == 1) {

                if (tappxInterstitial_preload != null)
                    tappxInterstitial_preload.show();

                SharedPreferences.setsplashcount(mContext,
                        (SharedPreferences.getsplashcount(mContext) + 1));

            }

            if (Inter_Failed == 0) {

                if (InterstialAd1 != null) {
                    InterstialAd1.show();
                    SharedPreferences.setsplashcount(mContext, 0);
                }

            }

            if (Inter_Failed == 50) {

                if (startAppAd.isReady()) {
                    startAppAd.showAd();
                    SharedPreferences.setsplashcount(mContext,
                            (SharedPreferences.getsplashcount(mContext) + 1));
                }


            }

            Pre_Interstial_Load_Normal(mContext);

        }
    }

    public void Pre_Interstial_Show_End_Normal(final Context mContext) {

        if (Exit_Menu_Decided == 100) {

            return;
        }

        if (isNetworkConnected(Contextt) == true) {

            if (Inter_Failed == 1) {

                if (tappxInterstitial_preload != null)
                    tappxInterstitial_preload.show();

                SharedPreferences.setsplashcount(mContext,
                        (SharedPreferences.getsplashcount(mContext) + 1));

            }

            if (Inter_Failed == 0) {

                if (InterstialAd1 != null) {
                    InterstialAd1.show();
                    SharedPreferences.setsplashcount(mContext, 0);
                }

            }

            if (Inter_Failed == 50) {

                if (startAppAd.isReady()) {
                    startAppAd.showAd();
                    SharedPreferences.setsplashcount(mContext,
                            (SharedPreferences.getsplashcount(mContext) + 1));
                }

            }

        }

    }

    public void Load_Inter_Setup1(final Context mContext) {

        if (Exit_Menu_Decided == 100) {

            return;
        }

        if (SharedPreferences.getII1(mContext) == 0) {

            Interstial = SharedPreferences.getI11(mContext);

            SharedPreferences.setII1(mContext, 1);

        } else {

            Interstial = SharedPreferences.getI111(mContext);

            SharedPreferences.setII1(mContext, 0);

        }

        try {

            AdRequest adRequest = new AdRequest.Builder().build();
            InterstialAd_Setup3 = new InterstitialAd(mContext);
            InterstialAd_Setup3.setAdUnitId("" + Interstial);

            InterstialAd_Setup3.loadAd(adRequest);

            InterstialAd_Setup3.setAdListener(new AdListener() {
                @Override
                public void onAdLoaded() {

                    super.onAdLoaded();

                    Inter_Setup = 3;


                }

                @Override
                public void onAdFailedToLoad(int errorCode) {

                    super.onAdFailedToLoad(errorCode);

                    InterstialAd_Setup3 = null;

                    Inter_Setup = 33;

                    Load_Inter_Setup2(mContext);


                }

            });
        } catch (Exception e) {

        }

    }

    public void Load_Inter_Setup2(final Context mContext) {

        if (Exit_Menu_Decided == 100) {

            return;
        }

        if (SharedPreferences.getII2(mContext) == 0) {

            Interstial = SharedPreferences.getI22(mContext);

            SharedPreferences.setII2(mContext, 1);

        } else {

            Interstial = SharedPreferences.getI222(mContext);

            SharedPreferences.setII2(mContext, 0);

        }

        try {

            AdRequest adRequest = new AdRequest.Builder().build();
            InterstialAd_Setup2 = new InterstitialAd(mContext);
            InterstialAd_Setup2.setAdUnitId("" + Interstial);

            InterstialAd_Setup2.loadAd(adRequest);

            InterstialAd_Setup2.setAdListener(new AdListener() {
                @Override
                public void onAdLoaded() {

                    super.onAdLoaded();

                    Inter_Setup = 2;


                }

                @Override
                public void onAdFailedToLoad(int errorCode) {

                    super.onAdFailedToLoad(errorCode);

                    InterstialAd_Setup2 = null;

                    Inter_Setup = 22;

                    Load_Inter_Setup3(mContext);


                }

            });
        } catch (Exception e) {

        }

    }

    public void Load_Inter_Setup3(final Context mContext) {

        if (Exit_Menu_Decided == 100) {

            return;
        }

        if (SharedPreferences.getII3(mContext) == 0) {

            Interstial = SharedPreferences.getI33(mContext);

            SharedPreferences.setII3(mContext, 1);

        } else {

            Interstial = SharedPreferences.getI333(mContext);

            SharedPreferences.setII3(mContext, 0);

        }

        try {

            AdRequest adRequest = new AdRequest.Builder().build();
            InterstialAd_Setup1 = new InterstitialAd(mContext);
            InterstialAd_Setup1.setAdUnitId("" + Interstial);

            InterstialAd_Setup1.loadAd(adRequest);

            InterstialAd_Setup1.setAdListener(new AdListener() {
                @Override
                public void onAdLoaded() {

                    super.onAdLoaded();

                    Inter_Setup = 1;


                }

                @Override
                public void onAdFailedToLoad(int errorCode) {

                    super.onAdFailedToLoad(errorCode);


                    Inter_Setup = 11;

                    InterstialAd_Setup1 = null;

                    tappxInterstitial_preload = new TappxInterstitial(mContext,
                            SharedPreferences.gettx(Contextt));
                    tappxInterstitial_preload.loadAd();
                    tappxInterstitial_preload
                            .setListener(new TappxInterstitialListener() {
                                @Override
                                public void onInterstitialLoaded(
                                        TappxInterstitial tappxInterstitial) {

                                    Inter_Failed = 1;


                                }

                                @Override
                                public void onInterstitialLoadFailed(
                                        TappxInterstitial tappxInterstitial,
                                        TappxAdError tappxAdError) {

                                    Inter_Failed = 50;

                                    if ((new Random().nextInt((2 - 1) + 1) + 1) == 1) {
                                        SO = SO_FULLPAGE;
                                    } else {
                                        SO = SO_OFFERWALL;
                                    }

                                    startAppAd.loadAd(SO, new AdEventListener() {
                                        @Override
                                        public void onReceiveAd(Ad ad) {


                                        }

                                        @Override
                                        public void onFailedToReceiveAd(Ad ad) {

                                        }

                                    });
                                }

                                @Override
                                public void onInterstitialClicked(
                                        TappxInterstitial arg0) {
                                    // TODO Auto-generated method stub

                                }

                                @Override
                                public void onInterstitialDismissed(
                                        TappxInterstitial arg0) {
                                    // TODO Auto-generated method stub

                                }

                                @Override
                                public void onInterstitialShown(
                                        TappxInterstitial arg0) {
                                    // TODO Auto-generated method stub

                                }

                            });


                }

            });
        } catch (Exception e) {

        }

    }

    public void Show_Inter_Setup_Show(final Context context) {


        if (isNetworkConnected(context) == true) {


            if (Inter_Setup == 33) {


            }


            if (Inter_Setup == 3) {

                if (InterstialAd_Setup3 != null) {
                    InterstialAd_Setup3.show();
                }

            }


            if (Inter_Setup == 22) {


            }


            if (Inter_Setup == 2) {

                if (InterstialAd_Setup2 != null) {
                    InterstialAd_Setup2.show();
                }

            }


            if (Inter_Setup == 1) {

                if (InterstialAd_Setup1 != null) {
                    InterstialAd_Setup1.show();
                }

            }

            if (Inter_Setup == 11) {

                if (tappxInterstitial_preload != null)
                    tappxInterstitial_preload.show();

            }

            if (Inter_Setup == 50) {

                if (startAppAd.isReady()) {
                    startAppAd.showAd();
                    SharedPreferences.setsplashcount(context,
                            (SharedPreferences.getsplashcount(context) + 1));
                }

            }

            Load_Inter_Setup1(context);

        }


    }

    public void Show_Inter_Setup_Show_End(final Context context) {


        if (isNetworkConnected(context) == true) {


            if (Inter_Setup == 33) {


            }


            if (Inter_Setup == 3) {

                if (InterstialAd_Setup3 != null) {
                    InterstialAd_Setup3.show();
                }

            }


            if (Inter_Setup == 22) {


            }


            if (Inter_Setup == 2) {

                if (InterstialAd_Setup2 != null) {
                    InterstialAd_Setup2.show();
                }

            }


            if (Inter_Setup == 1) {

                if (InterstialAd_Setup1 != null) {
                    InterstialAd_Setup1.show();
                }

            }

            if (Inter_Setup == 11) {

                if (tappxInterstitial_preload != null)
                    tappxInterstitial_preload.show();

            }

            if (Inter_Setup == 50) {

                if (startAppAd.isReady()) {
                    startAppAd.showAd();
                    SharedPreferences.setsplashcount(context,
                            (SharedPreferences.getsplashcount(context) + 1));
                }

            }


        }


    }

    public void Interstial_Counted(Context mContext,
                                   int How_Much_Click_After_Interstial) {

        if (Exit_Menu_Decided == 100) {

            return;
        }

        if (isNetworkConnected(Contextt) == true) {

            if (How_Much_Click_After_Interstial <= SharedPreferences.getcount(mContext)) {

                SharedPreferences.setcount(mContext, 1);

                Pre_Interstial_Show(mContext);

            } else {

                SharedPreferences.setcount(mContext, (SharedPreferences.getcount(mContext) + 1));

            }

        }

    }

    public void Native(Context nContext, final RelativeLayout Ad_Layout,
                       int Native_Type, int Bottom_Ad_Margin, int Top_Ad_Margin, int Animation) {

        if (Exit_Menu_Decided == 100) {

            return;
        }

        if (isNetworkConnected(nContext) == true) {

            final Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {

                    if (Server_Yes_No == 1 || Server_Yes_No == 0) {

                        if ((SharedPreferences.getSetup(nContext)).equals("1")) {

                            Native_Auto_Setup(nContext, Ad_Layout,
                                    Native_Type, Bottom_Ad_Margin, Top_Ad_Margin, Animation);

                        } else if ((SharedPreferences.getSetup(nContext)).equals("0")) {

                            Native_Normal(nContext, Ad_Layout,
                                    Native_Type, Bottom_Ad_Margin, Top_Ad_Margin, Animation);

                        }


                    } else {

                        handler.postDelayed(this, 500);

                    }

                }

            }, 500);

        } else {

            Ad_Layout.setVisibility(View.GONE);

        }

    }

    public void Native_Main_Linear(Context nContext, final RelativeLayout Ad_Layout,
                                   int Native_Type, int Bottom_Ad_Margin, int Top_Ad_Margin, int Animation) {

        if (Exit_Menu_Decided == 100) {

            return;
        }

        if (isNetworkConnected(nContext) == true) {

            final Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {

                    if (Server_Yes_No == 1 || Server_Yes_No == 0) {

                        if ((SharedPreferences.getSetup(nContext)).equals("1")) {

                            Native_Auto_Setup_Main_Linear(nContext, Ad_Layout,
                                    Native_Type, Bottom_Ad_Margin, Top_Ad_Margin, Animation);

                        } else if ((SharedPreferences.getSetup(nContext)).equals("0")) {

                            Native_Main_Linear_Normal(nContext, Ad_Layout,
                                    Native_Type, Bottom_Ad_Margin, Top_Ad_Margin, Animation);

                        }


                    } else {

                        handler.postDelayed(this, 500);

                    }

                }

            }, 500);

        } else {

            Ad_Layout.setVisibility(View.GONE);

        }

    }

    public void Native_Normal(Context nContext, final RelativeLayout Ad_Layout,
                              int Native_Type, int Bottom_Ad_Margin, int Top_Ad_Margin, int Animation) {

        if (Exit_Menu_Decided == 100) {

            return;
        }

        if (isNetworkConnected(Contextt) == true) {

            final Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {

                    if (Server_Yes_No == 1 || Server_Yes_No == 0) {

                        if (SharedPreferences.getnative(nContext) == 0) {

                            Native_ID = SharedPreferences.getnative1(nContext);

                            SharedPreferences.setnative(nContext, 1);


                        } else {

                            Native_ID = SharedPreferences.getnative2(nContext);

                            SharedPreferences.setnative(nContext, 0);


                        }

                        AdLoader adLoader = new AdLoader.Builder(nContext, Native_ID)
                                .forNativeAd(new NativeAd.OnNativeAdLoadedListener() {
                                    private ColorDrawable background;

                                    @Override
                                    public void onNativeAdLoaded(NativeAd nativeAd) {
                                        NativeStyle styles = new
                                                NativeStyle.Builder().withMainBackgroundColor(background).build();


                                        NativeTemplateView nativeTemplateView = new NativeTemplateView(nContext, Native_Type);

                                        nativeTemplateView.setStyles(styles);
                                        nativeTemplateView.setNativeAd(nativeAd);

                                        Ad_Layout.removeAllViews();
                                        Ad_Layout.addView(nativeTemplateView);
                                        RelativeLayout.LayoutParams relativeParams = (RelativeLayout.LayoutParams) Ad_Layout
                                                .getLayoutParams();
                                        relativeParams.setMargins(0, Bottom_Ad_Margin, 0, Top_Ad_Margin); // left, top, right,

                                        Ad_Layout.setLayoutParams(relativeParams);

                                        nativeTemplateView.setVisibility(View.VISIBLE);


                                    }

                                })
                                .withAdListener(new AdListener() {
                                    @Override
                                    public void onAdFailedToLoad(LoadAdError adError) {


                                        Ad_Layout.removeAllViews();


                                        if (Native_Type == 2) {

                                            Banner(Ad_Layout, 4);

                                        } else {

                                            Banner(Ad_Layout, 3);
                                        }

                                    }
                                })
                                .withNativeAdOptions(new NativeAdOptions.Builder()

                                        .build())
                                .build();

                        adLoader.loadAd(new AdRequest.Builder().build());


                    } else {

                        handler.postDelayed(this, 500);

                    }

                }

            }, 500);

        } else {

            Ad_Layout.setVisibility(View.GONE);

        }
    }

    public void Native_Main_Linear_Normal(Context nContext, final RelativeLayout Ad_Layout,
                                          int Native_Type, int Bottom_Ad_Margin, int Top_Ad_Margin, int Animation) {

        if (Exit_Menu_Decided == 100) {

            return;
        }

        if (isNetworkConnected(Contextt) == true) {

            final Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {

                    if (Server_Yes_No == 1 || Server_Yes_No == 0) {


                        if (SharedPreferences.getnative(nContext) == 0) {

                            Native_ID = SharedPreferences.getnative1(nContext);

                            SharedPreferences.setnative(nContext, 1);

                        } else {

                            Native_ID = SharedPreferences.getnative2(nContext);

                            SharedPreferences.setnative(nContext, 0);

                        }

                        AdLoader adLoader = new AdLoader.Builder(nContext, Native_ID)
                                .forNativeAd(new NativeAd.OnNativeAdLoadedListener() {
                                    private ColorDrawable background;

                                    @Override
                                    public void onNativeAdLoaded(NativeAd nativeAd) {
                                        NativeStyle styles = new
                                                NativeStyle.Builder().withMainBackgroundColor(background).build();


                                        NativeTemplateView nativeTemplateView = new NativeTemplateView(nContext, Native_Type);


                                        nativeTemplateView.setStyles(styles);
                                        nativeTemplateView.setNativeAd(nativeAd);

                                        Ad_Layout.removeAllViews();
                                        Ad_Layout.addView(nativeTemplateView);
                                        LinearLayout.LayoutParams relativeParams = (LinearLayout.LayoutParams) Ad_Layout
                                                .getLayoutParams();
                                        relativeParams.setMargins(0, Bottom_Ad_Margin, 0, Top_Ad_Margin);

                                        Ad_Layout.setLayoutParams(relativeParams);

                                        nativeTemplateView.setVisibility(View.VISIBLE);


                                    }

                                })
                                .withAdListener(new AdListener() {
                                    @Override
                                    public void onAdFailedToLoad(LoadAdError adError) {


                                        Ad_Layout.removeAllViews();


                                        if (Native_Type == 2) {

                                            Banner_Main_Linear(Ad_Layout, 4);

                                        } else {

                                            Banner_Main_Linear(Ad_Layout, 3);
                                        }

                                    }
                                })
                                .withNativeAdOptions(new NativeAdOptions.Builder()

                                        .build())
                                .build();

                        adLoader.loadAd(new AdRequest.Builder().build());


                    } else {

                        handler.postDelayed(this, 500);

                    }

                }

            }, 500);

        } else {

            Ad_Layout.setVisibility(View.GONE);

        }

    }

    public void Native_Auto_Setup(Context nContext, final RelativeLayout Ad_Layout,
                                  int Native_Type, int Bottom_Ad_Margin, int Top_Ad_Margin, int Animation) {

        if (Exit_Menu_Decided == 100) {

            return;
        }

        if (isNetworkConnected(Contextt) == true) {

            final Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {

                    if (Server_Yes_No == 1 || Server_Yes_No == 0) {

                        Native_Auto_Setup1(nContext, Ad_Layout, Native_Type, Bottom_Ad_Margin, Top_Ad_Margin, Animation);

                    } else {

                        handler.postDelayed(this, 500);

                    }

                }

            }, 500);

        } else {

            Ad_Layout.setVisibility(View.GONE);

        }


    }

    public void Native_Auto_Setup1(Context nContext, final RelativeLayout Ad_Layout,
                                   int Native_Type, int Bottom_Ad_Margin, int Top_Ad_Margin, int Animation) {


        if (Exit_Menu_Decided == 100) {

            return;
        }

        if (SharedPreferences.getNN1(nContext) == 0) {

            Native_ID = SharedPreferences.getN11(nContext);

            SharedPreferences.setNN1(nContext, 1);


        } else {

            Native_ID = SharedPreferences.getN111(nContext);

            SharedPreferences.setNN1(nContext, 0);


        }

        AdLoader adLoader = new AdLoader.Builder(nContext, Native_ID)
                .forNativeAd(new NativeAd.OnNativeAdLoadedListener() {
                    private ColorDrawable background;

                    @Override
                    public void onNativeAdLoaded(NativeAd nativeAd) {
                        NativeStyle styles = new
                                NativeStyle.Builder().withMainBackgroundColor(background).build();


                        NativeTemplateView nativeTemplateView = new NativeTemplateView(nContext, Native_Type);

                        nativeTemplateView.setStyles(styles);
                        nativeTemplateView.setNativeAd(nativeAd);

                        Ad_Layout.removeAllViews();
                        Ad_Layout.addView(nativeTemplateView);
                        RelativeLayout.LayoutParams relativeParams = (RelativeLayout.LayoutParams) Ad_Layout
                                .getLayoutParams();
                        relativeParams.setMargins(0, Bottom_Ad_Margin, 0, Top_Ad_Margin); // left, top, right,

                        Ad_Layout.setLayoutParams(relativeParams);

                        nativeTemplateView.setVisibility(View.VISIBLE);


                    }

                })
                .withAdListener(new AdListener() {
                    @Override
                    public void onAdFailedToLoad(LoadAdError adError) {

                        Ad_Layout.removeAllViews();
                        Native_Auto_Setup2(nContext, Ad_Layout, Native_Type, Bottom_Ad_Margin, Top_Ad_Margin, Animation);

                    }
                })
                .withNativeAdOptions(new NativeAdOptions.Builder()

                        .build())
                .build();

        adLoader.loadAd(new AdRequest.Builder().build());


    }

    public void Native_Auto_Setup2(Context nContext, final RelativeLayout Ad_Layout,
                                   int Native_Type, int Bottom_Ad_Margin, int Top_Ad_Margin, int Animation) {


        if (Exit_Menu_Decided == 100) {

            return;
        }

        if (SharedPreferences.getNN2(nContext) == 0) {

            Native_ID = SharedPreferences.getN22(nContext);

            SharedPreferences.setNN2(nContext, 1);


        } else {

            Native_ID = SharedPreferences.getN222(nContext);

            SharedPreferences.setNN2(nContext, 0);


        }

        AdLoader adLoader = new AdLoader.Builder(nContext, Native_ID)
                .forNativeAd(new NativeAd.OnNativeAdLoadedListener() {
                    private ColorDrawable background;

                    @Override
                    public void onNativeAdLoaded(NativeAd nativeAd) {
                        NativeStyle styles = new
                                NativeStyle.Builder().withMainBackgroundColor(background).build();


                        NativeTemplateView nativeTemplateView = new NativeTemplateView(nContext, Native_Type);

                        nativeTemplateView.setStyles(styles);
                        nativeTemplateView.setNativeAd(nativeAd);

                        Ad_Layout.removeAllViews();
                        Ad_Layout.addView(nativeTemplateView);
                        RelativeLayout.LayoutParams relativeParams = (RelativeLayout.LayoutParams) Ad_Layout
                                .getLayoutParams();
                        relativeParams.setMargins(0, Bottom_Ad_Margin, 0, Top_Ad_Margin); // left, top, right,

                        Ad_Layout.setLayoutParams(relativeParams);

                        nativeTemplateView.setVisibility(View.VISIBLE);


                    }

                })
                .withAdListener(new AdListener() {
                    @Override
                    public void onAdFailedToLoad(LoadAdError adError) {

                        Ad_Layout.removeAllViews();
                        Native_Auto_Setup3(nContext, Ad_Layout, Native_Type, Bottom_Ad_Margin, Top_Ad_Margin, Animation);

                    }
                })
                .withNativeAdOptions(new NativeAdOptions.Builder()

                        .build())
                .build();

        adLoader.loadAd(new AdRequest.Builder().build());


    }

    public void Native_Auto_Setup3(Context nContext, final RelativeLayout Ad_Layout,
                                   int Native_Type, int Bottom_Ad_Margin, int Top_Ad_Margin, int Animation) {


        if (Exit_Menu_Decided == 100) {

            return;
        }

        if (SharedPreferences.getNN3(nContext) == 0) {

            Native_ID = SharedPreferences.getN33(nContext);

            SharedPreferences.setNN3(nContext, 1);


        } else {

            Native_ID = SharedPreferences.getN333(nContext);

            SharedPreferences.setNN3(nContext, 0);


        }

        AdLoader adLoader = new AdLoader.Builder(nContext, Native_ID)
                .forNativeAd(new NativeAd.OnNativeAdLoadedListener() {
                    private ColorDrawable background;

                    @Override
                    public void onNativeAdLoaded(NativeAd nativeAd) {
                        NativeStyle styles = new
                                NativeStyle.Builder().withMainBackgroundColor(background).build();


                        NativeTemplateView nativeTemplateView = new NativeTemplateView(nContext, Native_Type);

                        nativeTemplateView.setStyles(styles);
                        nativeTemplateView.setNativeAd(nativeAd);

                        Ad_Layout.removeAllViews();
                        Ad_Layout.addView(nativeTemplateView);
                        RelativeLayout.LayoutParams relativeParams = (RelativeLayout.LayoutParams) Ad_Layout
                                .getLayoutParams();
                        relativeParams.setMargins(0, Bottom_Ad_Margin, 0, Top_Ad_Margin); // left, top, right,

                        Ad_Layout.setLayoutParams(relativeParams);

                        nativeTemplateView.setVisibility(View.VISIBLE);


                    }

                })
                .withAdListener(new AdListener() {
                    @Override
                    public void onAdFailedToLoad(LoadAdError adError) {

                        Ad_Layout.removeAllViews();

                        if (Native_Type == 2) {

                            Banner_Auto_Setup1(Ad_Layout, 4);

                        } else {

                            Banner_Auto_Setup1(Ad_Layout, 3);
                        }

                    }
                })
                .withNativeAdOptions(new NativeAdOptions.Builder()

                        .build())
                .build();

        adLoader.loadAd(new AdRequest.Builder().build());


    }

    public void Native_Auto_Setup_Main_Linear(Context nContext, final RelativeLayout Ad_Layout,
                                              int Native_Type, int Bottom_Ad_Margin, int Top_Ad_Margin, int Animation) {

        if (Exit_Menu_Decided == 100) {

            return;
        }

        if (isNetworkConnected(Contextt) == true) {

            final Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {

                    if (Server_Yes_No == 1 || Server_Yes_No == 0) {

                        Native_Auto_Setup_Linear1(nContext, Ad_Layout, Native_Type, Bottom_Ad_Margin, Top_Ad_Margin, Animation);

                    } else {

                        handler.postDelayed(this, 500);

                    }

                }

            }, 500);

        } else {

            Ad_Layout.setVisibility(View.GONE);

        }


    }

    public void Native_Auto_Setup_Linear1(Context nContext, final RelativeLayout Ad_Layout,
                                          int Native_Type, int Bottom_Ad_Margin, int Top_Ad_Margin, int Animation) {


        if (Exit_Menu_Decided == 100) {

            return;
        }

        if (SharedPreferences.getNN1(nContext) == 0) {

            Native_ID = SharedPreferences.getN11(nContext);

            SharedPreferences.setNN1(nContext, 1);


        } else {

            Native_ID = SharedPreferences.getN111(nContext);

            SharedPreferences.setNN1(nContext, 0);


        }

        AdLoader adLoader = new AdLoader.Builder(nContext, Native_ID)
                .forNativeAd(new NativeAd.OnNativeAdLoadedListener() {
                    private ColorDrawable background;

                    @Override
                    public void onNativeAdLoaded(NativeAd nativeAd) {
                        NativeStyle styles = new
                                NativeStyle.Builder().withMainBackgroundColor(background).build();


                        NativeTemplateView nativeTemplateView = new NativeTemplateView(nContext, Native_Type);

                        nativeTemplateView.setStyles(styles);
                        nativeTemplateView.setNativeAd(nativeAd);

                        Ad_Layout.removeAllViews();
                        Ad_Layout.addView(nativeTemplateView);
                        LinearLayout.LayoutParams relativeParams = (LinearLayout.LayoutParams) Ad_Layout
                                .getLayoutParams();
                        relativeParams.setMargins(0, Bottom_Ad_Margin, 0, Top_Ad_Margin);

                        Ad_Layout.setLayoutParams(relativeParams);

                        nativeTemplateView.setVisibility(View.VISIBLE);


                    }

                })
                .withAdListener(new AdListener() {
                    @Override
                    public void onAdFailedToLoad(LoadAdError adError) {

                        Ad_Layout.removeAllViews();
                        Native_Auto_Setup_Linear2(nContext, Ad_Layout, Native_Type, Bottom_Ad_Margin, Top_Ad_Margin, Animation);

                    }
                })
                .withNativeAdOptions(new NativeAdOptions.Builder()

                        .build())
                .build();

        adLoader.loadAd(new AdRequest.Builder().build());


    }

    public void Native_Auto_Setup_Linear2(Context nContext, final RelativeLayout Ad_Layout,
                                          int Native_Type, int Bottom_Ad_Margin, int Top_Ad_Margin, int Animation) {


        if (Exit_Menu_Decided == 100) {

            return;
        }

        if (SharedPreferences.getNN2(nContext) == 0) {

            Native_ID = SharedPreferences.getN22(nContext);

            SharedPreferences.setNN2(nContext, 1);


        } else {

            Native_ID = SharedPreferences.getN222(nContext);

            SharedPreferences.setNN2(nContext, 0);


        }

        AdLoader adLoader = new AdLoader.Builder(nContext, Native_ID)
                .forNativeAd(new NativeAd.OnNativeAdLoadedListener() {
                    private ColorDrawable background;

                    @Override
                    public void onNativeAdLoaded(NativeAd nativeAd) {
                        NativeStyle styles = new
                                NativeStyle.Builder().withMainBackgroundColor(background).build();


                        NativeTemplateView nativeTemplateView = new NativeTemplateView(nContext, Native_Type);

                        nativeTemplateView.setStyles(styles);
                        nativeTemplateView.setNativeAd(nativeAd);

                        Ad_Layout.removeAllViews();
                        Ad_Layout.addView(nativeTemplateView);
                        LinearLayout.LayoutParams relativeParams = (LinearLayout.LayoutParams) Ad_Layout
                                .getLayoutParams();
                        relativeParams.setMargins(0, Bottom_Ad_Margin, 0, Top_Ad_Margin);

                        Ad_Layout.setLayoutParams(relativeParams);

                        nativeTemplateView.setVisibility(View.VISIBLE);


                    }

                })
                .withAdListener(new AdListener() {
                    @Override
                    public void onAdFailedToLoad(LoadAdError adError) {

                        Ad_Layout.removeAllViews();
                        Native_Auto_Setup_Linear3(nContext, Ad_Layout, Native_Type, Bottom_Ad_Margin, Top_Ad_Margin, Animation);

                    }
                })
                .withNativeAdOptions(new NativeAdOptions.Builder()

                        .build())
                .build();

        adLoader.loadAd(new AdRequest.Builder().build());


    }

    public void Native_Auto_Setup_Linear3(Context nContext, final RelativeLayout Ad_Layout,
                                          int Native_Type, int Bottom_Ad_Margin, int Top_Ad_Margin, int Animation) {


        if (Exit_Menu_Decided == 100) {

            return;
        }

        if (SharedPreferences.getNN3(nContext) == 0) {

            Native_ID = SharedPreferences.getN33(nContext);

            SharedPreferences.setNN3(nContext, 1);


        } else {

            Native_ID = SharedPreferences.getN333(nContext);

            SharedPreferences.setNN3(nContext, 0);


        }

        AdLoader adLoader = new AdLoader.Builder(nContext, Native_ID)
                .forNativeAd(new NativeAd.OnNativeAdLoadedListener() {
                    private ColorDrawable background;

                    @Override
                    public void onNativeAdLoaded(NativeAd nativeAd) {
                        NativeStyle styles = new
                                NativeStyle.Builder().withMainBackgroundColor(background).build();


                        NativeTemplateView nativeTemplateView = new NativeTemplateView(nContext, Native_Type);

                        nativeTemplateView.setStyles(styles);
                        nativeTemplateView.setNativeAd(nativeAd);

                        Ad_Layout.removeAllViews();
                        Ad_Layout.addView(nativeTemplateView);
                        LinearLayout.LayoutParams relativeParams = (LinearLayout.LayoutParams) Ad_Layout
                                .getLayoutParams();
                        relativeParams.setMargins(0, Bottom_Ad_Margin, 0, Top_Ad_Margin);

                        Ad_Layout.setLayoutParams(relativeParams);

                        nativeTemplateView.setVisibility(View.VISIBLE);


                    }

                })
                .withAdListener(new AdListener() {
                    @Override
                    public void onAdFailedToLoad(LoadAdError adError) {

                        Ad_Layout.removeAllViews();

                        if (Native_Type == 2) {

                            Banner_Auto_Setup_Linear1(Ad_Layout, 4);

                        } else {

                            Banner_Auto_Setup_Linear1(Ad_Layout, 3);
                        }

                    }
                })
                .withNativeAdOptions(new NativeAdOptions.Builder()

                        .build())
                .build();

        adLoader.loadAd(new AdRequest.Builder().build());


    }

    public void Start(Context aContext, String App_Name) {


        if (Exit_Menu_Decided == 100) {

            return;
        }

        if (isNetworkConnected(Contextt) == true) {

            int width = 480, Height = 800;

            final android.app.Dialog builder = new android.app.Dialog(aContext);
            builder.requestWindowFeature(Window.FEATURE_NO_TITLE);
            builder.getWindow().setBackgroundDrawable(
                    new ColorDrawable(Color.BLACK));
            builder.getWindow().setFlags(
                    WindowManager.LayoutParams.FLAG_FULLSCREEN,
                    WindowManager.LayoutParams.FLAG_FULLSCREEN);

            WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
            lp.copyFrom(builder.getWindow().getAttributes());
            lp.width = WindowManager.LayoutParams.MATCH_PARENT;
            lp.height = WindowManager.LayoutParams.MATCH_PARENT;

            builder.setOnDismissListener(new DialogInterface.OnDismissListener() {
                @Override
                public void onDismiss(DialogInterface dialogInterface) {
                    // nothing;
                }
            });

            DisplayMetrics displayMetrics = new DisplayMetrics();
            builder.getWindow().getWindowManager().getDefaultDisplay()
                    .getMetrics(displayMetrics);

            width = displayMetrics.widthPixels;
            Height = displayMetrics.heightPixels;

            // Background
            final RelativeLayout RL = new RelativeLayout(aContext);
            RL.setBackgroundColor(Color.WHITE);
            RL.setGravity(Gravity.CENTER_HORIZONTAL | Gravity.TOP);
            builder.addContentView(RL, new RelativeLayout.LayoutParams(
                    WindowManager.LayoutParams.MATCH_PARENT,
                    WindowManager.LayoutParams.MATCH_PARENT));


            Native_ID = "/6499/example/native";

            AdLoader adLoader = new AdLoader.Builder(aContext, Native_ID)
                    .forNativeAd(new NativeAd.OnNativeAdLoadedListener() {
                        private ColorDrawable background;

                        @Override
                        public void onNativeAdLoaded(NativeAd nativeAd) {
                            NativeStyle styles = new
                                    NativeStyle.Builder().withMainBackgroundColor(background).build();


                            NativeTemplateView nativeTemplateView = new NativeTemplateView(aContext, 0);

                            //TemplateView templateView = findViewById(R.id.my_template);
                            nativeTemplateView.setStyles(styles);
                            nativeTemplateView.setNativeAd(nativeAd);

                            RL.removeAllViews();
                            RL.addView(nativeTemplateView);

                            nativeTemplateView.setVisibility(View.VISIBLE);
                            //Toast.makeText(nContext, "Native Ad is loaded, now you can show the native ad", Toast.LENGTH_LONG).show();

                        }

                    })
                    .withAdListener(new AdListener() {
                        @Override
                        public void onAdFailedToLoad(LoadAdError adError) {
                            // Handle the failure by logging, altering the UI, and so on.

                            RL.removeAllViews();
                            Banner(RL, 4);

                        }
                    })
                    .withNativeAdOptions(new NativeAdOptions.Builder()
                            // Methods in the NativeAdOptions.Builder class can be
                            // used here to specify individual options settings.
                            .build())
                    .build();

            adLoader.loadAd(new AdRequest.Builder().build());

            builder.show();
            builder.getWindow().setAttributes(lp);
            builder.setCancelable(false);


        }

    }

    public void Pre_App_Open_Show(Activity currentActivity) {

        if (Exit_Menu_Decided == 100) {

            return;
        }

        if (isNetworkConnected(Contextt) == true) {

            final Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {

                    if (Server_Yes_No == 1 || Server_Yes_No == 0) {


                        if ((SharedPreferences.getSetup(currentActivity)).equals("1")) {

                            Pre_App_Open_Show_Setup(currentActivity);

                        } else if ((SharedPreferences.getSetup(currentActivity)).equals("0")) {

                            Pre_App_Open_Show_Normal(currentActivity);

                        }

                    } else {

                        handler.postDelayed(this, 500);

                    }

                }

            }, 500);

        }


    }

    public void Pre_App_Open_Show_Normal(Activity currentActivity) {


        if (Exit_Menu_Decided == 100) {

            return;
        }
        if (!isShowingAd && appOpenAd != null) {


            FullScreenContentCallback fullScreenContentCallback =
                    new FullScreenContentCallback() {
                        @Override
                        public void onAdDismissedFullScreenContent() {

                            appOpenAd = null;
                            isShowingAd = false;
                            Pre_App_Open_Load_Normal(currentActivity);
                        }

                        @Override
                        public void onAdFailedToShowFullScreenContent(AdError adError) {

                            if (tappxInterstitial_preload != null)
                                tappxInterstitial_preload.show();

                        }

                        @Override
                        public void onAdShowedFullScreenContent() {
                            isShowingAd = true;
                        }
                    };

            appOpenAd.show(currentActivity, fullScreenContentCallback);

        } else {


            if (tappxInterstitial_preload != null)
                tappxInterstitial_preload.show();

        }
    }

    public void Pre_App_Open_Load_Normal(Context mContext) {

        if (Exit_Menu_Decided == 100) {

            return;
        }

        if (appOpenAd != null) {
            return;
        }

        loadCallback =
                new AppOpenAd.AppOpenAdLoadCallback() {

                    @Override
                    public void onAppOpenAdLoaded(AppOpenAd ad) {
                        appOpenAd = ad;

                    }


                    @Override
                    public void onAppOpenAdFailedToLoad(LoadAdError loadAdError) {
                        // Handle the error.

                        tappxInterstitial_preload = new TappxInterstitial(mContext,
                                SharedPreferences.gettx(Contextt));
                        tappxInterstitial_preload.loadAd();
                        tappxInterstitial_preload
                                .setListener(new TappxInterstitialListener() {
                                    @Override
                                    public void onInterstitialLoaded(
                                            TappxInterstitial tappxInterstitial) {


                                    }

                                    @Override
                                    public void onInterstitialLoadFailed(
                                            TappxInterstitial tappxInterstitial,
                                            TappxAdError tappxAdError) {

                                    }

                                    @Override
                                    public void onInterstitialClicked(
                                            TappxInterstitial arg0) {
                                        // TODO Auto-generated method stub

                                    }

                                    @Override
                                    public void onInterstitialDismissed(
                                            TappxInterstitial arg0) {
                                        // TODO Auto-generated method stub

                                    }

                                    @Override
                                    public void onInterstitialShown(
                                            TappxInterstitial arg0) {
                                        // TODO Auto-generated method stub

                                    }

                                });


                    }

                };
        AdRequest request = new AdRequest.Builder().build();
        AppOpenAd.load(
                mContext, SharedPreferences.getapp_open(mContext), request,
                AppOpenAd.APP_OPEN_AD_ORIENTATION_PORTRAIT, loadCallback);


    }

    public void Pre_App_Open_Load_Setup1(Context mContext) {

        if (Exit_Menu_Decided == 100) {

            return;
        }

        if (appOpenAd3 != null) {
            return;
        }

        String App_Open_ID = "";

        if (SharedPreferences.getAOAO1(mContext) == 0) {

            App_Open_ID = SharedPreferences.getAO11(mContext);

            SharedPreferences.setAOAO1(mContext, 1);

        } else {

            App_Open_ID = SharedPreferences.getAO111(mContext);

            SharedPreferences.setAOAO1(mContext, 0);

        }

        loadCallback3 =
                new AppOpenAd.AppOpenAdLoadCallback() {


                    @Override
                    public void onAppOpenAdLoaded(AppOpenAd ad) {
                        appOpenAd3 = ad;

                        App_Open_Setup = 3;

                    }


                    @Override
                    public void onAppOpenAdFailedToLoad(LoadAdError loadAdError) {
                        // Handle the error.
                        App_Open_Setup = 33;
                        Pre_App_Open_Load_Setup2(mContext);

                    }

                };
        AdRequest request = new AdRequest.Builder().build();
        AppOpenAd.load(
                mContext, App_Open_ID, request,
                AppOpenAd.APP_OPEN_AD_ORIENTATION_PORTRAIT, loadCallback3);


    }

    public void Pre_App_Open_Load_Setup2(Context mContext) {

        if (Exit_Menu_Decided == 100) {

            return;
        }

        if (appOpenAd2 != null) {
            return;
        }

        String App_Open_ID = "";

        if (SharedPreferences.getAOAO2(mContext) == 0) {

            App_Open_ID = SharedPreferences.getAO22(mContext);

            SharedPreferences.setAOAO2(mContext, 1);

        } else {

            App_Open_ID = SharedPreferences.getAO222(mContext);

            SharedPreferences.setAOAO2(mContext, 0);

        }

        loadCallback2 =
                new AppOpenAd.AppOpenAdLoadCallback() {


                    @Override
                    public void onAppOpenAdLoaded(AppOpenAd ad) {
                        appOpenAd2 = ad;

                        App_Open_Setup = 2;

                    }


                    @Override
                    public void onAppOpenAdFailedToLoad(LoadAdError loadAdError) {
                        // Handle the error.
                        App_Open_Setup = 22;
                        Pre_App_Open_Load_Setup3(mContext);

                    }

                };
        AdRequest request = new AdRequest.Builder().build();
        AppOpenAd.load(
                mContext, App_Open_ID, request,
                AppOpenAd.APP_OPEN_AD_ORIENTATION_PORTRAIT, loadCallback2);


    }

    public void Pre_App_Open_Load_Setup3(Context mContext) {

        if (Exit_Menu_Decided == 100) {

            return;
        }

        if (appOpenAd1 != null) {
            return;
        }

        String App_Open_ID = "";

        if (SharedPreferences.getAOAO3(mContext) == 0) {

            App_Open_ID = SharedPreferences.getAO33(mContext);

            SharedPreferences.setAOAO3(mContext, 1);

        } else {

            App_Open_ID = SharedPreferences.getAO333(mContext);

            SharedPreferences.setAOAO3(mContext, 0);

        }

        loadCallback1 =
                new AppOpenAd.AppOpenAdLoadCallback() {


                    @Override
                    public void onAppOpenAdLoaded(AppOpenAd ad) {
                        appOpenAd1 = ad;

                        App_Open_Setup = 1;

                    }


                    @Override
                    public void onAppOpenAdFailedToLoad(LoadAdError loadAdError) {
                        // Handle the error.
                        App_Open_Setup = 11;

                        tappxInterstitial_preload = new TappxInterstitial(mContext,
                                SharedPreferences.gettx(Contextt));
                        tappxInterstitial_preload.loadAd();
                        tappxInterstitial_preload
                                .setListener(new TappxInterstitialListener() {
                                    @Override
                                    public void onInterstitialLoaded(
                                            TappxInterstitial tappxInterstitial) {


                                    }

                                    @Override
                                    public void onInterstitialLoadFailed(
                                            TappxInterstitial tappxInterstitial,
                                            TappxAdError tappxAdError) {

                                    }

                                    @Override
                                    public void onInterstitialClicked(
                                            TappxInterstitial arg0) {
                                        // TODO Auto-generated method stub

                                    }

                                    @Override
                                    public void onInterstitialDismissed(
                                            TappxInterstitial arg0) {
                                        // TODO Auto-generated method stub

                                    }

                                    @Override
                                    public void onInterstitialShown(
                                            TappxInterstitial arg0) {
                                        // TODO Auto-generated method stub

                                    }

                                });

                    }

                };
        AdRequest request = new AdRequest.Builder().build();
        AppOpenAd.load(
                mContext, App_Open_ID, request,
                AppOpenAd.APP_OPEN_AD_ORIENTATION_PORTRAIT, loadCallback1);


    }

    public void Pre_App_Open_Show_Setup(Activity currentActivity) {
        // Only show ad if there is not already an app open ad currently showing
        // and an ad is available.

        if (Exit_Menu_Decided == 100) {

            return;
        }

        if (App_Open_Setup == 3) {

            if (!isShowingAd3 && appOpenAd3 != null) {


                FullScreenContentCallback fullScreenContentCallback3 =
                        new FullScreenContentCallback() {
                            @Override
                            public void onAdDismissedFullScreenContent() {
                                // Set the reference to null so isAdAvailable() returns false.
                                appOpenAd3 = null;
                                isShowingAd3 = false;
                                Pre_App_Open_Load_Setup1(currentActivity);
                            }

                            @Override
                            public void onAdFailedToShowFullScreenContent(AdError adError) {
                            }

                            @Override
                            public void onAdShowedFullScreenContent() {
                                isShowingAd3 = true;
                            }
                        };

                appOpenAd3.show(currentActivity, fullScreenContentCallback3);

            }

        }
        if (App_Open_Setup == 33) {
            // Do For fail
        }
        if (App_Open_Setup == 2) {
            if (!isShowingAd2 && appOpenAd2 != null) {


                FullScreenContentCallback fullScreenContentCallback2 =
                        new FullScreenContentCallback() {
                            @Override
                            public void onAdDismissedFullScreenContent() {
                                // Set the reference to null so isAdAvailable() returns false.
                                appOpenAd2 = null;
                                isShowingAd2 = false;
                                Pre_App_Open_Load_Setup1(currentActivity);
                            }

                            @Override
                            public void onAdFailedToShowFullScreenContent(AdError adError) {
                            }

                            @Override
                            public void onAdShowedFullScreenContent() {
                                isShowingAd2 = true;
                            }
                        };

                appOpenAd2.show(currentActivity, fullScreenContentCallback2);

            }
        }
        if (App_Open_Setup == 22) {
            // Do For fail
        }
        if (App_Open_Setup == 1) {
            if (!isShowingAd1 && appOpenAd1 != null) {


                FullScreenContentCallback fullScreenContentCallback1 =
                        new FullScreenContentCallback() {
                            @Override
                            public void onAdDismissedFullScreenContent() {
                                // Set the reference to null so isAdAvailable() returns false.
                                appOpenAd1 = null;
                                isShowingAd1 = false;
                                Pre_App_Open_Load_Setup1(currentActivity);
                            }

                            @Override
                            public void onAdFailedToShowFullScreenContent(AdError adError) {
                            }

                            @Override
                            public void onAdShowedFullScreenContent() {
                                isShowingAd1 = true;
                            }
                        };

                appOpenAd1.show(currentActivity, fullScreenContentCallback1);

            }
        }
        if (App_Open_Setup == 11) {
            Pre_App_Open_Load_Setup1(currentActivity);
            if (tappxInterstitial_preload != null)
                tappxInterstitial_preload.show();
        }


    }

    public void Reward_Inter_Show(Activity mContext, String title, String description, int Popupmenu_Type) {

        if (Exit_Menu_Decided == 100) {

            return;
        }

        if ((SharedPreferences.getSetup(mContext)).equals("1")) {

            CustomDialogue progressDialog = new CustomDialogue(mContext, Popupmenu_Type, title, description);

            progressDialog.show();

            Reward_Inter_Show_Setup1(mContext, title, description, Popupmenu_Type, progressDialog);


        } else if ((SharedPreferences.getSetup(mContext)).equals("0")) {

            Reward_Inter_Show_Normal(mContext, title, description, Popupmenu_Type);

        }

    }

    public void Reward_Inter_Show_Normal(Activity mContext, String title, String description, int Popupmenu_Type) {


        if (Exit_Menu_Decided == 100) {

            return;
        }

        CustomDialogue progressDialog = new CustomDialogue(mContext, Popupmenu_Type, title, description);

        progressDialog.show();

        RewardedInterstitialAd.load(mContext, SharedPreferences.getinter_reward(mContext),
                new AdRequest.Builder().build(), new RewardedInterstitialAdLoadCallback() {
                    @Override
                    public void onAdLoaded(RewardedInterstitialAd ad) {


                        rewardedInterstitialAd = ad;

                        rewardedInterstitialAd.show(mContext, new OnUserEarnedRewardListener() {
                            @Override
                            public void onUserEarnedReward(@NonNull RewardItem rewardItem) {

                            }
                        });


                        final Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {

                                progressDialog.dismiss();

                            }

                        }, 1000);


                    }

                    @Override
                    public void onAdFailedToLoad(LoadAdError loadAdError) {
                        rewardedInterstitialAd = null;


                        Tappx_Reward(mContext, title, description, Popupmenu_Type, progressDialog);


                    }
                });


    }

    public void Tappx_Reward(Activity mContext, String title, String description, int Popupmenu_Type, CustomDialogue progressDialog) {

        progressDialog.dismiss();

        //TappxRewardedVideo rewardedVideo;

    }

    public void Reward_Inter_Show_Setup1(Activity mContext, String title, String description, int Popupmenu_Type, CustomDialogue progressDialog) {


        String Inter_Reward_Ad_ID;

        if (SharedPreferences.getIIRRDD1(mContext) == 0) {

            Inter_Reward_Ad_ID = SharedPreferences.getIRD11(mContext);

            SharedPreferences.setIIRRDD1(mContext, 1);


        } else {

            Inter_Reward_Ad_ID = SharedPreferences.getIRD111(mContext);

            SharedPreferences.setIIRRDD1(mContext, 0);


        }


        RewardedInterstitialAd.load(mContext, Inter_Reward_Ad_ID,
                new AdRequest.Builder().build(), new RewardedInterstitialAdLoadCallback() {
                    @Override
                    public void onAdLoaded(RewardedInterstitialAd ad) {


                        rewardedInterstitialAd = ad;

                        rewardedInterstitialAd.show(mContext, new OnUserEarnedRewardListener() {
                            @Override
                            public void onUserEarnedReward(@NonNull RewardItem rewardItem) {

                            }
                        });


                        final Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {


                                progressDialog.dismiss();


                            }

                        }, 500);


                    }

                    @Override
                    public void onAdFailedToLoad(LoadAdError loadAdError) {
                        rewardedInterstitialAd = null;
                        Reward_Inter_Show_Setup2(mContext, title, description, Popupmenu_Type, progressDialog);
                    }
                });


    }

    public void Reward_Inter_Show_Setup2(Activity mContext, String title, String description, int Popupmenu_Type, CustomDialogue progressDialog) {


        String Inter_Reward_Ad_ID;

        if (SharedPreferences.getIIRRDD2(mContext) == 0) {

            Inter_Reward_Ad_ID = SharedPreferences.getIRD22(mContext);

            SharedPreferences.setIIRRDD2(mContext, 1);


        } else {

            Inter_Reward_Ad_ID = SharedPreferences.getIRD222(mContext);

            SharedPreferences.setIIRRDD2(mContext, 0);


        }


        RewardedInterstitialAd.load(mContext, Inter_Reward_Ad_ID,
                new AdRequest.Builder().build(), new RewardedInterstitialAdLoadCallback() {
                    @Override
                    public void onAdLoaded(RewardedInterstitialAd ad) {


                        rewardedInterstitialAd = ad;

                        rewardedInterstitialAd.show(mContext, new OnUserEarnedRewardListener() {
                            @Override
                            public void onUserEarnedReward(@NonNull RewardItem rewardItem) {

                            }
                        });


                        final Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {


                                progressDialog.dismiss();


                            }

                        }, 1000);


                    }

                    @Override
                    public void onAdFailedToLoad(LoadAdError loadAdError) {
                        rewardedInterstitialAd = null;
                        Reward_Inter_Show_Setup3(mContext, title, description, Popupmenu_Type, progressDialog);
                    }
                });


    }

    public void Reward_Inter_Show_Setup3(Activity mContext, String title, String description, int Popupmenu_Type, CustomDialogue progressDialog) {


        String Inter_Reward_Ad_ID;

        if (SharedPreferences.getIIRRDD3(mContext) == 0) {

            Inter_Reward_Ad_ID = SharedPreferences.getIRD33(mContext);

            SharedPreferences.setIIRRDD3(mContext, 1);


        } else {

            Inter_Reward_Ad_ID = SharedPreferences.getIRD333(mContext);

            SharedPreferences.setIIRRDD3(mContext, 0);


        }


        RewardedInterstitialAd.load(mContext, Inter_Reward_Ad_ID,
                new AdRequest.Builder().build(), new RewardedInterstitialAdLoadCallback() {
                    @Override
                    public void onAdLoaded(RewardedInterstitialAd ad) {


                        rewardedInterstitialAd = ad;

                        rewardedInterstitialAd.show(mContext, new OnUserEarnedRewardListener() {
                            @Override
                            public void onUserEarnedReward(@NonNull RewardItem rewardItem) {

                            }
                        });


                        final Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {


                                progressDialog.dismiss();


                            }

                        }, 1000);


                    }

                    @Override
                    public void onAdFailedToLoad(LoadAdError loadAdError) {
                        rewardedInterstitialAd = null;
                        progressDialog.dismiss();
                    }
                });


    }

    public void Reward_Inter_Show_with_Dialog(Activity mContext, OnRewardgetListner onRewardgetListner, String title, String description, int Popupmenu_Type) {

        if (Exit_Menu_Decided == 100) {

            return;
        }

        if ((SharedPreferences.getSetup(mContext)).equals("1")) {

            CustomDialogue progressDialog = new CustomDialogue(mContext, Popupmenu_Type, title, description);

            new Dialog.Builder(mContext)
                    .setTitle(title)
                    .setMessage(description)
                    .setTitleTextColor(R.color.titleText)
                    .setDescriptionTextColor(R.color.descriptionText)
                    .setNegativeBtnText("Close")
                    .setPositiveBtnBackground(R.color.positiveButton)
                    .setPositiveBtnText("Watch Now (Ad)")
                    .setNegativeBtnBackground(R.color.positiveButton)
                    .setGifResource(R.drawable.ad1)
                    .isCancellable(true)
                    .OnPositiveClicked(new DialogListener() {
                        @Override
                        public void OnClick() {
                            progressDialog.show();
                            Reward_Inter_Show_with_Dialog_Setup1(mContext, onRewardgetListner, title, description, Popupmenu_Type, progressDialog);

                        }
                    })
                    .OnNegativeClicked(new DialogListener() {
                        @Override
                        public void OnClick() {


                        }
                    })
                    .build();


        } else if ((SharedPreferences.getSetup(mContext)).equals("0")) {

            Reward_Inter_Show_with_Dialog_Normal(mContext, onRewardgetListner, title, description, Popupmenu_Type);

        }

    }

    public void Reward_Inter_Show_with_Dialog_Normal(Activity mContext, OnRewardgetListner onRewardgetListner, String title, String description, int Popupmenu_Type) {


        if (Exit_Menu_Decided == 100) {

            return;
        }

        CustomDialogue progressDialog = new CustomDialogue(mContext, Popupmenu_Type, title, description);


        new Dialog.Builder(mContext)
                .setTitle(title)
                .setMessage(description)
                .setTitleTextColor(R.color.titleText)
                .setDescriptionTextColor(R.color.descriptionText)
                .setNegativeBtnText("Close")
                .setPositiveBtnBackground(R.color.positiveButton)
                .setPositiveBtnText("Watch Now (Ad)")
                .setNegativeBtnBackground(R.color.positiveButton)
                .setGifResource(R.drawable.ad1)
                .isCancellable(true)
                .OnPositiveClicked(new DialogListener() {
                    @Override
                    public void OnClick() {


                        progressDialog.show();

                        AdRequest adRequest = new AdRequest.Builder().build();
                        RewardedInterstitialAd.load(mContext, SharedPreferences.getinter_reward(mContext),
                                adRequest, new RewardedInterstitialAdLoadCallback() {
                                    @Override
                                    public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                                        mrewardedInterstitialAd = null;


                                        onRewardgetListner.OnReward(false);
                                        progressDialog.dismiss();
                                    }

                                    @Override
                                    public void onAdLoaded(@NonNull RewardedInterstitialAd rewardedInterstitialAd) {
                                        super.onAdLoaded(rewardedInterstitialAd);

                                        mrewardedInterstitialAd = rewardedInterstitialAd;

                                        mrewardedInterstitialAd.show(mContext, new OnUserEarnedRewardListener() {
                                            @Override
                                            public void onUserEarnedReward(@NonNull RewardItem rewardItem) {
                                                onRewardgetListner.OnReward(true);
                                            }
                                        });


                                        final Handler handler = new Handler();
                                        handler.postDelayed(new Runnable() {
                                            @Override
                                            public void run() {


                                                progressDialog.dismiss();


                                            }

                                        }, 500);
                                    }


                                });

                    }
                })
                .OnNegativeClicked(new DialogListener() {
                    @Override
                    public void OnClick() {


                    }
                })
                .build();


    }

    public void Reward_Inter_Show_with_Dialog_Setup1(Activity mContext, OnRewardgetListner onRewardgetListner, String title, String description, int Popupmenu_Type, CustomDialogue progressDialog) {


        String Inter_Reward_Ad_ID;

        if (SharedPreferences.getIIRRDD1(mContext) == 0) {

            Inter_Reward_Ad_ID = SharedPreferences.getIRD11(mContext);

            SharedPreferences.setIIRRDD1(mContext, 1);


        } else {

            Inter_Reward_Ad_ID = SharedPreferences.getIRD111(mContext);

            SharedPreferences.setIIRRDD1(mContext, 0);


        }

        AdRequest adRequest = new AdRequest.Builder().build();
        RewardedInterstitialAd.load(mContext, Inter_Reward_Ad_ID,
                adRequest, new RewardedInterstitialAdLoadCallback() {

                    @Override
                    public void onAdLoaded(@NonNull RewardedInterstitialAd rewardedInterstitialAd) {
                        super.onAdLoaded(rewardedInterstitialAd);

                        mrewardedInterstitialAd = rewardedInterstitialAd;

                        mrewardedInterstitialAd.show(mContext, new OnUserEarnedRewardListener() {
                            @Override
                            public void onUserEarnedReward(@NonNull RewardItem rewardItem) {
                                onRewardgetListner.OnReward(true);
                            }
                        });


                        final Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {

                                progressDialog.dismiss();

                            }

                        }, 500);
                    }

                    @Override
                    public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                        // Handle the error.
                        mrewardedInterstitialAd = null;

                        Reward_Inter_Show_with_Dialog_Setup2(mContext, onRewardgetListner, title, description, Popupmenu_Type, progressDialog);

                    }


                });


    }

    public void Reward_Inter_Show_with_Dialog_Setup2(Activity mContext, OnRewardgetListner onRewardgetListner, String title, String description, int Popupmenu_Type, CustomDialogue progressDialog) {


        String Inter_Reward_Ad_ID;

        if (SharedPreferences.getIIRRDD2(mContext) == 0) {

            Inter_Reward_Ad_ID = SharedPreferences.getIRD22(mContext);

            SharedPreferences.setIIRRDD2(mContext, 1);


        } else {

            Inter_Reward_Ad_ID = SharedPreferences.getIRD222(mContext);

            SharedPreferences.setIIRRDD2(mContext, 0);


        }

        AdRequest adRequest = new AdRequest.Builder().build();
        RewardedInterstitialAd.load(mContext, Inter_Reward_Ad_ID,
                adRequest, new RewardedInterstitialAdLoadCallback() {

                    @Override
                    public void onAdLoaded(@NonNull RewardedInterstitialAd rewardedInterstitialAd) {
                        super.onAdLoaded(rewardedInterstitialAd);

                        mrewardedInterstitialAd = rewardedInterstitialAd;

                        mrewardedInterstitialAd.show(mContext, new OnUserEarnedRewardListener() {
                            @Override
                            public void onUserEarnedReward(@NonNull RewardItem rewardItem) {
                                onRewardgetListner.OnReward(true);
                            }
                        });


                        final Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {

                                progressDialog.dismiss();

                            }

                        }, 500);
                    }

                    @Override
                    public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                        // Handle the error.
                        mrewardedInterstitialAd = null;


                        Reward_Inter_Show_with_Dialog_Setup3(mContext, onRewardgetListner, title, description, Popupmenu_Type, progressDialog);
                    }


                });


    }

    public void Reward_Inter_Show_with_Dialog_Setup3(Activity mContext, OnRewardgetListner onRewardgetListner, String title, String description, int Popupmenu_Type, CustomDialogue progressDialog) {


        String Inter_Reward_Ad_ID;

        if (SharedPreferences.getIIRRDD3(mContext) == 0) {

            Inter_Reward_Ad_ID = SharedPreferences.getIRD33(mContext);

            SharedPreferences.setIIRRDD3(mContext, 1);


        } else {

            Inter_Reward_Ad_ID = SharedPreferences.getIRD333(mContext);

            SharedPreferences.setIIRRDD3(mContext, 0);


        }

        AdRequest adRequest = new AdRequest.Builder().build();
        RewardedInterstitialAd.load(mContext, Inter_Reward_Ad_ID,
                adRequest, new RewardedInterstitialAdLoadCallback() {

                    @Override
                    public void onAdLoaded(@NonNull RewardedInterstitialAd rewardedInterstitialAd) {
                        super.onAdLoaded(rewardedInterstitialAd);

                        mrewardedInterstitialAd = rewardedInterstitialAd;

                        mrewardedInterstitialAd.show(mContext, new OnUserEarnedRewardListener() {
                            @Override
                            public void onUserEarnedReward(@NonNull RewardItem rewardItem) {
                                onRewardgetListner.OnReward(true);
                            }
                        });


                        final Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {

                                progressDialog.dismiss();

                            }

                        }, 500);
                    }

                    @Override
                    public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                        mrewardedInterstitialAd = null;


                        onRewardgetListner.OnReward(false);
                        progressDialog.dismiss();
                    }


                });


    }

    public void Reward(Activity mContext, OnRewardgetListner onRewardgetListner, String title, String description, int Popupmenu_Type) {

        if (Exit_Menu_Decided == 100) {

            return;
        }

        if ((SharedPreferences.getSetup(mContext)).equals("1")) {

            CustomDialogue progressDialog = new CustomDialogue(mContext, Popupmenu_Type, title, description);

            progressDialog.show();

            new Dialog.Builder(mContext)
                    .setTitle(title)
                    .setMessage(description)
                    .setTitleTextColor(R.color.titleText)
                    .setDescriptionTextColor(R.color.descriptionText)
                    .setNegativeBtnText("Close")
                    .setPositiveBtnBackground(R.color.positiveButton)
                    .setPositiveBtnText("Watch Now (Ad)")
                    .setNegativeBtnBackground(R.color.positiveButton)
                    .setGifResource(R.drawable.ad1)
                    .isCancellable(true)
                    .OnPositiveClicked(new DialogListener() {
                        @Override
                        public void OnClick() {

                            progressDialog.show();

                            Reward_Setup1(mContext, onRewardgetListner, title, description, Popupmenu_Type, progressDialog);

                        }
                    })
                    .OnNegativeClicked(new DialogListener() {
                        @Override
                        public void OnClick() {


                        }
                    })
                    .build();


        } else if ((SharedPreferences.getSetup(mContext)).equals("0")) {

            Reward_Normal(mContext, onRewardgetListner, title, description, Popupmenu_Type);

        }

    }

    public void Reward_Normal(Activity mContext, OnRewardgetListner onRewardgetListner, String title, String description, int Popupmenu_Type) {

        if (Exit_Menu_Decided == 100) {

            return;
        }

        CustomDialogue progressDialog = new CustomDialogue(mContext, Popupmenu_Type, title, description);


        new Dialog.Builder(mContext)
                .setTitle(title)
                .setMessage(description)
                .setTitleTextColor(R.color.titleText)
                .setDescriptionTextColor(R.color.descriptionText)
                .setNegativeBtnText("Close")
                .setPositiveBtnBackground(R.color.positiveButton)
                .setPositiveBtnText("Watch Now (Ad)")
                .setNegativeBtnBackground(R.color.positiveButton)
                .setGifResource(R.drawable.ad1)
                .isCancellable(true)
                .OnPositiveClicked(new DialogListener() {
                    @Override
                    public void OnClick() {


                        progressDialog.show();

                        AdRequest adRequest = new AdRequest.Builder().build();
                        RewardedAd.load(mContext, SharedPreferences.getreward(mContext),
                                adRequest, new RewardedAdLoadCallback() {
                                    @Override
                                    public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                                        // Handle the error.
                                        mRewardedAd = null;


                                        onRewardgetListner.OnReward(false);
                                        progressDialog.dismiss();
                                    }

                                    @Override
                                    public void onAdLoaded(@NonNull RewardedAd rewardedAd) {
                                        mRewardedAd = rewardedAd;


                                        mRewardedAd.show(mContext, new OnUserEarnedRewardListener() {
                                            @Override
                                            public void onUserEarnedReward(@NonNull RewardItem rewardItem) {

                                                onRewardgetListner.OnReward(true);


                                            }
                                        });

                                        final Handler handler = new Handler();
                                        handler.postDelayed(new Runnable() {
                                            @Override
                                            public void run() {


                                                progressDialog.dismiss();


                                            }

                                        }, 500);


                                    }

                                });

                    }
                })
                .OnNegativeClicked(new DialogListener() {
                    @Override
                    public void OnClick() {


                    }
                })
                .build();


    }

    public void Reward_Setup1(Activity mContext, OnRewardgetListner onRewardgetListner, String title, String description, int Popupmenu_Type, CustomDialogue progressDialog) {

        if (Exit_Menu_Decided == 100) {

            return;
        }

        String Reward_Ad_ID;

        if (SharedPreferences.getRRDD1(mContext) == 0) {

            Reward_Ad_ID = SharedPreferences.getRD11(mContext);

            SharedPreferences.setRRDD1(mContext, 1);


        } else {

            Reward_Ad_ID = SharedPreferences.getRD111(mContext);

            SharedPreferences.setRRDD1(mContext, 0);


        }


        AdRequest adRequest = new AdRequest.Builder().build();
        RewardedAd.load(mContext, Reward_Ad_ID,
                adRequest, new RewardedAdLoadCallback() {

                    @Override
                    public void onAdLoaded(@NonNull RewardedAd rewardedAd) {
                        mRewardedAd = rewardedAd;


                        mRewardedAd.show(mContext, new OnUserEarnedRewardListener() {
                            @Override
                            public void onUserEarnedReward(@NonNull RewardItem rewardItem) {

                                onRewardgetListner.OnReward(true);


                            }
                        });

                        final Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {

                                progressDialog.dismiss();

                            }

                        }, 500);


                    }

                    @Override
                    public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                        // Handle the error.
                        mRewardedAd = null;
                        Reward_Setup2(mContext, onRewardgetListner, title, description, Popupmenu_Type, progressDialog);
                    }

                });


    }

    public void Reward_Setup2(Activity mContext, OnRewardgetListner onRewardgetListner, String title, String description, int Popupmenu_Type, CustomDialogue progressDialog) {

        if (Exit_Menu_Decided == 100) {

            return;
        }

        String Reward_Ad_ID;

        if (SharedPreferences.getRRDD2(mContext) == 0) {

            Reward_Ad_ID = SharedPreferences.getRD22(mContext);

            SharedPreferences.setRRDD2(mContext, 1);


        } else {

            Reward_Ad_ID = SharedPreferences.getRD222(mContext);

            SharedPreferences.setRRDD2(mContext, 0);


        }


        AdRequest adRequest = new AdRequest.Builder().build();
        RewardedAd.load(mContext, Reward_Ad_ID,
                adRequest, new RewardedAdLoadCallback() {

                    @Override
                    public void onAdLoaded(@NonNull RewardedAd rewardedAd) {
                        mRewardedAd = rewardedAd;


                        mRewardedAd.show(mContext, new OnUserEarnedRewardListener() {
                            @Override
                            public void onUserEarnedReward(@NonNull RewardItem rewardItem) {

                                onRewardgetListner.OnReward(true);


                            }
                        });

                        final Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {

                                progressDialog.dismiss();

                            }

                        }, 500);


                    }

                    @Override
                    public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                        mRewardedAd = null;
                        Reward_Setup3(mContext, onRewardgetListner, title, description, Popupmenu_Type, progressDialog);
                    }

                });


    }

    public void Reward_Setup3(Activity mContext, OnRewardgetListner onRewardgetListner, String title, String description, int Popupmenu_Type, CustomDialogue progressDialog) {

        if (Exit_Menu_Decided == 100) {

            return;
        }

        String Reward_Ad_ID;

        if (SharedPreferences.getRRDD3(mContext) == 0) {

            Reward_Ad_ID = SharedPreferences.getRD33(mContext);

            SharedPreferences.setRRDD3(mContext, 1);


        } else {

            Reward_Ad_ID = SharedPreferences.getRD333(mContext);

            SharedPreferences.setRRDD3(mContext, 0);


        }


        AdRequest adRequest = new AdRequest.Builder().build();
        RewardedAd.load(mContext, Reward_Ad_ID,
                adRequest, new RewardedAdLoadCallback() {

                    @Override
                    public void onAdLoaded(@NonNull RewardedAd rewardedAd) {
                        mRewardedAd = rewardedAd;


                        mRewardedAd.show(mContext, new OnUserEarnedRewardListener() {
                            @Override
                            public void onUserEarnedReward(@NonNull RewardItem rewardItem) {

                                onRewardgetListner.OnReward(true);


                            }
                        });

                        final Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {

                                progressDialog.dismiss();

                            }

                        }, 500);


                    }

                    @Override
                    public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                        // Handle the error.
                        mRewardedAd = null;
                        onRewardgetListner.OnReward(false);
                        progressDialog.dismiss();
                    }

                });


    }

    public void Exit(Context aContext) {

        Exit("Do you want to exit ?", aContext,
                "" + aContext.getString(R.string.app_name));

    }

    @SuppressLint({"InflateParams", "InlinedApi"})
    public void Exit(String Description, final Context context, String App_Name) {

        final android.app.Dialog dialog = new android.app.Dialog(context);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        if (dialog.getWindow() != null)
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.setCancelable(true);
        dialog.setContentView(R.layout.exitt);

        TextView text = (TextView) dialog.findViewById(R.id.title);
        text.setText(Description);

        RelativeLayout Exit_Ads = (RelativeLayout) dialog.findViewById(R.id.banner);

        Button Btn_Yes = (Button) dialog.findViewById(R.id.Btn_Yes);
        Button Btn_Rate = (Button) dialog.findViewById(R.id.Btn_Rate);
        Button Btn_No = (Button) dialog.findViewById(R.id.Btn_No);

        Btn_Yes.setText("Yes");
        Btn_Rate.setText("Rate Us");
        Btn_No.setText("No");

        Btn_Yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                ((Activity) context).moveTaskToBack(true);
                ((Activity) context).finish();
            }
        });
        Btn_Rate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("market://details?id="
                        + Packages);
                Intent goToMarket = new Intent(
                        Intent.ACTION_VIEW, uri);

                goToMarket
                        .addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY
                                | Intent.FLAG_ACTIVITY_MULTIPLE_TASK);
                try {
                    context.startActivity(goToMarket);
                } catch (ActivityNotFoundException e) {
                    context.startActivity(new Intent(
                            Intent.ACTION_VIEW,
                            Uri.parse("http://play.google.com/OneForAll/apps/details?id="
                                    + Packages)));
                }
            }
        });
        Btn_No.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        dialog.show();


    }

    public void Tappx_Inter(final Context context) {

        if (isNetworkConnected(Contextt) == true) {

            tappxInterstitial = new TappxInterstitial(context,
                    SharedPreferences.gettx(Contextt));
            tappxInterstitial.loadAd();
            tappxInterstitial.setListener(new TappxInterstitialListener() {
                @Override
                public void onInterstitialLoaded(
                        TappxInterstitial tappxInterstitial) {

                    tappxInterstitial.show();
                    Ad_ProgressDialog.dismiss();

                    SharedPreferences.setsplashcount(context,
                            (SharedPreferences.getsplashcount(context) + 1));
                }

                @Override
                public void onInterstitialLoadFailed(
                        TappxInterstitial tappxInterstitial,
                        TappxAdError tappxAdError) {

                    if ((new Random().nextInt((2 - 1) + 1) + 1) == 1) {
                        SO = SO_FULLPAGE;
                    } else {
                        SO = SO_OFFERWALL;
                    }
                    startAppAd.loadAd(SO, new AdEventListener() {
                        @Override
                        public void onReceiveAd(Ad ad) {

                            startAppAd.showAd();
                            Ad_ProgressDialog.dismiss();

                        }

                        @Override
                        public void onFailedToReceiveAd(Ad ad) {
                            Ad_ProgressDialog.dismiss();
                        }

                    });

                }

                @Override
                public void onInterstitialClicked(TappxInterstitial arg0) {
                    // TODO Auto-generated method stub

                }

                @Override
                public void onInterstitialDismissed(TappxInterstitial arg0) {
                    // TODO Auto-generated method stub

                }

                @Override
                public void onInterstitialShown(TappxInterstitial arg0) {
                    // TODO Auto-generated method stub

                }

            });

        }

    }

    @SuppressLint("SetTextI18n")
    public void Exit_With_Ads_Banner(final Context context) {


        final int Banner_Type = 4;

        if (Exit_Menu_Decided == 0) {

            onBackPressed(context);

        } else if (Exit_Menu_Decided == 1) {

            Exit("Do You Want To Exit ?", context,
                    "" + context.getString(R.string.app_name));

        } else if (Exit_Menu_Decided == 2) {

            Exit_Popup_With_Ads_Banner(context, Banner_Type);

        } else if (Exit_Menu_Decided == 3) {

            Exit("Do You Want To Exit ?", context,
                    "" + context.getString(R.string.app_name));

        } else if (Exit_Menu_Decided == 4) {

            Exit_Popup_With_Ads_Banner(context, Banner_Type);

        } else {

            onBackPressed(context);

        }

    }

    public void Exit_Popup_With_Ads_Banner(final Context context, final int Banner_Type) {

        String Description = "Do You Want To Exit ?";

        final android.app.Dialog dialog = new android.app.Dialog(context);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        if (dialog.getWindow() != null)
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.setCancelable(true);
        dialog.setContentView(R.layout.exitt);

        TextView text = (TextView) dialog.findViewById(R.id.title);
        text.setText(Description);

        RelativeLayout Exit_Ads = (RelativeLayout) dialog.findViewById(R.id.banner);
        Banner_Back_Setup1(Exit_Ads, Banner_Type);

        Button Btn_Yes = (Button) dialog.findViewById(R.id.Btn_Yes);
        Button Btn_Rate = (Button) dialog.findViewById(R.id.Btn_Rate);
        Button Btn_No = (Button) dialog.findViewById(R.id.Btn_No);

        Btn_Yes.setText("Yes");
        Btn_Rate.setText("Rate Us");
        Btn_No.setText("No");

        Btn_Yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                ((Activity) context).moveTaskToBack(true);
                ((Activity) context).finish();
            }
        });
        Btn_Rate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("market://details?id="
                        + Packages);
                Intent goToMarket = new Intent(
                        Intent.ACTION_VIEW, uri);

                goToMarket
                        .addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY
                                | Intent.FLAG_ACTIVITY_MULTIPLE_TASK);
                try {
                    context.startActivity(goToMarket);
                } catch (ActivityNotFoundException e) {
                    context.startActivity(new Intent(
                            Intent.ACTION_VIEW,
                            Uri.parse("http://play.google.com/OneForAll/apps/details?id="
                                    + Packages)));
                }
            }
        });
        Btn_No.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        dialog.show();


    }

    public void Banner_Back_Setup1(final RelativeLayout Ad_Layout, final int Banner_Type) {


        if (Exit_Menu_Decided == 100) {

            return;
        }

        if (isNetworkConnected(Contextt) == true) {

            final Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {

                    if (Server_Yes_No == 1 || Server_Yes_No == 0) {

                        AdSize Banner_Type_Size = null;

                        if (Banner_Type == 1) {

                            Banner_Type_Size = AdSize.BANNER;

                        } else if (Banner_Type == 2) {

                            Banner_Type_Size = AdSize.LARGE_BANNER;

                        } else if (Banner_Type == 3) {

                            Banner_Type_Size = AdSize.LARGE_BANNER;

                        } else if (Banner_Type == 4) {

                            Banner_Type_Size = AdSize.MEDIUM_RECTANGLE;

                        } else {

                            Banner_Type_Size = AdSize.BANNER;

                        }

                        if ((SharedPreferences.getSetup(Contextt)).equals("1")) {


                            if (SharedPreferences.getBB1(Contextt) == 0) {

                                Banner = SharedPreferences.getB11(Contextt);

                                SharedPreferences.setBB1(Contextt, 1);

                            } else {

                                Banner = SharedPreferences.getB111(Contextt);

                                SharedPreferences.setBB1(Contextt, 0);

                            }
                        } else if ((SharedPreferences.getSetup(Contextt)).equals("0")) {


                            if (SharedPreferences.getbanner(Contextt) == 0) {

                                Banner = SharedPreferences.getbanner1(Contextt);

                                SharedPreferences.setbanner(Contextt, 1);

                            } else {

                                Banner = SharedPreferences.getbanner2(Contextt);

                                SharedPreferences.setbanner(Contextt, 0);

                            }

                        }

                        mAdView = new AdView(Contextt);
                        mAdView.setAdSize(Banner_Type_Size);
                        mAdView.setAdUnitId(Banner);
                        AdRequest adore = new AdRequest.Builder().build();
                        mAdView.loadAd(adore);
                        Ad_Layout.addView(mAdView);

                        mAdView.setAdListener(new AdListener() {

                            @Override
                            public void onAdLoaded() {
                                // TODO Auto-generated method stub

                                Ad_Layout.setVisibility(View.VISIBLE);
                                SharedPreferences.setsplashcount(Contextt, 0);

                                super.onAdLoaded();

                            }

                            @Override
                            public void onAdFailedToLoad(int errorCode) {
                                // TODO Auto-generated method stub
                                super.onAdFailedToLoad(errorCode);

                                mAdView.destroy();

                                Banner_Back_Setup2(Ad_Layout, Banner_Type);


                            }
                        });
                    } else {

                        handler.postDelayed(this, 500);

                    }

                }

            }, 500);

        } else {

            Ad_Layout.setVisibility(View.GONE);

        }

    }

    public void Banner_Back_Setup2(final RelativeLayout Ad_Layout, final int Banner_Type) {


        AdSize Banner_Type_Size = null;

        if (Banner_Type == 1) {

            Banner_Type_Size = AdSize.BANNER;

        } else if (Banner_Type == 2) {

            Banner_Type_Size = AdSize.LARGE_BANNER;

        } else if (Banner_Type == 3) {

            Banner_Type_Size = AdSize.LARGE_BANNER;

        } else if (Banner_Type == 4) {

            Banner_Type_Size = AdSize.MEDIUM_RECTANGLE;

        } else {

            Banner_Type_Size = AdSize.BANNER;

        }

        if ((SharedPreferences.getSetup(Contextt)).equals("1")) {


            if (SharedPreferences.getBB2(Contextt) == 0) {

                Banner = SharedPreferences.getB22(Contextt);

                SharedPreferences.setBB2(Contextt, 1);

            } else {

                Banner = SharedPreferences.getB222(Contextt);

                SharedPreferences.setBB2(Contextt, 0);

            }

        } else if ((SharedPreferences.getSetup(Contextt)).equals("0")) {


            if (SharedPreferences.getbanner(Contextt) == 0) {

                Banner = SharedPreferences.getbanner1(Contextt);

                SharedPreferences.setbanner(Contextt, 1);

            } else {

                Banner = SharedPreferences.getbanner2(Contextt);

                SharedPreferences.setbanner(Contextt, 0);

            }

        }

        mAdView = new AdView(Contextt);
        mAdView.setAdSize(Banner_Type_Size);
        mAdView.setAdUnitId(Banner);
        AdRequest adore = new AdRequest.Builder().build();
        mAdView.loadAd(adore);
        Ad_Layout.addView(mAdView);

        mAdView.setAdListener(new AdListener() {

            @Override
            public void onAdLoaded() {
                // TODO Auto-generated method stub

                Ad_Layout.setVisibility(View.VISIBLE);
                SharedPreferences.setsplashcount(Contextt, 0);

                super.onAdLoaded();

            }

            @Override
            public void onAdFailedToLoad(int errorCode) {
                // TODO Auto-generated method stub
                super.onAdFailedToLoad(errorCode);

                mAdView.destroy();

                Banner_Back_Setup3(Ad_Layout, Banner_Type);


            }
        });


    }

    public void Banner_Back_Setup3(final RelativeLayout Ad_Layout, final int Banner_Type) {


        AdSize Banner_Type_Size = null;

        if (Banner_Type == 1) {

            Banner_Type_Size = AdSize.BANNER;

        } else if (Banner_Type == 2) {

            Banner_Type_Size = AdSize.LARGE_BANNER;

        } else if (Banner_Type == 3) {

            Banner_Type_Size = AdSize.LARGE_BANNER;

        } else if (Banner_Type == 4) {

            Banner_Type_Size = AdSize.MEDIUM_RECTANGLE;

        } else {

            Banner_Type_Size = AdSize.BANNER;

        }


        if ((SharedPreferences.getSetup(Contextt)).equals("1")) {


            if (SharedPreferences.getBB3(Contextt) == 0) {

                Banner = SharedPreferences.getB33(Contextt);

                SharedPreferences.setBB3(Contextt, 1);

            } else {

                Banner = SharedPreferences.getB333(Contextt);

                SharedPreferences.setBB3(Contextt, 0);

            }

        } else if ((SharedPreferences.getSetup(Contextt)).equals("0")) {


            if (SharedPreferences.getbanner(Contextt) == 0) {

                Banner = SharedPreferences.getbanner1(Contextt);

                SharedPreferences.setbanner(Contextt, 1);

            } else {

                Banner = SharedPreferences.getbanner2(Contextt);

                SharedPreferences.setbanner(Contextt, 0);

            }

        }

        mAdView = new AdView(Contextt);
        mAdView.setAdSize(Banner_Type_Size);
        mAdView.setAdUnitId(Banner);
        AdRequest adore = new AdRequest.Builder().build();
        mAdView.loadAd(adore);
        Ad_Layout.addView(mAdView);

        mAdView.setAdListener(new AdListener() {

            @Override
            public void onAdLoaded() {
                // TODO Auto-generated method stub

                Ad_Layout.setVisibility(View.VISIBLE);
                SharedPreferences.setsplashcount(Contextt, 0);

                super.onAdLoaded();

            }

            @Override
            public void onAdFailedToLoad(int errorCode) {
                // TODO Auto-generated method stub
                super.onAdFailedToLoad(errorCode);

                mAdView.destroy();

                TappxBanner.AdSize Banner_Type_Size_Tappx = null;

                if (Banner_Type == 1) {

                    Banner_Type_Size_Tappx = TappxBanner.AdSize.SMART_BANNER;

                } else if (Banner_Type == 2) {

                    Banner_Type_Size_Tappx = TappxBanner.AdSize.BANNER_300x250;

                } else if (Banner_Type == 3) {

                    Banner_Type_Size_Tappx = TappxBanner.AdSize.BANNER_300x250;

                } else if (Banner_Type == 4) {

                    Banner_Type_Size_Tappx = TappxBanner.AdSize.BANNER_300x250;

                } else {

                    Banner_Type_Size_Tappx = TappxBanner.AdSize.SMART_BANNER;

                }

                Tappxbanner = new TappxBanner(Contextt, SharedPreferences
                        .gettx(Contextt));
                Tappxbanner.setAdSize(Banner_Type_Size_Tappx);
                Ad_Layout.addView(Tappxbanner);
                Tappxbanner.loadAd();
                Tappxbanner.setRefreshTimeSeconds(45);

                Tappxbanner.setListener(new TappxBannerListener() {
                    @Override
                    public void onBannerLoaded(
                            TappxBanner tappxBanner) {
                        Ad_Layout.setVisibility(View.VISIBLE);

                        SharedPreferences.setsplashcount(
                                Contextt,
                                (SharedPreferences.getsplashcount(Contextt) + 1));

                    }

                    @Override
                    public void onBannerLoadFailed(
                            TappxBanner tappxBanner,
                            TappxAdError tappxAdError) {

                        Ad_Layout.setVisibility(View.GONE);
                        SO_Banner(Ad_Layout, Banner_Type);

                    }

                    @Override
                    public void onBannerClicked(
                            TappxBanner tappxBanner) {
                        Ad_Layout.setVisibility(View.GONE);
                    }

                    @Override
                    public void onBannerExpanded(
                            TappxBanner tappxBanner) {
                    }

                    @Override
                    public void onBannerCollapsed(
                            TappxBanner tappxBanner) {
                    }
                });


            }
        });


    }

    public void Exit_With_Ads_Native(final Context context) {

        if (Exit_Menu_Decided == 0) {

            onBackPressed(context);

        } else if (Exit_Menu_Decided == 1) {

            Exit("Do You Want To Exit ?", context,
                    "" + context.getString(R.string.app_name));

        } else if (Exit_Menu_Decided == 2) {

            Exit_Popup_With_Ads_Native(context);

        } else if (Exit_Menu_Decided == 3) {

            Exit("Do You Want To Exit ?", context,
                    "" + context.getString(R.string.app_name));

        } else if (Exit_Menu_Decided == 4) {

            Exit_Popup_With_Ads_Native(context);

        } else if (Exit_Menu_Decided == 100) {

            onBackPressed(context);

        } else {

            onBackPressed(context);

        }

    }

    @SuppressLint("SetTextI18n")
    public void Exit_Popup_With_Ads_Native(final Context context) {

        int Native_Type = 2;

        String Description = "Do You Want To Exit ?";

        final android.app.Dialog dialog = new android.app.Dialog(context);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        if (dialog.getWindow() != null)
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.setCancelable(true);
        dialog.setContentView(R.layout.exitt);

        TextView text = (TextView) dialog.findViewById(R.id.title);
        text.setText(Description);

        RelativeLayout Exit_Ads = (RelativeLayout) dialog.findViewById(R.id.banner);
        Native_Back(context, Exit_Ads, Native_Type, 0, 0, 0);

        Button Btn_Yes = (Button) dialog.findViewById(R.id.Btn_Yes);
        Button Btn_Rate = (Button) dialog.findViewById(R.id.Btn_Rate);
        Button Btn_No = (Button) dialog.findViewById(R.id.Btn_No);

        Btn_Yes.setText("Yes");
        Btn_Rate.setText("Rate Us");
        Btn_No.setText("No");

        Btn_Yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                ((Activity) context).moveTaskToBack(true);
                ((Activity) context).finish();
            }
        });
        Btn_Rate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("market://details?id="
                        + Packages);
                Intent goToMarket = new Intent(
                        Intent.ACTION_VIEW, uri);

                goToMarket
                        .addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY
                                | Intent.FLAG_ACTIVITY_MULTIPLE_TASK);
                try {
                    context.startActivity(goToMarket);
                } catch (ActivityNotFoundException e) {
                    context.startActivity(new Intent(
                            Intent.ACTION_VIEW,
                            Uri.parse("http://play.google.com/OneForAll/apps/details?id="
                                    + Packages)));
                }
            }
        });
        Btn_No.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        dialog.show();


    }

    public void Native_Back(Context nContext, final RelativeLayout Ad_Layout, int Native_Type, int Bottom_Ad_Margin, int Top_Ad_Margin, int Animation) {


        if (Exit_Menu_Decided == 100) {

            return;
        }

        if (isNetworkConnected(Contextt) == true) {

            final Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {

                    if (Server_Yes_No == 1 || Server_Yes_No == 0) {


                        Native_Back_Setup1(nContext, Ad_Layout, Native_Type, Bottom_Ad_Margin, Top_Ad_Margin, Animation);

                    } else {

                        handler.postDelayed(this, 500);

                    }

                }

            }, 500);

        } else {

            Ad_Layout.setVisibility(View.GONE);

        }

    }

    public void Native_Back_Setup1(Context nContext, final RelativeLayout Ad_Layout, int Native_Type, int Bottom_Ad_Margin, int Top_Ad_Margin, int Animation) {

        if (Exit_Menu_Decided == 100) {

            return;
        }

        if ((SharedPreferences.getSetup(Contextt)).equals("1")) {


            if (SharedPreferences.getNN1(nContext) == 0) {

                Native_ID = SharedPreferences.getN11(nContext);

                SharedPreferences.setNN1(nContext, 1);


            } else {

                Native_ID = SharedPreferences.getN111(nContext);

                SharedPreferences.setNN1(nContext, 0);


            }
        } else if ((SharedPreferences.getSetup(Contextt)).equals("0")) {


            if (SharedPreferences.getnative(nContext) == 0) {

                Native_ID = SharedPreferences.getnative1(nContext);

                SharedPreferences.setnative(nContext, 1);


            } else {

                Native_ID = SharedPreferences.getnative2(nContext);

                SharedPreferences.setnative(nContext, 0);


            }

        }
        AdLoader adLoader = new AdLoader.Builder(nContext, Native_ID)
                .forNativeAd(new NativeAd.OnNativeAdLoadedListener() {
                    private ColorDrawable background;

                    @Override
                    public void onNativeAdLoaded(NativeAd nativeAd) {
                        NativeStyle styles = new
                                NativeStyle.Builder().withMainBackgroundColor(background).build();


                        NativeTemplateView nativeTemplateView = new NativeTemplateView(nContext, Native_Type);

                        nativeTemplateView.setStyles(styles);
                        nativeTemplateView.setNativeAd(nativeAd);

                        Ad_Layout.removeAllViews();
                        Ad_Layout.addView(nativeTemplateView);

                        nativeTemplateView.setVisibility(View.VISIBLE);

                    }

                })
                .withAdListener(new AdListener() {
                    @Override
                    public void onAdFailedToLoad(LoadAdError adError) {

                        Ad_Layout.removeAllViews();


                        Native_Back_Setup2(nContext, Ad_Layout, Native_Type, Bottom_Ad_Margin, Top_Ad_Margin, Animation);


                    }
                })
                .withNativeAdOptions(new NativeAdOptions.Builder()

                        .build())
                .build();

        adLoader.loadAd(new AdRequest.Builder().build());

    }

    public void Native_Back_Setup2(Context nContext, final RelativeLayout Ad_Layout, int Native_Type, int Bottom_Ad_Margin, int Top_Ad_Margin, int Animation) {

        if (Exit_Menu_Decided == 100) {

            return;
        }
        if ((SharedPreferences.getSetup(Contextt)).equals("1")) {


            if (SharedPreferences.getNN2(nContext) == 0) {

                Native_ID = SharedPreferences.getN22(nContext);

                SharedPreferences.setNN2(nContext, 1);


            } else {

                Native_ID = SharedPreferences.getN222(nContext);

                SharedPreferences.setNN2(nContext, 0);


            }
        } else if ((SharedPreferences.getSetup(Contextt)).equals("0")) {


            if (SharedPreferences.getnative(nContext) == 0) {

                Native_ID = SharedPreferences.getnative1(nContext);

                SharedPreferences.setnative(nContext, 1);


            } else {

                Native_ID = SharedPreferences.getnative2(nContext);

                SharedPreferences.setnative(nContext, 0);


            }

        }
        AdLoader adLoader = new AdLoader.Builder(nContext, Native_ID)
                .forNativeAd(new NativeAd.OnNativeAdLoadedListener() {
                    private ColorDrawable background;

                    @Override
                    public void onNativeAdLoaded(NativeAd nativeAd) {
                        NativeStyle styles = new
                                NativeStyle.Builder().withMainBackgroundColor(background).build();


                        NativeTemplateView nativeTemplateView = new NativeTemplateView(nContext, Native_Type);

                        nativeTemplateView.setStyles(styles);
                        nativeTemplateView.setNativeAd(nativeAd);

                        Ad_Layout.removeAllViews();
                        Ad_Layout.addView(nativeTemplateView);

                        nativeTemplateView.setVisibility(View.VISIBLE);

                    }

                })
                .withAdListener(new AdListener() {
                    @Override
                    public void onAdFailedToLoad(LoadAdError adError) {

                        Ad_Layout.removeAllViews();


                        Native_Back_Setup3(nContext, Ad_Layout, Native_Type, Bottom_Ad_Margin, Top_Ad_Margin, Animation);


                    }
                })
                .withNativeAdOptions(new NativeAdOptions.Builder()

                        .build())
                .build();

        adLoader.loadAd(new AdRequest.Builder().build());

    }

    public void Native_Back_Setup3(Context nContext, final RelativeLayout Ad_Layout, int Native_Type, int Bottom_Ad_Margin, int Top_Ad_Margin, int Animation) {

        if (Exit_Menu_Decided == 100) {

            return;
        }
        if ((SharedPreferences.getSetup(Contextt)).equals("1")) {


            if (SharedPreferences.getNN3(nContext) == 0) {

                Native_ID = SharedPreferences.getN33(nContext);

                SharedPreferences.setNN3(nContext, 1);


            } else {

                Native_ID = SharedPreferences.getN333(nContext);

                SharedPreferences.setNN3(nContext, 0);


            }
        } else if ((SharedPreferences.getSetup(Contextt)).equals("0")) {


            if (SharedPreferences.getnative(nContext) == 0) {

                Native_ID = SharedPreferences.getnative1(nContext);

                SharedPreferences.setnative(nContext, 1);


            } else {

                Native_ID = SharedPreferences.getnative2(nContext);

                SharedPreferences.setnative(nContext, 0);


            }

        }
        AdLoader adLoader = new AdLoader.Builder(nContext, Native_ID)
                .forNativeAd(new NativeAd.OnNativeAdLoadedListener() {
                    private ColorDrawable background;

                    @Override
                    public void onNativeAdLoaded(NativeAd nativeAd) {
                        NativeStyle styles = new
                                NativeStyle.Builder().withMainBackgroundColor(background).build();


                        NativeTemplateView nativeTemplateView = new NativeTemplateView(nContext, Native_Type);

                        nativeTemplateView.setStyles(styles);
                        nativeTemplateView.setNativeAd(nativeAd);

                        Ad_Layout.removeAllViews();
                        Ad_Layout.addView(nativeTemplateView);

                        nativeTemplateView.setVisibility(View.VISIBLE);

                    }

                })
                .withAdListener(new AdListener() {
                    @Override
                    public void onAdFailedToLoad(LoadAdError adError) {

                        Ad_Layout.removeAllViews();


                        Banner_Back_Setup1(Ad_Layout, 4);


                    }
                })
                .withNativeAdOptions(new NativeAdOptions.Builder()

                        .build())
                .build();

        adLoader.loadAd(new AdRequest.Builder().build());

    }

    private void Ad_Popup(Context mContext, String Title_Text_Of_Popup) {
        // TODO Auto-generated method stub

        Ad_ProgressDialog = ProgressDialog.show(mContext, "", ""
                + Title_Text_Of_Popup, true);
        Ad_ProgressDialog.getWindow().setBackgroundDrawable(
                new ColorDrawable(Color.TRANSPARENT));
        Ad_ProgressDialog.setCancelable(true);
        Ad_ProgressDialog.show();

    }

    public void Rate_App_Randomly(Context mContext) {
        // TODO Auto-generated method stub

        if ((new Random().nextInt((20 - 1) + 1) + 1) == 10) {
            Rate_App(mContext);
        }

    }

    public void Rate_App(final Context mContext) {
        // TODO Auto-generated method stub

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                mContext);

        // set the title
        alertDialogBuilder.setTitle("" + mContext.getString(R.string.app_name));

        // set dialog message
        alertDialogBuilder
                .setMessage("Please Rate Our Application")
                .setCancelable(true)
                .setPositiveButton("Yes",
                        new DialogInterface.OnClickListener() {
                            @SuppressLint("InlinedApi")
                            public void onClick(DialogInterface dialog, int id) {
                                // what to do if YES is tapped
                                Uri uri = Uri.parse("market://details?id="
                                        + mContext.getPackageName());
                                Intent goToMarket = new Intent(
                                        Intent.ACTION_VIEW, uri);

                                goToMarket
                                        .addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY
                                                | Intent.FLAG_ACTIVITY_MULTIPLE_TASK);
                                try {
                                    mContext.startActivity(goToMarket);
                                } catch (ActivityNotFoundException e) {
                                    mContext.startActivity(new Intent(
                                            Intent.ACTION_VIEW,
                                            Uri.parse("http://play.google.com/OneForAll/apps/details?id="
                                                    + mContext.getPackageName())));
                                }
                            }
                        })

                .setNeutralButton("Remind Me Later",
                        new DialogInterface.OnClickListener() {
                            @SuppressLint("InlinedApi")
                            public void onClick(DialogInterface dialog, int id) {
                                // code to do on Remind Me Later tapped
                                dialog.cancel();

                            }
                        })

                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // code to do on NO tapped
                        dialog.cancel();
                    }
                });

        AlertDialog alertDialog = alertDialogBuilder.create();

        alertDialog.show();

    }

    private boolean isNetworkConnected(Context aContext) {
        ConnectivityManager cm = (ConnectivityManager) aContext
                .getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        boolean isConnected = activeNetwork != null
                && activeNetwork.isConnectedOrConnecting();
        return isConnected;
    }

    public void onBackPressed(Context aContext) {

        if (doubleBackToExitPressedOnce) {
            ((Activity) aContext).moveTaskToBack(true);
            ((Activity) aContext).finish();
        } else {

            Toast.makeText(aContext, "Press Back Again to Exit",
                    Toast.LENGTH_SHORT).show();

            doubleBackToExitPressedOnce = true;
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    doubleBackToExitPressedOnce = false;
                }
            }, 2000);

        }

    }

    public void After_2_3(Context aContext) {

        if (Exit_Menu_Decided == 100) {

            return;
        }

        if (Exit_Menu_Decided == 3) {

            Pre_Interstial_Show(aContext);

        }

        if (Exit_Menu_Decided == 4) {

            Pre_Interstial_Show(aContext);

        }

    }

    public void onDestroy(Context aContext) {

        if (Splash_tappxInterstitial_preload != null) {
            Splash_tappxInterstitial_preload.destroy();
        }
        if (tappxInterstitial != null) {
            tappxInterstitial.destroy();
        }
        if (Tappxbanner != null) {
            Tappxbanner.destroy();
        }
        if (tappxInterstitial_preload != null) {
            tappxInterstitial_preload.destroy();
        }
        if (Pre_Tappxbanner != null) {
            Pre_Tappxbanner.destroy();
        }
        if (Splash_InterstialAd != null) {
        }
        if (InterstialAd != null) {
        }
        if (InterstialAd1 != null) {
        }
        if (InterstialAd_Setup3 != null) {
        }
        if (InterstialAd_Setup2 != null) {
        }
        if (InterstialAd_Setup1 != null) {
        }
        if (mAdView != null) {
            mAdView.destroy();
        }
        if (mAdView_exit != null) {
            mAdView_exit.destroy();
        }
        if (mRewardedAd != null) {
        }
        if (mrewardedInterstitialAd != null) {
        }
        if (rewardedInterstitialAd != null) {
        }
    }

    public void SO_Banner(final RelativeLayout Ad_Layout, final int Banner_Type) {

        if (Banner_Type == 1) {

            final Banner SO_Banner = new Banner(Contextt);
            SO_Banner.setBannerListener(new BannerListener() {
                @Override
                public void onReceiveAd(View view) {
                    Ad_Layout.setVisibility(View.VISIBLE);
                }

                @Override
                public void onFailedToReceiveAd(View view) {
                    Ad_Layout.setVisibility(View.GONE);
                }

                @Override
                public void onImpression(View view) {

                }

                @Override
                public void onClick(View view) {
                    Ad_Layout.setVisibility(View.GONE);
                }
            });
            Ad_Layout.addView(SO_Banner);

        } else {

            final Mrec SO_Banner = new Mrec(Contextt);
            SO_Banner.setBannerListener(new BannerListener() {
                @Override
                public void onReceiveAd(View view) {
                    Ad_Layout.setVisibility(View.VISIBLE);
                }

                @Override
                public void onFailedToReceiveAd(View view) {
                    Ad_Layout.setVisibility(View.GONE);
                }

                @Override
                public void onImpression(View view) {

                }

                @Override
                public void onClick(View view) {
                    Ad_Layout.setVisibility(View.GONE);
                }
            });
            Ad_Layout.addView(SO_Banner);

        }


    }

    public interface OnRewardgetListner {
        public void OnReward(boolean b);   //method, which can have parameters
    }

    private class GetData extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            // Showing progress dialog

        }

        @Override
        protected Void doInBackground(Void... arg0) {
            HttpHandler sh = new HttpHandler();

            String jsonStr = sh.makeServiceCall("" + Server);

            if (jsonStr != null) {
                try {
                    JSONObject jsonObj = new JSONObject(jsonStr);

                    // Getting JSON Array node
                    JSONArray contacts = jsonObj.getJSONArray("" + Packages);

                    // looping through All Contacts
                    for (int i = 0; i < contacts.length(); i++) {
                        JSONObject c = contacts.getJSONObject(i);


                        String id = c.getString("exit_popup");
                        String tx = c.getString("tx");
                        String b1 = c.getString("b1");
                        String b2 = c.getString("b2");
                        String i1 = c.getString("i1");
                        String i2 = c.getString("i2");
                        String na1 = c.getString("na1");
                        String na2 = c.getString("na2");
                        String aid = c.getString("aid");
                        String ao = c.getString("ao");
                        String rd = c.getString("rd");
                        String ird = c.getString("ird");
                        String extra1 = c.getString("extra1");
                        String extra2 = c.getString("extra2");

                        String setup = c.getString("setup");
                        String b11 = c.getString("b11");
                        String b111 = c.getString("b111");
                        String b22 = c.getString("b22");
                        String b222 = c.getString("b222");
                        String b33 = c.getString("b33");
                        String b333 = c.getString("b333");
                        String i11 = c.getString("i11");
                        String i111 = c.getString("i111");
                        String i22 = c.getString("i22");
                        String i222 = c.getString("i222");
                        String i33 = c.getString("i33");
                        String i333 = c.getString("i333");
                        String n11 = c.getString("n11");
                        String n111 = c.getString("n111");
                        String n22 = c.getString("n22");
                        String n222 = c.getString("n222");
                        String n33 = c.getString("n33");
                        String n333 = c.getString("n333");
                        String ao11 = c.getString("ao11");
                        String ao111 = c.getString("ao111");
                        String ao22 = c.getString("ao22");
                        String ao222 = c.getString("ao222");
                        String ao33 = c.getString("ao33");
                        String ao333 = c.getString("ao333");
                        String rd11 = c.getString("rd11");
                        String rd111 = c.getString("rd111");
                        String rd22 = c.getString("rd22");
                        String rd222 = c.getString("rd222");
                        String rd33 = c.getString("rd33");
                        String rd333 = c.getString("rd333");
                        String ird11 = c.getString("ird11");
                        String ird111 = c.getString("ird111");
                        String ird22 = c.getString("ird22");
                        String ird222 = c.getString("ird222");
                        String ird33 = c.getString("ird33");
                        String ird333 = c.getString("ird333");

                        HashMap<String, String> contact = new HashMap<String, String>();

                        contact.put("exit_popup", id);
                        contact.put("tx", tx);
                        contact.put("b1", b1);
                        contact.put("b2", b2);
                        contact.put("i1", i1);
                        contact.put("i2", i2);
                        contact.put("na1", na1);
                        contact.put("na2", na2);
                        contact.put("aid", aid);
                        contact.put("ao", ao);
                        contact.put("rd", rd);
                        contact.put("ird", ird);
                        contact.put("extra1", extra1);
                        contact.put("extra2", extra2);

                        contact.put("setup", setup);
                        contact.put("b11", b11);
                        contact.put("b111", b111);
                        contact.put("b22", b22);
                        contact.put("b222", b222);
                        contact.put("b33", b33);
                        contact.put("b333", b333);
                        contact.put("i11", i11);
                        contact.put("i111", i111);
                        contact.put("i22", i22);
                        contact.put("i222", i222);
                        contact.put("i33", i33);
                        contact.put("i333", i333);
                        contact.put("n11", n11);
                        contact.put("n111", n111);
                        contact.put("n22", n22);
                        contact.put("n222", n222);
                        contact.put("n33", n33);
                        contact.put("n333", n333);
                        contact.put("ao11", ao11);
                        contact.put("ao111", ao111);
                        contact.put("ao22", ao22);
                        contact.put("ao222", ao222);
                        contact.put("ao33", ao33);
                        contact.put("ao333", ao333);
                        contact.put("rd11", rd11);
                        contact.put("rd111", rd111);
                        contact.put("rd22", rd22);
                        contact.put("rd222", rd222);
                        contact.put("rd33", rd33);
                        contact.put("rd333", rd333);
                        contact.put("ird11", ird11);
                        contact.put("ird111", ird111);
                        contact.put("ird22", ird22);
                        contact.put("ird222", ird222);
                        contact.put("ird33", ird33);
                        contact.put("ird333", ird333);


                        contactList.add(contact);


                    }
                } catch (final JSONException e) {

                }
            } else {

            }

            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
            // Dismiss the progress dialog

            if (contactList.size() > 0) {

                Exit_Menu_Decided = Integer.parseInt(contactList.get(0).get("exit_popup"));

                SharedPreferences.setincreseeee(Contextt, Exit_Menu_Decided);

                TX = "" + contactList.get(0).get("tx");
                BR1 = "" + contactList.get(0).get("b1");
                BR2 = "" + contactList.get(0).get("b2");
                IN1 = "" + contactList.get(0).get("i1");
                IN2 = "" + contactList.get(0).get("i2");
                NA1 = "" + contactList.get(0).get("na1");
                NA2 = "" + contactList.get(0).get("na2");
                AID = "" + contactList.get(0).get("aid");
                AO = "" + contactList.get(0).get("ao");
                RD = "" + contactList.get(0).get("rd");
                IRD = "" + contactList.get(0).get("ird");
                EX1 = "" + contactList.get(0).get("extra1");
                EX2 = "" + contactList.get(0).get("extra2");

                Setup = "" + contactList.get(0).get("setup");
                B11 = "" + contactList.get(0).get("b11");
                B111 = "" + contactList.get(0).get("b111");
                B22 = "" + contactList.get(0).get("b22");
                B222 = "" + contactList.get(0).get("b222");
                B33 = "" + contactList.get(0).get("b33");
                B333 = "" + contactList.get(0).get("b333");
                I11 = "" + contactList.get(0).get("i11");
                I111 = "" + contactList.get(0).get("i111");
                I22 = "" + contactList.get(0).get("i22");
                I222 = "" + contactList.get(0).get("i222");
                I33 = "" + contactList.get(0).get("i33");
                I333 = "" + contactList.get(0).get("i333");
                N11 = "" + contactList.get(0).get("n11");
                N111 = "" + contactList.get(0).get("n111");
                N22 = "" + contactList.get(0).get("n22");
                N222 = "" + contactList.get(0).get("n222");
                N33 = "" + contactList.get(0).get("n33");
                N333 = "" + contactList.get(0).get("n333");
                AO11 = "" + contactList.get(0).get("ao11");
                AO111 = "" + contactList.get(0).get("ao111");
                AO22 = "" + contactList.get(0).get("ao22");
                AO222 = "" + contactList.get(0).get("ao222");
                AO33 = "" + contactList.get(0).get("ao33");
                AO333 = "" + contactList.get(0).get("ao333");
                RD11 = "" + contactList.get(0).get("rd11");
                RD111 = "" + contactList.get(0).get("rd111");
                RD22 = "" + contactList.get(0).get("rd22");
                RD222 = "" + contactList.get(0).get("rd222");
                RD33 = "" + contactList.get(0).get("rd33");
                RD333 = "" + contactList.get(0).get("rd333");
                IRD11 = "" + contactList.get(0).get("ird11");
                IRD111 = "" + contactList.get(0).get("ird111");
                IRD22 = "" + contactList.get(0).get("ird22");
                IRD222 = "" + contactList.get(0).get("ird222");
                IRD33 = "" + contactList.get(0).get("ird33");
                IRD333 = "" + contactList.get(0).get("ird333");

                SharedPreferences.settx(Contextt, "" + TX);
                SharedPreferences.setbanner1(Contextt, "" + BR1);
                SharedPreferences.setbanner2(Contextt, "" + BR2);
                SharedPreferences.setinter1(Contextt, "" + IN1);
                SharedPreferences.setinter2(Contextt, "" + IN2);
                SharedPreferences.setnative1(Contextt, "" + NA1);
                SharedPreferences.setnative2(Contextt, "" + NA2);
                SharedPreferences.setapp_id(Contextt, "" + AID);
                SharedPreferences.setapp_open(Contextt, "" + AO);
                SharedPreferences.setreward(Contextt, "" + RD);
                SharedPreferences.setinter_reward(Contextt, "" + IRD);
                SharedPreferences.setextra1(Contextt, "" + EX1);
                SharedPreferences.setextra2(Contextt, "" + EX2);

                SharedPreferences.setSetup(Contextt, "" + Setup);
                SharedPreferences.setB11(Contextt, "" + B11);
                SharedPreferences.setB111(Contextt, "" + B111);
                SharedPreferences.setB22(Contextt, "" + B22);
                SharedPreferences.setB222(Contextt, "" + B222);
                SharedPreferences.setB33(Contextt, "" + B33);
                SharedPreferences.setB333(Contextt, "" + B333);
                SharedPreferences.setI11(Contextt, "" + I11);
                SharedPreferences.setI111(Contextt, "" + I111);
                SharedPreferences.setI22(Contextt, "" + I22);
                SharedPreferences.setI222(Contextt, "" + I222);
                SharedPreferences.setI33(Contextt, "" + I33);
                SharedPreferences.setI333(Contextt, "" + I333);
                SharedPreferences.setN11(Contextt, "" + N11);
                SharedPreferences.setN111(Contextt, "" + N111);
                SharedPreferences.setN22(Contextt, "" + N22);
                SharedPreferences.setN222(Contextt, "" + N222);
                SharedPreferences.setN33(Contextt, "" + N33);
                SharedPreferences.setN333(Contextt, "" + N333);
                SharedPreferences.setAO11(Contextt, "" + AO11);
                SharedPreferences.setAO111(Contextt, "" + AO111);
                SharedPreferences.setAO22(Contextt, "" + AO22);
                SharedPreferences.setAO222(Contextt, "" + AO222);
                SharedPreferences.setAO33(Contextt, "" + AO33);
                SharedPreferences.setAO333(Contextt, "" + AO333);
                SharedPreferences.setRD11(Contextt, "" + RD11);
                SharedPreferences.setRD111(Contextt, "" + RD111);
                SharedPreferences.setRD22(Contextt, "" + RD22);
                SharedPreferences.setRD222(Contextt, "" + RD222);
                SharedPreferences.setRD33(Contextt, "" + RD33);
                SharedPreferences.setRD333(Contextt, "" + RD333);
                SharedPreferences.setIRD11(Contextt, "" + IRD11);
                SharedPreferences.setIRD111(Contextt, "" + IRD111);
                SharedPreferences.setIRD22(Contextt, "" + IRD22);
                SharedPreferences.setIRD222(Contextt, "" + IRD222);
                SharedPreferences.setIRD33(Contextt, "" + IRD33);
                SharedPreferences.setIRD333(Contextt, "" + IRD333);


                Server_Yes_No = 1;


                if (Exit_Menu_Decided == 100) {


                } else {

                    if ((SharedPreferences.getapp_id(Contextt)).equals("ca-app-pub-3940256099942544~3347511713")) {

                    } else {

                        MobileAds.initialize(Contextt, SharedPreferences.getapp_id(Contextt));

                    }

                    if ((SharedPreferences.getextra1(Contextt)).equals("1")) {

                        if ((SharedPreferences.getSetup(Contextt)).equals("1")) {


                            Load_Inter_Setup1(Contextt);

                        } else if ((SharedPreferences.getSetup(Contextt)).equals("0")) {


                            Pre_Interstial_Load_Normal(Contextt);

                        }


                    } else if ((SharedPreferences.getextra1(Contextt)).equals("2")) {

                        if ((SharedPreferences.getSetup(Contextt)).equals("1")) {

                            Pre_App_Open_Load_Setup3(Contextt);


                        } else if ((SharedPreferences.getSetup(Contextt)).equals("0")) {


                            Pre_App_Open_Load_Normal(Contextt);

                        }


                    } else if ((SharedPreferences.getextra1(Contextt)).equals("3")) {

                        Load_Inter_Setup1(Contextt);

                        Pre_App_Open_Load_Setup3(Contextt);

                        Pre_Interstial_Load_Normal(Contextt);

                        Pre_App_Open_Load_Normal(Contextt);

                    } else {

                        Load_Inter_Setup1(Contextt);

                        Pre_App_Open_Load_Setup3(Contextt);

                        Pre_Interstial_Load_Normal(Contextt);

                        Pre_App_Open_Load_Normal(Contextt);

                    }
                }


            }

            if (contactList.size() == 0) {


                SharedPreferences.settx(Contextt, "" + Tx_ID);
                SharedPreferences.setbanner1(Contextt, "" + Banner1);
                SharedPreferences.setbanner2(Contextt, "" + Banner2);
                SharedPreferences.setinter1(Contextt, "" + Interstial1);
                SharedPreferences.setinter2(Contextt, "" + Interstial2);
                SharedPreferences.setnative1(Contextt, "" + Native_ID1);
                SharedPreferences.setnative2(Contextt, "" + Native_ID2);
                SharedPreferences.setapp_id(Contextt, "" + APP_ID);
                SharedPreferences.setapp_open(Contextt, "" + APP_OPEN);
                SharedPreferences.setreward(Contextt, "" + REWARD);
                SharedPreferences.setinter_reward(Contextt, "" + INTER_REWARD);
                SharedPreferences.setextra1(Contextt, "" + EXTRA1);
                SharedPreferences.setextra2(Contextt, "" + EXTRA2);

                SharedPreferences.setSetup(Contextt, "" + Setup_ID);
                SharedPreferences.setB11(Contextt, "" + B11_ID);
                SharedPreferences.setB111(Contextt, "" + B111_ID);
                SharedPreferences.setB22(Contextt, "" + B22_ID);
                SharedPreferences.setB222(Contextt, "" + B222_ID);
                SharedPreferences.setB33(Contextt, "" + B33_ID);
                SharedPreferences.setB333(Contextt, "" + B333_ID);
                SharedPreferences.setI11(Contextt, "" + I11_ID);
                SharedPreferences.setI111(Contextt, "" + I111_ID);
                SharedPreferences.setI22(Contextt, "" + I22_ID);
                SharedPreferences.setI222(Contextt, "" + I222_ID);
                SharedPreferences.setI33(Contextt, "" + I33_ID);
                SharedPreferences.setI333(Contextt, "" + I333_ID);
                SharedPreferences.setN11(Contextt, "" + N11_ID);
                SharedPreferences.setN111(Contextt, "" + N111_ID);
                SharedPreferences.setN22(Contextt, "" + N22_ID);
                SharedPreferences.setN222(Contextt, "" + N222_ID);
                SharedPreferences.setN33(Contextt, "" + N33_ID);
                SharedPreferences.setN333(Contextt, "" + N333_ID);
                SharedPreferences.setAO11(Contextt, "" + AO11_ID);
                SharedPreferences.setAO111(Contextt, "" + AO111_ID);
                SharedPreferences.setAO22(Contextt, "" + AO22_ID);
                SharedPreferences.setAO222(Contextt, "" + AO222_ID);
                SharedPreferences.setAO33(Contextt, "" + AO33_ID);
                SharedPreferences.setAO333(Contextt, "" + AO333_ID);
                SharedPreferences.setRD11(Contextt, "" + RD11_ID);
                SharedPreferences.setRD111(Contextt, "" + RD111_ID);
                SharedPreferences.setRD22(Contextt, "" + RD22_ID);
                SharedPreferences.setRD222(Contextt, "" + RD222_ID);
                SharedPreferences.setRD33(Contextt, "" + RD33_ID);
                SharedPreferences.setRD333(Contextt, "" + RD333_ID);
                SharedPreferences.setIRD11(Contextt, "" + IRD11_ID);
                SharedPreferences.setIRD111(Contextt, "" + IRD111_ID);
                SharedPreferences.setIRD22(Contextt, "" + IRD22_ID);
                SharedPreferences.setIRD222(Contextt, "" + IRD222_ID);
                SharedPreferences.setIRD33(Contextt, "" + IRD33_ID);
                SharedPreferences.setIRD333(Contextt, "" + IRD333_ID);

                if ((SharedPreferences.getapp_id(Contextt)).equals("ca-app-pub-3940256099942544~3347511713")) {

                } else {

                    MobileAds.initialize(Contextt, SharedPreferences.getapp_id(Contextt));

                }

                Exit_Menu_Decided = 0;

                Server_Yes_No = 0;

                if ((SharedPreferences.getextra1(Contextt)).equals("1")) {

                    if ((SharedPreferences.getSetup(Contextt)).equals("1")) {

                        Load_Inter_Setup1(Contextt);

                    } else if ((SharedPreferences.getSetup(Contextt)).equals("0")) {

                        Pre_Interstial_Load_Normal(Contextt);

                    }

                } else if ((SharedPreferences.getextra1(Contextt)).equals("2")) {

                    if ((SharedPreferences.getSetup(Contextt)).equals("1")) {

                        Pre_App_Open_Load_Setup3(Contextt);

                    } else if ((SharedPreferences.getSetup(Contextt)).equals("0")) {

                        Pre_App_Open_Load_Normal(Contextt);

                    }


                } else if ((SharedPreferences.getextra1(Contextt)).equals("3")) {

                    if ((SharedPreferences.getSetup(Contextt)).equals("1")) {

                        Load_Inter_Setup1(Contextt);

                        Pre_App_Open_Load_Setup3(Contextt);

                    } else if ((SharedPreferences.getSetup(Contextt)).equals("0")) {

                        Pre_Interstial_Load_Normal(Contextt);

                        Pre_App_Open_Load_Normal(Contextt);

                    }


                } else {

                    if ((SharedPreferences.getSetup(Contextt)).equals("1")) {

                        Load_Inter_Setup1(Contextt);

                        Pre_App_Open_Load_Setup3(Contextt);

                    } else if ((SharedPreferences.getSetup(Contextt)).equals("0")) {

                        Pre_Interstial_Load_Normal(Contextt);

                        Pre_App_Open_Load_Normal(Contextt);

                    }

                }

            }

        }

    }

    public class HttpHandler {

        public HttpHandler() {
        }

        public String makeServiceCall(String reqUrl) {
            String response = null;
            try {
                URL url = new URL(reqUrl);
                HttpURLConnection conn = (HttpURLConnection) url
                        .openConnection();
                conn.setRequestMethod("GET");

                InputStream in = new BufferedInputStream(conn.getInputStream());
                response = convertStreamToString(in);
            } catch (MalformedURLException e) {

            } catch (ProtocolException e) {

            } catch (IOException e) {

            } catch (Exception e) {

            }
            return response;
        }

        private String convertStreamToString(InputStream is) {
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(is));
            StringBuilder sb = new StringBuilder();

            String line;
            try {
                while ((line = reader.readLine()) != null) {
                    sb.append(line).append('\n');
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            return sb.toString();
        }
    }
}