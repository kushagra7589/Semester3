
import RPi.GPIO as GPIO
import MFRC522
import signal
import time
continue_reading = True
import urllib2

url = "http://192.168.57.55:8000/home/"

MIFAREReader = MFRC522.MFRC522()
GPIO.setwarnings(False)
try:
	while continue_reading:
   	
		(status,TagType) = MIFAREReader.MFRC522_Request(MIFAREReader.PICC_REQIDL)

		if status == MIFAREReader.MI_OK:
			pass        
    
		(status,uid) = MIFAREReader.MFRC522_Anticoll()

		if status == MIFAREReader.MI_OK:

			uid = str(uid[0])+","+str(uid[1])+","+str(uid[2])+","+str(uid[3])
			url += uid
#			print uid
			response = urllib2.urlopen(url)
			data = response.read()
			print data
			continue_reading = False
			GPIO.cleanup()
except : 
	print "exiting"
