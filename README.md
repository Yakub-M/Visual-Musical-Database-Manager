# Visual-Musical-Database-Manager

Treble Soft Inc. is a fictitious company specializing in software solutions for audio applications. This prototype software has two main components: a user interface for browsing music records in a database and an admin interface for managing the database, including viewing, editing, and adding records.

Upon launching the software, a splash screen appears, prompting the user to press a button to continue. Users must either log in or register an account to access the software. Administrators, who have additional privileges for database management, must also log in, with their account assigned an "admin" status. The interface is in Bulgarian, as to comply with client needs.

The LoginForm handles the authentication process, verifying the user's credentials and determining their access level (user or admin). The database connection is managed through the SQLConnect class, which is responsible for all database queries, including login, registration, browsing, and editing operations. This class supports various SQL operations such as SELECT, SELECT WHERE, INSERT, DELETE, UPDATE, and more.
