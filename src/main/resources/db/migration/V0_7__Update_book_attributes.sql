alter table "book"
    rename column "author" to "author_name";
alter table "book"
    add constraint "fk_author" foreign key ("author_name") references "author" (name);