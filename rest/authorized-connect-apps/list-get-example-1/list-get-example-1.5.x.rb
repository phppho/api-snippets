# Get twilio-ruby from twilio.com/docs/ruby/install
require 'twilio-ruby'

# Get your Account Sid and Auth Token from https://www.twilio.com/console
account_sid = 'ACXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX'
auth_token = 'your_auth_token'

# Initialize Twilio Client
@client = Twilio::REST::Client.new(account_sid, auth_token)

# Loop over authorized_apps and print out a property for each one
@client.api.v2010.accounts(account_sid).authorized_connect_apps.list
       .each do |authorized_app|
         puts authorized_app.connect_app_homepage_url
       end