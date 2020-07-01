from django.shortcuts import render, redirect
import os
import random
from django import template
from django.conf import settings


# Create your views here.
def images(request):
    if request.method == 'POST':
        datalen = len(list(request.POST))
        datalist = list(request.POST)
        #print(len(list(request.POST)))
        #print(list(request.POST))
        for i in range(1,datalen):
            print(datalist[i])
    return render(request, 'taging/images.html')


# def random_image():
#     print('*****random_image()******')
#     try:
#         valid_extensions = settings.RANDOM_IMAGE_EXTENSIONS
#     except AttributeError:
#         valid_extensions = ['.jpg','.jpeg','.png','.gif',]

#     rand_dir = os.path.join(settings.BASE_DIR, settings.RANDOM_IMAGE_DIR)
#     print(rand_dir)
#     print(os.listdir(rand_dir))
#     files = [f for f in os.listdir(rand_dir) if os.path.splitext(f)[1] in valid_extensions]

#     return "/static" + "/" + settings.RANDOM_IMAGE_DIR + "/" + random.choice(files)