@import exercise.dto.articles.NewArticlePage
@param NewArticlePage page
@template.layout.page(
content = @`
    @if(page.getErrors() != null)
        <ul>
            @for(var validator : page.getErrors().values())
                @for(var error : validator)
                    <li>${error.getMessage()}</li>
                @endfor
            @endfor
        </ul>
    @endif

    <form action="/articles" method="post">
        <div class="mb-3">
            <label class="form-label">
                Название
                <input type="text" class="form-control" name="title" value="${page.getTitle()}"/>
            </label>
        </div>

        <div class="mb-3">
            <label class="form-label">
                Содержимое
                <textarea id="content" name="content" rows="5" cols="33" value="${page.getContent()}"> </textarea>
            </label>
        </div>
        <input type="submit" class="btn btn-primary" value="Зарегистрировать"/>
    </form>
`
)
