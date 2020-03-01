from django import forms


class LoginForm(forms.Form):
    loginClass = forms.TextInput(attrs={'class': 'form-control'})
    passwordClass = forms.PasswordInput(attrs={'class': 'form-control'})
    login = forms.CharField(widget=loginClass, label='Loginaaaaaaaaaaaa', max_length=50, required=True)
    password = forms.CharField(widget=passwordClass, label='Passwordaa', max_length=50, required=True)


class EventForm(forms.Form):
    textClass = forms.TextInput(attrs={'class': 'form-control'})
    eventName = forms.CharField(widget=textClass, label='Loginaaaaaaaaaaaa', max_length=50, required=True)
    eventDate = forms.CharField(widget=textClass, label='Loginaaaaaaaaaaaa1', max_length=50, required=True)
    pubDate = forms.CharField(widget=textClass, label='Loginaaaaaaaaaaaa2', max_length=50, required=True)
    tresc = forms.CharField(widget=forms.TextInput(attrs={'size': 70}), label='Loginaaaaaaaaaaaa3', max_length=5000,
                            required=True)
    location = forms.CharField(widget=textClass, label='Loginaaaaaaaaaaaa4', max_length=50, required=True)
    iloscMiejsc = forms.CharField(widget=textClass, label='Loginaaaaaaaaaaaa5', max_length=50, required=True)
    cenaBiletu = forms.CharField(widget=textClass, label='Loginaaaaaaaaaaaa6', max_length=50, required=True)


class RegisterForm(forms.Form):
    txtClass = forms.TextInput(attrs={'class': 'form-control'})
    passwordClass = forms.PasswordInput(attrs={'class': 'form-control'})
    emailClass = forms.EmailInput(attrs={'class': 'form-control'})
    login = forms.CharField(widget=txtClass, label="Login", max_length=50, required=True)
    email = forms.EmailField(widget=emailClass, label="Email", max_length=500, required=True)
    password = forms.CharField(widget=passwordClass, label="Password", max_length=50, required=True)


class UzytkownikForm(forms.Form):
    txtClass = forms.TextInput(attrs={'class': 'form-control'})
    numberClass = forms.NumberInput(attrs={'class': 'form-control'})
    imie = forms.CharField(widget=txtClass, label="Imie", max_length=30, required=True)
    nazwisko = forms.CharField(widget=txtClass, label="Nazwisko", max_length=30, required=True)
    telefon = forms.IntegerField(widget=numberClass, label="Numer telefonu", required=True)
    opis = forms.CharField(widget=txtClass, label="Opis samego siebie", max_length=2000, required=True)