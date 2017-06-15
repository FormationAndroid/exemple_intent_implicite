package teamgeny.com.intentsimplicitesexemples;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId())
        {
            case R.id.btn_browser:
                openBrowser();
                break;
            case R.id.btn_SMS:
                sendSMS();
                break;
            case R.id.btn_Email:
                sendEmail();
                break;
        }
    }

    public void openBrowser() {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com"));
        startActivity(browserIntent);
    }

    public void sendSMS() {
        Intent sendSMSIntent = new Intent(Intent.ACTION_VIEW);
        sendSMSIntent.setData(Uri.parse("sms:"));
        sendSMSIntent.putExtra("sms_body", "bla bla bla");
        startActivity(sendSMSIntent);
    }

    public void sendEmail() {
        Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto","abc@gmail.com", null));
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Sujet");
        emailIntent.putExtra(Intent.EXTRA_TEXT, "Bla bla bla");
        startActivity(Intent.createChooser(emailIntent, "Envoyer email..."));
    }

}
