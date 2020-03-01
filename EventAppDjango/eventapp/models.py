import uuid

from django.contrib.auth.models import User
from django.db import models


# Create your models here.
class Uzytkownik(models.Model):
    user = models.OneToOneField(User, on_delete=models.CASCADE)
    id = models.UUIDField(primary_key=True, default=uuid.uuid4, editable=False)
    imie = models.CharField(max_length=30,verbose_name=("Imie"))
    nazwisko = models.CharField(max_length=30,verbose_name=("Nazwisko"))
    adresEmail = models.EmailField(unique=True, verbose_name=("Email"))
    telefon = models.IntegerField(unique=True, blank=True, verbose_name=("Telefon"))
    # branza
    # lokalizacja
    opis = models.CharField(max_length=2000, verbose_name=("Opis"))


class Location(models.Model):
    city = models.CharField(max_length=30)
    street = models.CharField(max_length=40)
    buildingNumber = models.IntegerField()
    apartamentNumber = models.IntegerField(blank=True)


class Contact(models.Model):
    phoneNumber = models.IntegerField(blank=True)
    email = models.EmailField(unique=True)


class Event(models.Model):
    id = models.UUIDField(primary_key=True, default=uuid.uuid4, editable=False)
    eventName = models.CharField(max_length=150,verbose_name=('Nazwa eventu'))
    eventDate = models.DateTimeField(blank=False, verbose_name=("Data Eventu"))
    pubDate = models.DateField(blank=False)
    tresc = models.CharField(max_length=2000, verbose_name="Opis Eventu")
    #user = models.ManyToManyField(User)
    #location = models.ManyToOneRel(Location)
    location = models.CharField(max_length=150, verbose_name=("Lokalizacja Eventu"))
    iloscMiejsc = models.IntegerField(verbose_name="Maksymalna ilość uczestników")
    # organizator
    cenaBiletu = models.DecimalField(max_digits=4, decimal_places=2, verbose_name="Cena Biletu")


class Organizer(models.Model):
    id = models.UUIDField(primary_key=True, default=uuid.uuid4, editable=False)
    # lokalizacja
    # branza
    telefon = models.IntegerField(unique=True, blank=True)
    email = models.EmailField(unique=True)
    # eventy
    # prac



