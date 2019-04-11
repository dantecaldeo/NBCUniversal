# NBCUniversal
Goal: To test the new /search endpoint

- Test the API Root
	https://images-api.nasa.gov/
	Expected Result: 2 curly brackets on the page
			 no error messages

- Test for the HTTP status code
	https://images-api.nasa.gov/search?q=space
		Expected Result: 200
	https://images-api.nasa.gov/search/q=asd
		Expected Result: 404	
	//TODO
	//hit invalid endpoints

- Test for all the allowed search parameters
	for example, ?q=text, ?center=text, ?description=text
		Expected Result: Collection+Json / Content

- Test for the correct search parameter value
	for example, year_start should have a valid year 
	/search?year_start=text
		Expected Result: Invalid value year_start

- Test for search parameters that are not allowed.
	?notallowed=text
		Expected Result: 404


Unexpected Issues / Concerns:
- Endpoint should check for SQL Injections, Cross-Site Scripting
- If all of the search parameters are used, the Response is going to be big, performance, up time may suffer









