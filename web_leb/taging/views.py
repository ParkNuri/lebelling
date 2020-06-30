from django.shortcuts import render, redirect


# Create your views here.
def images(request):
    if request.method == 'POST':
        print(request.POST.length)
    return render(request, 'taging/images.html')