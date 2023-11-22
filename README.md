In this we try to create Bank api which will do CRUD Operation

Set up 
for this we need to create mysql db "bank"

End URL
    
    @PostMapping("account") - to create new account
    @GetMapping("account/{id}") - get account by id
    @GetMapping("accounts") - get all accounts
    @PatchMapping("account/{id}") - modify account
    @DeleteMapping("account/{id}") - delete account

**Flow**
**normal flow for db**
    
    controller --> service --> repository --> db


**DTO flow**

    API -> Controller -> service --> mapper --> repository --> db

**Mapper is used to convert**

    AccountRequestDTO to Account
    Account to AccountResponseDTO

Folder Description

    dto - use to create req/res object
    mapper - used to convert request response object
    exception - used to create custom exception
    util - used to create other utility classes

    controller -  contain all the classes for req mapping
    service -  contain business logic
    model -  simple pojo classes which create tale in db
    repository - to interact with db

    application.properties - anything we want to provide from outside

   
