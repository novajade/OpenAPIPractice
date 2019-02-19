Retrofit2 & OpenAPI Practice

purpose to practice and learn how to use retrofit, openAPI and JSON.

trying to use NAVER's search API to receive JSON data and parse it.

02-17: 
it was struggling with data class which is not match to the NAVER's JSON format.
was keep receiving "expected BEGIN_ARRAY but was BEGIN_OBJECT" error.
so the problem i have was my data Class's format, and the format when i call the data.
i was using "Call<List<MovieData>> call = blablabla " <- this was the main problem.

     
02-19:
now it shows images with picasso api, and added the keyboard search feature that not needed to using button to search the keyword.
it was my first time using Picasso api, so i found that if you are using it without .error().placeHolder() method,
it will crash and shows runtime error. i think this error is causing when the image is not fully loaded or is null, and the ViewAdapter is trying to put this into ImageView. 
And the feature using keyboard to search the keyword, i think android dev should update this event when xml file is including imeOptions, and let it trigger the event if the editText is on the View.
