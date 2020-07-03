from django.shortcuts import render, redirect
import os
import random
from django import template
from django.conf import settings
from images.models import Image, Tag, ImageUserTagBox
from accounts.models import User
from django.views.decorators.http import require_POST
from django.db.models import Count

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
    else:
        allimage = Image.objects.all()
        image = random.choice(list(allimage))
        context = {
            'image' : image.image.url,
            'image_pk' : image.pk
        }
        return render(request, 'taging/images.html',context)

@require_POST
def addtag(request, image_pk):
    user = User.objects.get(username=request.user)
    image = Image.objects.get(pk=image_pk)

    datalen = len(list(request.POST))
    datalist = request.POST.getlist('tag')
    for data in datalist:
        try:
            #tag = Tag.objects.filter(name=data)
            tag = Tag.objects.get(name=data)
        except:
            tag = Tag.objects.create(name=data)
        imagetag = ImageUserTagBox.objects.create(user=user,image=image,tag=tag)

    return redirect('taging:images')

def test(request):
    # delimage = Image.objects.filter(image='')
    # delimage.delete()
    # print(delimage)
    image = Image.objects.order_by('?').first()
    tags = image.tags.annotate(tag_count=Count('name')).order_by('-tag_count')
    context = {
        'image' : image.image.url,
        'tags' : tags
    }
    return render(request, 'taging/test.html', context)