from django.db import models

# Create your models here.
class Student(models.Model):
	name   = models.CharField(max_length = 200)
	roll_no = models.IntegerField(default = 0)

	def __str__(self):
		return "{} ({})".format(self.name, self.roll_no)

class Coupons(models.Model):
	student = models.ForeignKey(Student, on_delete=models.CASCADE)

	UID = models.CharField(max_length = 30, default = "0,0,0,0")

	year  = models.IntegerField(default = 0)
	month = models.IntegerField(default = 0)

	breakfast  = models.IntegerField(default = 0)
	lunch      = models.IntegerField(default = 0)
	eveningtea = models.IntegerField(default = 0)
	dinner     = models.IntegerField(default = 0)

	def __str__(self):
		return "{} | {}".format(self.student.name, self.UID)