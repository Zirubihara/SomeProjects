from django.shortcuts import render
from django.views import generic, View

from .forms import LoginForm, UzytkownikForm, RegisterForm
from .models import Event, Uzytkownik
from django.shortcuts import render, redirect
from django.http import HttpResponse, request
from django.contrib import messages
from django.views import generic, View
from django.template import loader
from django.contrib.auth import authenticate, login, logout
from django.contrib.auth.forms import User
from django.views.generic import ListView, DetailView
from django.views.generic.edit import CreateView, UpdateView, DeleteView
from django.urls import reverse_lazy
from django.contrib.auth import authenticate, login, logout
from django.contrib.auth.decorators import login_required
from django.contrib.auth.mixins import LoginRequiredMixin

# Create your views here.
class EventList(ListView):
    model = Event


class EventView(DetailView):
    model = Event

class EventCreate(LoginRequiredMixin, CreateView):
    login_url = '/login/'
    redirect_field_name = 'redirect_to'
    model = Event
    fields = ['eventName', 'eventDate', 'pubDate', 'tresc', 'location', 'iloscMiejsc', 'cenaBiletu']
    success_url = reverse_lazy('event_list')


class EventUpdate(UpdateView):
    model = Event
    fields = ['eventName', 'eventDate', 'pubDate', 'tresc', 'location', 'iloscMiejsc', 'cenaBiletu']
    success_url = reverse_lazy('event_list')

class EventDelete(DeleteView):
    model = Event
    success_url = reverse_lazy('event_list')

# class welcome(request):
#     if(request.user.is_authenticated):
#         return HttpResponse("Hihi")
#     else:
#         return HttpResponse("zaloguj sie")

def welcome (request):
    if(request.user.is_authenticated):
        return HttpResponse ("Czesc"+request.user.username)
    else:
        return HttpResponse ("Zaloguj")

def appLogin(request):
    if request.method == "POST":
        form = LoginForm(request.POST)
        if form.is_valid():
            username = request.POST["login"]
            password = request.POST["password"]
            user = authenticate(request, username=username, password=password)
            if user is not None:
                login(request, user)
                messages.success(request, 'Zalogowany pomyslnie')
            else:
                messages.warning(request, 'Wprowadzono błędne dane')
    if (request.user.is_authenticated):
        return redirect('event_list')
    else:
        form = LoginForm()
        return render(request, 'loginApp.html', {'form': form})


def appReg(request):
    if request.method=="POST":
        form = LoginForm(request.POST)
        if form.is_valid():
            username = request.POST["login"]
            email = request.POST["email"]
            password = request.POST["password"]
            imie = request.POST["imie"]
            nazwisko = request.POST["nazwisko"]
            telefon = request.POST["telefon"]
            opis = request.POST["opis"]
            user, created = User.objects.get_or_create(username=username,email=email)
            if created:
                Uzytkownik.user=user
                Uzytkownik.imie = imie
                Uzytkownik.nazwisko = nazwisko
                Uzytkownik.telefon = telefon
                Uzytkownik.opis = opis
                Uzytkownik.user.set_password(password)
                Uzytkownik.user.save()
                return redirect('/eventapp/login')
            else:
                messages.warning(request,"Użytkownik istnieje już w bazie!")
    if(not request.user.is_authenticated):
        form = RegisterForm()
        form2 = UzytkownikForm()
        return render(request,'registerApp.html',{'form':form,'form2':form2})
    else:
        return redirect('login/')

def logout(request):
    logout(request)
    return redirect('new/')