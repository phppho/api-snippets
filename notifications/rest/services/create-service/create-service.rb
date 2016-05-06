# Get twilio-ruby from twilio.com/docs/ruby/install
require 'twilio-ruby'

# Get your Account Sid and Auth Token from twilio.com/user/account
account_sid = '{twilio account sid}'
auth_token = '{twilio auth token}'
client = Twilio::REST::Client.new account_sid, auth_token

service = client.notifications.v1.services.create(:friendly_name => "My Awesome Service")

puts service
