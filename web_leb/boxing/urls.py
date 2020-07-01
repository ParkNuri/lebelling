from django.urls import path
from . import views

app_name = "boxing"

urlpatterns = [
    path('', views.boxing, name="menu"),
    path('box/', views.tag, name="tag"),
    path('non_box/', views.non_tag, name="nontag"),
    path('save_position/', views.save_position, name="save_position"),
    path('img/', views.img, name="img"),
]