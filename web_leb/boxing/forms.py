from django import forms
from images.models import Image

class ImgForm(forms.ModelForm):
    class Meta:
        model = Image
        # fields = '__all__'
        exclude = ['status']