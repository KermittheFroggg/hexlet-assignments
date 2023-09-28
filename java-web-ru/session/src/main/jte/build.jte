@import exercise.dto.LoginPage
@import exercise.util.NamedRoutes
@param LoginPage page


@template.layout.page(
content = @`
    <div class="mx-auto p-4 py-md-5">
        <form action="${NamedRoutes.loginPath()}" method="post">
            <div class="mb-3">
                @if (page != null)
                    <div>
                        ${page.getError()}
                    </div>
                    <div class="mb-3">
                        <label class="form-label">
                            Имя
                            <input type="text" class="form-control" name="name"/>
                        </label>
                    </div>
                    <div class="mb-3">
                        <label class="form-label">
                            Пароль
                            <input type="password" class="form-control" required name="password"/>
                        </label>
                    </div>
                    <input type="submit" class="btn btn-primary" value="Войти"/>
                @else
                    <div class="mb-3">
                        <label class="form-label">
                            Имя
                            <input type="text" class="form-control" name="name"/>
                        </label>
                    </div>
                    <div class="mb-3">
                        <label class="form-label">
                            Пароль
                            <input type="password" class="form-control" required name="password"/>
                        </label>
                    </div>
                    <input type="submit" class="btn btn-primary" value="Войти"/>
                @endif
            </div>
        </form>
    </div>
`
)
