// Install the Java helper library from twilio.com/docs/java/install
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;

import com.twilio.Twilio;
import com.twilio.http.HttpMethod;
import com.twilio.rest.api.v2010.account.Call;
import com.twilio.type.PhoneNumber;

public class Example {
  // Find your Account Sid and Token at twilio.com/user/account
  public static final String ACCOUNT_SID = "ACXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX";
  public static final String AUTH_TOKEN = "your_auth_token";

  public static void main(String[] args) throws URISyntaxException {
    Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

    List<String> callbackEvents = Arrays.asList("initiated", "ringing", "answered", "completed");

    Call call = Call
        .creator(new PhoneNumber("+14155551212"), new PhoneNumber("+18668675310"),
            new URI("http://demo.twilio.com/docs/voice.xml"))
        .setMethod(HttpMethod.GET).setStatusCallback("https://www.myapp.com/events")
        .setStatusCallbackMethod(HttpMethod.POST).setStatusCallbackEvent(callbackEvents).create();

    System.out.println(call.getSid());
  }
}
