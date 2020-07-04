from django.urls import path
from . import views

app_name = "yesorno"

urlpatterns = [
    path('info/', views.yesnoinfo, name="yesnoinfo"),
]