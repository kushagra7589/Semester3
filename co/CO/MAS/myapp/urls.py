from django.conf.urls import url

from . import views

urlpatterns = [
	url(r'^home/(?P<uid>\d+(,\d+)*)', views.home, name="home")
]