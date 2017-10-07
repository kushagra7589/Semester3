import urllib2

url = "http://localhost:8000/home/100,91,126,185"

response = urllib2.urlopen(url)

data = response.read()

print(data)