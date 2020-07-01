from django.shortcuts import render, redirect, get_object_or_404
from .forms import ImgForm, BoxForm
from images.models import Image, Box, ImageUserTagBox
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

def save_position(request, image_pk):
    image = get_object_or_404(Image, pk=image_pk)
    # positionList = request.POST
    # form = BoxForm(request.POST)
    # if request.method == "POST":
    #     box = form.save(commit=False)
    # print(request.POST)
    positions = request.POST.get('position').split(',')
    for position in positions:
        strs = position.split('/')
        print(int(round(float(strs[2]))))

        saveBox = Box.objects.create(lefttopx=strs[0], lefttopy=int(round(float(strs[1]))), rightbotx=strs[2], rightboty=int(round(float(strs[3]))))
        ImageUserTagBox.objects.create(image=image, user=request.user, box=saveBox)

    return redirect('boxing:nontag')

def save_img(request):
    if request.method == "POST":
        form = ImgForm(files=request.FILES)
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