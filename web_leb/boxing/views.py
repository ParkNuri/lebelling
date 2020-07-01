from django.shortcuts import render, redirect, get_object_or_404
from .forms import ImgForm
from images.models import Image
import random

# Create your views here.
def boxing(request):
    return render(request, 'boxing/index.html')

def tag(request):
    return render(request, 'boxing/tag.html')

def non_tag(request):
    images = Image.objects.all()
    image = random.choice(images)
    context = {
        'image' : image
    }
    return render(request, 'boxing/nontag.html', context)

def save_position(request):
    return redirect('boxing:non_tag')

def img(request):
    if request.method == "POST":
        form = ImgForm(request.FILES)
        if form.is_valid():
            image = form.save(commit=False)
            image.status = 0
            image.save()
            return redirect('boxing:menu')
    else: 
        form = ImgForm()
    context = {
        'form' : form
    }
    return render(request, 'boxing/imgupload.html', context)