package com.yzu.kevinchang.twelveconstellationtransfer_numpicker;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.NumberPicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private LinearLayout llMain;
    private LinearLayout llInput;
    private LinearLayout llNumPicker;
    private NumberPicker npMon;
    private NumberPicker npDate;
    private Button btnGo;
    private WebView wv;
    private ProgressDialog pd;
    public String url = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        llMain = (LinearLayout) findViewById(R.id.mainlayout);
        wv = (WebView) findViewById(R.id.webView);
        wv.setWebViewClient(new mywebview());
        pd = new ProgressDialog(this);

        llInput = (LinearLayout) findViewById(R.id.inputLayout);
        llInput.setWeightSum(1);

        // Dynamically creat LinearLayout llNumPicker.
        llNumPicker = new LinearLayout(this);
        llNumPicker.setGravity(LinearLayout.HORIZONTAL);
        llNumPicker.setWeightSum(1);

        // Dynamically creat Button btnGo.
        btnGo = new Button(this);
        btnGo.setText("GO !");

        // Dynamically creat NumberPicker npMon, set Max / min value.
        npMon = new NumberPicker(this);
        npMon.setMinValue(1);
        npMon.setMaxValue(12);
        npMon.setDescendantFocusability(NumberPicker.FOCUS_BLOCK_DESCENDANTS); // Hide keyboard
        // Reference : http://stackoverflow.com/questions/8854781/disable-soft-keyboard-on-numberpicker

        // Dynamically creat NumberPicker npDate, set Max / min value.
        npDate = new NumberPicker(this);
        npDate.setMinValue(1);
        npDate.setMaxValue(31);
        npDate.setDescendantFocusability(NumberPicker.FOCUS_BLOCK_DESCENDANTS); // Hide keyboard
        // Reference : http://stackoverflow.com/questions/8854781/disable-soft-keyboard-on-numberpicker

        // Add to layout and set layoutparams ( width / height / weight ).
        llInput.addView(llNumPicker, new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT, 0.9f));
        llNumPicker.addView(npMon, new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.MATCH_PARENT, 0.5f));
        llNumPicker.addView(npDate, new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.MATCH_PARENT, 0.5f));
        llInput.addView(btnGo, new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT, 0.1f));

        btnGo.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer mon = npMon.getValue();
                Integer day = npDate.getValue();

                switch (mon) {
                    case 1:
                        if (day >= 1 && day <= 20) {
                            // 摩羯座 Capricorn (the Goat)
                            url = "https://zh.wikipedia.org/wiki/%E6%91%A9%E7%BE%AF%E5%BA%A7";
                        } else if (day >= 21 && day <= 31) {
                            // 水瓶座 Aquarius (the Water Carrier)
                            url = "https://zh.wikipedia.org/wiki/%E5%AF%B6%E7%93%B6%E5%BA%A7";
                        }
                        break;
                    case 2:
                        if (day >= 1 && day <= 19) {
                            // 水瓶座 Aquarius (the Water Carrier)
                            url = "https://zh.wikipedia.org/wiki/%E5%AF%B6%E7%93%B6%E5%BA%A7";
                        } else if (day >= 20 && day <= 29) {
                            // 雙魚座 Pisces (the Fishes)
                            url = "https://zh.wikipedia.org/wiki/%E5%8F%8C%E9%B1%BC%E5%BA%A7";
                        } else url = "";
                        break;
                    case 3:
                        if (day >= 1 && day <= 20) {
                            // 雙魚座 Pisces (the Fishes)
                            url = "https://zh.wikipedia.org/wiki/%E5%8F%8C%E9%B1%BC%E5%BA%A7";
                        } else if (day >= 21 && day <= 31) {
                            // 牡羊座 Aries (the Ram)
                            url = "https://zh.wikipedia.org/wiki/%E7%99%BD%E7%BE%8A%E5%BA%A7";
                        } else url = "";
                        break;
                    case 4:
                        if (day >= 1 && day <= 20) {
                            // 牡羊座 Aries (the Ram)
                            url = "https://zh.wikipedia.org/wiki/%E7%99%BD%E7%BE%8A%E5%BA%A7";
                        } else if (day >= 21 && day <= 30) {
                            // 金牛座 Taurus (the Bull)
                            url = "https://zh.wikipedia.org/wiki/%E9%87%91%E7%89%9B%E5%BA%A7";
                        } else url = "";
                        break;
                    case 5:
                        if (day >= 1 && day <= 21) {
                            // 金牛座 Taurus (the Bull)
                            url = "https://zh.wikipedia.org/wiki/%E9%87%91%E7%89%9B%E5%BA%A7";
                        } else if (day >= 22 && day <= 31) {
                            // 雙子座 Gemini (the Twins)
                            url = "https://zh.wikipedia.org/wiki/%E5%8F%8C%E5%AD%90%E5%BA%A7";
                        } else url = "";
                        break;
                    case 6:
                        if (day >= 1 && day <= 21) {
                            // 雙子座 Gemini (the Twins)
                            url = "https://zh.wikipedia.org/wiki/%E5%8F%8C%E5%AD%90%E5%BA%A7";
                        } else if (day >= 22 && day <= 30) {
                            // 巨蠍座 Cancer (the Crab)
                            url = "https://zh.wikipedia.org/wiki/%E5%B7%A8%E8%9F%B9%E5%BA%A7";
                        } else url = "";
                        break;
                    case 7:
                        if (day >= 1 && day <= 23) {
                            // 巨蠍座 Cancer (the Crab)
                            url = "https://zh.wikipedia.org/wiki/%E5%B7%A8%E8%9F%B9%E5%BA%A7";
                        } else if (day >= 24 && day <= 31) {
                            // 獅子座 Leo (the Lion)
                            url = "https://zh.wikipedia.org/wiki/%E7%8B%AE%E5%AD%90%E5%BA%A7";
                        } else url = "";
                        break;
                    case 8:
                        if (day >= 1 && day <= 23) {
                            // 獅子座 Leo (the Lion)
                            url = "https://zh.wikipedia.org/wiki/%E7%8B%AE%E5%AD%90%E5%BA%A7";
                        } else if (day >= 24 && day <= 31) {
                            // 處女座 Virgo (the Virgin)
                            url = "https://zh.wikipedia.org/wiki/%E5%AE%A4%E5%A5%B3%E5%BA%A7";
                        } else url = "";
                        break;
                    case 9:
                        if (day >= 1 && day <= 23) {
                            // 處女座 Virgo (the Virgin)
                            url = "https://zh.wikipedia.org/wiki/%E5%AE%A4%E5%A5%B3%E5%BA%A7";
                        } else if (day >= 24 && day <= 30) {
                            // 天秤座 Libra (the Scales)
                            url = "https://zh.wikipedia.org/wiki/%E5%A4%A9%E7%A7%A4%E5%BA%A7";
                        } else url = "";
                        break;
                    case 10:
                        if (day >= 1 && day <= 23) {
                            // 天秤座 Libra (the Scales)
                            url = "https://zh.wikipedia.org/wiki/%E5%A4%A9%E7%A7%A4%E5%BA%A7";
                        } else if (day >= 24 && day <= 31) {
                            // 天蠍座 Scorpio (the Scorpion)
                            url = "https://zh.wikipedia.org/wiki/%E5%A4%A9%E8%9D%8E%E5%BA%A7";
                        } else url = "";
                        break;
                    case 11:
                        if (day >= 1 && day <= 22) {
                            // 天蠍座 Scorpio (the Scorpion)
                            url = "https://zh.wikipedia.org/wiki/%E5%A4%A9%E8%9D%8E%E5%BA%A7";
                        } else if (day >= 23 && day <= 30) {
                            // 射手座 Sagittarius (the Archer)
                            url = "https://zh.wikipedia.org/wiki/%E4%BA%BA%E9%A9%AC%E5%BA%A7";
                        } else url = "";
                        break;
                    case 12:
                        if (day >= 1 && day <= 22) {
                            // 射手座 Sagittarius (the Archer)
                            url = "https://zh.wikipedia.org/wiki/%E4%BA%BA%E9%A9%AC%E5%BA%A7";
                        } else if (day >= 23 && day <= 31) {
                            // 摩羯座 Capricorn (the Goat)
                            url = "https://zh.wikipedia.org/wiki/%E6%91%A9%E7%BE%AF%E5%BA%A7";
                        } else url = "";
                        break;
                }
                // Reference: Wikipedia -

                if (url == "")
                    webviewError(); // Show error msg.
                else
                    webviewLoad(url); // Load url.
            }
        });
    }

    // Load website
    public void webviewLoad(String url) {
        pd.setMessage("loading...");
        pd.show();
        wv.loadUrl(url);
    }

    // Show error message
    public void webviewError() {
        pd.setMessage("loading...");
        pd.show();
        String html = "<html><head></head><body><h1>Error !</h1><hr>"
                     +"<h2>Please double check, and input right month / date !</h2></body></html>";
        wv.loadData(html, "text/html", null);
    }

    @Override
    public void onBackPressed() {
        if (wv.canGoBack())
            wv.goBack();
        else
            super.onBackPressed();
    }

    private class mywebview extends WebViewClient {
        public mywebview() {
        }

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
            view.loadUrl(request.getUrl().toString());
            return super.shouldOverrideUrlLoading(view, request);
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            if (pd.isShowing())
                pd.dismiss();
            super.onPageFinished(view, url);
        }

        @Override
        public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
            Toast.makeText(view.getContext(), "Error", Toast.LENGTH_LONG).show();
            super.onReceivedError(view, request, error);
        }
    }
}

// Github URL: https://github.com/d900139/TwelveConstellationTransfer-NumPicker