# OTP SERVICE

## CREATE .env file and update the env file

MYSQL_HOST=
MYSQL_USER=
MYSQL_PASSWORD=
DB_NAME=

ADMIN_EMAIL=
ADMIN_PASSWORD=

## Create SQL Tables

1) go to app/resources/db.sql file
2) copy and execute the sql statements in the file to create SQL tables
3) create new sql user for this application and update the hostname,user,password,db_name in the .env file
4) update the table names (if changes made in table names while table creation) - go to app/config/db_tables.js

## Change Email

if you want to change the email address from which you
want to send email do the following steps

1) create new google account
2) add two step verification
3) go to https://myaccounts.google.com/apppasswords
4) create new app - now a password will be generated for the app
5) change the ADMIN_PASSWORD in the .env file