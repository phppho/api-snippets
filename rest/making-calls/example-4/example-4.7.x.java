// Install the Java helper library from twilio.com/docs/java/install
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;

import com.twilio.Twilio;
import com.twilio.http.HttpMethod;
import com.twilio.rest.api.v2010.account.Call;
import com.twilio.type.PhoneNumber;

import static com.google.common.collect.Lists.newArrayList;

public class Example {
    // Get your Account SID and Auth Token from https://twilio.com/console
    // To set up environment variables, see http://twil.io/secure
    public static final String ACCOUNT_SID = System.getenv("TWILIO_ACCOUNT_SID");
    public static final String AUTH_TOKEN = System.getenv("TWILIO_AUTH_TOKEN");

    public static void main(String[] args) throws URISyntaxException {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

        ArrayList<String> callbackEvents = newArrayList(
            "initiated",
            "ringing",
            "answered",
            "completed"
        );

        Call call = Call
            .creator(
                new PhoneNumber("+14155551212"),
                new PhoneNumber("+18668675310"),
                new URI("http://demo.twilio.com/docs/voice.xml")
            )
            .setMethod(HttpMethod.GET)
            .setStatusCallback("https://www.myapp.com/events")
            .setStatusCallbackMethod(HttpMethod.POST)
            .setStatusCallbackEvent(callbackEvents)
            .create();

        System.out.println(call.getSid());
    }
}
