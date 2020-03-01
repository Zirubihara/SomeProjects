from django.contrib import admin
from .models import Post, Comment


class PostAdmin(admin.ModelAdmin):
    list_display = ('title', 'slug', 'country', 'city', 'pub_date', 'status')
    list_filter = ('status',)
    search_fields = ['title', 'content']
    prepopulated_fields = {'slug': ('title',)}


class CommentAdmin(admin.ModelAdmin):
    list_display = ('name', 'comment_text', 'post', 'created', 'active')
    list_filter = ('active', 'created')
    search_fields = ('name', 'email', 'comment_text')
    actions = ['approve_comments']

    def approve_comments(self, request, queryset):
        queryset.upadte(active=True)

admin.site.register(Comment, CommentAdmin)
admin.site.register(Post, PostAdmin)
