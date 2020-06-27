from django.db import models
from django.conf import settings
from django.contrib.auth.models import AbstractUser
from phonenumber_field.modelfields import PhoneNumberField

# Create your models here.
class User(AbstractUser):
    phone = PhoneNumberField(null=False, blank=False, unique=True)
    birth = models.DateField()
    gender = models.CharField(max_length=2)

class Point(models.Model):
    #(적립, 소모) 건 by 건으로 저장.
    username = models.ForeignKey(User, on_delete=models.CASCADE)
    occurpoint = models.IntegerField()
    occurdate = models.DateField(auto_now_add=True)
