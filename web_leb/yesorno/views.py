from django.shortcuts import render
from images.models import ImageUserTagBox

# Create your views here.
def yesnoinfo(request):
    images = ImageUserTagBox.objects.exclude(image=None).exclude(box=None).exclude(tag=None)
    context = {
        'images' : images
    }
    return render(request, 'yesorno/info.html', context)