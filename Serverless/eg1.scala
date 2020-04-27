const db = require('db').connect();
const mailer = require('mailer');
module.exports.saveUser = (event, context, callback) => {
    const user = {
        email: event.email,
        created_at: Date.now()
    }

    db.saveUser(user, function (err) {
        if (err) {
            callback(err);
        } else {
            mailer.sendWelcomeEmail(event.email);
            callback();
        }
    });
};

/*
The second method is preferable both for avoiding vendor 
lock-in and for testing. Removing the cloud provider logic 
from the event handler makes the application more flexible 
and applicable to many providers. It also makes testing 
easier by allowing you to write traditional unit tests to 
ensure it is working properly. You can also write 
integration tests to verify that integrations with other 
services are working properly
*/