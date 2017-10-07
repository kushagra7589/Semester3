from django.shortcuts import render
from django.http import HttpResponse
from .models import Student, Coupons
import datetime

# Create your views here.

def home(request, uid):
	c = Coupons.objects.get(UID=uid)
	s = c.student
	# print(s)
	now1 = datetime.datetime.now()
	now = now1.hour
	now = int(now)
	now += 5
	output = ""
	print ("hh:mm:ss format = {}:{}:{}".format(now1.hour, now1.month, now1.second) )
	if(now > 5 and now < 12):
		c.breakfast -= 1;
		output += "breakfast : {}".format(c.breakfast)
	elif(now > 12 and now < 15):
		c.lunch -= 1
		output += "lunch : {}".format(c.lunch)
	elif(now > 16 and now < 19):
		c.eveningtea -= 1
		output += "evening tea : {}".format(c.eveningtea)
	elif(now > 19 and now < 23):
		c.dinner -= 1
		output += "dinner : {}".format(c.dinner)
	else :
		output = "No food"
	print (output)
	c.save()

	return HttpResponse(output)