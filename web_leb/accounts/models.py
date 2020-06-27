from django.db import models
from django.conf import settings
from django.contrib.auth.models import AbstractUser
from phonenumber_field.modelfields import PhoneNumberField

# Create your models here.
class User(AbstractUser):
    phone = PhoneNumberField(null=False, blank=False, unique=True)
    birth = models.CharField(max_length=6)
    gender = models.CharField(max_length=2)