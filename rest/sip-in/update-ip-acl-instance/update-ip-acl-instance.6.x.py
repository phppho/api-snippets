# Download the Python helper library from twilio.com/docs/python/install
import os
from twilio.rest import Client

# Your Account Sid and Auth Token from twilio.com/user/account
# To set up environmental variables, see http://twil.io/secure
account_sid = os.environ['TWILIO_ACCOUNT_SID']
auth_token = os.environ['TWILIO_AUTH_TOKEN']
client = Client(account_sid, auth_token)

# Get an object from its sid. If you do not have a sid,
# check out the list resource examples on this page
ip_access_control_list = client.sip \
    .ip_access_control_lists("AL32a3c49700934481addd5ce1659f04d2") \
    .update("Avons Lieutenants")

print(ip_access_control_list.friendly_name)
