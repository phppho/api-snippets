// Get the Node helper library from https://twilio.com/docs/libraries/node
// Get your Account SID and Auth Token from https://twilio.com/console
// To set up environmental variables, see http://twil.io/secure
const accountSid = process.env.TWILIO_ACCOUNT_SID;
const authToken = process.env.TWILIO_AUTH_TOKEN;

const client = require('twilio')(accountSid, authToken);

client.proxy
  .services('KSXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX')
  .sessions('KCXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX')
  .participants('KPXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX')
  .messageInteractions.create({
    body: 'Reply to this message to chat!',
  })
  .then(response => {
    console.log(response);
  })
  .catch(err => {
    console.log(err);
  });
