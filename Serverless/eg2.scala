class Users {
    constructor(db, mailer) {
        this.db = db;
        this.mailer = mailer;
    }
    save(email, callback) {
        const user = {
            email: email,
            created_at: Date.now()
        }
        this.db.saveUser(user, function (err) {
            if (err) {
                callback(err);
            } else {
                this.mailer.sendWelcomeEmail(email);
                callback();
            }
        });
    }
}
module.exports = Users;
const db = require('db').connect();
const mailer = require('mailer');
const Users = require('users');
let users = new Users(db, mailer);
module.exports.saveUser = (event, context, callback) => {
    users.save(event.email, callback);
};