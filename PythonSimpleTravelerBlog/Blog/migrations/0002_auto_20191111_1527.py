# Generated by Django 2.2.7 on 2019-11-11 14:27

from django.db import migrations, models


class Migration(migrations.Migration):

    dependencies = [
        ('Blog', '0001_initial'),
    ]

    operations = [
        migrations.AddField(
            model_name='post',
            name='city',
            field=models.CharField(default='Somewhere', max_length=50),
        ),
        migrations.AddField(
            model_name='post',
            name='title',
            field=models.CharField(default='Title', max_length=200),
        ),
    ]