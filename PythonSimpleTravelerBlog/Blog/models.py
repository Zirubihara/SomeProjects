import datetime

from django.db import models
from django.utils import timezone
from django.contrib.auth.models import User

STATUS = (
    (0,"Draft"),
    (1,"Publish")
)

class Post(models.Model):
    title = models.CharField(max_length=200, unique=True, default='Title')
    slug = models.CharField(max_length=200, unique=True, default='slug')
    text = models.CharField(max_length=2000)
    country = models.CharField(max_length=50)
    city = models.CharField(max_length=50, default='Somewhere')
    pub_date = models.DateTimeField('date published')
    status = models.IntegerField(choices=STATUS, default=0)

    def __str__(self):
        return self.text
    def was_published_recently(self):
        return self.pub_date >= timezone.now() - datetime.timedelta(days=1)

class Comment(models.Model):
    post = models.ForeignKey(Post,on_delete=models.CASCADE,related_name='comments')
    name = models.CharField(max_length=80)
    email = models.EmailField()
    comment_text = models.TextField()
    created = models.DateTimeField(auto_now_add=True)
    active = models.BooleanField(default=False)

    class Meta:
        ordering = ['created']

    def __str__(self):
        return 'Comment {} by {}'.format(self.comment_text, self.name)


# Create your models here.
