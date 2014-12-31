package io.sixth.imgur9000.login;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;

import com.squareup.otto.Bus;

import io.sixth.imgur9000.util.BusProvider;
import io.sixth.imgur9000.util.Constants;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginActivity extends Activity {

    private WebView mWebView;
    private Bus bus;

    private static final Pattern accessTokenPattern = Pattern.compile("access_token=([^&]*)");
    private static final Pattern refreshTokenPattern = Pattern.compile("refresh_token=([^&]*)");
    private static final Pattern expiresInPattern = Pattern.compile("expires_in=(\\d+)");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        bus = BusProvider.getInstance();

        FrameLayout root = new FrameLayout(this);
        mWebView = new WebView(this);
        root.addView(mWebView);
        setContentView(root);

        setupWebView();

        mWebView.loadUrl("https://api.imgur.com/oauth2/authorize?client_id=" + Constants.CLIENT_ID + "&response_type=token");
    }

    private void setupWebView() {
        mWebView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                // intercept the tokens
                // http://example.com#access_token=ACCESS_TOKEN&token_type=Bearer&expires_in=3600
                boolean tokensURL = false;
                if (url.startsWith(Constants.REDIRECT_URL)) {
                    tokensURL = true;
                    Matcher m;

                    m = refreshTokenPattern.matcher(url);
                    m.find();
                    String refreshToken = m.group(1);

                    m = accessTokenPattern.matcher(url);
                    m.find();
                    String accessToken = m.group(1);

                    m = expiresInPattern.matcher(url);
                    m.find();
                    long expiresIn = Long.valueOf(m.group(1));

                    ImgurAuthorization.getInstance().saveRefreshToken(refreshToken, accessToken, expiresIn);

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            bus.post("Logged In");
                            finish();
                        }
                    });
                }
                return tokensURL;
            }
        });
    }

}
