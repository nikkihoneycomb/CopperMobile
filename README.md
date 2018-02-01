# CopperMobile
A working version of an app that will simulate a user being able to sign in with their email
and password and upon successful sign in be brought to their account profile screen where they
can see they can simply view their first name, last name, and email.

----------------------------------------#MVVM #RXJAVA #MOCKITO #DATABINDING---------------------------------------------------------------

Preferred Libraries
Android Data Binding Library
RXJava
Mockito

Android Specs
Utilized Android Studio for the IDE
build the project towards API 26 (Android M)
App can easily be run on any simulator or hardware

SignInRequest:
+public email
+public password

SignInResponse:
+public int statusCode

ProfileResponse:
+public String firstName
+public String lastName
+public String email
+public int statusCode

I have taken a sample URL where the parameter is "TOKEN" instead of "STATUS_CODE"


Testing at ViewModel level of MVVM:
JUNIT
MOCKITO
