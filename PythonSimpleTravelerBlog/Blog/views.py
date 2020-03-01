from django.shortcuts import render, get_object_or_404
from django.http import HttpResponse, request
from django.template import loader
from .models import Post
from django.views import generic
from .forms import CommentForm

class PostList(generic.ListView):
    queryset = Post.objects.filter(status=1).order_by('-pub_date')[:5]
    template_name = 'index.html'
    context_object_name = 'latest_post_list'


def post_detail(request, slug):
    template_name = 'post_detail.html'
    post = get_object_or_404(Post,slug=slug)
    comments = post.comments.filter(active=True)
    new_comment = None
    if request.method == 'POST':
        comment_form = CommentForm(data=request.POST)
        if comment_form.is_valid():
            new_comment = comment_form.save(commit=False)
            new_comment.post = post
            new_comment.save()
    else:
        comment_form = CommentForm()

    return render(request, template_name, {'post': post,
                                           'comments': comments,
                                           'new_comment': new_comment,
                                           'comment_form': comment_form})


#
# def detail(request, post_id):
#    post = get_object_or_404(Post, pk=post_id)
#    return render(request,'Blog/detail.html',{'post':post})

# Create your views here.
