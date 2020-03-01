from django.conf import settings
from django.contrib.auth import views as auth_views
from django.urls import path
from django.conf.urls import url
from django.conf import settings
from django.contrib.auth.views import LogoutView

from . import views

urlpatterns = [
    path('', views.EventList.as_view(), name='event_list'),
    path('view/<uuid:pk>', views.EventView.as_view(), name='event_view'),
    path('new/', views.EventCreate.as_view(), name='event_new'),
    path('update/<uuid:pk>', views.EventUpdate.as_view(), name='event_update'),
    path('delete/<uuid:pk>', views.EventDelete.as_view(), name='event_delete'),
    path('logout/',LogoutView.as_view(),{'next_page': settings.LOGOUT_REDIRECT_URL}, name='logout'),
    path('login/', views.appLogin,  name="login"),
    path('register/', views.appReg, name="register"),
]
