from django import forms
from images.models import Image, Box

class ImgForm(forms.ModelForm):
    class Meta:
        model = Image
        # fields = '__all__'
        exclude = ['status']

class BoxForm(forms.ModelForm):
    class Meta:
        model = Box
        fields = '__all__'