Retrofit2 & OpenAPI Practice

purpose to practice and learn how to use retrofit, openAPI and JSON.

trying to use NAVER's search API to receive JSON data and parse it.

02-17: 
it was struggling with data class which is not match to the NAVER's JSON format.
was keep receiving "expected BEGIN_ARRAY but was BEGIN_OBJECT" error.
so the problem i have was my data Class's format, and the format when i call the data.
i was using "Call<List<MovieData>> call = blablabla " <- this was the main problem.

     
