package com.app.healthy_diet.model


class User {
    var id: Long? = null
    var fname: String? = null
    var lname: String? = null
    var email: String? = null
    var password: String? = null

    constructor() {}
    constructor(fname: String?, lname: String?, email: String?, password: String?) {
        this.fname = fname
        this.lname = lname
        this.email = email
        this.password = password
    }

    constructor(id: Long?, fname: String?, lname: String?, email: String?, password: String?) {
        this.id = id
        this.fname = fname
        this.lname = lname
        this.email = email
        this.password = password
    }
}