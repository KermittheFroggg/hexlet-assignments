@import exercise.dto.MainPage
@import exercise.util.NamedRoutes
@param MainPage page

@template.layout.page(
content = @`
    <div class="mx-auto p-4 py-md-5">
        <main>
            @if(page.getName() != null)
                <div>
                    Добро пожаловать ${page.getName().toString()}.
                    <form>
                        <button>Выйти</button>
                    </form>
                </div>
            @else
                <div>
                    <a href="${NamedRoutes.buildSessionPath()}">Войти</a>
                </div>
            @endif
        </main>
    </div>
`
)
