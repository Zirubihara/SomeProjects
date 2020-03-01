from django.contrib import admin
from .models import Event

# Register your models here.
class EventAdmin(admin.ModelAdmin):
    list_display = ('eventName','eventDate','pubDate')
    list_filter = ('eventName',)
    search_fields = ['eventName', 'eventDate']

admin.site.register(Event, EventAdmin)