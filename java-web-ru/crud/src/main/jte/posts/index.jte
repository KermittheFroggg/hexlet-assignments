@import exercise.dto.posts.PostsPage
@import exercise.util.NamedRoutes
@param PostsPage page

@template.layout.page(
content = @`
    @if(page.getPosts().isEmpty())
        <p>Пока не добавлено ни одного поста</p>
    @else
        @for(var post : page.getPosts())
            <div>
                <h2><a href="${NamedRoutes.postsPath()}/${post.getId()}">${post.getName()}</a></h2>
            </div>
        @endfor
    @endif

    @if(page.getNumberOfPage()<5 && page.getNumberOfPage()>1)
        <div>
            <h2><a href="${NamedRoutes.postsPath()}/?page=${page.getNumberOfPage() + 1}">Вперед</a></h2>
        </div>
        <div>
            <h2><a href="${NamedRoutes.postsPath()}/?page=${page.getNumberOfPage() - 1}">Назад</a></h2>
        </div>
    @elseif(page.getNumberOfPage()==1)
        <div>
            <h2><a href="${NamedRoutes.postsPath()}/?page=${page.getNumberOfPage() + 1}">Вперед</a></h2>
        </div>
        <div>
            <h2><a href="${NamedRoutes.postsPath()}/?page=${5}">Назад</a></h2>
        </div>
    @elseif(page.getNumberOfPage()==5)
        <div>
            <h2><a href="${NamedRoutes.postsPath()}/?page=${1}">Вперед</a></h2>
        </div>
        <div>
            <h2><a href="${NamedRoutes.postsPath()}/?page=${page.getNumberOfPage() - 1}">Назад</a></h2>
        </div>
    @endif
`
)
