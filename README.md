# Questions to be solved by coding

1 - Write a function that will flatten an array of arbitrarily nested arrays of integers into a flat array of integers. e.g. [[1,2,[3]],4] → [1,2,3,4]. If the language you're using has a function to flatten arrays, you should pretend it doesn't exist.

2 - We have some customer records in a text file (customers.json) -- one customer per line, JSON-encoded. We want to invite any customer within 100km of our Dublin office for some food and drinks on us. Write a program that will read the full list of customers and output the names and user ids of matching customers (within 100km), sorted by User ID (ascending).
 - You can use the first formula from this Wikipedia article to calculate distance. 
 - Don't forget, you'll need to convert degrees to radians.
 - The GPS coordinates for our Dublin office are 53.3381985, -6.2592576.
