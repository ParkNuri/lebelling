from django.urls import path
from . import views

app_name = "taging"

urlpatterns = [
    path('images/', views.images, name="images"),
]