@import exercise.dto.users.UserPage
@param UserPage page

<html>

<body>
<main>
    <p>${page.getUser().getFirstName()}>${page.getUser().getLastName()}</p>
</main>
</body>
</html>
